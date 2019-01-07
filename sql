create table USERS
(
  USERNAME VARCHAR2(36) not null,
  PASSWORD VARCHAR2(100) not null,
  ENABLED  NUMBER(1) not null
) ;
 
alter table USERS
  add constraint USER_PK primary key (USERNAME);
 drop table  USERS;
---------------------
 
-- Create table
create table USER_ROLES
(
  ROLE_ID   VARCHAR2(50) not null,
  USERNAME  VARCHAR2(36) not null,
  USER_ROLE VARCHAR2(30) not null
) ;
  
alter table USER_ROLES
  add constraint USER_ROLE_PK primary key (ROLE_ID);
 
alter table USER_ROLES
  add constraint USER_ROLE_UK unique (USERNAME, USER_ROLE);
  
-------------------------------
  
insert into users (USERNAME, PASSWORD, ENABLED)
values ('admin','$2a$08$YN2y9ehNoknkvyPn5iVNEeb8qnCO5VDKs7FkmoM8hQjt2IZh/ACza',1);
 
insert into users (USERNAME, PASSWORD, ENABLED)
values ('dbadmin1', '12345', 1);  
 
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('1', 'admin', 'USER');
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('2', 'dbadmin1', 'ADMIN');
 
insert into User_Roles (ROLE_ID, USERNAME, USER_ROLE)
values ('3', 'dbadmin1', 'USER');
 
 select* from users;
 select* from User_Roles;

-------------------------------
Commit;
