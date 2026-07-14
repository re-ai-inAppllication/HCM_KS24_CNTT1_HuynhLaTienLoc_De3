package refactoring;

import java.util.List;
import java.util.Objects;

public final class StudentDiscount implements DiscountStrategy {

    private static final String SUPPORTED_DISCOUNT_CODE = "STUDENT";
    private static final double DISCOUNT_RATE = 0.10;

    @Override
    public boolean supports(String discountCode) {
        return SUPPORTED_DISCOUNT_CODE.equalsIgnoreCase(discountCode);
    }

    @Override
    public double applyDiscount(
            double total,
            User user,
            ShowTime show,
            List<Seat> seats
    ) {
        validateInput(total, user, show, seats);

        return total * (1 - DISCOUNT_RATE);
    }

    private void validateInput(
            double total,
            User user,
            ShowTime show,
            List<Seat> seats
    ) {
        if (total < 0) {
            throw new IllegalArgumentException(
                    "Total amount must not be negative"
            );
        }

        Objects.requireNonNull(user, "User must not be null");
        Objects.requireNonNull(show, "ShowTime must not be null");
        Objects.requireNonNull(seats, "Seats must not be null");
    }
}
