use project1_ticket_agency;

# role
insert into project1_ticket_agency.app_role (id, name) 
values 
(1, 'Admin'),
(2, 'Employee'),
(3, 'User');

# account
insert into project1_ticket_agency.app_account (id, enabled, password, username, verification_code, app_role_id) 
values 
(1, true, '$2a$10$an/E3E9ow74oSYc6jJluyOGnxMSeXai7kAM0uKIhioAe.CpE/gtqy', 'user@gmail.com', 
'o1vsAyF2yV4O4Xs6AY2QMwxgp62adEMs1qnuVQhIDEMqp45wLadHqfaQVtwsAIoX', 3),
(2, true, '$2a$10$an/E3E9ow74oSYc6jJluyOGnxMSeXai7kAM0uKIhioAe.CpE/gtqy', 'admin@gmail.com', 
'o1vsAyF2yV4O4Xs6AY2QMwxgp62adEMs1qnuVQhIDEMqp45wLadHqfaQVtwsAIoX', 1),
(3, true, '$2a$10$an/E3E9ow74oSYc6jJluyOGnxMSeXai7kAM0uKIhioAe.CpE/gtqy', 'employee@gmail.com', 
'o1vsAyF2yV4O4Xs6AY2QMwxgp62adEMs1qnuVQhIDEMqp45wLadHqfaQVtwsAIoX', 2);

# admin, user, employee
insert into project1_ticket_agency.app_admin (id, address, birthday, email, full_name, gender, phone_number, app_account_id) values (1, '72 Hàm , Đà Nẵng', '1992-07-20', 'admin@gmail.com', 'Admin Account', true, 0785855955, 2);
insert into project1_ticket_agency.app_user (id, address, birthday, email, full_name, gender, phone_number, user_rank, app_account_id, user_type_id) values (1, '111 Lê Duẩn, Đà Nẵng', '2000-02-19', 'user@gmail.com', 'User Account', true, 0909111111, null, 1, null);
insert into project1_ticket_agency.employee (id, address, birthday, email, employee_code, full_name, gender, phone_number, app_account_id) values (1, 'Đà Nẵng', '1990-06-01', 'employee@gmail.com', 'NV-1111', 'Employee Account', true, 0935161990, 3);

# status payment
INSERT INTO project1_ticket_agency.booking (id, booking_code, booking_date, user_id) VALUES (1, 'BC12345', '2020-12-01', 1);
INSERT INTO project1_ticket_agency.status_payment (id, name) VALUES (1, 'Cancel');
INSERT INTO project1_ticket_agency.status_payment (id, name) VALUES (2, 'Pending');
INSERT INTO project1_ticket_agency.status_payment (id, name) VALUES (3, 'Paid');

# luggage
INSERT INTO `luggage` VALUES 
(1,'Gói 15kg',155000),(2,'Gói 20kg',175000),(3,'Kiện HLQK 20kg',375000);

