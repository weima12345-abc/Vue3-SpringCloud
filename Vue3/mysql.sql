create DATABASE shopping;
USE shopping;
create table account
(
    user_id          int auto_increment
        primary key,
    account_password varchar(20) not null,
    account_username varchar(20) not null,
    constraint account_account_username_uindex
        unique (account_username),
    constraint account_user_id_uindex
        unique (user_id)
);

create table commodity
(
    commodity_id    int auto_increment
        primary key,
    commodity_name  varchar(20) not null,
    commodity_price float       not null,
    constraint commodity_commodity_id_uindex
        unique (commodity_id)
);

create table order_record
(
    user_id        int         not null,
    commodity_id   int         not null,
    buy_time       timestamp   not null,
    commodity_name varchar(20) not null,
    record_id      int auto_increment
        primary key,
    constraint order_record_record_id_uindex
        unique (record_id)
);

create table shopping_cart
(
    commodity_id    int         not null,
    user_id         int         not null,
    commodity_name  varchar(20) not null,
    commodity_price float       not null,
    cart_id         int auto_increment
        primary key,
    constraint cart_id
        unique (cart_id)
);

create table user_message
(
    user_name        varchar(20) not null,
    user_id          int         not null,
    account_username varchar(20) not null,
    user_phone       varchar(20) not null,
    constraint user_message_account_username_uindex
        unique (account_username),
    constraint user_message_user_id_uindex
        unique (user_id),
    constraint user_message_user_phone_uindex
        unique (user_phone)
);
CREATE TABLE `logg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loginTime` varchar(30) DEFAULT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
