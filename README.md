Database Query
use library;
create table userDetails(id int AUTO_INCREMENT primary key , name varchar(30) not null unique,password varchar(8) not null);
desc userDetails;
create table rental (userId int not null unique,bookId int not null unique,bookname varchar(30) not null unique,BookStatus int not null);
desc rental;
create table bookDetails (bookId int not null,bookname varchar(30) not null,Authour varchar(30) not null,price int not null);
desc bookDetails;
