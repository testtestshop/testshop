insert into `user_role` values(DEFAULT, 'ROLE_USER', NULL);
insert into `user_role` values(DEFAULT, 'ROLE_ADMIN', NULL);

insert into `user` values('admin', 'admin@testshop.com', '3-33-3', 'ul. Mira d 11', 1, 'testpass');
insert into `user` values('user', 'user@testshop.com', '4-33-3', 'ul. Mira d 12', 1, 'testpass');

update `user_role` set `user_username` = 'admin' where `role` = 'ROLE_ADMIN' LIMIT 1;
update `user_role` set `user_username` = 'user' where `role` = 'ROLE_USER' LIMIT 1;

--tested goods

insert into `item_type` values(1, 'all');
insert into `item_type` values(2, 'animal');

insert into `item` values(DEFAULT, 2.3, 'some cat', 'cat', 5, 1);
insert into `item` values(DEFAULT, 2.3, 'some dog', 'dog', 5, 2);

insert into `task` values(DEFAULT, '2016-07-15', 'some cat task', 2, 'WAITING', (select `id` from `item` where `name` = 'cat' limit 1), 'admin');
insert into `task` values(DEFAULT, '2016-07-15', 'some dog task', 2, 'WAITING', (select `id` from `item` where `name` = 'dog' limit 1), 'user');