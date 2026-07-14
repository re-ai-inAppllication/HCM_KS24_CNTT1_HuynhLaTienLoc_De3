HUỲNH LA TIẾN LỘC 
========BÁO CÁO========

PHẦN I: TÁI CẤU TRÚC HỆ THỐNG ĐỂ DỄ MỞ RỘNG
1. Mục tiêu kỹ thuật
Phân tích nguyên nhân hệ thống khó mở rộng do sử dụng nhiều câu lệnh if-else.
Áp dụng Strategy Pattern để tuân thủ nguyên tắc Open/Closed Principle (OCP).
Cho phép thêm loại ghế và chương trình khuyến mãi mới mà không cần sửa TicketingService.
Nâng cao khả năng bảo trì, mở rộng và kiểm thử hệ thống.
2. Lịch sử Prompt (Prompt Chain)
Prompt 1: Phân tích mã nguồn ban đầu
Mục tiêu

Xác định các vấn đề trong đoạn code hiện tại và kiểm tra việc vi phạm OCP.

Prompt đã sử dụng

///////////////////////////////////////////////////////////////////////////////

Đóng vai Senior Java Developer có kinh nghiệm về SOLID và Design Pattern.

Phân tích đoạn code TicketingService dưới đây.

Yêu cầu:

1. Xác định các trách nhiệm mà TicketingService đang đảm nhận.
2. Chỉ ra các đoạn code vi phạm Open/Closed Principle.
3. Giải thích vì sao việc sử dụng if-else cho loại ghế và mã giảm giá
gây khó khăn khi mở rộng.
4. Mô tả những phần cần sửa nếu thêm ghế IMAX hoặc mã giảm giá BLACKFRIDAY.
5. Chưa viết mã nguồn mới ở bước này.

[Mã nguồn TicketingService]

///////////////////////////////////////////////////////////////////////////////

Kết quả AI trả về

AI xác định TicketingService đang đảm nhận quá nhiều trách nhiệm:

Tính giá ghế.
Tính giảm giá.
Tính điểm thưởng.
Gửi thông báo.
Tạo vé.

AI cũng xác định hai nhóm if-else xử lý loại ghế và mã giảm giá là nguyên nhân chính làm hệ thống vi phạm OCP.

Đánh giá của sinh viên

Kết quả phân tích đúng nhưng AI mới chỉ phát hiện vấn đề, chưa đưa ra nhiều phương án giải quyết để so sánh.

Do đó, sinh viên tiếp tục sử dụng Prompt 2.

Prompt 2: Đề xuất nhiều phương án
Mục tiêu

Yêu cầu AI đưa ra nhiều giải pháp thay vì chọn ngay một phương án.

Prompt đã sử dụng

///////////////////////////////////////////////////////////////////////////////

Dựa trên các vấn đề vừa phân tích, hãy đề xuất ít nhất 3 phương án
tái cấu trúc TicketingService.

Có thể xem xét:

- Strategy Pattern.
- Factory Pattern kết hợp Strategy.
- Polymorphism.
- Rule Engine.

Đối với mỗi phương án, hãy trình bày:

1. Ý tưởng hoạt động.
2. Ưu điểm.
3. Nhược điểm.
4. Mức độ dễ triển khai.
5. Khả năng mở rộng.
6. Mức độ phù hợp với bài toán đặt vé.

Chưa viết code.

///////////////////////////////////////////////////////////////////////////////

Kết quả AI trả về

AI đề xuất các phương án:

Strategy Pattern.
Factory kết hợp Strategy.
Rule Engine.
Đánh giá của sinh viên

AI đưa ra nhiều phương án nhưng phần so sánh còn chung chung.

Sinh viên sử dụng Prompt 3 để yêu cầu so sánh theo tiêu chí cụ thể.

Prompt 3: So sánh và lựa chọn giải pháp
Prompt đã sử dụng

///////////////////////////////////////////////////////////////////////////////

Hãy so sánh các phương án Strategy Pattern, Factory + Strategy
và Rule Engine theo các tiêu chí:

1. Dễ hiểu đối với sinh viên.
2. Dễ triển khai bằng Java.
3. Dễ kiểm thử.
4. Dễ bảo trì.
5. Dễ thêm loại ghế mới.
6. Dễ thêm mã giảm giá mới.
7. Phù hợp với quy mô bài tập hiện tại.
8. Nguy cơ làm hệ thống phức tạp quá mức.

