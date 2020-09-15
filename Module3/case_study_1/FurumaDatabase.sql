drop database if exists furuma;
create database furuma;
use  furuma;

-- Bảng kiểu thuê 
drop table if exists type_rent;
create table type_rent (
id_type_rent int primary key,
name_type_rent varchar(45),
price_rent int
);

-- Bảng loại dịch vụ
drop table if exists type_service ;
create table type_service (
id_type_service int primary key,
name_type_service varchar(45)
);

-- Bảng thông tin dịch vụ
drop table if exists service;
create table service (
id_service int,
name_service varchar(45),
area int not null,
number_floor int,
maximum_customer varchar(45) not null,
cost_rent varchar(45) not null,
id_type_service int,
foreign key (id_type_service) references type_service(id_type_servicess),
id_type_rent varchar(50),
foreign key (id_type_rent) references type_rent(id_type_rent),
`status` varchar(45),
primary key(id_service)
);

-- Bảng loại khách hàng 
drop table if exists type_customer;
create table type_customer (
id_type_customer int primary key,
name_type_customer varchar(45)
);

-- Bảng khách hàng 
drop table if exists customer;
create table customer (
id_customer int primary key,
id_type_customer varchar(45),
foreign key (id_type_customer) references type_customer(id_type_customer),
name_customer varchar(45),
day_of_birth_customer date,
identity_card varchar(45),
phone_customer varchar(45),
email_customer varchar(45),
address_customer varchar(45)
);

-- Bảng vị trí nhân viên
drop table if exists positive_employee;
create table positive_employee (
id_positive_employee int primary key,
name_positive_employee varchar(45)
);

-- Bảng trình độ nhân viên
drop table if exists level_employee;
create table level_employee (
id_level_employee int,
level_employee varchar (45)
);

-- Bảng bộ phận nhân viên làm việc
drop table if exists department_employee;
create table department_employee (
id_department_employee int,
name_department_employee varchar (45)
);

-- Bảng nhân viên
drop table if exists employee;
create table employee ( 
id_employee int primary key,
name_employee varchar(45), -- varchar
id_positive_employee int not null , 
foreign key (id_positive_employee) references positive_employee(id_positive_employee),
id_level_employee int not null ,
foreign key (id_level_employee) references level_employee (id_level_employee),
id_department_employee varchar(45) not null ,
foreign key (id_department_employee) references department_employee (id_department_employee),
day_of_birth_employee date,
identity_card_employee varchar(45),
salary_employee varchar(45),
phone_number varchar(45),
email_employee varchar(45),
address_employee varchar(45)
);

-- Bảng hợp đồng
 drop table if exists contract;
create table contract (
id_contract int primary key,
id_employee int not null,
foreign key (id_employee) references employee(id_employee),
id_customer int not null ,
id_service int not null,
contract_date date not null,
contract_end_date date not null,
deposit_money int not null, -- Tiền đặt cọc 
total_money int
);

-- Bảng dịch vụ đi kèm
drop table if exists service_accompanied;
create table service_accompanied (
id_service_accompanied int primary key,
name_service_accompanied varchar(45),
price int,
unit int,
status_service_accompanied varchar (45)
);

-- Bảng hợp đồng chi tiết
drop table if exists contract_detail;
create table contract_detail (
id_contract_detail int primary key,
id_contract int not null,
foreign key (id_contract) references contract (id_contract),
id_service_accompanied int,
foreign key (id_service_accompanied) references service_accompanied (id_service_accompanied),
amount_contract_detail int
); 

