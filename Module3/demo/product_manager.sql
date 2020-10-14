drop database if exists product_manager;
Create database product_manager;
use product_manager;
create table category(
category_id int primary key auto_increment,
category_name varchar(50)
);
create table product(
product_id int primary key auto_increment,
product_name varchar(50) not null,
price double not null,
quantity int not null,
color varchar(50),
`description` text,
category_id int not null,
constraint fk_contegory foreign key (category_id) references category(category_id) on delete cascade on update cascade
);

insert into category(category_name)
values 
("phone"),
("television"),
("personal computer");

insert into product(product_name,price,quantity,color,category_id)
values 
("iPhone 11",799,12,"Purple",1),
("iPhone 11 Pro",1100,12,"White",1),
("iPhone X",749,13,"Blue",1),
("Smart TV màn hình cong 4k UHD 49 inch RU7300",10000000,5,"Black",2),
("SAMSUNG GALAXY S10 E",420,10,"Ceramic Black",1);
