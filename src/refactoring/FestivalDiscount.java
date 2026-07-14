package refactoring;

import java.util.List;
import java.util.Objects;

public final class FestivalDiscount implements DiscountStrategy {

    private static final String SUPPORTED_DISCOUNT_CODE = "FESTIVAL";
    private static final double DISCOUNT_AMOUNT = 40_000;

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

        /*
         * Không cho phép tổng tiền sau giảm giá nhỏ hơn 0.
         */
        return Math.max(0, total - DISCOUNT_AMOUNT);
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