package refactoring;

import java.util.Objects;

public final class SweetBoxPricing implements SeatPricingStrategy {

    private static final String SUPPORTED_SEAT_TYPE = "SWEETBOX";
    private static final double SWEETBOX_SURCHARGE = 50_000;

    @Override
    public boolean supports(String seatType) {
        return SUPPORTED_SEAT_TYPE.equalsIgnoreCase(seatType);
    }

    @Override
    public double calculatePrice(ShowTime show, Seat seat) {
        Objects.requireNonNull(show, "ShowTime must not be null");
        Objects.requireNonNull(seat, "Seat must not be null");

        return show.getBasePrice() + SWEETBOX_SURCHARGE;
    }
}
