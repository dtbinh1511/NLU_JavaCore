﻿CREATE DATABASE QLHOCVIEN

USE QLHOCVIEN

--Tạo bảng khóa học
CREATE TABLE KHOA_HOC(
	MAKHOA CHAR(10),
	NGAYBD DATE NOT NULL,
	NGAYKT DATE,

	PRIMARY KEY (MAKHOA)
)

--Tạo bảng môn học
CREATE TABLE MON_HOC(
	MAMH CHAR(10),
	TENMH NVARCHAR(100) NOT NULL,
	SOTIET INT NOT NULL,
	HOCPHI INT NOT NULL,

	PRIMARY KEY (MAMH), 
	CONSTRAINT CK_SO_TIET CHECK (SOTIET > 0),
	CONSTRAINT CK_HOC_PHI CHECK (HOCPHI > 0)
)

--Tạo bảng giáo viên
CREATE TABLE GIAO_VIEN(
	MAGV CHAR(10),
	HOGV NVARCHAR(50),
	TENGV NVARCHAR(20) NOT NULL,
	NAMSINH CHAR(4),

	PRIMARY KEY (MAGV)
)

--Tạo bảng học viên
CREATE TABLE HOC_VIEN(
	MAHV CHAR(10),
	HOHV NVARCHAR(50),
	TENHV NVARCHAR(20) NOT NULL,
	NOISINH NVARCHAR(80),
	GIOITINH NVARCHAR(10) NOT NULL,
	LOP CHAR(2),
	NGAYSINH INT,
	THANGSINH INT,
	NAMSINH INT,

	PRIMARY KEY(MAHV),
	CONSTRAINT CK_NGAY_SINH CHECK (NGAYSINH BETWEEN 1 AND 31),
	CONSTRAINT CK_THANGSINH CHECK (THANGSINH BETWEEN 1 AND 12),
	CONSTRAINT CK_NAMSINH CHECK (NAMSINH > 1980),
	CONSTRAINT CK_GIOI_TINH CHECK (GIOITINH IN ('Nam', N'Nữ'))
)

--Tạo bảng lớp
CREATE TABLE LOP(
	MAKHOA CHAR(10),
	MALOP CHAR(10),
	MAPHONG CHAR(10)  NOT NULL,
	SI_SO INT NOT NULL,
	SI_TD INT  NOT NULL,
	MAMH CHAR(10)NOT NULL,
	NGAYHOC NVARCHAR(50)  NOT NULL,
	GIO_BD INT,
	GIO_KT INT,
	MAGV CHAR(10),

	PRIMARY KEY (MAKHOA, MALOP),
	CONSTRAINT CK_SISO CHECK (SI_TD BETWEEN 0 AND 80),
	CONSTRAINT CK_GIO_BD CHECK (GIO_BD > 0),
	CONSTRAINT CK_GIO_KT CHECK (GIO_KT > 0),
	CONSTRAINT FK_MAGV_LOP FOREIGN KEY (MAGV) REFERENCES GIAO_VIEN(MAGV),
	CONSTRAINT FK_MAKHOA_LOP FOREIGN KEY (MAKHOA) REFERENCES KHOA_HOC(MAKHOA),
	CONSTRAINT FK_MAMH_LOP FOREIGN KEY (MAMH) REFERENCES MON_HOC(MAMH)
)

--Tạo bảng chuyên môn
CREATE TABLE CHUYEN_MON(
	MAGV CHAR(10),
	MAMH CHAR(10),
	
	PRIMARY KEY (MAGV, MAMH),
)
--Tạo bảng đăng ký
CREATE TABLE DANG_KY(
	SOQUYEN CHAR(10),
	SOPT CHAR(10),
	NGAYTHU DATE DEFAULT GETDATE() NOT NULL,
	MAHV CHAR(10) NOT NULL,
	MALOP CHAR(10),
	MAKHOA CHAR(10) NOT NULL,
	SOTIEN INT NOT NULL,
	DIEM FLOAT,

	PRIMARY KEY (SOQUYEN, SOPT),
	CONSTRAINT CK_SO_TIEN CHECK (SOTIEN > 0),
	CONSTRAINT CK_DIEM CHECK (DIEM BETWEEN 0 AND 10),
	CONSTRAINT FK_MAHV_DK FOREIGN KEY (MAHV)  REFERENCES HOC_VIEN(MAHV),
	--CONSTRAINT FK_MALOP_DK FOREIGN KEY (MALOP) REFERENCES LOP(MALOP)
)


--Tạo dữ liệu bảng khóa học
INSERT INTO KHOA_HOC (MAKHOA,NGAYBD,NGAYKT)
VALUES ('K95','11-5-2011','12-10-2011'),
('K96','12-25-2011','1-30-2011'),
('K97','2-10-2011','3-15-2011')

