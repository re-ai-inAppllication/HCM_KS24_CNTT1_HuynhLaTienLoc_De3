package refactoring;

import java.util.Objects;

public final class NormalPricing implements SeatPricingStrategy {

    private static final String SUPPORTED_SEAT_TYPE = "NORMAL";

    @Override
    public boolean supports(String seatType) {
        return SUPPORTED_SEAT_TYPE.equalsIgnoreCase(seatType);
    }

    @Override
    public double calculatePrice(ShowTime show, Seat seat) {
        Objects.requireNonNull(show, "ShowTime must not be null");
        Objects.requireNonNull(seat, "Seat must not be null");

        return show.getBasePrice();
    }
}
