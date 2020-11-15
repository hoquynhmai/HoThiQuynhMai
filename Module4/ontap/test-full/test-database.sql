drop database if exists test_complete;
create database test_complete;

use test_complete;

create table product_type (
	id int primary key auto_increment,
    `name` varchar (45)
);

insert into product_type (`name`)
values
	('SmartPhone'),
	('TiVi'),
	('LapTop'),
	('Other Machine');

    
    create table product (
	id int primary key auto_increment,
    `name` varchar(45),
    cost varchar(45),
    `status` varchar(45),
    product_type_id int,
    foreign key (product_type_id) references product_type(id) on delete cascade on update cascade
);

insert into product
values
	( 1,'SamSung TV', 500000, 'empty', 2),
	( 2,'Dell 155',  100000, 'empty', 3),
	( 3,'Lamp', '900000', 'empty', '4'),
	(4,'A51', 800000, 'empty', 1);
    
    create table APP_USER ( USER_ID BIGINT not null , USER_NAME VARCHAR(36) not null, ENCRYTED_PASSWORD VARCHAR(128) not null, ENABLED BIT not null ) ;
alter table APP_USER add constraint APP_USER_PK primary key (USER_ID);
alter table APP_USER add constraint APP_USER_UK unique (USER_NAME);

create table APP_ROLE ( ROLE_ID BIGINT not null, ROLE_NAME VARCHAR(30) not null ) ;
alter table APP_ROLE add constraint APP_ROLE_PK primary key (ROLE_ID);
alter table APP_ROLE add constraint APP_ROLE_UK unique (ROLE_NAME);

create table USER_ROLE ( ID BIGINT not null, USER_ID BIGINT not null, ROLE_ID BIGINT not null );
alter table USER_ROLE add constraint USER_ROLE_PK primary key (ID);
alter table USER_ROLE add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);
alter table USER_ROLE add constraint USER_ROLE_FK1 foreign key (USER_ID) references APP_USER (USER_ID);
alter table USER_ROLE add constraint USER_ROLE_FK2 foreign key (ROLE_ID) references APP_ROLE (ROLE_ID);

CREATE TABLE Persistent_Logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');
insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_MEMBER');
	