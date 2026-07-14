package refactoring;

import java.util.List;

public interface DiscountStrategy {

    /**
     * Kiểm tra Strategy có hỗ trợ mã giảm giá hay không.
     *
     * @param discountCode mã giảm giá
     * @return true nếu Strategy hỗ trợ mã
     */
    boolean supports(String discountCode);

    /**
     * Áp dụng chính sách giảm giá.
     *
     * @param total tổng tiền trước giảm giá
     * @param user người đặt vé
     * @param show suất chiếu
     * @param seats danh sách ghế
     * @return tổng tiền sau giảm giá
     */
    double applyDiscount(
            double total,
            User user,
            ShowTime show,
            List<Seat> seats
    );
}
