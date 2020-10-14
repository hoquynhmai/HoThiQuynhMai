drop database if exists student;
create database student;
use student;

create table class (
	class_id int primary key auto_increment,
    class_name varchar (50)
);

insert into class
values
	(1, 'C0620G1'),
	(2, 'C0720G1'),
	(3, 'C0920G1');

create table student (
	student_id varchar (50) primary key,
    student_name varchar (50),
    age int,
    email varchar (50),
    address varchar (50),
    class_id int,
    foreign key (class_id) references class(class_id) on delete cascade on update cascade
);

insert into student
values
	('CG-527', 'Chau Luong Phu', 25, 'chauluong@gmail.com', 'Quang Nam', 1),
	('CG-515', 'Mai Ho Quynh', 25, 'maiho@gmail.com', 'Da Nang', 1),
	('CG-217', 'Din Luong Vu', 24, 'dinluong@gmail.com', 'Quang Ngai', 1),
	('CG-902', 'Khanh Nguyen Quoc', 26, 'khanh@gmail.com', 'Quang Nam', 2),
	('CG-222', 'Lanh Nguyen Quang', 23, 'lanhnguyen@gmail.com', 'Da Nang', 2),
	('CG-777', 'Vu Nguyen Duc', 23, 'vunguyen@gmail.com', 'Ha Tinh', 3),
	('CG-810', 'Mai Ho Truc', 24, 'trucmai@gmail.com', 'Da Nang', 3);
​
DELIMITER //
create procedure update_student (id_update varchar (50), name_update varchar(50), age_update int, email_update varchar (50), address_update varchar (50), class_id_update int)
BEGIN
	update student
    set student_name = name_update, age = age_update, email = email_update, address = address_update, class_id = class_id_update
    where student_id = id_update;
END //
DELIMITER ;
​
DELIMITER //
create procedure delete_student(id_need_delete varchar (50))
BEGIN
	delete from student
    where student_id = id_need_delete;
END //
DELIMITER ;