use master
go
create database blog
go
use blog
go
create table account(
	username varchar(30) primary key,
	password varchar(60) not null,
	created date not null
)
go
create table category(
	id varchar(30) primary key,
	name nvarchar(30) not null unique,
	created date not null
)
go
create table post(
	id varchar(200) primary key,
	title nvarchar(200) not null unique,
	content ntext,
	views int not null default 0,
	created date not null,
	id_category varchar(30) not null,
	foreign key(id_category) references category(id)
)
go

insert into category values('java','java','2019-02-03')
insert into category values('spring','spring','2019-02-04')
insert into post values('bai-viet-1','bai viet 1','noi dung 1',230,'2019-08-02','java')
insert into post values('bai-viet-2','bai viet 2','noi dung 2',122,'2019-08-02','spring')
go

alter view chart
as
	select c.name,sum(p.views) as 'views' from category as c inner join post as p on c.id=p.id_category group by c.name 
go
select * from chart