Trình bày bằng bảng và đưa ra phương án được khuyến nghị.

///////////////////////////////////////////////////////////////////////////////

Kết quả AI trả về

AI khuyến nghị sử dụng Strategy Pattern vì:

Cấu trúc đơn giản.
Dễ triển khai.
Phù hợp với bài toán có nhiều thuật toán tính giá.
Dễ thêm chiến lược mới.
Không làm hệ thống phức tạp như Rule Engine.
Quyết định của sinh viên

Sinh viên lựa chọn Strategy Pattern vì phù hợp với phạm vi bài tập và đáp ứng tốt OCP.

Prompt 4: Thiết kế kiến trúc mới
Prompt đã sử dụng

///////////////////////////////////////////////////////////////////////////////

Dựa trên phương án Strategy Pattern, hãy thiết kế lại hệ thống đặt vé
theo nguyên tắc SOLID.

Hãy liệt kê:

1. Các interface cần tạo.
2. Các concrete class.
3. Trách nhiệm của từng class.
4. Quan hệ giữa các class.
5. Luồng tính giá vé.
6. Luồng áp dụng giảm giá.

Trình bày thêm sơ đồ UML dạng text.

Chưa sinh code Java.

///////////////////////////////////////////////////////////////////////////////

Kết quả AI trả về

AI đề xuất:

SeatPricingStrategy
├── VipPricing
├── SweetBoxPricing
└── NormalPricing

DiscountStrategy
├── StudentDiscount
├── FestivalDiscount
└── NoDiscount

TicketingService

TicketingService chỉ điều phối quá trình đặt vé và không còn chứa điều kiện tính giá chi tiết.

Prompt 5: Sinh mã nguồn Java
Prompt đã sử dụng
///////////////////////////////////////////////////////////////////////////////
Dựa trên kiến trúc đã thiết kế, hãy sinh mã nguồn Java đầy đủ cho:

1. SeatPricingStrategy.
2. VipPricing.
3. SweetBoxPricing.
4. NormalPricing.
5. DiscountStrategy.
6. StudentDiscount.
7. FestivalDiscount.
8. NoDiscount.
9. LoyaltyPointService.
10. NotificationService.
11. TicketingService mới.

Yêu cầu:

- Áp dụng constructor injection.
- Không sử dụng if-else dài trong TicketingService.
- Mỗi class chỉ có một trách nhiệm chính.
- Tên biến và phương thức rõ nghĩa.
- Không sử dụng System.out.println trong business service.
- Không thay đổi kết quả nghiệp vụ ban đầu.
  
///////////////////////////////////////////////////////////////////////////////

Prompt 6: Kiểm tra khả năng mở rộng
Prompt đã sử dụng

///////////////////////////////////////////////////////////////////////////////

Kiểm tra thiết kế mới theo Open/Closed Principle.

Giả sử hệ thống cần thêm:

- Ghế IMAX.
- Ghế Couple.
- Mã giảm giá BLACKFRIDAY.

Hãy mô tả:

1. Class mới cần tạo.
2. Interface cần triển khai.
3. Cách đăng ký chiến lược mới.
4. Những class cũ có cần sửa hay không.
5. TicketingService có cần sửa hay không.

Mục tiêu là chứng minh hệ thống mở rộng được mà không sửa logic cũ

///////////////////////////////////////////////////////////////////////////////

Prompt 7: Review mã nguồn
Prompt đã sử dụng

///////////////////////////////////////////////////////////////////////////////

Đóng vai Technical Reviewer.

Review mã nguồn vừa sinh theo các tiêu chí:

1. Open/Closed Principle.
2. Single Responsibility Principle.
3. Dependency Inversion Principle.
4. Clean Code.
5. Null safety.
6. Tránh magic number.
7. Tránh so sánh String dễ gây lỗi.
8. Khả năng kiểm thử.
9. Khả năng mở rộng.
10. Các lỗi có thể xảy ra trong runtime.

Với mỗi vấn đề, hãy chỉ rõ nguyên nhân và đề xuất cách sửa

///////////////////////////////////////////////////////////////////////////////

3. Phân tích lỗi AI
Lỗi 1

