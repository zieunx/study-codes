drop table if exists PRODUCT;

create table PRODUCT (
    id int not null,
    name varchar(100) not null,
    price int not null,
    stock int not null,
    description varchar(1000) not null,
    category varchar(100) not null,
    primary key (id)
);
