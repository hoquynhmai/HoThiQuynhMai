use codegym_management;

alter table student
modify id int auto_increment;

insert into student (`name`, date_of_birth)
values
('Tien2', '2020-09-11'),
('Hung1', '2007-07-07'),
('Hung2', '2007-07-07'),
('Hung3', '2007-07-07');

insert into student (`name`, date_of_birth)
values ('Hung4', '2007-07-07');
