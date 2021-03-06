------------------
-- 19130017
-- Đỗ Thanh Bình
------------------

use QLGiaoVu
go

--1. Học viên thi một môn tối đa 3 lần.
CREATE OR ALTER TRIGGER TRIGGER_SLTHI
ON KETQUATHI
AFTER INSERT
AS
BEGIN
	DECLARE @MAHV CHAR(5) = (SELECT MAHV FROM inserted)
	DECLARE @MAMH VARCHAR(10) = (SELECT MAMH FROM inserted)
	DECLARE @COUNT INT = (SELECT COUNT(MAHV) FROM KETQUATHI WHERE MAHV = @MAHV AND MAMH = @MAMH)
	
	IF( @COUNT > 3 OR (SELECT LANTHI FROM inserted ) > 3  )
	BEGIN
		RAISERROR ('Học viên thi một môn tối đa 3 lần.!',10,1)
		ROLLBACK
	END
END
--TEST
SELECT * FROM KETQUATHI
INSERT INTO KETQUATHI VALUES ('K1101',	'CSDL',4,'2006-08-10 ',4.50,'Khong Dat')
GO

--2. Học kỳ chỉ có giá trị từ 1 đến 3.
CREATE OR ALTER TRIGGER TRIGGER_HOCKY
ON GIANGDAY
AFTER INSERT
AS
BEGIN
	IF((SELECT HOCKY FROM inserted) NOT IN (1,2,3))
	BEGIN
		RAISERROR (N'Học kỳ chỉ có giá trị từ 1 đến 3.!',10,1)
		ROLLBACK
	END
END
--TEST
INSERT INTO GIANGDAY(MALOP, MAMH, MAGV, HOCKY, NAM,TUNGAY,DENNGAY)
VALUES ('K11', 'LTCFW', 'GV14', 4, 2021, '2/15/2021', '6/15/2021')
GO

--3. Học vị của giáo viên chỉ có thể là “CN”, “KS”, “Ths”, ”TS”, ”PTS”.
CREATE OR ALTER TRIGGER TRIGGER_HOCVI
ON GIAOVIEN
AFTER INSERT
AS
BEGIN
	IF((SELECT HOCVI FROM inserted) NOT IN ('CN', 'KS', 'Ths', 'TS', 'PTS'))
	BEGIN
		RAISERROR (N'Học vị của giáo viên chỉ có thể là “CN”, “KS”, “Ths”, ”TS”, ”PTS”.!',10,1)
		ROLLBACK
	END
END
-- TEST
INSERT INTO GIAOVIEN  
VALUES('GV16', 'ALEX', 'GV',NULL,'Nam','5/25/1990', '5/1/2020',1.69,760500,'KHMT')
GO

--4. Lớp trưởng của một lớp phải là học viên của lớp đó.
CREATE OR ALTER TRIGGER TRIGGER_LOPTRG
ON LOP
AFTER INSERT
AS
BEGIN
	DECLARE @TRGLOP CHAR(5) = (SELECT TRGLOP FROM inserted)
	DECLARE @MALOP CHAR(3) =(SELECT MALOP FROM inserted)

	IF (@TRGLOP NOT IN (SELECT MAHV FROM HOCVIEN WHERE MALOP = @MALOP))
	BEGIN
		RAISERROR (N'Lớp trưởng của một lớp phải là học viên của lớp đó.',10,1)
		ROLLBACK
	END
END
-- TEST
INSERT INTO LOP (MALOP, TENLOP, TRGLOP,SISO,MAGVCN)
VALUES ('K14','Lop 1 khoa 1','K1208','11','GV07')
GO

--5. Trưởng khoa phải là giáo viên thuộc khoa và có học vị “TS” hoặc “PTS”.
CREATE OR ALTER TRIGGER TRIGGER_TRGKHOA
ON KHOA
AFTER INSERT
AS
BEGIN
	DECLARE @TRGKHOA CHAR(4) = (SELECT TRGKHOA FROM inserted);
	DECLARE @MAKHOA CHAR(4) = (SELECT MAKHOA FROM inserted);

	IF(@TRGKHOA NOT IN (SELECT MAGV FROM GIAOVIEN WHERE MAKHOA = @MAKHOA AND HOCVI IN('TS','PTS')))
	BEGIN
		RAISERROR (N'Trưởng khoa phải là giáo viên thuộc khoa và có học vị “TS” hoặc “PTS”.',10,1)
		ROLLBACK
	END
