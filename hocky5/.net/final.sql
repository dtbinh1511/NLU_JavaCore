create database bookdb
go
use bookdb
go

CREATE TABLE Author (
  AuthorId varchar(20)  NOT NULL,
  AuthorName nvarchar(100),
	
	DisplayOrder int DEFAULT 0,
	MetaTitle varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDescription nvarchar(255),
	MetaKeywords nvarchar(255),
	[Status] bit DEFAULT 1,
  PRIMARY KEY (AuthorId)
) 

CREATE TABLE Publisher (
  PublisherId varchar(20)  NOT NULL,
  PublisherName nvarchar(100) ,
	
	DisplayOrder int DEFAULT 0,
	MetaTitle varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDescription nvarchar(255),
	MetaKeywords nvarchar(255),
	[Status] bit DEFAULT 1,
   PRIMARY KEY (PublisherId)
) 

CREATE TABLE Category (
  CategoryId varchar(20) NOT NULL,
  CategoryName nvarchar(100),
	
	DisplayOrder int DEFAULT 0,
	MetaTitle varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDescription nvarchar(255),
	MetaKeywords nvarchar(255),
	[Status] bit DEFAULT 1,
  PRIMARY KEY (CategoryId)
) 

CREATE TABLE Book (
  BookId varchar(20)  NOT NULL,
  BookName nvarchar(255),
	Code varchar(20),
	[Description] text,
  Image varchar(255) ,
  Price DECIMAL(10,0) DEFAULT 0,
  Rate decimal(2,2) DEFAULT 0,
	QuantityStock int DEFAULT 0,
  QuantityImport int,
  DateImport datetime, 
  AuthorId varchar(20),
  CategoryId varchar(20),
  PublisherId varchar(20),
 
  [Size] varchar(100)  NOT NULL,
  [Weight] varchar(10)  NOT NULL,
  DatePub DATETIME NOT NULL,
		
	DisplayOrder int DEFAULT 0,
	MetaTitle varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDescription nvarchar(255),
	MetaKeywords nvarchar(255),
	[Status] bit DEFAULT 1,
  PRIMARY KEY (BookId),
  foreign key (AuthorId) references Author(AuthorId),
  foreign key (CategoryId) references Category(CategoryId),
  foreign key (PublisherId) references Publisher(PublisherId)
) 


CREATE TABLE Slide (
  SlideId int identity  NOT NULL,
  Image varchar(255) ,
	DisplayOrder int DEFAULT 0,
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,	
	[Status] bit DEFAULT 1,	
  PRIMARY KEY (sliderId)
) 

CREATE TABLE [User] (
  UserId int NOT NULL identity,
  Email varchar(100),
  [Password] nvarchar(100),
  Fullname nvarchar(100),
  [Address] text,
  Phone varchar(15),
  Gender bit,
  [Role] varchar DEFAULT 'Customer',
  DisplayOrder int DEFAULT 0,
	MetaTitle varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,	
	[Status] bit DEFAULT 1,
  check ([role] in ('Customer','Admin')),
  PRIMARY KEY (UserId)
) 

CREATE TABLE [Order] (
  OrderId varchar(20)  NOT NULL,
  UserId int NOT NULL,
  Price DECIMAL(10,0),
  DisplayOrder int DEFAULT 0,
	MetaTitle varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,	
	[Status] bit DEFAULT 1,
  PRIMARY KEY (OrderId),
  constraint order_fk_1 foreign key (UserId) references [User](UserId)
) 
go

CREATE TABLE OrderDetail (
  OrderId varchar(20)  NOT NULL,
  BookId varchar(20)  NOT NULL,
  Quantity int,
  PRIMARY KEY (OrderId),
  constraint order_detail_fk_1 foreign key (BookId) references Book(BookId),
  constraint order_detail_fk_2 foreign key (OrderId) references [Order](OrderId)
) 

CREATE TABLE Config(
	Id varchar(50),
	Name nvarchar(50),
	Type nvarchar(50),
	Value nvarchar(50),
	Status bit default 1,
	primary key (Id)
)
-- sach moi: lay ra danh sach sach moi phat hanh
-- sach sap hanh: lay ra danh sach có ngay phat hanh > ngay hien tai
-- sach ban chay: lay ra danh sach top 10 sach co sl ban nhieu nhat
-- sach cung tac gia

-- filter: loc theo the loai, tac gia, nha xuat ban
-- sap xep: theo gia (tang <-> giam), theo ngay xuat ban(moi <-> cu)
-- search theo ten
