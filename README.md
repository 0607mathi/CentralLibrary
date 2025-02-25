-- database
use library; 

-- User Details Table_01
create table userDetails(id int AUTO_INCREMENT primary key , name varchar(30) not null unique,password varchar(8) not null);
desc userDetails;

-- Rental Book Table_02
create table rental (userId int not null,bookId int not null,bookname varchar(30) not null,BookStatus int not null);
desc rental;

-- Book Details Table_03
create table bookDetails (bookId int not null AUTO_INCREMENT primary key,bookname varchar(30) not null,Authour varchar(30) not null,price int not null);
desc bookDetails;

-- Display all the Details From User Details Table_01 
select * from userDetails;

-- Display all the Details From User Details Table_01 
select * from rental;

-- Display all the Details From User Details Table_01 
select * from bookDetails;

-- This all are updateing altering query
select name from userDetails where name ='mathi';
drop table rental;
drop table bookDetails;
insert into rental (userId,bookId,bookname,BookStatus) value (1001,100,'Java',1);
insert into rental (userId,bookId,bookname,BookStatus) value (1001,102,'sql',1);
select * from rental;
select bookId,bookname from rental where userId=(select id from userDetails where name='prateek');
insert into bookDetails (bookId,bookname,Authour,price) values (100,'java','Tambraz',1000);
insert into bookDetails (bookId,bookname,Authour,price) values (200,'sql','Nagaraj',1000);
insert into bookDetails (bookname,Authour,price) values ('frontend','Mathiyarasu',2000);
select * from bookDetails;
alter table userDetails modify password varchar(16);
