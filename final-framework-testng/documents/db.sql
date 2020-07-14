create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 



create table registeruser(
firstName varchar(50) not null,
lastName varchar(50),
email varchar(50),
username varchar(50),
password varchar(50),
confirmpassword varchar(50),
phonenumber varchar(50),
language varchar(50));
insert into registeruser values("karthik1", "Kash1","v1@b.com","bd11","QAgroup123","QAgroup123","1234567890","English"); 