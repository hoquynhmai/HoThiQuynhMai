create database classsicmodels;
use classsicmodels;
create table customer (
id int primary key auto_increment,
customername varchar(50),
phone char(10),
city varchar(20),
country varchar(20)
);
drop table customer;
insert into customer(customername,phone,city,country)
values
('A','1234567890','Hải Phòng','Việt Nam'),
('Mai','0905123456','Đà Nẵng','Việt Nam'),
('Sao','0901111222','Huế','Việt Nam');
insert into customer(customername,phone,city,country)
values
('John','0901111332','Hội An','Việt Nam');
delete from customer
where id = 4;
drop database classsicmodels;