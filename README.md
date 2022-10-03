# Hotel Management System
**Mô hình CSDL trên MySql như sau:**
![Xem ảnh ở đây](https://github.com/sonMMI/QuanLyKhachSan/blob/34d3a222958028ed51a3abce635823aca574b810/Screen%20Shot%202022-01-11%20at%2016.10.22.png)

**Cách sử dụng:**
- import project vào eclipse hoặc netbean. Rồi mở file src/hotelmanagement/HotelManagement_Main.java
- cài Xampp để kết nối với MySql. Dùng datagrip để lấy đường dẫn connect giữa máy local và MySql. sau khi lấy được đường dẫn thì copy và thay vào các file .java có câu lệnh như sau: 
```Connection con = DriverManager.getConnection("JDBC:mysql://192.168.64.2:3306/Hotel_Management_System","root","password");```
- các bạn hãy thay địa chỉ link, username, password tương ứng ở máy (lưu ý: sau khi sửa xong khi chạy chương trình bằng file HotelManagement_Main.java chương trình sẽ tự động tạo cơ sở dữ liệu mặc định và bạn có thể đăng nhập bầng tài khoản: admin, mật khẩu: admin)
- Chúc các bạn thành công
