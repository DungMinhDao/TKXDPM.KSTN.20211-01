# TKXDPM.KSTN.20211-01
Hướng dẫn cài đặt phần mềm:

Sau khi tải project về máy thì add tất cả các file jar trong thư mục lib vào classpath của project.

Tiếp tục add junit vào classpath

Việc tiếp theo là add thông tin sau vào VM agrument: 
--module-path="<đường dẫn tới thư mục chứa các file jar vủa JavaFX>" --add-modules=javafx.controls,javafx.fxml

Tiếp theo là thực thi các câu lệnh trong file script.sql để tạo các bảng cần thiết, sau đó insert thông tin vào table bike và dock.
(Yêu cầu máy đã cài MySQL Server, ngoài ra nhóm sử dụng MySQL WorkBench để có giao diện run câu lệnh sql và dễ dàng quản lý bảng) 

Đến đây là có thể run hàm Main trong package presentation để chạy chương trình.
