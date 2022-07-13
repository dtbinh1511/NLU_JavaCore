create database QLDTKH
use QLDTKH

create table Khoa(
MaKhoa int primary key,
TenKhoa nvarchar(255),
TruongKhoa nvarchar(255),
Ngaythanhlap date,
Diachi nvarchar(255)
)

create table SinhVien(
MaSV int primary key,
HoTenSV nvarchar(255),
NgaySinh date,
Gioitinh char(3),
Diachi nvarchar(255),
Ngaynhaphoc date,
MaKhoa int
)

create table GiangVien(
MaGV int primary key,
HoTenGV nvarchar(255),
NgaySinh date,
Diachi nvarchar(255),
ngaybd date,
MaKhoa int
)

create table DeTai(
MaDeTai int primary key,
TenDeTai nvarchar(255),
LinhVuc nvarchar(255),
Nam int,
MaGV int
)

create table HuongDan(
MaDeTai int ,
MaSV int ,
Diemso float,
primary key(MaDeTai, MaSV)
)

insert into Khoa (MaKhoa,TenKhoa,TruongKhoa ,Ngaythanhlap ,Diachi) 
values(1, 'CNTT','Nguyen Van A', '1/1/2002',N'Thủ Đức'),
	  (2, 'CNHH','Nguyen Van B', '1/1/2002',N'Thủ Đức'),
	  (3, 'CNSH','Nguyen Van C', '1/1/2002',N'Thủ Đức')

insert into SinhVien(MaSV,HoTenSV,NgaySinh,Gioitinh,Diachi,Ngaynhaphoc,MaKhoa)
values (1,'Do A', '1/1/2002','NAM',N'Thủ Đức', getdate(), 1),
(2,'Do B', '1/1/2002','NU',N'Thủ Đức', getdate(), 2),
(3,'Do C', '1/1/2002','NAM',N'Thủ Đức', getdate(), 3),
(4,'Do D', '1/1/2002','NU',N'Thủ Đức', getdate(), 1),
(5,'Do E', '1/1/2002','NU',N'Thủ Đức', getdate(), 2)

insert into GiangVien(MaGV,HoTenGV,NgaySinh ,Diachi,ngaybd,MaKhoa)
values 
(1,'Nguyen Van A', '1/1/2002',N'Thủ Đức', '1/2/2010',1),
(2,'Nguyen Van B', '1/1/2002',N'Thủ Đức', '1/2/2010',2),
(3,'Nguyen Van C', '1/1/2002',N'Thủ Đức', '1/2/2010',3)

insert into DeTai(MaDeTai,TenDeTai,LinhVuc,Nam ,MaGV )
values
(1,N'Robot dọn nhà','AI',2022,1),
(2,N'Nhận diện khuôn mặt','AI',2021,1),
(3,N'CNHH vào nghiên cứu thực tiễn','CNHH',2022,2),
(4,N'CNSH nhân giống cây đậu','CNSH',2021,3),
(5,N'CNSH chiết cây','CNSH',2022,3)

insert into HuongDan(MaDeTai,MaSV,Diemso)
values 
(1,1,5.1),
(1,2,5.1),
(2,3,5.1),
(2,4,5.1),
(3,5,5.1),
(4,5,5.1),
(5,1,5.1)
go
create function f_detail(@nam int)
returns table
as return(
	select DT.Nam, DT.MaDeTai, DT.TenDeTai, COUNT(DT.MaDeTai)as sl
	from DeTai DT
	join HuongDan HD on HD.MaDeTai = DT.MaDeTai
	group by DT.Nam, DT.MaDeTai, DT.TenDeTai
	having DT.Nam = @nam
	order by DT.MaDeTai)

	go