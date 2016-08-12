insert into user (USERNAME, PASSWORD, ENABLED) values ('user', 'password', TRUE)
insert into user (USERNAME, PASSWORD, ENABLED) values ('admin', 'password', TRUE)
insert into user (USERNAME, PASSWORD, ENABLED) values ('test@gmail.com', '12345', TRUE)
insert into user (USERNAME, PASSWORD, ENABLED) values ('test@email.com', '12345', TRUE)

insert into authorities (USERNAME, AUTHORITY) values ('user', 'ROLE_USER')
insert into authorities (USERNAME, AUTHORITY) values ('admin', 'ROLE_ADMIN')
insert into authorities (USERNAME, AUTHORITY) values ('test@gmail.com', 'ROLE_USER')
insert into authorities (USERNAME, AUTHORITY) values ('test@email.com', 'ROLE_USER')