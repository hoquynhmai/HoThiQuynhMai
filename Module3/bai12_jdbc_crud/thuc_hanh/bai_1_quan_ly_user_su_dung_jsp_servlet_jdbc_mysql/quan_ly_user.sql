DROP database if exists  quan_ly_user ;
CREATE DATABASE quan_ly_user;
USE quan_ly_user;

create table users (
 id  int NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

create table Permision(
id int primary key AUTO_INCREMENT,
name varchar(50)
);

 

create table User_Permision(
permision_id int,
user_id int
);

insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');

insert into Permision(`name`) values('add');
insert into Permision(`name`) values('edit');
insert into Permision(`name`) values('delete');
insert into Permision(`name`) values('view');