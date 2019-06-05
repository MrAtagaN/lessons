drop table if exists ADDRESS;
drop table if exists PERSON;
create table ADDRESS (
    ID integer primary key,
    country varchar(20) not null,
    city varchar(20) not null,
    street varchar(20) not null,
    home integer);

create table PERSON (
    ID integer primary key,
    name varchar(20) not null,
    age integer not null,
    phone integer not null,
    birthday date not null,
    address_id integer,
    FOREIGN KEY (address_id) REFERENCES address (id));
