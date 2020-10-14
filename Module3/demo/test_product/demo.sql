drop database if exists database_product;
create database database_product;
use database_product;

create table category (
	category_id int primary key,
    category_name varchar (50)
);

create table color (
	color_id int primary key,
    color_name varchar (50)
);

insert into color
values
	(1, 'Red'),
	(2, 'Blue'),
	(3, 'Black'),
	(4, 'White'),
	(5, 'Yellow');

create table product (
	product_id int primary key auto_increment,
    product_name varchar (50),
    price int,
    quantity int,
    color_id int,
    foreign key (color_id) references color(color_id) on delete cascade on update cascade,
    `description` varchar (50),
    category_id int,
    foreign key (category_id) references category(category_id) on delete cascade on update cascade
);
​
DELIMITER //
create procedure update_product (id_update int, name_update varchar(50), price_update int, quantity_update int, 
color_update int, description_update varchar (50), category_id_update int)
BEGIN
	update product
    set product_name = name_update, price = price_update, quantity = quantity_update, color_id = color_update,
    `description` = description_update, category_id = category_id_update
    where product_id = id_update;
END //
DELIMITER ;
​
DELIMITER //
create procedure delete_product(id_need_delete int)
BEGIN
	delete from product
    where product_id = id_need_delete;
END //
DELIMITER ;

insert into category
values
	(1, 'Phone'),
	(2, 'Television'),
	(3, 'Other Machine');
    
insert into product
values
	(1, 'Iphone 11', 11000000, 10, 1, 'Nice', 1),
	(2, 'Smart TV Samsung', 12000000, 5, '3', 'Nice', 2),
	(3, 'Acer Nitro 5', 13000000, 7, 5, 'Nice', 3),
	(4, 'Iphone 12', 15000000, 3, 2, 'Nice', 1),
	(5, 'Dell Pro', 10000000, 11, 3, 'Nice', 3),
	(6, 'Asus ROG', 23000000, 12, 4, 'Nice', 3),
	(7, 'HP Vip', 19000000, 15, 1, 'Nice', 3);