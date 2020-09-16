use furuma;
select * 
from furuma.contract;
select * 
from furuma.ontract_detail;
select * 
from furuma.customer;
select * 
from furuma.department_employee;
select *
from furuma.employee;
select *
from furuma.level_employee;
select *
from furuma.positive_employee;
select *
from furuma.service;
select *
from furuma.service_accompanied;
select *
from furuma.type_customer;
select *
from furuma.type_rent;
select *
from furuma.type_service;

/* Task 1: Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới */
-- Thông tin kiểu thuê
insert into type_rent (name_type_rent, price_rent)
values
('3 days', 300000),
('a week',700000),
('a month', 3100000);

-- Thông tin loại dịch vụ
insert into type_service (name_type_service)
values
('Villa'),
('House'),
('Room'),
('Villa'),
('Room');

-- Thông tin về dịch vụ
insert into service (name_service, area, number_floor, maximum_customer, cost_rent, `status`)
values
('Villa',30, 3, '20', '3000000', 'Booked'),
('House',40, 4, '30', '4000000', 'Empty'),
('Room',50, 2, '35', '5000000', 'Empty'),
('House',60, 5, '40', '6000000', 'Booked'),
('Villa',55, 4, '45', '7000000', 'Empty');

-- Thông tin loại khách hàng
insert into type_customer (name_type_customer)
values
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');

-- Thông tin khách hàng
insert into customer (name_customer, day_of_birth_customer, identity_card, phone_customer, email_customer, address_customer)
values
('Ho Quynh Mai', '1995-05-15', '123456789', '0905002003', 'hoquynhmai@gmail.com', 'Da Nang'),
('Nguyen Kieu Tien', '1998-08-18', '111222333', '0901789456', 'nguyenkieutien@gmail.com', 'Quang Nam'),
('Tran Van Hoang', '1993-03-13', '999222000', '0789456512', 'tranvanhoang@gmail.com', 'Hue'),
('Trinh Khanh', '2000-02-20', '555666789', '0258147369', 'trinhkhanh@gmail.com','Hai Phong'),
('Ho Truc Mai', '1997-07-17', '561234789', '0123654789', 'hotrucmai@gmail.com','Binh Dinh');

-- Thông tin vị trí nhân viên
insert into positive_employee (name_positive_employee)
values
('Receptionist'), -- Lễ tân
('Waiters'), -- Phục vụ 
('Expert'), -- Chuyên viên
('Monitoring'), -- Giám sát
('Manager'),
('Directior');

-- Thông tin trình độ nhân viên
insert into level_employee (level_employee)
values
('Intermediate'), -- Trung cấp
('Colleges'), -- Cao đẳng
('University'),
('After university');

-- Thông tin bộ phận nhân viên
insert into department_employee (name_department_employee)
values
('Sale – Marketing'),
('Administrative'), -- Bộ phận hành chính
('Waiters'),
('Manager');

-- Thông tin nhân viên
insert into employee (name_employee, id_positive_employee, id_level_employee, id_department_employee , day_of_birth_employee, identity_card_employee, salary_employee, phone_number, email_employee, address_employee)
values
('Truong Van An', 1, 2, 4,'1980-10-10', '123456789', '5000000', '0123456789', 'truongvan.an', 'Da Nang'),
('Tran Viet Binh', 1, 3, 2, '1990-02-01', '123123123', '6000000', '0369258147', 'tranviet.binh', 'Hai Phong'),
('Trinh Pham Nha Uyen', 3, 4, 1, '1993-05-09', '369258147', '7000000', '0789456123', 'trinhphamnha.uyen', 'Bac Giang'),
('Pham Dinh Toan', 2, 2, 3, '1995-03-30', '789412563', '4500000', '0951357147', 'phamdinh.toan', 'Quy Nhon'),
('Phung Viet Hai', 4, 3, 1, '1991-08-28', '654987123', '4500000', '0852741963', 'phungviet.hai', 'Lao Cai');

-- Thông tin bảng hợp đồng
insert into contract (contract_date, contract_end_date, deposit_money, total_money)
values
('2020-09-10', '2020-09-15', 1000000,5000000),
('2020-09-01', '2020-09-20', 500000, 8000000),
('2020-09-11', '2020-09-24', 2000000, 7000000),
('2020-09-15', '2020-09-30', 1000000, 9000000),
('2020-09-16', '2020-09-20', 1000000, 5000000);

-- Thông tin dịch vụ đi kèm
insert into service_accompanied (name_service_accompanied, price, unit, status_service_accompanied)
values
('Massage', 300000, 100000, 'Free'),
('Karaoke', 400000, 100000, 'Free'),
('Food', 500000, 1000000, 'Free'),
('Drink', 600000, 1000000, 'Free'),
('Car Rental', 700000, 100000, 'Free');

-- Thông tin hợp đồng chi tiết
insert into contract_detail ()
values
(),
(),
(),
(),
();

/*Task 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự */
select *
from furuma.employee
where name_employee like 'H%' or name_employee like 'T%'or name_employee like 'K%';


/*Task3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/
select * 
from furuma.customer
where year(day_of_birth_customer) between 1970 and 2002
having address_customer = 'Da Nang' or address_customer = 'Quang Tri';

/*Task 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond” */
select name_customer, count(*) as count
from furuma.customer
	join contract on contract.id_contract = customer.id_customer
	join type_customer on type_customer.id_type_customer = customer.id_contract
where type_customer = 'Diamond'
group by name_customer
order by count;