AI ban đầu vẫn sử dụng String để xác định loại ghế và mã giảm giá.

Khắc phục: Chuyển sang sử dụng Enum để tránh sai chính tả và dễ quản lý.

Lỗi 2

AI sử dụng các giá trị cố định (magic number) như:

basePrice + 20000

Khắc phục: Đưa các giá trị này thành hằng số hoặc cấu hình.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
PHẦN II: DeBugging Bảo mật và xử lý Lỗi hệ thống 
1. tiêu kỹ thuật
Áp dụng các góp ý từ lần đánh giá đầu tiên để tái cấu trúc mã nguồn theo hướng tuân thủ SOLID, Clean Code và tăng khả năng mở rộng của hệ thống.

2. Lịch sử Prompt (Prompt Chain)

///////////////////////////////////////////////////////////////////////////////

Prompt 1 — Thu thập và phân loại lỗi
Đóng vai Senior Java Backend Engineer có kinh nghiệm với Spring Boot,
Spring Security và JWT.

Tôi đang gặp lỗi khi xác thực JWT trong một OncePerRequestFilter.

Exception:

io.jsonwebtoken.security.SignatureException:
JWT signature does not match locally computed signature.

Đoạn code:

[Paste JwtAuthenticationFilter]

Hãy thực hiện:

1. Xác định vị trí chính xác phát sinh lỗi.
2. Phân loại đây là lỗi cú pháp, lỗi nghiệp vụ, lỗi cấu hình hay lỗi bảo mật.
3. Giải thích luồng request từ khi đi vào Security Filter Chain đến khi server trả HTTP 500.
4. Chưa sửa code ở bước này.
5. Không kết luận ngay khi chưa liệt kê đủ các giả thuyết.
Mục đích

Prompt đầu tiên không yêu cầu AI sửa ngay. Nó bắt AI hiểu:

///////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////

Prompt 2 — Phân tích nguyên nhân gốc theo phương pháp 5 Whys
Dựa trên lỗi và luồng xử lý vừa phân tích, hãy thực hiện Root Cause Analysis
bằng kỹ thuật 5 Whys.

Với mỗi giả thuyết, trình bày:

- Giả thuyết
- Bằng chứng từ stack trace hoặc source code
- Cách kiểm chứng
- Mức độ khả năng: cao, trung bình hoặc thấp
- Cách loại trừ giả thuyết

Tập trung kiểm tra các trường hợp:

1. Secret key dùng khi generate và validate token khác nhau.
2. Cách encode secret key không đồng nhất.
3. Token cũ được tạo trước khi thay đổi secret.
4. Token đến từ môi trường hoặc service khác.
5. Token bị thay đổi nội dung.
6. Thuật toán ký token không đồng nhất.

Không viết code giải pháp ở bước này.
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
Prompt 3 — Yêu cầu AI tạo kế hoạch điều tra thực tế
Hãy chuyển phần Root Cause Analysis thành một checklist điều tra có thể thực hiện
trong dự án Spring Boot.

Sắp xếp các bước theo thứ tự từ dễ kiểm tra nhất đến khó nhất.

Mỗi bước phải có:

1. File hoặc thành phần cần kiểm tra.
2. Dữ liệu cần quan sát.
3. Kết quả mong đợi.
4. Kết luận nếu kết quả đúng.
5. Kết luận nếu kết quả sai.

Không được yêu cầu log toàn bộ JWT secret hoặc token trong môi trường production.
Chỉ được phép log thông tin an toàn như:

- Loại exception
- Request path
- Token presence
- JWT algorithm
- Thời điểm phát sinh lỗi

///////////////////////////////////////////////////////////////////////////////

Checklist thực tế AI nên đưa ra
Đăng nhập lại để lấy token mới.
Kiểm tra token khi login và token gửi qua Postman có giống nhau không.
Kiểm tra code generate token.
Kiểm tra code parse token.
Kiểm tra cả hai cùng đọc một property.
Kiểm tra encoding của key.
Kiểm tra key giữa local, test và production.
Kiểm tra token có khoảng trắng hoặc dấu ngoặc kép không.


///////////////////////////////////////////////////////////////////////////////
3. Prompt điều hướng AI chọn kiến trúc xử lý lỗi

