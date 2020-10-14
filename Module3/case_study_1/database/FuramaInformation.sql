use furuma;

/* Task 1: Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới */
-- Thông tin kiểu thuê
insert into type_rent (name_type_rent, price_rent)
values
('3 days', 3000),
('a week', 7000),
('a day', 1000),
('5 days', 5000),
('a month', 31000);

-- Thông tin loại dịch vụ
insert into type_service (name_type_service)
values
('Villa'),
('House'),
('Room');

-- Thông tin về dịch vụ
insert into service (name_service, area, number_floor, maximum_customer, cost_rent, id_type_service, id_type_rent, `status`)
values
('Villa 1',30, 3, '20', '3000', 1,5, 'Booked'),
('House 1',40, 4, '30', '4000',2,2, 'Empty'),
('Room',50, 2, '35', '5000',3,3, 'Empty'),
('House 2',60, 5, '40', '6000',2,4, 'Booked'),
('Villa 2',55, 4, '45', '7000',1,1, 'Empty');

-- Thông tin loại khách hàng
insert into type_customer (name_type_customer)
values
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');

-- Thông tin khách hàng
insert into customer (name_customer, id_type_customer, day_of_birth_customer, identity_card, phone_customer, email_customer, address_customer)
values
('Ho Quynh Mai', 1, '1995-05-15', '123456789', '0905002003', 'hoquynhmai@gmail.com', 'Da Nang'),
('Trinh Anh Sang', 2,  '1995-03-01', '111222333', '0901789456', 'trinhanhsang@gmail.com', 'Vinh'),
('Trinh Uyen', 1, '1995-11-01', '999222000', '0789456512', 'trinhphamnhauyen@gmail.com', 'Vinh'),
('Le Hoang Oanh', 1, '1995-10-01', '555666789', '0258147369', 'lehoangoanh@gmail.com','Quang Tri'),
('Ho Truc Mai', 5, '1996-10-08', '561234789', '0123654789', 'hotrucmai@gmail.com','Quang Ngai');

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
('Nguyen Truong An', 1, 1, 1,'1980-10-10', '123456789', '5000', '0123456789', 'nguyentruong.an', 'Da Nang'),
('Doan Thi To Uyen', 2, 2, 2, '1990-02-01', '123123123', '6000', '0369258147', 'donthito.uyen', 'Hai Phong'),
('Bui Van Thanh', 3, 3, 3, '1993-05-09', '369258147', '7000', '0789456123', 'buivan.thanh', 'Hai Chau'),
('Ho Thuy Hoang Tram Uyen', 4, 4, 4, '1995-03-30', '789412563', '4500', '0951357147', 'hothuyhoangtram.uyen', 'Quy Nhon'),
('Nguyen Khuong Binh', 5, 1, 1, '1991-08-28', '654987123', '4500', '0852741963', 'nguyenkhuong.binh', 'Lao Cai');

-- Thông tin bảng hợp đồng
insert into contract (id_employee, id_customer, id_service, contract_date, contract_end_date, deposit_money, total_money)
values
(1,1,1,'2018-03-10', '2018-03-15', 100,5000),
(2,3,2,'2019-01-01', '2019-01-20', 500, 8000),
(3,1,3,'2019-12-11', '2019-12-24', 200, 7000),
(4,4,4,'2018-05-15', '2018-05-30', 100, 9000),
(2,3,4,'2014-09-15', '2014-09-30', 100, 9000),
(5,5,5,'2020-08-16', '2020-08-20', 100, 5000);

-- Thông tin dịch vụ đi kèm
insert into service_accompanied (name_service_accompanied, price, unit, status_service_accompanied)
values
('Massage', 300, 100, 'Free'),
('Karaoke', 400, 100, 'Free'),
('Food', 500, 100, 'Free'),
('Drink', 600, 100, 'Free'),
('Car Rental', 700, 100, 'Free');

-- Thông tin hợp đồng chi tiết
insert into contract_detail (id_contract, id_service_accompanied, amount_contract_detail)
values
(1,5,3),
(2,2,1),
(3,3,1),
(4,3,5),
(1,5,1);
