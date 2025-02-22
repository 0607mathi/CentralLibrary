use library;
create table userDetails(id int AUTO_INCREMENT primary key , name varchar(30) not null unique,password varchar(8) not null);
desc userDetails;
create table rental (userId int not null,bookId int not null unique,bookname varchar(30) not null unique,BookStatus int not null);
desc rental;
create table bookDetails (bookId int not null AUTO_INCREMENT primary key,bookname varchar(30) not null,Authour varchar(30) not null,price int not null);
desc bookDetails;
select * from userDetails;
select name from userDetails where name ='mathi';
drop table rental;
drop table bookDetails;
insert into rental (userId,bookId,bookname,BookStatus) value (1001,100,'Java',1);
insert into rental (userId,bookId,bookname,BookStatus) value (1001,102,'sql',1);
select * from rental;
select bookId,bookname from rental where userId=(select id from userDetails where name='prateek');

