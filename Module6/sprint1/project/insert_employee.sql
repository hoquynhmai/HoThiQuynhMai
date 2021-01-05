use project1_ticket_agency;

insert into app_role (id,`name`)
values
	(1,'Admin'),
	(2,'Employee'),
	(3,'User');

insert into app_account (id,`password`, username, `enabled`, app_role_id)
values
	(1, '$2y$12$oVUkilFRsyZEcYSq/tae2OzIoqVbJUaWuiuUEHQyFTSge7Ltwhyp2', 'hoquynhmai@gmail.com', 1, 1);
    
insert into employee (id, employee_code, full_name, birthday, gender, email, `address`, phone_number, app_account_id)
values
	(1,'NV-1111', 'Hồ Huy Hoàng', '1990-06-01', 1, 'hoquynhmai@gmail.com', 'Đà Nẵng', '0935161990', 1);