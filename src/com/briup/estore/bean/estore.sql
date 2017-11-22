--顾客表
create table tbl_customer(
	id number primary key,
	name varchar2(20) ,
	password varchar2(200),
	zip varchar2(20),
	address varchar2(200),
	telephone varchar2(15),
	email varchar2(50)
);
--订单表
create table tbl_order(
	id number primary key,
	cost number(10,2),
	orderDate date,
	customer_id number references tbl_customer(id)
);
--书
create table tbl_book(
    id number primary key,
	name varchar2(100),
	price number(10,2)
);
--订单项
create table tbl_line(
	id number primary key,
	num number,
	order_id number references tbl_order(id),
	book_id number references tbl_book(id)
);
--我修改的tbl_line表
--create table tbl_line(
--	id number primary key,
--	num number,
--	order_id number references tbl_order(id),
--	book_id number references tbl_book(id),
--    customer_id number references tbl_customer(id),
--    ispurchase number 
--);


insert into tbl_book values(1,'JAVA核心技术',81.00);
insert into tbl_book values(2,'UNIX技术手册',21.15);
insert into tbl_book values(3,'ORACLE9I参考手册',108.00);
insert into tbl_book values(4,'JSP设计(第三版)',59.25);
insert into tbl_book values(5,'JAVA SERVLET 编程(第二版)',38.25);
insert into tbl_book values(6,'XML 高级编程(第2版)',97.20);
insert into tbl_book values(7,'精通STRUTS:基于MVC的JAVA WEB设计与开发',36.75);
insert into tbl_book values(8,'精通HIBERNATE：JAVA对象持久化技术详解',44.25);
insert into tbl_book values(9,'SPRING IN ACTION中文版',29.25);
insert into tbl_book values(10,'精通EJB 3.0',44.25);
commit;