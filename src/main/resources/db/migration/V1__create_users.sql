create table users (
    emailid varchar(250) not null primary key,
    password varchar(500) not null,
    address json,
    name varchar(250)
);