///////////////////////////////////////////////////////////////////////////////
Prompt 4 — So sánh các vị trí bắt exception
Hiện tại SignatureException được ném ra trong JwtAuthenticationFilter và làm
server trả HTTP 500.

Hãy so sánh các phương án xử lý:

A. Bắt try-catch trực tiếp trong JwtAuthenticationFilter.
B. Ném AuthenticationException và xử lý bằng AuthenticationEntryPoint.
C. Dùng HandlerExceptionResolver để chuyển exception từ filter sang hệ thống
xử lý lỗi tập trung.
D. Chờ GlobalExceptionHandler bắt lỗi.

So sánh theo các tiêu chí:

- Có xử lý được exception phát sinh trước Controller hay không.
- Mức độ tập trung.
- Khả năng tái sử dụng.
- Phù hợp với Spring Security.
- Dễ kiểm thử.
- Có đảm bảo mọi lỗi JWT trả cùng JSON hay không.
///////////////////////////////////////////////////////////////////////////////


Sau đó đề xuất kiến trúc phù hợp nhất.

Lưu ý: Không được kết luận rằng chỉ cần GlobalExceptionHandler vì lỗi phát sinh
trong Security Filter Chain trước Controller.

Spring Security sử dụng AuthenticationEntryPoint để khởi động phản hồi khi quá trình xác thực thất bại. ExceptionTranslationFilter là cầu nối giữa các exception bảo mật phù hợp và phản hồi HTTP.


///////////////////////////////////////////////////////////////////////////////

4. Prompt yêu cầu thiết kế giải pháp
Prompt 5 — Thiết kế các thành phần

///////////////////////////////////////////////////////////////////////////////

Dựa trên phương án xử lý lỗi tập trung, hãy thiết kế lại phần JWT Security.

Yêu cầu có các thành phần:

1. JwtService
   - Chịu trách nhiệm parse và validate token.
   - Phân biệt invalid signature, expired token, malformed token và unsupported token.

2. JwtAuthenticationFilter
   - Chỉ điều phối quá trình xác thực.
   - Không tự viết JSON response.
   - Không chứa hard-coded secret key.

3. CustomAuthenticationEntryPoint hoặc JwtErrorResponseHandler
   - Trả HTTP 401.
   - Content-Type application/json.
   - JSON đồng nhất.

4. SecurityConfig
   - Cấu hình exceptionHandling.
   - Đăng ký JWT filter đúng vị trí.

5. ErrorResponse
   - timestamp
   - status
   - error
   - code
   - message
   - path

Trình bày:

- Trách nhiệm từng class.
- Quan hệ giữa các class.
- Luồng xử lý token hợp lệ.
- Luồng xử lý token sai chữ ký.
- Luồng xử lý token hết hạn.

Chưa sinh code.
///////////////////////////////////////////////////////////////////////////////


5. Prompt sinh code giải pháp thực thi
Prompt 6 — Sinh code đầy đủ

///////////////////////////////////////////////////////////////////////////////
Dựa trên kiến trúc vừa thiết kế, hãy sinh mã nguồn Java Spring Boot hoàn chỉnh.

Yêu cầu:

1. Sử dụng constructor injection.
2. Secret key phải đọc từ application.yml hoặc biến môi trường.
3. Không hard-code secret trong source code.
4. Dùng cùng một phương thức tạo SecretKey cho cả generate và parse token.
5. Mọi lỗi xác thực JWT phải trả HTTP 401, không trả HTTP 500.
6. Response có dạng:

{
  "timestamp": "...",
  "status": 401,
  "error": "UNAUTHORIZED",
  "code": "INVALID_JWT_SIGNATURE",
  "message": "JWT signature is invalid",
  "path": "/api/example"
}

7. Phân biệt các mã lỗi:

- MISSING_TOKEN
- INVALID_JWT_SIGNATURE
- EXPIRED_JWT
- MALFORMED_JWT
- UNSUPPORTED_JWT
- INVALID_JWT

8. Không đưa stack trace hoặc secret key vào response.
9. Không dùng System.out.println.
10. Giải thích tại sao GlobalExceptionHandler thông thường không phải nơi đáng
tin cậy để bắt exception phát sinh trực tiếp trong custom security filter.

Sinh đầy đủ:

- JwtProperties
- JwtService
- JwtAuthenticationFilter
- JwtAuthenticationEntryPoint
- ErrorResponse
- SecurityConfig
- application.yml mẫu

