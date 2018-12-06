DROP SCHEMA if exists management CASCADE;
commit;

CREATE SCHEMA if not exists management AUTHORIZATION sa;
SET SCHEMA MANAGEMENT;

DROP TABLE if exists management.management_user;
commit;

CREATE TABLE if not exists management.management_user
(id integer primary key auto_increment, name varchar2(50),email varchar2(50),password varchar2(50));
commit;