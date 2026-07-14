package refactoring;

public interface SeatPricingStrategy {

    /**
     * Kiểm tra Strategy có hỗ trợ loại ghế được truyền vào hay không.
     *
     * @param seatType loại ghế
     * @return true nếu Strategy hỗ trợ loại ghế
     */
    boolean supports(String seatType);

    /**
     * Tính giá của một ghế.
     *
     * @param show suất chiếu
     * @param seat ghế cần tính giá
     * @return giá của ghế
     */
    double calculatePrice(ShowTime show, Seat seat);
}
