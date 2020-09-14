use ho_thi_quynh_mai_c0620g1;
CREATE TABLE users(
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(40),
   `password` VARCHAR(255),
   email VARCHAR(255)
);

CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);

-- Khóa chính tổ hợp 
CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(role_id) REFERENCES roles(role_id)
);

-- Tạo khóa chính khi thay đổi bảng
-- ALTER TABLE table_name
    -- ADD PRIMARY KEY(primary_key_column); 

INSERT INTO users (username,`password`,email)
values
('Hồ','123456','abc@abc.abc'),
('Quỳnh','112233','123@abc.abc'),
('Mai','987654','9876@abc.abc');

INSERT INTO roles (role_name)
values
('Hồ'),
('Quỳnh'),
('Mai');

DROP TABLE users, userroles, roles;