END
-- TEST
INSERT INTO KHOA (MAKHOA, TENKHOA, NGTLAP,TRGKHOA)
VALUES ('KHDL', 'Khoa hoc du lieu', '5/10/2010','GV15')
INSERT INTO KHOA (MAKHOA, TENKHOA, NGTLAP,TRGKHOA)
VALUES ('KHDL', 'Khoa hoc du lieu', '5/10/2010','GV02')
 
GO

--6. Học viên ít nhất là 18 tuổi.
CREATE OR ALTER TRIGGER TRIGGER_TUOIHV
ON HOCVIEN
AFTER INSERT
AS
BEGIN
	DECLARE @NGAYSINH DATE = (SELECT NGSINH FROM inserted)
	IF( DATEDIFF(YEAR, @NGAYSINH, GETDATE()) < 18)
	BEGIN
		RAISERROR (N'Học viên ít nhất là 18 tuổi.',10,1)
		ROLLBACK
	END
END
--TEST
INSERT INTO HOCVIEN(MAHV, HO,TEN,NGSINH,GIOITINH,NOISINH,MALOP)
VALUES	('K1112', 'Tran Thi','A', '5/15/2003','Nu','Ha noi', 'K11'),
		('K1113', 'Tran Thi','C', '5/15/2004','Nu','Ha noi', 'K11')

GO

--7. Giảng dạy một môn học ngày bắt đầu (TUNGAY) phải nhỏ hơn ngày kết thúc (DENNGAY).
CREATE OR ALTER TRIGGER TRIGGER_THOI_GIAN_DAY
ON GIANGDAY
INSTEAD OF INSERT
AS
BEGIN
	IF ((SELECT DATEDIFF(DAY, TUNGAY, DENNGAY) FROM inserted)< 0)
	BEGIN
		RAISERROR (N'Giảng dạy một môn học ngày bắt đầu phải nhỏ hơn ngày kết thúc.',10,1)
		ROLLBACK
	END
END
--TEST
INSERT INTO GIANGDAY(MALOP, MAMH, MAGV, HOCKY, NAM,TUNGAY,DENNGAY)
VALUES ('K11', 'LTCFW', 'GV14', 3, 2021, '2/15/2021', '2/16/2021')
GO

--8. Giáo viên khi vào làm ít nhất là 22 tuổi.
CREATE OR ALTER TRIGGER TRIGGER_TUOIVL
ON GIAOVIEN
AFTER INSERT
AS
BEGIN
	DECLARE @NGSINH DATE = (SELECT NGSINH FROM inserted);
	IF(DATEDIFF(YEAR, @NGSINH, GETDATE()) <22)
	BEGIN
		RAISERROR(N'GIÁO VIÊN PHẢI ÍT NHẤT 22 TUÔI',10,1);
		ROLLBACK
	END
END

--TEST
INSERT INTO GIAOVIEN  
VALUES('GV16', 'ALEX', 'KS','GV','Nam','5/25/2004', '5/1/2020',1.69, 760500, 'KHMT')
GO

--9. Tất cả các môn học đều có số tín chỉ lý thuyết và tín chỉ thực hành chênh lệch nhau không quá 3.
CREATE OR ALTER TRIGGER TRIGGER_MH_LTTH
ON MONHOC
AFTER INSERT
AS
BEGIN
	IF((SELECT ABS(TCLT - TCTH) FROM inserted) > 3)
	BEGIN
		RAISERROR('TCLT VÀ TCTH KHÔNG CHÊCH QUÁ 3',10,1);
		ROLLBACK
	END
END
-- TEST
INSERT INTO MONHOC (MAMH, TENMH,TCLT,TCTH,MAKHOA)
VALUES ('AI','Nhap mon tri tue nhan tao', 3,1,'KHMT')
GO