# flight info
INSERT INTO `flight_information` VALUES 
(1,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-22','13:05:00','Đà Nẵng (DAD)','2020-12-22','11:40:00','VJ629',49000,'Hạng phổ thông'),
(2,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-22','13:05:00','Đà Nẵng (DAD)','2020-12-22','11:40:00','VJ629',699000,'Hạng thương gia'),
(3,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-22','13:05:00','Đà Nẵng (DAD)','2020-12-22','11:40:00','VJ629',2300000,'Hạng nhất'),
(4,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-17','13:05:00','Đà Nẵng (DAD)','2020-12-23','11:40:00','VJ629',49000,'Hạng phổ thông'),
(5,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-17','13:05:00','Đà Nẵng (DAD)','2020-12-23','11:40:00','VJ629',699000,'Hạng thương gia'),
(6,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-17','13:05:00','Đà Nẵng (DAD)','2020-12-23','11:40:00','VJ629',2300000,'Hạng nhất'),
(7,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-18','13:05:00','Đà Nẵng (DAD)','2020-12-24','11:40:00','VJ629',49000,'Hạng phổ thông'),
(8,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-18','13:05:00','Đà Nẵng (DAD)','2020-12-24','11:40:00','VJ629',699000,'Hạng thương gia'),
(9,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-18','13:05:00','Đà Nẵng (DAD)','2020-12-24','11:40:00','VJ629',2300000,'Hạng nhất'),
(10,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-19','13:05:00','Đà Nẵng (DAD)','2020-12-25','11:40:00','VJ629',49000,'Hạng phổ thông'),
(11,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-19','13:05:00','Đà Nẵng (DAD)','2020-12-25','11:40:00','VJ629',699000,'Hạng thương gia'),
(12,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-19','13:05:00','Đà Nẵng (DAD)','2020-12-25','11:40:00','VJ629',2300000,'Hạng nhất'),
(13,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-20','13:05:00','Đà Nẵng (DAD)','2020-12-26','11:40:00','VJ629',49000,'Hạng phổ thông'),
(14,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-20','13:05:00','Đà Nẵng (DAD)','2020-12-26','11:40:00','VJ629',699000,'Hạng thương gia'),
(15,'VietJet','TP Hồ Chí Minh (SGN)','2020-12-20','13:05:00','Đà Nẵng (DAD)','2020-12-26','11:40:00','VJ629',2300000,'Hạng nhất'),
(16,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-16','13:05:00','Đà Nẵng (DAD)','2020-12-22','11:40:00','VN131',49000,'Hạng phổ thông'),
(17,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-16','13:05:00','Đà Nẵng (DAD)','2020-12-22','11:40:00','VN131',699000,'Hạng thương gia'),
(18,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-16','13:05:00','Đà Nẵng (DAD)','2020-12-22','11:40:00','VN131',2300000,'Hạng nhất'),
(19,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-17','13:05:00','Đà Nẵng (DAD)','2020-12-23','11:40:00','VN131',49000,'Hạng phổ thông'),
(20,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-17','13:05:00','Đà Nẵng (DAD)','2020-12-23','11:40:00','VN131',699000,'Hạng thương gia'),
(21,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-17','13:05:00','Đà Nẵng (DAD)','2020-12-23','11:40:00','VN131',2300000,'Hạng nhất'),
(22,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-18','13:05:00','Đà Nẵng (DAD)','2020-12-24','11:40:00','VN131',49000,'Hạng phổ thông'),
(23,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-18','13:05:00','Đà Nẵng (DAD)','2020-12-24','11:40:00','VN131',699000,'Hạng thương gia'),
(24,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-18','13:05:00','Đà Nẵng (DAD)','2020-12-24','11:40:00','VN131',2300000,'Hạng nhất'),
(25,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-19','13:05:00','Đà Nẵng (DAD)','2020-12-25','11:40:00','VN131',49000,'Hạng phổ thông'),
(26,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-19','13:05:00','Đà Nẵng (DAD)','2020-12-25','11:40:00','VN131',699000,'Hạng thương gia'),
(27,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-19','13:05:00','Đà Nẵng (DAD)','2020-12-25','11:40:00','VN131',2300000,'Hạng nhất'),
(28,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-20','13:05:00','Đà Nẵng (DAD)','2020-12-26','11:40:00','VN131',49000,'Hạng phổ thông'),
(29,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-20','13:05:00','Đà Nẵng (DAD)','2020-12-26','11:40:00','VN131',699000,'Hạng thương gia'),
(30,'VietnamAirlines','TP Hồ Chí Minh (SGN)','2020-12-20','13:05:00','Đà Nẵng (DAD)','2020-12-26','11:40:00','VN131',2300000,'Hạng nhất'),
(31,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-17','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-22','11:40:00','VN131',49000,'Hạng phổ thông'),
(32,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-17','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-22','11:40:00','VN131',699000,'Hạng thương gia'),
(33,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-17','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-22','11:40:00','VN131',2300000,'Hạng nhất'),
(34,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-18','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-23','11:40:00','VN131',49000,'Hạng phổ thông'),
(35,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-18','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-23','11:40:00','VN131',699000,'Hạng thương gia'),
(36,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-18','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-23','11:40:00','VN131',2300000,'Hạng nhất'),
(37,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-19','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-24','11:40:00','VN131',49000,'Hạng phổ thông'),
(38,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-19','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-24','11:40:00','VN131',699000,'Hạng thương gia'),
(39,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-19','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-24','11:40:00','VN131',2300000,'Hạng nhất'),
(40,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-20','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-25','11:40:00','VN131',49000,'Hạng phổ thông'),
(41,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-20','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-25','11:40:00','VN131',699000,'Hạng thương gia'),
(42,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-20','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-25','11:40:00','VN131',2300000,'Hạng nhất'),
(43,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-21','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-26','11:40:00','VN131',49000,'Hạng phổ thông'),
(44,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-21','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-26','11:40:00','VN131',699000,'Hạng thương gia'),
(45,'VietnamAirlines','Đà Nẵng (DAD)','2020-12-21','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-26','11:40:00','VN131',2300000,'Hạng nhất'),
(46,'VietJet','Đà Nẵng (DAD)','2020-12-22','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-17','11:40:00','VJ629',49000,'Hạng phổ thông'),
(47,'VietJet','Đà Nẵng (DAD)','2020-12-22','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-17','11:40:00','VJ629',699000,'Hạng thương gia'),
(48,'VietJet','Đà Nẵng (DAD)','2020-12-22','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-17','11:40:00','VJ629',2300000,'Hạng nhất'),
(49,'VietJet','Đà Nẵng (DAD)','2020-12-23','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-18','11:40:00','VJ629',49000,'Hạng phổ thông'),
(50,'VietJet','Đà Nẵng (DAD)','2020-12-23','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-18','11:40:00','VJ629',699000,'Hạng thương gia'),
(51,'VietJet','Đà Nẵng (DAD)','2020-12-23','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-18','11:40:00','VJ629',2300000,'Hạng nhất'),
(52,'VietJet','Đà Nẵng (DAD)','2020-12-24','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-19','11:40:00','VJ629',49000,'Hạng phổ thông'),
(53,'VietJet','Đà Nẵng (DAD)','2020-12-24','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-19','11:40:00','VJ629',699000,'Hạng thương gia'),
(54,'VietJet','Đà Nẵng (DAD)','2020-12-24','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-19','11:40:00','VJ629',2300000,'Hạng nhất'),
(55,'VietJet','Đà Nẵng (DAD)','2020-12-25','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-20','11:40:00','VJ629',49000,'Hạng phổ thông'),
(56,'VietJet','Đà Nẵng (DAD)','2020-12-25','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-20','11:40:00','VJ629',699000,'Hạng thương gia'),
(57,'VietJet','Đà Nẵng (DAD)','2020-12-25','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-20','11:40:00','VJ629',2300000,'Hạng nhất'),
(58,'VietJet','Đà Nẵng (DAD)','2020-12-26','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-21','11:40:00','VJ629',49000,'Hạng phổ thông'),
(59,'VietJet','Đà Nẵng (DAD)','2020-12-26','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-21','11:40:00','VJ629',699000,'Hạng thương gia'),
(60,'VietJet','Đà Nẵng (DAD)','2020-12-26','13:05:00','TP Hồ Chí Minh (SGN)','2020-12-21','11:40:00','VJ629',2300000,'Hạng nhất');

# ticket
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (3, 1231241, 124124, 0, 'AB002', 1, 4, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (4, 1231241, 124124, 0, 'AB002', 1, 4, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (5, 1231241, 124124, 0, 'AB002', 1, 7, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (6, 1231241, 124124, 0, 'AB002', 1, 7, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (7, 1231241, 124124, 0, 'AB002', 1, 11, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (8, 1231241, 124124, 0, 'AB002', 1, 11, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (9, 1231241, 124124, 0, 'AB002', 1, 30, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (10, 1231241, 124124, 0, 'AB002', 1, 30, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (11, 1231241, 124124, 0, 'AB002', 1, 31, 2);
INSERT INTO `project1_ticket_agency`.`ticket` (`id`, `price_arrival`, `price_departure`, `status_checkin`, `ticket_code`, `employee_id`, `flight_information_id`, `status_payment_id`) VALUES (12, 1231241, 124124, 0, 'AB002', 1, 31, 2);

#invoice
insert into invoice (id,date_created,form_code,invoice_code,total_money,user_id)
values(1,'2020-12-12','GTHDK','ILOG',1234,1),
(5,'2020-08-11','GTHDK','ILOG',1234,1),
(2,'2020-09-09','GTHDK','ILOG',5773,1),
(3,'2020-10-10','GTHDK','ILOG',12234,1),
(4,'2020-06-04','GTHDK','ILOG',121234,1);

#employee
insert into app_account (id,`password`, username, `enabled`, app_role_id)
values
    (4, '$2y$12$oVUkilFRsyZEcYSq/tae2OzIoqVbJUaWuiuUEHQyFTSge7Ltwhyp2', 'h3bam@gmail.com', 1, 1),
    (5, '$2y$12$oVUkilFRsyZEcYSq/tae2OzIoqVbJUaWuiuUEHQyFTSge7Ltwhyp2', 'c0nl0ck@gmail.com', 1, 1),
    (6, '$2y$12$oVUkilFRsyZEcYSq/tae2OzIoqVbJUaWuiuUEHQyFTSge7Ltwhyp2', 'hoquynhmai@gmail.com', 1, 2),
    (7, '$2y$12$oVUkilFRsyZEcYSq/tae2OzIoqVbJUaWuiuUEHQyFTSge7Ltwhyp2', 'trucmai0810@gmail.com', 1, 2),
    (8, '$2y$12$oVUkilFRsyZEcYSq/tae2OzIoqVbJUaWuiuUEHQyFTSge7Ltwhyp2', 'huuduy@gmail.com', 1, 1),
    (9, '$2y$12$oVUkilFRsyZEcYSq/tae2OzIoqVbJUaWuiuUEHQyFTSge7Ltwhyp2', 'xuandiem@gmail.com', 1, 1);
    -- Pass: Codegym06

insert into employee (id, employee_code, full_name, birthday, gender, email, `address`, phone_number, app_account_id)
values
    (7,'NV-1111', 'Hồ Huy Hoàng', '1990-06-01', 1, 'h3bam@gmai.com', 'Đà Nẵng', '0935161990',4),
    (2,'NV-2222', 'Hồ Hồng Nhung', '1993-01-02', 1, 'c0nl0ck@gmail.com', 'Đà Nẵng', '0905129775',5),
    (3,'NV-3333', 'Hồ Quỳnh Mai', '1995-05-15', 1, 'hoquynhmai@gmail.com', 'Đà Nẵng', '0901171603',6),
    (4,'NV-4444', 'Hồ Trúc Mai', '1996-10-08', 1, 'trucmai0810@gmail.com', 'Đà Nẵng', '0905085170',7),
    (5,'NV-5555', 'Tràn Hữu Duy', '2009-09-29', 1, 'huuduy@gmail.com', 'Quảng Nam', '0776401281',8),
    (6,'NV-6666', 'Trần Xuân Diễm', '1993-06-25', 1, 'xuandiem@gmail.com', 'Quảng Nam', '0935293949',9);
    
#promo
INSERT INTO `project1_ticket_agency`.`promotion` (`id`, `airline`,  `arrival_place`,`arrival_time`, `departure_date`,   `departure_place`, `departure_time`, `flight`, `flight_number`, `information`, `price`) 
VALUES 
(1,'Bamboo Airway','Tp.HCM (SGN)','07:25:00','2021-01-04','Đà Nẵng (DAD)','05:15:00','DAD-SGN','QH 123','',1990000),
(2,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-05','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 246','',899000),
(3,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-05','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 111','',529000),
(4,'Vietnam Airlines','Hà Nội (HAN)','07:25:00','2021-01-10','Đà Nẵng (DAD)','05:15:00','DAD-HAN','VN 201','',2599000),
(5,'Vietnam Airlines','Phú Quốc (PQC)','10:25:00','2021-01-06','Hà Nội (HAN)','08:15:00','HAN-PQC','VN 222','',2039000),
(6,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-07','Hải Phòng (HPH)','05:15:00','HPH-SGN','VJ 176','',2790000),
(7,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-08','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 113','',1689000),
(8,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-09','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 777','',99000),
(9,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-10','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 178','',299000),
(10,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-04','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 456','',399000),
(11,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-06','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 369','',99000),
(12,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-07','Hải Phòng (HPH)','05:15:00','HPH-SGN','VJ 357','',2990000),
(13,'VietJet Air','Tp.HCM (SGN)','11:25:00','2021-01-08','Hải Phòng (HPH)','09:15:00','HPH-SGN','VJ 246','',5990000),
(14,'Bamboo Airway','Tp.HCM (SGN)','07:25:00','2021-01-09','Đà Nẵng (DAD)','05:15:00','DAD-SGN','QH 123','',1990000),
(15,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-10','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 246','',899000),
(16,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-08','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 111','',529000),
(17,'Vietnam Airlines','Hà Nội (HAN)','07:25:00','2021-01-04','Đà Nẵng (DAD)','05:15:00','DAD-HAN','VN 201','',2599000),
(18,'Vietnam Airlines','Phú Quốc (PQC)','10:25:00','2021-01-06','Hà Nội (HAN)','08:15:00','HAN-PQC','VN 222','',2039000),
(19,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-07','Hải Phòng (HPH)','05:15:00','HPH-SGN','VJ 176','',2790000),
(20,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-08','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 113','',1689000),
(21,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-04','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 777','',99000),
(22,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-05','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 178','',299000),
(23,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-04','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 456','',399000),
(24,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-06','Đà Nẵng (DAD)','05:15:00','DAD-SGN','VJ 369','',99000),
(25,'VietJet Air','Tp.HCM (SGN)','07:25:00','2021-01-07','Hải Phòng (HPH)','05:15:00','HPH-SGN','VJ 357','',2990000);