--Tạo dữ liệu bảng giáo viên
INSERT INTO GIAO_VIEN (MAGV,HOGV,TENGV,NAMSINH)
VALUES('01',N'Tô Minh',N'Vũ','1970'),
('02',N'Lê Văn',N'Thành','1975'),
('03',N'Phạm Thị Minh',N'Tuyền','1968'),
('04',N'Lê Tấn',N'Long','1977')

--Tạo dữ liệu bảng học viên
INSERT INTO HOC_VIEN (MAHV,HOHV,TENHV,NOISINH,GIOITINH,LOP, NGAYSINH,THANGSINH,NAMSINH)
VALUES 
('1',N'Nguyễn Thị Hồng', N'Ân', N'Tây Ninh', N'Nữ', 'a',20,8,1990),
('2',N'Phạm Thị Bích', N'An', N'Đồng Nai', N'Nữ', 'a',28,2,1989),
('3',N'Thái Thị Thu', N'Diễm', N'Sông Bé', N'Nữ', 'b',12,8,2004),
('4',N'Lê Hữu', N'Dự', N'Bình Định', N'Nam', 'a',12,2,1989),
('5',N'Hồ Thị Thúy', N'An', N'Vũng Tàu', N'Nữ', 'b',12,4,2001),
('6',N'Lê Xuân', N'Ái', N'Long An', N'Nam', 'b',22,3,1989),
('7',N'Khương Thị', N'Diệu', N'Ninh Thuận', N'Nữ', 'a',20,1,1989)

--Tạo dữ liệu bảng môn học
INSERT INTO MON_HOC (MAMH,TENMH,SOTIET,HOCPHI)
VALUES ('AC1',N'Access CB',45,250000),
('AC2',N'Access NC',45,270000),
('EXCB',N'Excel căn bản',30,220000),
('EXNC',N'Excel NC',45,250000),
('THCB',N'Tin học CB',30,210000),
('WW',N'Microsoft Word',30,210000)

--Tạo dữ liệu bảng chuyên môn
INSERT INTO CHUYEN_MON (MAGV,MAMH)
VALUES ('01','EXCB'),
('01','EXNC'),
('02','AC1'),
('02','AC2'),
('03','EXCB'),
('03','THCB'),
('03','WW'),
('04','AC1'),
('04','EXNC')

--Tạo dữ liệu bảng lớp
INSERT INTO LOP (MAKHOA,MALOP,MAPHONG,SI_SO,SI_TD, MAMH, NGAYHOC,GIO_BD,GIO_KT,MAGV)
VALUES ('K95','CBA','PM1', 25,3,'THCB','3-5-7',15,17,'01'),
('K95','CBB','PM2', 30,3,'THCB','2-4-6',17,19,'03'),
('K95','EXCB','PM3', 30,1,'EXCB','3-5-7',17,19,'02'),
('K96','ACCB','PM1', 25,2,'AC1','2-4-6',17,19,'01'),
('K96','ACNC','PM3', 30,2,'AC2','2-4-6',15,17,'04'),
('K96','EXCB','PM2', 25,1,'EXCB','3-5-7',17,19,'02'),
('K96','EXNC','PM2', 30,1,'EXNC','3-5-7',15,17,'03'),
('K96','THCB','PM1', 30,3,'THCB','3-5-7',15,17,'01')

--Tạo dữ liệu bảng đăng ký
INSERT INTO DANG_KY(SOQUYEN,SOPT,NGAYTHU,MAHV,MALOP,MAKHOA,SOTIEN,DIEM)
VALUES 
('1','2', '11-2-2011','1','CBB','K95',210000,6),
('1','3', '11-2-2011','1','EXCB','K95',220000,8),
('1','4', '11-1-2011','2','CBA','K95',210000,8),
('1','5', '11-3-2011','2','EXCB','K95',220000,10),
('1','6', '12-20-2011','1','ACCB','K96',250000,8),
('1','7', '12-20-2011','2','ACCB','K96',250000,9),
('1','8', '11-24-2011','3','THCB','K96',210000,5),
('1','9', '12-23-2011','3','EXCB','K96',220000,9),
('1','10', '11-24-2011','4','THCB','K96',210000,10),
('1','11', '11-24-2011','5','THCB','K96',210000,9),
('1','12', '11-24-2011','5','EXCB','K96',220000,4),
('2','13', '12-22-2011','5','ACCB','K96',250000,9),
('2','14', '12-23-2011','2','ACNC','K96',270000,10),
('2','15', '11-24-2011','6','THCB','K96',210000,3),
('2','16', '11-24-2011','7','THCB','K96',210000,10),
('2','17', '11-24-2011','7','EXCB','K96',220000,NULL),
('2','18', '12-22-2011','7','ACCB','K96',250000,9),
('2','19', '11-24-2011','2','EXNC','K96',250000,10)

