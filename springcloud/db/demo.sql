create database demo_user;

use demo_user;

create table tb_user(
	`id` bigint not null auto_increment,
    `name` varchar(100) not null,
    `sex` tinyint not null default 0,
    `create_time` datetime not null default CURRENT_TIMESTAMP,
	`update_time` datetime not null default CURRENT_TIMESTAMP on update current_timestamp,
    `delete` bool not null default false,
    primary key(id)
);
alter table tb_user add index idx_user_name (`name`);

create database demo_wallet;

use demo_wallet;

create table tb_wallet(
	`id` bigint not null auto_increment,
    `user_id` bigint not null,
    `total` decimal(20,5) not null default 0,
    `freezed` decimal(20,5) not null default 0,
    `useable` decimal(20,5) not null default 0,
	`delete` bool not null default false,
    primary key(id)
);
alter table tb_wallet add index idx_wallet_uid (`user_id`);