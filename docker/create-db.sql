create schema if not exists mydb;
create table if not exists movie(
  id serial not null primary key,
  name varchar(255)  null,
  year int  null
);
