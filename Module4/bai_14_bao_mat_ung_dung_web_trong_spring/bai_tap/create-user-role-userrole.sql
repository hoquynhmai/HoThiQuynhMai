drop database if exists blogs;
create database blogs;

use blogs;

create table APP_USER (
	USER_ID bigint not null,
	USER_NAME varchar(36) not null,
	ENCRYTED_PASSWORD varchar(128) not null,
	ENABLED bit not null
);

alter table APP_USER add constraint APP_USER_PK primary key (USER_ID);

alter table APP_USER add constraint APP_USER_UK unique (USER_NAME);

create table APP_ROLE (
	ROLE_ID bigint not null,
	ROLE_NAME varchar(30) not null
);

alter table APP_ROLE add constraint APP_ROLE_PK primary key (ROLE_ID);

alter table APP_ROLE add constraint APP_ROLE_UK unique (ROLE_NAME);

create table USER_ROLE (
	ID bigint not null,
	USER_ID bigint not null,
	ROLE_ID bigint not null
);

alter table USER_ROLE add constraint USER_ROLE_PK primary key (ID);

alter table USER_ROLE add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);

alter table USER_ROLE add constraint USER_ROLE_FK1 foreign key (USER_ID) references APP_USER (USER_ID);

alter table USER_ROLE add constraint USER_ROLE_FK2 foreign key (ROLE_ID) references APP_ROLE (ROLE_ID);

-- create table PERSISTENT_LOGINS (
-- 	USERNAME varchar(64) not null,
-- 	SERIES varchar(64) not null,
-- 	TOKEN varchar(64) not null,
-- 	LAST_USED timestamp not null,
-- 	primary key (SERIES)
-- );

insert into APP_USER (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (2, 'hoquynhmaiuser', '$2y$12$hbUCCpd/CFFbHLz3s/MB9.b7fdbPkAHBBM0.DpJPd.9nyvffwmEp2', 1);

insert into APP_USER (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED)
values (1, 'hoquynhmai', '$2y$12$hbUCCpd/CFFbHLz3s/MB9.b7fdbPkAHBBM0.DpJPd.9nyvffwmEp2', 1);
-- pass: hoquynhmai 

insert into APP_ROLE (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');

insert into APP_ROLE (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');

insert into USER_ROLE (ID, USER_ID, ROLE_ID)
values (1, 1, 1);

insert into USER_ROLE (ID, USER_ID, ROLE_ID)
values (2, 1, 2);

insert into USER_ROLE (ID, USER_ID, ROLE_ID)
values (3, 2, 2);