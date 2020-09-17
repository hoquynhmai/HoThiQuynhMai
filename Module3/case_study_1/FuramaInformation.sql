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
('Room'),
('Villa'),
('Room');

-- Thông tin về dịch vụ
insert into service (name_service, area, number_floor, maximum_customer, cost_rent, `status`)
values
('Villa 1',30, 3, '20', '3000000', 'Booked'),
('House',40, 4, '30', '4000000', 'Empty'),
('Room',50, 2, '35', '5000000', 'Empty'),
('House',60, 5, '40', '6000000', 'Booked'),
('Villa 2',55, 4, '45', '7000000', 'Empty');

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
('Nguyen Kieu Tien', 2,  '1998-08-18', '111222333', '0901789456', 'nguyenkieutien@gmail.com', 'Quang Nam'),
('Tran Van Hoang', 3, '1993-03-13', '999222000', '0789456512', 'tranvanhoang@gmail.com', 'Hue'),
('Trinh Khanh', 4, '2000-02-20', '555666789', '0258147369', 'trinhkhanh@gmail.com','Hai Phong'),
('Ho Truc Mai', 1, '1997-07-17', '561234789', '0123654789', 'hotrucmai@gmail.com','Binh Dinh');

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
insert into contract (id_employee, id_customer, id_service, contract_date, contract_end_date, deposit_money, total_money)
values
(2,3,1,'2020-09-10', '2020-09-15', 1000000,5000000),
(2,2,1,'2020-09-01', '2020-09-20', 500000, 8000000),
(1,2,3,'2020-09-11', '2020-09-24', 2000000, 7000000),
(4,3,2,'2020-09-15', '2020-09-30', 1000000, 9000000),
(3,3,3,'2020-09-16', '2020-09-20', 1000000, 5000000);

-- Thông tin dịch vụ đi kèm
insert into service_accompanied (name_service_accompanied, price, unit, status_service_accompanied)
values
('Massage', 300000, 100000, 'Free'),
('Karaoke', 400000, 100000, 'Free'),
('Food', 500000, 1000000, 'Free'),
('Drink', 600000, 1000000, 'Free'),
('Car Rental', 700000, 100000, 'Free');

-- Thông tin hợp đồng chi tiết
insert into contract_detail (id_contract, id_service_accompanied, amount_contract_detail)
values
(1,2,3),
(2,3,1),
(4,3,1),
(2,3,5),
(4,5,1);
