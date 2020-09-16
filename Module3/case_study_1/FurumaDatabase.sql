drop database if exists furuma;
create database furuma;
use  furuma;

/* Task 1: Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới */
-- Bảng kiểu thuê 
drop table if exists type_rent;
create table type_rent (
id_type_rent int auto_increment,
name_type_rent varchar(45),
price_rent int,
primary key (id_type_rent)
);

-- Bảng loại dịch vụ
drop table if exists type_service ;
create table type_service (
id_type_service int auto_increment,
name_type_service varchar(45),
primary key (id_type_service)
);

-- Bảng thông tin dịch vụ
drop table if exists service;
create table service (
id_service int auto_increment,
name_service varchar(45),
area int,
number_floor int,
maximum_customer varchar(45),
cost_rent varchar(45),
id_type_service int,
foreign key (id_type_service) references type_service(id_type_service),
id_type_rent int,
foreign key (id_type_rent) references type_rent(id_type_rent),
`status` varchar(45),
primary key(id_service)
);

-- Bảng loại khách hàng 
drop table if exists type_customer;
create table type_customer (
id_type_customer int auto_increment ,
name_type_customer varchar(45),
primary key (id_type_customer)
); 

-- Bảng khách hàng 
drop table if exists customer;
create table customer (
id_customer int auto_increment,
id_type_customer int,
foreign key (id_type_customer) references type_customer(id_type_customer),
name_customer varchar(45),
day_of_birth_customer date,
identity_card varchar(45),
phone_customer varchar(45),
email_customer varchar(45),
address_customer varchar(45),
primary key (id_customer)
);

-- Bảng vị trí nhân viên
drop table if exists positive_employee;
create table positive_employee (
id_positive_employee int auto_increment ,
name_positive_employee varchar(45),
primary key (id_positive_employee)
);

-- Bảng trình độ nhân viên
drop table if exists level_employee;
create table level_employee (
id_level_employee int auto_increment,
level_employee varchar (45),
primary key (id_level_employee)
);

-- Bảng bộ phận nhân viên làm việc
drop table if exists department_employee;
create table department_employee (
id_department_employee int auto_increment,
name_department_employee varchar (45),
primary key (id_department_employee)
);

-- Bảng nhân viên
drop table if exists employee;
create table employee ( 
id_employee int auto_increment,
name_employee varchar(45),

id_positive_employee int, 
foreign key (id_positive_employee) references positive_employee(id_positive_employee),

id_level_employee int,
foreign key (id_level_employee) references level_employee (id_level_employee),

id_department_employee int,
foreign key (id_department_employee) references department_employee (id_department_employee),

day_of_birth_employee date,
identity_card_employee varchar(45),
salary_employee varchar(45),
phone_number varchar(45),
email_employee varchar(45),
address_employee varchar(45),
primary key (id_employee)
);

-- Bảng hợp đồng
 drop table if exists contract;
create table contract (
id_contract int auto_increment,
id_employee int,
foreign key (id_employee) references employee(id_employee),
id_customer int,
foreign key (id_customer) references customer (id_customer),
id_service int,
foreign key (id_service) references service (id_service),
contract_date date,
contract_end_date date,
deposit_money int, -- Tiền đặt cọc 
total_money int,
primary key (id_contract)
);

-- Bảng dịch vụ đi kèm
drop table if exists service_accompanied;
create table service_accompanied (
id_service_accompanied int auto_increment,
name_service_accompanied varchar(45),
price int,
unit int,
status_service_accompanied varchar (45),
primary key (id_service_accompanied)
);

-- Bảng hợp đồng chi tiết
drop table if exists contract_detail;
create table contract_detail (
id_contract_detail int auto_increment,
id_contract int,
foreign key (id_contract) references contract (id_contract),
id_service_accompanied int,
foreign key (id_service_accompanied) references service_accompanied (id_service_accompanied),
amount_contract_detail int,
primary key (id_contract_detail)
); 

/*Task 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự */
select name_employee `name`
from employee
where (`name`= 'H%' or `name`= 'T%' or `name`= '%K') and length(`name`) <= 15; 