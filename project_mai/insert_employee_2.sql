use project1_ticket_agency;

insert into app_role (id,`name`)
values
	(1,'Admin'),
	(2,'Employee'),
	(3,'User');
    
insert into app_account (id,`enabled`, `password`, username,verification_code, app_role_id)
values
(1, 1, '$2a$10$PveysJuxebQAmPxsAAFNduUr1.RPYfiJ0vqfopu3YUhdQ/8wT8nHy', 'h3bam@gmail.com',
'GD7FReAl0t0GDzYDf4kOrvgR4UtAxZgzR2RYPun4TFvBfQeDevNFFBOAgkwdfshv', 1),
(2, 1, '$2a$10$9aH.OkqETjojkAxUaBW3lOYJGuKMIFz3KFthwRqpLPf8B6LEkZqMO', 'c0nl0ck@gmail.com',
'aPrbhM9A8H2rkiBkG8JqusbI2qOgjhhQpaiKXLXiQfujmxRB57TANehaaSQQDSK6', 2),
(3, 1, '$2a$10$4G3qbobzT9rqxfAQl2YWGuP5LEcan3O5xA7zo6AzQ05iTmf5AaFvW', 'hoquynhmai@gmail.com',
'JGqIha4VkAiLbUiiMQaIJOnqq3w9S9DKf7hqPzonVYBBsAlBI63Zd0RWrDRp9wKJ', 2),
(4, 1, '$2a$10$jTKysKZVap6P.R77gTdPvuTrORZ5wWF6tnd1MpCaD5WCMMpx73ZUK', 'trucmai@gmail.com',
'BBlm5ubyKL0ol1WpP3aYx1oiVLKhJcoOWeCHV488vtsfNXIvCBRH27cwueVydoXc', 2),
(5, 1, '$2a$10$/5DwToA9JGsNWt4Yg/3ew.fSV0PDvZ3O5NdOdPmo/iVHB0TS6E7t6', 'huuduy@gmail.com',
'cX9Ir5QTaJsyWC3cGeq19nUNCVrsEWxT7IDkdOrxxOKBT9BPlHwRkpvQ05cvd7Sf', 2),
(6, 1, '$2a$10$xdpZvRNDzwscizjfjhKhf.RAFJ4aBIrMZm7FJ0t0zzXth57lUXbA6', 'xuandiem@gmail.com',
'FktiEXefTPMFiGf9pGBEQkM3OxzvM3nqjk6zIDiy0U9FtKszx9aPJrurKKDtz2Zf', 2);


insert into employee (id, employee_code, full_name, birthday, gender, email, `address`, phone_number, app_account_id)
values
(1, 'NV-1111', 'Hồ Huy Hoàng', '1990-06-01', 1, 'employee@gmail.com', 'Đà Nẵng', 0935161990,1),
(2, 'NV-2222', 'Hồ Thị Hồng Nhung','1990-01-02', 1, 'c0nl0ck@gmail.com', 'Đà Nẵng', 0905648403,2),
(3, 'NV-3333', 'Hồ Thị Quỳnh Mai', '1990-05-15', 1, 'hoquynhmai@gmail.com', 'Đà Nẵng', 0901171603,2),
(4, 'NV-4444', 'Hồ Trúc Mai', '1990-10-08', 1, 'trucmai@gmail.com', 'Đà Nẵng', 0905085170,2),
(5, 'NV-5555', 'Trần Hữu Duy', '1990-09-29', 1, 'huuduy@gmail.com', 'Đà Nẵng', 0776401281,2),
(6, 'NV-6666', 'Trần Xuân Diễm', '1990-06-25', 1, 'xuandiem@gmail.com', 'Đà Nẵng', 0935161990,2);