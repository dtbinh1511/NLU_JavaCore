﻿
create database NUOCGIAIKHAT
use NUOCGIAIKHAT
create table NHACC
(
	MaNCC		varchar(3),
	TenNCC		nvarchar(100),
	DiaChiNCC	nvarchar(200),
	DTNCC		char(12)
	constraint pk_nhacc primary key(MaNCC)
)

create table KH
(
	MaKH		varchar(5),
	TenKH		nvarchar(100),
	DCKH		nvarchar(200),
	DTKH		char(12),
	constraint pk_kh primary key(MaKH)
)

create table LOAINGK
(
	MaLoaiNGK	varchar(3),
	TenLoaiNGK	nvarchar(50),
	MaNCC		varchar(3)
	constraint	pk_loaingk primary key(MaLoaiNGK),
	constraint	fk_nhacc_loaingk foreign key(MaNCC) references NHACC(MaNCC)
)

create table NGK
(
	MaNGK		varchar(3),
	TenNGK		nvarchar(50),
	Quycach		nvarchar(15),
	MaLoaiNGK	varchar(3),
	constraint	pk_ngk primary key(MaNGK),
	constraint	fk_loaingk_ngk foreign key(MaLoaiNGK) references LOAINGK(MaLoaiNGK)
)

create table DDH
(
	SoDDH		varchar(5),
	NgayDH		smalldatetime,
	MaNCC		varchar(3),
	constraint pk_dd primary key(SoDDH),
	constraint fk_nhacc_ddh foreign key(MaNCC) references NHACC(MaNCC)
)

create table CT_DDH
(
	SoDDH		varchar(5),
	MaNGK		varchar(3),
	SLDat		int,
	constraint pk_ctddh primary key(SoDDH,MaNGK),
	constraint fk_ddh_ctddh foreign key(SoDDH) references DDH(SoDDH),
	constraint fk_ngk_ctddh foreign key(MaNGK) references NGK(MaNGK)
)

create table PHIEUGH
(
	SoPGH		varchar(5),
	NgayGH		smalldatetime,
	SoDDH		varchar(5),
	constraint pk_phieugh primary key(SoPGH),
	constraint fk_ddh_phieugh foreign key(SoDDH) references DDH(SoDDH)
)

create table CT_PGH
(
	SoPGH		varchar(5),
	MaNGK		varchar(3),
	SLGiao		int,
	DGGiao		int,
	constraint pk_ctphieugh primary key(SoPGH,MaNGK),
	constraint fk_phieugh_ctphieugh foreign key(SoPGH) references PHIEUGH(SoPGH),
	constraint fk_ngk_ctphieugh foreign key(MaNGK) references NGK(MaNGK)
)

create table HOADON
(
	SoHD		varchar(5),
	NgaylapHD	smalldatetime,
	MaKH		varchar(5),
	constraint pk_hoadon primary key(SoHD),
	constraint fk_kh_hoadon foreign key(MaKH) references KH(MaKH)
)

create table CT_HOADON
(
	SoHD		varchar(5),
	MaNGK		varchar(3),
	SLKHMua		int,
	DGBan		int,
	constraint pk_cthoadon primary key(SoHD,MaNGK),
	constraint fk_hoadon_cthoadon foreign key(SoHD) references HOADON(SoHD),
	constraint fk_ngk_cthoadon foreign key(MaNGK) references NGK(MaNGK)
)

create table PHIEUHEN
(
	SoPH		varchar(5),
	NgaylapPH	smalldatetime,
	NgayhenGiao	smalldatetime,
	MaKH		varchar(5),
	constraint pk_phieuhen primary key(SoPH),
	constraint fk_kh_phieuhen foreign key(MaKH) references KH(MaKH)
)

create table CT_PH
(
	SoPH		varchar(5),
	MaNGK		varchar(3),
	SLHen		int,
	constraint pk_ctphieuhen primary key(SoPH,MaNGK),
	constraint fk_ngk_ctphieuhen foreign key(MaNGK) references NGK(MaNGK)
)

create table PHIEUTRANO
(
	SoPTN		varchar(5),
	Ngaytra		smalldatetime,
	SotienTra	int,
	SoHD		varchar(5),
	constraint pk_phieutrano primary key(SoPTN),
	constraint fk_hoadon_phieutrano foreign key(SoHD) references HOADON(SoHD)
)

insert into NHACC values('NC1',N'Công ty NGK quốc tế Coca Cola',N'Xa lộ Hà Nội, Thủ Đức, TP.HCM','088967908')
insert into NHACC values('NC2',N'Công ty NGK quốc tế Pepsi',N'Bến Chương Dương, Quận 1, TP.HCM','083663366')
insert into NHACC values('NC3',N'Công ty NGK Bến Chương Dương',N'Hàm Tử, Quận 5, TP.HCM','089456677')

insert into KH values('KH01',N'Cửa hàng BT',N'144 XVNT','088405996')
insert into KH values('KH02',N'Cửa hàng trà',N'198/42 NTT','085974572')
insert into KH values('KH03',N'Siêu thị COOP',N'24 ĐTH','086547888')