--a. Cho biết danh sách gồm MAHV, HOHV, TENHV, SOPT của các đăng ký trong ngày 24 tháng
--11 năm 2011 với lớp có mã số THCB
SELECT HV.MAHV, HV.HOHV,HV.TENHV, DK.SOPT 
FROM  DANG_KY DK
JOIN HOC_VIEN HV ON HV.MAHV = DK.MAHV
WHERE DK.NGAYTHU = '11-24-2011' AND DK.MALOP = 'THCB'

--b. Cho biết danh sách học viên khóa K96 chưa có điểm thi (điểm thi có giá trị null)
SELECT * FROM HOC_VIEN HV
JOIN DANG_KY DK ON DK.MAHV = HV.MAHV
WHERE DK.DIEM IS NULL AND DK.MAKHOA = 'K96'

--c. Cho biết danh sách gồm mã số, họ, tên của những giáo viên có thể dạy môn có mã số EXNC.
SELECT *
FROM GIAO_VIEN GV
JOIN CHUYEN_MON CM ON CM.MAGV = GV.MAGV
WHERE CM.MAMH = 'EXNC'


--d. Cho biết danh sách lớp mã số EXCB khóa K95 với các thông tin: MAMH, MAHV, HOHV,
--TENHV, DIEM. Kết quả được sắp tăng dần theo TENHV, nếu cùng tên thì sắp theo HOHV
SELECT DK.MALOP , HV.MAHV, HV.HOHV, HV.TENHV, DK.DIEM
FROM HOC_VIEN HV
JOIN DANG_KY DK ON DK.MAHV = HV.MAHV
WHERE DK.MAKHOA ='K95' AND DK.MALOP ='EXCB'
ORDER BY HV.TENHV , HV.HOHV

--e. Cho biết danh sách các lớp mở trong khóa học mã số K96, kết quả gồm các thông tin: MALOP,
--TENMH, HOGV, TENGV, NGAYBD, SOTIET
SELECT LOP.MALOP, MH.TENMH, GV.TENGV, KH.NGAYBD, MH.SOTIET
FROM KHOA_HOC KH
JOIN LOP ON LOP.MAKHOA =KH.MAKHOA
JOIN GIAO_VIEN GV ON GV.MAGV = LOP.MAGV
JOIN MON_HOC MH ON MH.MAMH = LOP.MAMH
WHERE KH.MAKHOA ='K96'


--f. Cho biết danh sách học viên khóa K95 có điểm thi lớn hơn hay bằng 5. Kết quả gồm các thông
--tin: MALOP, MAMH, TENMH,MAHV, HOHV, TENHV, NOISINH, DIEM, sắp theo
--MALOP, trong cùng lớp sắp giảm dần theo DIEM.
SELECT DISTINCT LOP.MALOP, MH.MAMH, MH.TENMH, HV.MAHV, HV.HOHV, HV.TENHV, HV.NOISINH, DK.DIEM
FROM LOP
JOIN MON_HOC MH ON MH.MAMH = LOP.MAMH
JOIN DANG_KY DK ON DK.MALOP = LOP.MALOP
JOIN HOC_VIEN HV ON HV.MAHV = DK.MAHV
WHERE DK.DIEM >= 5 AND DK.MAKHOA ='K95'
ORDER BY LOP.MALOP ASC, DK.DIEM DESC 


--g. Cho biết danh sách các lớp có số lượng học viên đăng ký thực sự lớn hơn hay bằng sĩ số của
--lớp.

SELECT LOP.MALOP, LOP.MAKHOA, SLDK, LOP.SI_TD
FROM LOP
JOIN (
	SELECT MALOP, MAKHOA, COUNT(MALOP) AS SLDK
	FROM DANG_KY
	GROUP BY MALOP, MAKHOA
) AS DK ON DK.MALOP = LOP.MALOP AND DK.MAKHOA = LOP.MAKHOA
WHERE DK.SLDK > LOP.SI_TD

--h. Cho biết danh sách các lớp học trong khóa 96 cùng với số lượng học viên thực sự đăng ký vào
--mỗi lớp đó.
SELECT MALOP, COUNT(MALOP) AS SLDK
FROM DANG_KY
WHERE MAKHOA = 'K96'
GROUP BY MALOP

--i. Cho biết danh sách học viên đã đăng ký học trên 3 lớp với các thông tin MAHV, TENHV,
--SOLUONGLOP

SELECT HV.MAHV,HV.HOHV, HV.TENHV, DK.SOLUONGLOP
FROM HOC_VIEN HV
JOIN (
	SELECT MAHV, COUNT(MAHV) AS SOLUONGLOP
	FROM DANG_KY
	GROUP BY MAHV
)AS DK ON DK.MAHV = HV.MAHV
WHERE DK.SOLUONGLOP >=3