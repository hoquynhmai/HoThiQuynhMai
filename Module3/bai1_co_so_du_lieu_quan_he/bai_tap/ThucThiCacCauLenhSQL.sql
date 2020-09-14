create database classsicmodels;
use classsicmodels;
create table customer(
id int primary key auto_increment,
customername varchar(50),
phone int(10),
city varchar(20),
country varchar(20)
);
insert into customer (customername,phone,city,country)
values
('Hồ',090,'Đà Nẵng','Việt Nam'),
('Thị',171,'Hải Phòng','Việt Nam'),
('Quỳnh',123,'Huế','Việt Nam'),
('Mai',456,'Vũng Tàu','Việt Nam');
SELECT * FROM customer;
SELECT customerName, phone, city, country FROM customer;
SELECT * FROM customer WHERE city IN ('Hồ',090,'Đà Nẵng','Việt Nam') ;
drop database classsicmodels;