///////////////////////////////////////////////////////////////////////////////
6. Prompt bắt AI tự review code
Prompt 7 — Technical Review
///////////////////////////////////////////////////////////////////////////////
Đóng vai Technical Reviewer.

Hãy review toàn bộ code JWT vừa sinh.

Kiểm tra:

1. Generate và validate có dùng cùng SecretKey hay không.
2. Secret có đủ độ dài cho thuật toán đang dùng hay không.
3. Có hard-code secret hoặc log secret hay không.
4. Filter có gọi filterChain.doFilter đúng một lần hay không.
5. Khi token sai, response có bị ghi hai lần hay không.
6. Sau khi gửi lỗi 401, filter có tiếp tục chạy hay không.
7. SecurityContext có bị giữ lại khi token không hợp lệ hay không.
8. Response có đúng Content-Type application/json hay không.
9. Có trả 401 thay vì 403 hoặc 500 hay không.
10. Có dependency hoặc API JJWT đã lỗi thời hay không.

Với mỗi vấn đề:

- Chỉ rõ đoạn code.
- Giải thích hậu quả.
- Đưa ra phiên bản sửa.

///////////////////////////////////////////////////////////////////////////////
7. Prompt tạo test chứng minh giải pháp
Prompt 8 — Sinh test case

///////////////////////////////////////////////////////////////////////////////
Hãy viết test cho giải pháp JWT bằng JUnit 5, Mockito và Spring Security Test.

Tối thiểu phải có các trường hợp:

1. Không có Authorization header.
2. Header không bắt đầu bằng Bearer.
3. Token hợp lệ.
4. Token bị sửa một ký tự.
5. Token được ký bằng secret khác.
6. Token hết hạn.
7. Token malformed.
8. Authentication đã tồn tại trong SecurityContext.
9. Endpoint public không bị chặn.
10. Endpoint protected trả JSON 401 đồng nhất.

Với mỗi test, chỉ rõ:

- Input.
- HTTP status mong đợi.
- Error code mong đợi.
- filterChain có được tiếp tục hay không.

Đặc biệt chứng minh token sai chữ ký không còn làm server trả HTTP 500.
///////////////////////////////////////////////////////////////////////////////


8. Prompt kiểm tra khả năng vận hành
Prompt 9 — Kiểm tra production readiness

///////////////////////////////////////////////////////////////////////////////
Hãy đánh giá giải pháp theo góc nhìn production.

Kiểm tra:

- Quản lý JWT secret bằng biến môi trường.
- Rotation secret key.
- Token cũ sau khi đổi key.
- Không ghi token đầy đủ vào log.
- Correlation ID để truy vết.
- Monitoring số lượng lỗi INVALID_JWT_SIGNATURE.
- Phân biệt lỗi do client và lỗi hệ thống.
- Tránh tiết lộ quá nhiều thông tin bảo mật cho client.

Đề xuất những phần bắt buộc phải làm ngay và những phần có thể cải tiến sau.
///////////////////////////////////////////////////////////////////////////////

3.Phân tích lỗi AI
AI phát hiện một số điểm chưa tối ưu về khả năng mở rộng.
Một số class còn phụ thuộc trực tiếp vào implementation cụ thể.
Naming và cấu trúc package chưa hoàn toàn theo chuẩn Clean Architecture.
Sau khi refactor, mã nguồn dễ bảo trì hơn và đáp ứng OCP tốt hơn khi mở rộng chức năng mới.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
PHẦN 3: PHÂN TÍCH VÀ THIẾT KẾ HỆ THỐNG VỚI AI

1.Mục tiêu kỹ thuật
Lựa chọn Tech Stack phù hợp cho hệ thống đặt vé rạp chiếu phim.
Thiết kế chức năng giữ ghế và cập nhật trạng thái ghế theo thời gian thực.
Xác định các thực thể, thuộc tính và quan hệ trong cơ sở dữ liệu.
Xây dựng sơ đồ ERD hỗ trợ quản lý người dùng, phim, suất chiếu, vé, combo và thanh toán.
Đảm bảo hệ thống dễ mở rộng, bảo trì và hạn chế đặt trùng ghế.

