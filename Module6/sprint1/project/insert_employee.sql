use project1_ticket_agency;

insert into app_role (id,`name`)
values
	(1,'Admin'),
	(2,'Employee'),
	(3,'User');
    
-- insert into app_admin (id,address, birthday,email, full_name, gender, phone_number, app_account_id)
-- values
-- 	(1,'72 Hàm - Đà Nẵng',1992-07-20,'admin@gmail.com','Admin Account',true,785855955,2);

insert into app_account (id,`enabled`,`password`,username,verification_code, app_role_id)
values
    (1,true,'$2a$10$an/E3E9ow74oSYc6jJluyOGnxMSeXai7kAM0uKIhioAe.CpE/gtqy','admin@gmail.com','o1vsAyF2yV4O4Xs6AY2QMwxgp62adEMs1qnuVQhIDEMqp45wLadHqfaQVtwsAIoX',1);
    
-- insert into employee (id, employee_code, full_name, birthday, gender, email, `address`, phone_number, app_account_id)
-- values
-- 	(1,'NV-1111','Employee Account','1990-06-01',true,'employee@gmail.com','Đà Nẵng','0935161990',3);