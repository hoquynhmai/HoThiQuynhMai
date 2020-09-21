/* Bước 1: Tạo cơ sở dữ liệu demo */
drop database if exists demo;
create database demo;
use demo;


/* Bước 2: Tạo bảng Products */
create table products (
id int auto_increment,
productCode varchar (10),
productName varchar (50),
productPrice varchar (20),
productAmount int,
productDescription varchar (255),
productStatus varchar (50),
primary key (id)
);

insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
values
('003', 'Xiaomi Note 7', '3800000', 10, 'Xiaomi', 'Stocking'),
('002', 'Asus Rog Phone', '12000000', 5, 'Asus', 'Out of stock'),
('004', 'Realme X', '5500000', 12, 'Oppo', 'Stocking'),
('005', 'Samsung A60', '4000000', 1, 'Samsung', 'Out of stock'),
('001', 'Samsung Note 10', '13500000', 3, 'Samsung', 'Out of stock');


/* Bước 3:
Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
So sánh câu truy vấn trước và sau khi tạo index */

ALTER TABLE products ADD INDEX idx_productCode(productCode);
EXPLAIN SELECT * FROM products WHERE productCode = 5; -- Tìm tất cả sản phẩm bên trong bảng products 

-- Truy vấn trước khi tạo index 
SELECT * FROM products WHERE productCode = '005';

-- Truy vấn sau khi gọi index
CREATE UNIQUE INDEX productCode ON products(productCode);
select * from products;
EXPLAIN SELECT * FROM products WHERE productCode = '005'; -- Tìm sản phẩm có mã 005 

/* Bước 4:
Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products */
CREATE VIEW products_view AS
SELECT productCode, productName, productPrice, productStatus
FROM products; 

SELECT * FROM products_view;

/* Tiến hành sửa đổi view */
CREATE OR REPLACE VIEW products_view AS 
SELECT productCode, productName, productPrice, productStatus
FROM products
WHERE productName = 'Realme X';

SELECT * FROM products_view;

/* Tiến hành xoá view */
DROP VIEW products_view;

/* Bước 5: Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product */
DELIMITER //
CREATE PROCEDURE findAllProduct()
BEGIN
SELECT * FROM products ;
END; //
DELIMITER ; 

call findAllProduct();

/*Tạo store procedure thêm một sản phẩm mới */
insert into products (productCode, productName, productPrice, productAmount, productDescription, productStatus) 
values ('006', 'Iphone X', '10000000', 5, 'Iphone', 'Stocking')

SELECT * 
FROM products

/* Tạo store procedure sửa thông tin sản phẩm theo id */
DELIMITER //
DROP PROCEDURE IF EXISTS `findAllProduct`//
CREATE PROCEDURE findAllProduct()
BEGIN
   SELECT *  FROM products where id = 3;
END; //
DELIMITER ;

call findAllProduct();

/* Tạo store procedure xoá sản phẩm theo id */
DELIMITER //
CREATE PROCEDURE delete_id()
BEGIN
  DELETE FROM products
  WHERE id = 3;
  select * from products;
END; //
DELIMITER ;   

call delete_id();