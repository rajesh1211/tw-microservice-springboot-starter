create table genres (
    id serial primary key,
    name varchar not null,
    created_at timestamp,
    updated_at timestamp
);

create table types (
    id serial primary key,
    name varchar not null,
    created_at timestamp,
    updated_at timestamp
);

create table authors (
    id serial primary key,
    name varchar not null,
    created_at timestamp,
    updated_at timestamp
);


create table books (
    id serial primary key,
    name varchar not null,
    isbn varchar not null,
    genre_id integer,
    type_id integer,
    author_id integer,
    publication_date timestamp,
    edition varchar,
    price decimal,
    quantity_left integer,
    created_at timestamp,
    updated_at timestamp
);

create table book_tags (
    id serial primary key,
    tag varchar not null
);