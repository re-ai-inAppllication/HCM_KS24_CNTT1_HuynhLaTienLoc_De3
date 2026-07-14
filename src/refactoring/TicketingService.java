package refactoring;

import java.util.List;
import java.util.Objects;

public final class TicketingService {

    private final List<SeatPricingStrategy> seatPricingStrategies;
    private final List<DiscountStrategy> discountStrategies;
    private final LoyaltyPointService loyaltyPointService;
    private final NotificationService notificationService;

    public TicketingService(
            List<SeatPricingStrategy> seatPricingStrategies,
            List<DiscountStrategy> discountStrategies,
            LoyaltyPointService loyaltyPointService,
            NotificationService notificationService
    ) {
        this.seatPricingStrategies = List.copyOf(
                Objects.requireNonNull(
                        seatPricingStrategies,
                        "Seat pricing strategies must not be null"
                )
        );

        this.discountStrategies = List.copyOf(
                Objects.requireNonNull(
                        discountStrategies,
                        "Discount strategies must not be null"
                )
        );

        this.loyaltyPointService = Objects.requireNonNull(
                loyaltyPointService,
                "LoyaltyPointService must not be null"
        );

        this.notificationService = Objects.requireNonNull(
                notificationService,
                "NotificationService must not be null"
        );

        validateStrategies();
    }

    public Ticket bookTicket(
            User user,
            ShowTime show,
            List<Seat> seats,
            String discountCode
    ) {
        validateBookingRequest(user, show, seats);

        List<Seat> immutableSeats = List.copyOf(seats);

        double subtotal = calculateSeatTotal(show, immutableSeats);

        double finalTotal = applyDiscount(
                subtotal,
                discountCode,
                user,
                show,
                immutableSeats
        );

        Ticket ticket = new Ticket(
                user,
                show,
                immutableSeats,
                finalTotal
        );

        int loyaltyPoints =
                loyaltyPointService.calculatePoints(finalTotal);

        loyaltyPointService.addPoints(user, loyaltyPoints);

        notificationService.notifyTicketBooked(user, ticket);

        return ticket;
    }

    private double calculateSeatTotal(
            ShowTime show,
            List<Seat> seats
    ) {
        return seats.stream()
                .mapToDouble(seat -> {
                    SeatPricingStrategy strategy =
                            findSeatPricingStrategy(seat.getType());

                    return strategy.calculatePrice(show, seat);
                })
                .sum();
    }

    private double applyDiscount(
            double total,
            String discountCode,
            User user,
            ShowTime show,
            List<Seat> seats
    ) {
        if (discountCode == null || discountCode.isBlank()) {
            return total;
        }

        DiscountStrategy strategy =
                findDiscountStrategy(discountCode);

        return strategy.applyDiscount(
                total,
                user,
                show,
                seats
        );
    }

    private SeatPricingStrategy findSeatPricingStrategy(
            String seatType
    ) {
        if (seatType == null || seatType.isBlank()) {
            throw new IllegalArgumentException(
                    "Seat type must not be null or blank"
            );
        }

        return seatPricingStrategies.stream()
                .filter(strategy -> strategy.supports(seatType))
                .findFirst()
                .orElseThrow(() ->
                        new UnsupportedOperationException(
                                "Unsupported seat type: " + seatType
                        )
                );
    }

    private DiscountStrategy findDiscountStrategy(
            String discountCode
    ) {
        return discountStrategies.stream()
                .filter(strategy ->
                        strategy.supports(discountCode)
                )
                .findFirst()
                .orElseThrow(() ->
                        new UnsupportedOperationException(
                                "Unsupported discount code: "
                                        + discountCode
                        )
                );
    }

    private void validateBookingRequest(
            User user,
            ShowTime show,
            List<Seat> seats
    ) {
        Objects.requireNonNull(user, "User must not be null");
        Objects.requireNonNull(show, "ShowTime must not be null");
        Objects.requireNonNull(seats, "Seats must not be null");

        if (seats.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one seat must be selected"
            );
        }

        if (seats.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(
                    "Seat list must not contain null elements"
            );
        }

        if (show.getBasePrice() < 0) {
            throw new IllegalArgumentException(
                    "Show base price must not be negative"
            );
        }
    }

    private void validateStrategies() {
        if (seatPricingStrategies.isEmpty()) {
            throw new IllegalArgumentException(
                    "At least one seat pricing strategy is required"
            );
        }

        if (seatPricingStrategies.stream()
                .anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(
                    "Seat pricing strategies must not contain null"
            );
        }

        if (discountStrategies.stream()
                .anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(
                    "Discount strategies must not contain null"
            );
        }
    }
}
