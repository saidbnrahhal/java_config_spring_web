drop table if exists user
drop table if exists authority
create table user (id bigint generated by default as identity (start with 1,increment by 1) NOT NULL, USERNAME varchar(100) not null,PASSWORD varchar(100) not null,ENABLED boolean not null, primary key (id))
create table authority (id bigint generated by default as identity (start with 1 ,increment by 1), USERNAME varchar(100) not null, AUTHORITY varchar(100) not null, primary key (id))