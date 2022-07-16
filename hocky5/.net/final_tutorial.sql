create database bookdb
go
use bookdb
go


CREATE TABLE Post(
Id INT NOT NULL PRIMARY KEY IDENTITY,
Title NVARCHAR(255),
Slug VARCHAR(255),
PostType VARCHAR(50),
CreateAt DATETIME DEFAULT getdate(),
CreateBy int,
UpdateAt DATETIME DEFAULT getdate(),
UpdateBy int,
MetaDesc nvarchar(255),
MetaKey nvarchar(255),
Status int
)

CREATE TABLE Menu(
Id INT NOT NULL PRIMARY KEY IDENTITY,
Name nvarchar(255),
Link varchar(255),
TableId int ,
ParentId int,
TypeMenu VARCHAR(40),
[Position] VARCHAR(50),
DisplayOrder int DEFAULT 0,
CreateAt DATETIME DEFAULT getdate(),
CreateBy int,
UpdateAt DATETIME DEFAULT getdate(),
UpdateBy int,	
Status int
)


CREATE TABLE Link(
Id int PRIMARY KEY IDENTITY,
Slug VARCHAR(255),
TableId int,
Type VARCHAR(50)
)

CREATE TABLE Author (
	Id int NOT NULL primary key IDENTITY,
	Name nvarchar(100),	
	DisplayOrder int DEFAULT 0,
	Slug varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDesc nvarchar(255),
	MetaKey nvarchar(255),
	Status int
) 

CREATE TABLE Publisher (
	Id int NOT NULL primary key IDENTITY,
  Name nvarchar(100),	
	DisplayOrder int DEFAULT 0,
	Slug varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDesc nvarchar(255),
	MetaKey nvarchar(255),
	Status int
) 

CREATE TABLE Category (
  Id int NOT NULL primary key IDENTITY,
	Name nvarchar(100),	
	DisplayOrder int DEFAULT 0,
	Slug varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDesc nvarchar(255),
	MetaKey nvarchar(255),
	Status int
) 

CREATE TABLE Book (
  Id int NOT NULL PRIMARY KEY IDENTITY,
  Name nvarchar(255),
	[Description] nvarchar(MAX),
  Image varchar(255) ,
  Price DECIMAL(10,0) DEFAULT 0,
  Rate decimal(2,2) DEFAULT 0,
	QuantityStock int DEFAULT 0,
  QuantityImport int,
  DateImport datetime, 
  AuthorId int,
  CategoryId int,
  PublisherId int,
 
  [Size] varchar(100),
  [Weight] varchar(10),
  DatePub DATETIME,
		
	DisplayOrder int DEFAULT 0,
	Slug varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,
	MetaDesc nvarchar(255),
	MetaKey nvarchar(255),
	Status int
) 


CREATE TABLE Slide (
  Id int NOT NULL primary key IDENTITY,
  Image varchar(255) ,
	DisplayOrder int DEFAULT 0,
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,	
	Status int
) 

CREATE TABLE [User] (
  Id int NOT NULL primary key IDENTITY,
  Email varchar(100),
  [Password] nvarchar(100),
  Fullname nvarchar(100),
  [Address] nvarchar(500),
  Phone varchar(15),
  Gender bit,
  Role bit,
  DisplayOrder int DEFAULT 0,
	Slug varchar(255),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,	
	Status int
) 

CREATE TABLE [Order] (
  Id int NOT NULL primary key IDENTITY,
  UserId int NOT NULL,
  DisplayOrder int DEFAULT 0,
	Slug varchar(255),
	TimeOrder datetime,
	ReceiverName nvarchar(100),
	ReceiverPhone varchar(15),
	ReceiverAddress nvarchar(500),
	Note nvarchar(500),
  CreateAt DATETIME DEFAULT getdate(),
	CreateBy int,
  UpdateAt DATETIME DEFAULT getdate(),
	UpdateBy int,	
	Status int
) 
go

CREATE TABLE OrderDetail (
  Id int NOT NULL primary key IDENTITY,
  BookId int NOT NULL,
	OrderId int NOT NULL,
  Quantity int,
	Price DECIMAL(10,2),
	Amount DECIMAL(10,2)
) 

CREATE TABLE Config(
	Id int NOT NULL primary key IDENTITY,
	Name nvarchar(50),
	Type nvarchar(50),
	Value nvarchar(50),
	Status int
)
-- sach moi: lay ra danh sach sach moi phat hanh
-- sach sap hanh: lay ra danh sach có ngay phat hanh > ngay hien tai
-- sach ban chay: lay ra danh sach top 10 sach co sl ban nhieu nhat
-- sach cung tac gia

-- filter: loc theo the loai, tac gia, nha xuat ban
-- sap xep: theo gia (tang <-> giam), theo ngay xuat ban(moi <-> cu)
-- search theo ten
