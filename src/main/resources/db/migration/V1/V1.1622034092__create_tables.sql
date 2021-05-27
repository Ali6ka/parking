create table if not exists parking_place
(
    id            bigserial primary key,
    number        varchar(16) not null unique,
    taken         boolean not null default false
);

insert into parking_place(number, taken)
VALUES ('A1', false),
       ('A2', false),
       ('A3', true),
       ('A4', true);