--10. Học viên chỉ được thi một môn học nào đó khi lớp của học viên đã học xong môn học này.
CREATE OR ALTER TRIGGER TRIGGER_MOTMONTHI
ON KETQUATHI
AFTER INSERT
AS
BEGIN
	DECLARE @MAMH VARCHAR(10) = (SELECT MAMH FROM inserted)
	DECLARE @MAHV VARCHAR(5) = (SELECT MAHV FROM inserted)
	DECLARE @NGAYTHI DATE = (SELECT NGTHI FROM inserted)
	DECLARE @MALOP CHAR(3) = (SELECT MALOP FROM HOCVIEN WHERE MAHV = @MAHV)
	DECLARE @DENNGAY DATE = (SELECT DENNGAY FROM GIANGDAY GD WHERE GD.MALOP =@MALOP AND GD.MAMH = @MAMH) 
	IF(@DENNGAY > @NGAYTHI)
	BEGIN
		RAISERROR('Học viên chỉ được thi một môn học nào đó khi lớp của học viên đã học xong môn học này.',10,1)
		ROLLBACK
	END
END
--TEST
INSERT INTO KETQUATHI(MAHV,MAMH,LANTHI,NGTHI,DIEM,KQUA)
VALUES('K1102','DHMT',2,'7/19/2006',3.75,'Khong Dat')

GO

--11. Mỗi học kỳ của một năm học, một lớp chỉ được học tối đa 3 môn.
CREATE OR ALTER TRIGGER TRIGGER_SOLOP_HOC_1KY
ON GIANGDAY
AFTER INSERT
AS
BEGIN
	
	DECLARE @SO_LOP_HOC INT = ( SELECT COUNT(GD.MALOP) FROM GIANGDAY GD 
								JOIN inserted I ON I.MALOP = GD.MALOP AND I.HOCKY = GD.HOCKY AND I.NAM = GD.NAM )
	IF(@SO_LOP_HOC > 3)
	BEGIN
		RAISERROR(' Mỗi học kỳ của một năm học, một lớp chỉ được học tối đa 3 môn.', 10,1);
		ROLLBACK
	END
END
-- TEST
INSERT INTO GIANGDAY(MALOP, MAMH, MAGV, HOCKY, NAM,TUNGAY,DENNGAY)
VALUES ('K11', 'LTCFW', 'GV14', 1, 2006, '2/15/2021', '2/16/2021')
INSERT INTO GIANGDAY(MALOP, MAMH, MAGV, HOCKY, NAM,TUNGAY,DENNGAY)
VALUES ('K11', 'LTHDT', 'GV14', 1, 2006, '2/15/2021', '2/16/2021')
GO

--12. Sỉ số của một lớp bằng với số lượng học viên thuộc lớp đó.
CREATE OR ALTER TRIGGER TRIGGER_SSLOP
ON LOP
AFTER INSERT
AS
BEGIN
	DECLARE @SLHV INT  = (SELECT COUNT(MAHV) FROM HOCVIEN WHERE MALOP = (SELECT MALOP FROM inserted));
	IF((SELECT SISO FROM inserted) > @SLHV)
	BEGIN
		RAISERROR('Sỉ số của một lớp bằng với số lượng học viên thuộc lớp đó.', 10,1);
		ROLLBACK
	END
END
-- TEST
INSERT INTO LOP (MALOP, TENLOP, TRGLOP,SISO,MAGVCN)
VALUES ('K11','Lop 1 khoa 1','K1208','15','GV07')

GO
--13. Trong quan hệ DIEUKIEN giá trị của thuộc tính MAMH và MAMH_TRUOC
--trong cùng một bộ không được giống nhau (“A”,”A”) và cũng không tồn tại hai
--bộ (“A”,”B”) và (“B”,”A”).
CREATE OR ALTER TRIGGER TRIGGER_DK
ON DIEUKIEN
AFTER INSERT
AS
BEGIN
	DECLARE @MAMH CHAR(10) = (SELECT MAMH FROM inserted)
	DECLARE @MAMH_TRUOC CHAR(10) = (SELECT MAMH_TRUOC FROM inserted)

	IF (@MAMH LIKE @MAMH_TRUOC)
	BEGIN
		RAISERROR('MAMH VÀ MAMH_TRUOC KHÔNG ĐƯỢC GIỐNG NHAU',10,1)
		ROLLBACK
	END
	ELSE IF EXISTS (SELECT * FROM DIEUKIEN WHERE MAMH = @MAMH_TRUOC AND MAMH_TRUOC = @MAMH)
	BEGIN
		RAISERROR('KHÔNG ĐƯỢC TỒN TẠI MÔN NÀY PHẢI HỌC SAU',10,1)
		ROLLBACK
	END
