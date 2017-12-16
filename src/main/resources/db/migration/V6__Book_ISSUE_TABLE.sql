create table book_issues (
    id serial primary key,
    book_id integer not null,
    user_id integer not null
);