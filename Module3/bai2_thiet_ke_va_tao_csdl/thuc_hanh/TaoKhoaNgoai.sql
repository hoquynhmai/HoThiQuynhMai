use ho_thi_quynh_mai_c0620g1; 
CREATE TABLE customers(
   id INT AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255)
);

CREATE TABLE orders(
   id INT AUTO_INCREMENT,
   staff VARCHAR(50),
   PRIMARY KEY(id),
   customer_id INT,
   FOREIGN KEY (customer_id) REFERENCES customers(id) -- Định nghĩa khóa ngoại 
);

INSERT INTO customers (`name`,address,email)
values
('Hồ','Đà Nẵng','abc@abc.abc'),
('Quỳnh','Đà Nẵng','qwe@abc.abc'),
('Mai','Đà Nẵng','yhn@abc.abc');

INSERT INTO orders (staff,customer_id)
values
('D',2),
('H',1),
('F',3);

DROP TABLE customers,orders;