END

--TEST
INSERT INTO DIEUKIEN(MAMH,MAMH_TRUOC) VALUES('CSDL','CTRR')
INSERT INTO DIEUKIEN(MAMH,MAMH_TRUOC) VALUES('CTRR','CSDL')
INSERT INTO DIEUKIEN(MAMH,MAMH_TRUOC) VALUES('LTCFW','LTCFW')
GO

--14. Các giáo viên có cùng học vị, học hàm, hệ số lương thì mức lương bằng nhau.
CREATE OR ALTER TRIGGER TRIGGER_MUCLUONG
ON GIAOVIEN
AFTER INSERT
AS
BEGIN
	DECLARE @HOCHAM CHAR(4) = (SELECT HOCHAM FROM inserted)
	DECLARE @HOCVI CHAR(3) = (SELECT HOCVI FROM inserted) 
	DECLARE @HESO NUMERIC(4,2) = (SELECT HESO FROM inserted)
	DECLARE @MUCLUONG MONEY = (SELECT MUCLUONG FROM inserted)

	DECLARE @LUONG MONEY = (SELECT MAX(MUCLUONG) FROM GIAOVIEN WHERE HOCVI = @HOCVI AND HOCHAM = @HOCHAM  AND HESO = @HESO)

	IF ( @MUCLUONG <> @LUONG)

	BEGIN
		RAISERROR('giáo viên có cùng học vị, học hàm, hệ số lương thì mức lương bằng nhau.',10,1)
		ROLLBACK
	END
END
-- TEST
INSERT INTO GIAOVIEN  
VALUES('GV16', 'ALEX', 'CN',null,'Nam','5/25/1994', '5/1/2020',1.69, 760500, 'KHMT')

GO

--15. Học viên chỉ được thi lại (lần thi >1) khi điểm của lần thi trước đó dưới 5.
CREATE OR ALTER TRIGGER TRIGGER_THILAI 
ON KETQUATHI
AFTER INSERT
AS
BEGIN
	DECLARE @MAHV CHAR(5) = (SELECT MAHV FROM inserted)
	DECLARE @MAMH VARCHAR(10) = (SELECT MAMH FROM inserted)
	DECLARE @LANTHI INT = (SELECT LANTHI FROM inserted)
	IF(@LANTHI = 1 OR (SELECT DIEM FROM KETQUATHI KQT WHERE MAHV = @MAHV AND MAMH = @MAMH AND LANTHI = @LANTHI -1)>= 5)
	BEGIN
		RAISERROR('ĐIỂM CAO HƠN 5' , 10, 1);
		ROLLBACK
	END
END
--TEST
INSERT INTO KETQUATHI(MAHV,MAMH,LANTHI,NGTHI,DIEM,KQUA)
VALUES('K1102','THDC',2,'7/19/2006',3.75,'Khong Dat')

GO

--16. Ngày thi của lần thi sau phải lớn hơn ngày thi của lần thi trước (cùng học viên,
--cùng môn học).

CREATE OR ALTER TRIGGER TRIGGER_NGAYTHI
ON KETQUATHI
AFTER INSERT
AS
BEGIN
	DECLARE @NGAYTHI DATE = (SELECT NGTHI FROM inserted)
	DECLARE @MAHV CHAR(5) = (SELECT MAHV FROM inserted)
	DECLARE @MAMH VARCHAR(10) = (SELECT MAMH FROM inserted)
	DECLARE @LANTHI INT = (SELECT LANTHI FROM inserted)
	DECLARE @NGAYTHICU DATE = (SELECT NGTHI FROM KETQUATHI WHERE MAHV = @MAHV AND MAMH = @MAMH AND LANTHI = @LANTHI-1)

	IF (@NGAYTHICU > @NGAYTHI )	
	BEGIN
		RAISERROR('Ngày thi của lần thi sau phải lớn hơn ngày thi của lần thi trướC' , 10, 1);
		ROLLBACK
	END
END

--TEST
INSERT INTO KETQUATHI(MAHV,MAMH,LANTHI,NGTHI,DIEM,KQUA)
VALUES('K1104','CSDL',2,'1/19/2006',3.75,'Khong Dat')
GO

