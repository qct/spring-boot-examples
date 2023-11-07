drop table if exists person;
create table person
(
    id      int auto_increment primary key,
    name    varchar(20) null,
    address varchar(20) null,
    age     int         null
);

drop table if exists school;
create table school
(
    id   int auto_increment primary key,
    name varchar(20) null
);