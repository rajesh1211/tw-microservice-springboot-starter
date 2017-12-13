create table users (
    id integer not null primary key,
    email varchar(250) not null,
    password varchar(500) not null,
    name varchar(250)
);

create table classes (
  id integer not null primary key,
  subject varchar(250) not null,
  user_id integer REFERENCES users (id)
);