drop table if exists product;

create table product (
    id bigint not null,
    name varchar(100) not null,
    price bigint not null,
    stock bigint not null,
    description varchar(1000) not null,
    category varchar(100) not null,
    primary key (id)
);