2.Prompt Chain
Nhiệm vụ 1: Đề xuất Giải pháp Công nghệ (Tech Stack)
Prompt sử dụng
Bạn là Senior Solution Architect có 10 năm kinh nghiệm xây dựng hệ thống đặt vé rạp chiếu phim.

Bối cảnh dự án:

Tên hệ thống: Rikkei Cinema

Yêu cầu nghiệp vụ:

- Quản lý người dùng (Khách hàng, Nhân viên soát vé, Quản lý rạp)
- Giá vé động theo định dạng phim (2D, 3D, IMAX)
- Phụ phí khung giờ vàng (19h-21h)
- Combo đồ ăn giảm giá
- Đặt ghế Real-time, khi một khách giữ ghế phải hiển thị trạng thái cho khách khác ngay lập tức

Hãy đề xuất:

1. Kiến trúc hệ thống phù hợp
2. Frontend Framework
3. Backend Framework
4. Database
5. Công nghệ Real-time
6. Cache
7. Authentication
8. Triển khai hệ thống
9. Lý do lựa chọn từng công nghệ

Trình bày dưới dạng bảng.

Nhận xét cá nhân

Tôi đồng ý với đề xuất của AI vì:

ReactJS phù hợp với hệ thống nhiều màn hình quản lý.
Spring Boot mạnh về xử lý nghiệp vụ doanh nghiệp.
Redis giúp giảm tải Database.
WebSocket đáp ứng yêu cầu cập nhật ghế theo thời gian thực.
PostgreSQL ổn định và phù hợp cho hệ thống giao dịch.

Điểm cần lưu ý:

WebSocket làm tăng độ phức tạp hệ thống.
Nếu lượng người dùng lớn có thể cần Redis Pub/Sub hoặc Message Queue để mở rộng.

Nhiệm vụ 2: Phân tích Thực thể (Entity Analysis)
Prompt sử dụng
Bạn là System Analyst.

Dựa trên yêu cầu nghiệp vụ của hệ thống Rikkei Cinema.

Hãy phân tích Database và xác định:

1. Các Entity chính
2. Thuộc tính quan trọng của từng Entity
3. Khóa chính (Primary Key)
4. Các mối quan hệ giữa các Entity

Trình bày dưới dạng bảng.
Danh sách Entity
User
id
username
password
fullName
role
Cinema
id
name
address
Room
id
cinemaId
roomName
capacity
Seat
id
roomId
seatNumber
seatType
Movie
id
title
duration
format
Showtime
id
movieId
roomId
startTime
endTime
Ticket
id
userId
showtimeId
seatId
price
Booking
id
userId
bookingDate
totalAmount
Combo
id
comboName
price
BookingCombo
bookingId
comboId
quantity
Payment
id
bookingId
amount
paymentMethod


Nhiệm vụ 3: Thiết kế ERD
Prompt sử dụng
Bạn là Database Architect.

Dựa trên các Entity sau:

User
Cinema
Room
Seat
Movie
Showtime
Ticket
Booking
Combo
BookingCombo
Payment

Hãy:

1. Xác định quan hệ giữa các Entity
2. Sinh sơ đồ ERD bằng Mermaid
3. Đảm bảo chuẩn hóa dữ liệu và hỗ trợ mở rộng hệ thống

Trả về mã Mermaid hoàn chỉnh.


3.Phân tích lỗi của AI
AI có thể đề xuất quá nhiều công nghệ, làm hệ thống phức tạp hơn nhu cầu thực tế.
Danh sách Entity có thể thiếu thực thể giữ ghế tạm thời như SeatHold hoặc Reservation.
Nếu chỉ dùng Ticket để quản lý ghế, hệ thống chưa xử lý tốt trạng thái đang giữ, đã đặt hoặc đã hết thời gian giữ.
Quan hệ giữa Booking và Payment cần xác định rõ là một-một hay một-nhiều.
Giá vé không nên chỉ lưu cố định trong Ticket, mà cần có quy tắc tính giá theo định dạng phim, khung giờ và chương trình giảm giá.
AI chưa mô tả rõ cách chống hai khách cùng đặt một ghế, ví dụ sử dụng Redis Lock, Database Lock hoặc Unique Constraint.
Kết quả AI cần được kiểm tra lại theo nghiệp vụ thực tế trước khi áp dụng.

"# HCM_KS24_CNTT1_HuynhLaTienLoc_De3" 