insert into LOAINGK values('NK1',N'Nước ngọt có gas','NC1')
insert into LOAINGK values('NK2',N'Nước ngọt không gas','NC2')
insert into LOAINGK values('NK3',N'Trà','NC1')
insert into LOAINGK values('NK4',N'Sữa','NC2')

insert into NGK values('CC1',N'Coca Cola',N'Chai','NK1')
insert into NGK values('CC2',N'Coca Cola',N'Lon','NK1')
insert into NGK values('PS1',N'Pepsi',N'Chai','NK1')
insert into NGK values('PS2',N'Pepsi',N'Lon','NK1')
insert into NGK values('SV1',N'Seven Up',N'Chai','NK1')
insert into NGK values('SV2',N'Seven Up',N'Lon','NK1')
insert into NGK values('NO1',N'Number One',N'Chai','NK1')
insert into NGK values('NO2',N'Numbet One',N'Lon','NK1')
insert into NGK values('ST1',N'Sting dâu',N'Chai','NK1')
insert into NGK values('ST2',N'Sting dâu',N'Lon','NK1')
insert into NGK values('C2', N'Trà C2',N'Chai','NK2')
insert into NGK values('OD', N'Trà xanh 0 độ',N'Chai','NK2')
insert into NGK values('ML1',N'Sữa tươi tiệt trùng',N'Bịch','NK1')
insert into NGK values('WT1',N'Nước uống đóng chai',N'Chai','NK2')

insert into DDH values('DDH01','10/05/2011','NC1')
insert into DDH values('DDH02','05/20/2011','NC1')
insert into DDH values('DDH03','05/26/2011','NC2')
insert into DDH values('DDH04','03/06/2011','NC2')

insert into CT_DDH values('DDH01','CC1','20')
insert into CT_DDH values('DDH01','CC2','15')
insert into CT_DDH values('DDH01','PS1','18')
insert into CT_DDH values('DDH01','SV2','12')
insert into CT_DDH values('DDH02','CC2','30')
insert into CT_DDH values('DDH02','PS2','10')
insert into CT_DDH values('DDH02','SV1','5')
insert into CT_DDH values('DDH02','ST1','15')
insert into CT_DDH values('DDH02','C2','10')
insert into CT_DDH values('DDH03','OD','45')
insert into CT_DDH values('DDH04','CC1','8')
insert into CT_DDH values('DDH04','ST2','12')

insert into PHIEUGH values('PGH01','12/05/2010','DDH01')
insert into PHIEUGH values('PGH02','5/05/2010','DDH01')
insert into PHIEUGH values('PGH03','1/05/2010','DDH02')
insert into PHIEUGH values('PGH04','2/05/2010','DDH02')
insert into PHIEUGH values('PGH05','8/05/2010','DDH03')

insert into CT_PGH values('PGH01','CC1','15','5000')
insert into CT_PGH values('PGH01','CC2','15','4000')
insert into CT_PGH values('PGH01','SV2','10','4000')
insert into CT_PGH values('PGH02','SV2','2','4000')
insert into CT_PGH values('PGH03','CC2','30','5000')
insert into CT_PGH values('PGH03','PS1','10','4000')
insert into CT_PGH values('PGH03','ST1','15','9000')
insert into CT_PGH values('PGH03','C2','10','8000')

insert into HOADON values('HD01','10/05/2010','KH01')
insert into HOADON values('HD02','2/05/2010','KH01')
insert into HOADON values('HD03','5/06/2010','KH02')
insert into HOADON values('HD04','6/06/2010','KH02')
insert into HOADON values('HD05','2/06/2011','KH02')
insert into HOADON values('HD06','8/07/2010','KH03')

insert into CT_HOADON values('HD01','CC1','20','6000')
insert into CT_HOADON values('HD01','CC2','50','5000')
insert into CT_HOADON values('HD02','ST1','40','10000')
insert into CT_HOADON values('HD03','SV2','60','5000')
insert into CT_HOADON values('HD04','PS2','25','5000')

insert into PHIEUHEN values('PH01','08/05/2010','09/06/2010','KH01')
insert into PHIEUHEN values('PH02','5/05/2010','8/06/2010','KH02')
insert into PHIEUHEN values('PH03','01/06/2010','02/06/2010','KH03')

insert into CT_PH values('PH01','ST2','10')
insert into CT_PH values('PH01','OD','8')
insert into CT_PH values('PH02','CC1','20')
insert into CT_PH values('PH03','ST1','7')
insert into CT_PH values('PH03','SV2','12')
insert into CT_PH values('PH03','CC2','9')
insert into CT_PH values('PH03','PS2','15')

insert into PHIEUTRANO values('PTN01','8/05/2010','500000','HD01')
insert into PHIEUTRANO values('PTN02','01/06/2010','350000','HD01')
insert into PHIEUTRANO values('PTN03','02/06/2010','650000','HD02')
insert into PHIEUTRANO values('PTN04','5/06/2010','102000','HD03')
insert into PHIEUTRANO values('PTN05','01/07/2010','108000','HD03')

select * from NHACC
select * from KH
select * from LOAINGK
select * from NGK
select * from DDH
select * from CT_DDH
select * from PHIEUGH
select * from CT_PGH
select * from HOADON
select * from CT_HOADON
select * from PHIEUHEN
select * from CT_PH
select * from PHIEUTRANO