--17. Học viên chỉ được thi những môn mà lớp của học viên đó đã học xong.
CREATE OR ALTER TRIGGER TRIGGER_MONTHI
ON KETQUATHI
AFTER INSERT
AS
BEGIN
	DECLARE @MAMH VARCHAR(10) = (SELECT MAMH FROM inserted)
	DECLARE @MAHV VARCHAR(5) = (SELECT MAHV FROM inserted)
	DECLARE @NGAYTHI DATE = (SELECT NGTHI FROM inserted)
	DECLARE @MALOP CHAR(3) = (SELECT MALOP FROM HOCVIEN WHERE MAHV = @MAHV)

	-- KIỂM TRA MÔN HỌC CÓ TRONG DANH SÁCH MÔN HỌC CỦA HỌC VIÊN
	IF(@MAMH NOT IN (SELECT MAMH FROM GIANGDAY WHERE MALOP = @MALOP))
	BEGIN
		RAISERROR('Học viên chỉ được thi những môn mà lớp của học viên đó đã học xong.',10,1)
		ROLLBACK
	END
	-- KIỂM TRA MÔN HỌC ĐÃ KẾT THÚC CHƯA
	ELSE IF (@NGAYTHI > (SELECT DENNGAY FROM GIANGDAY WHERE MALOP = @MALOP AND MAMH = @MAMH))
	BEGIN
		RAISERROR('Học viên chỉ được thi những môn mà lớp của học viên đó đã học xong.',10,1)
		ROLLBACK
	END
END

INSERT INTO KETQUATHI (MAHV,MAMH,LANTHI,NGTHI,DIEM,KQUA)
VALUES ('K1101','DHMT', 1, '1/18/2007', 7, 'Dat')

GO
--18. Khi phân công giảng dạy một môn học, phải xét đến thứ tự trước sau giữa các
--môn học (sau khi học xong những môn học phải học trước mới được học
--những môn liền sau).
CREATE OR ALTER TRIGGER TRIGGER_PHANCONGGIANGDAY
ON GIANGDAY
AFTER INSERT
AS
BEGIN
	DECLARE @MAMH VARCHAR(10) = (SELECT MAMH FROM inserted)
	DECLARE @MALOP VARCHAR(10) = (SELECT MALOP FROM inserted)
	DECLARE @MAMH_TRUOC VARCHAR(10) = (SELECT MAMH_TRUOC FROM DIEUKIEN WHERE MAMH = @MAMH)

	-- KIỂM TRA NGÀY KẾT THÚC CỦA MÔN HỌC TRƯỚC SO VỚI NGÀY BẮT ĐẦU MÔN HỌC SAU
	IF ((SELECT DENNGAY FROM GIANGDAY WHERE MAMH = @MAMH_TRUOC AND MALOP = @MALOP)> (SELECT TUNGAY FROM inserted))
	BEGIN
		RAISERROR('Học xong những môn học phải học trước mới được học những môn liền sau.',10,1)
		ROLLBACK
	END
END
-- TEST

INSERT INTO GIANGDAY(MALOP, MAMH, MAGV, HOCKY, NAM,TUNGAY,DENNGAY)
VALUES ('K11', 'LTHDT', 'GV01', 1, 2006, '2/15/2021', '2/16/2021')
GO
--19. Giáo viên chỉ được phân công dạy những môn thuộc khoa giáo viên đó phụ
--trách.

CREATE OR ALTER TRIGGER TRIGGER_GVPHANCONG
ON GIANGDAY
AFTER INSERT
AS
BEGIN
	DECLARE @MAGV CHAR(4) = (SELECT MAGV FROM inserted)
	DECLARE @MAMH VARCHAR(10) = (SELECT MAMH FROM inserted)
	-- LẤY RA MAKHOA SAU ĐÓ SO SÁNH
	IF((SELECT MAKHOA FROM GIAOVIEN GV WHERE MAGV = @MAGV) != (SELECT MAKHOA FROM MONHOC WHERE MAMH = @MAMH))
	BEGIN
		RAISERROR('Giáo viên chỉ được phân công dạy những môn thuộc khoa giáo viên đó phụ trách.',10,1)
		ROLLBACK
	END
END
-- TEST
INSERT INTO GIANGDAY(MALOP, MAMH, MAGV, HOCKY, NAM,TUNGAY,DENNGAY)
VALUES ('K12', 'LTHDT', 'GV05', 4, 2006, '2/15/2021', '7/30/2021')
GO