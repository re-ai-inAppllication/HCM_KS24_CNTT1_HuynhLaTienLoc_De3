package refactoring;

import java.util.Objects;

public final class VipPricing implements SeatPricingStrategy {

    private static final String SUPPORTED_SEAT_TYPE = "VIP";
    private static final double VIP_SURCHARGE = 20_000;

    @Override
    public boolean supports(String seatType) {
        return SUPPORTED_SEAT_TYPE.equalsIgnoreCase(seatType);
    }

    @Override
    public double calculatePrice(ShowTime showTime, Seat seat) {
        Objects.requireNonNull(showTime, "ShowTime must not be null");
        Objects.requireNonNull(seat, "Seat must not be null");

        return showTime.getBasePrice() + VIP_SURCHARGE;
    }
}