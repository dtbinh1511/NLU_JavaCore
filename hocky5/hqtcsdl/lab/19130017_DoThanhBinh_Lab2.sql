use NUOCGIAIKHAT
go

-----------------
-- 19130017- ĐỖ THANH BÌNH - Lab 2
-----------------

-----------------
-- View
-----------------

--1. Tạo View V_NGK tổng hợp dữ liệu về từng NGK đã được bán. Cấu trúc View gồm các thuộc tính:
--MaNGK, TenNGK, Quycach, SoLuongBan,Tổng tiền= SoLuongBan*Đơn giá bán
CREATE OR ALTER VIEW V_NGK
AS (SELECT NGK.MaNGK, NGK.TenNGK, NGK.Quycach, CTHD.SLKHMua AS SoLuongBan, SUM(CTHD.SLKHMua * CTHD.DGBan) AS TongTien
	FROM NGK
	JOIN CT_HOADON CTHD ON CTHD.MaNGK = NGK.MaNGK
	GROUP BY NGK.MaNGK, NGK.TenNGK, NGK.Quycach, CTHD.SLKHMua)
GO
-- TEST
SELECT * FROM V_NGK
GO

--2. Tạo View V_khachang tổng hợp dữ liệu về 10 khách hàng lớn. Danh sách gồm MaKH, TenKH,
--DTKH, Tổng tiền= SoLuongBan*Đơn giá bán
CREATE OR ALTER VIEW V_KHACHHANG
AS( SELECT TOP 10 KH.MaKH, KH.TenKH, KH.DTKH, SUM(CTHD.SLKHMua *  CTHD.DGBan) AS TongTien
	FROM KH 
	JOIN HOADON HD ON KH.MaKH = HD.MaKH
	JOIN CT_HOADON CTHD ON CTHD.SoHD = HD.SoHD
	GROUP BY KH.MaKH, KH.TenKH, KH.DTKH
	ORDER BY TongTien)
GO
-- TEST
SELECT * FROM V_KHACHHANG

GO
--3. Tạo view V_TRANO cho biết danh sách khách hàng 
--đã thu hơn 2 lần nhưng chưa trả hết tiền. 
--Danh sách gồm: MaKH, TenKH, DTKH, tổng tiền phải trả, tổng tiền đã trả, số lần thu tiền
CREATE OR ALTER VIEW V_TRANO
AS (SELECT A.MaKH, A.TenKH, A.DTKH, A.TongTienPhaiTra,B.TongTienDaTra ,B.SoLanThuTien
	FROM(SELECT CTHD.SoHD, KH.MaKH, KH.TenKH, KH.DTKH, SUM(CTHD.SLKHMua *  CTHD.DGBan) AS TongTienPhaiTra
		FROM KH
		JOIN HOADON HD ON HD.MaKH = KH.MaKH
		JOIN CT_HOADON CTHD ON CTHD.SoHD = HD.SoHD
		GROUP BY CTHD.SoHD, KH.MaKH, KH.TenKH, KH.DTKH
		) AS A -- lấy ra số hóa đơn và tổng tiền đã trả
	JOIN (	SELECT HD.SoHD, SUM(PTN.SotienTra) AS TongTienDaTra , COUNT(PTN.SoHD) AS SoLanThuTien
			FROM HOADON HD
			JOIN PHIEUTRANO PTN ON PTN.SoHD = HD.SoHD
			GROUP BY HD.SoHD) AS B -- lấy ra số hóa đơn và tổng tiền phải trả
			ON B.SoHD = A.SoHD 
			WHERE B.SoLanThuTien >= 2 AND (A.TongTienPhaiTra - B.TongTienDaTra) > 0
	GROUP BY A.MaKH, A.TenKH, A.DTKH, A.TongTienPhaiTra,B.TongTienDaTra ,B.SoLanThuTien
)
GO
-- TEST
SELECT * FROM V_TRANO
GO

--4. Tạo view V_ngk_ton hiển thị thông tin nước giải khát chưa bán được
CREATE OR ALTER VIEW V_NGK_TON
AS(
	SELECT *
	FROM NGK
	WHERE MaNGK NOT IN (SELECT MaNGK FROM CT_DDH UNION SELECT MaNGK FROM CT_HOADON)
)
GO
-- TEST
SELECT * FROM V_NGK_TON
GO

-----------------
-- Procedure
-----------------

--1. Tạo thủ tục sp_tong_dt tinh tổng doanh thu của năm (với năm là tham số đầu vào và doanh thu là
--tham số đầu ra)
CREATE OR ALTER PROC SP_TONG_DT
@NAM INT = 2010 OUTPUT
AS
BEGIN
	DECLARE @DOANHTHUHD INT 
	SET @DOANHTHUHD = (	SELECT SUM(CTHD.SLKHMua * CTHD.DGBan) 
						FROM HOADON HD JOIN CT_HOADON CTHD 
						ON CTHD.SoHD = HD.SoHD 
						WHERE YEAR(HD.NgaylapHD) = @NAM)
	if(@DOANHTHUHD IS NULL) SET @DOANHTHUHD = 0

	DECLARE @DOANHTHUGD INT
	SET @DOANHTHUGD =  (SELECT SUM(CT_PGH.SLGiao * CT_PGH.DGGiao)
						FROM PHIEUGH PGH
						JOIN CT_PGH ON CT_PGH.SoPGH = PGH.SoPGH
						WHERE YEAR(PGH.NgayGH) = @NAM)
	if(@DOANHTHUGD IS NULL) SET @DOANHTHUGD = 0

	DECLARE @TONGDOANHTHU INT = @DOANHTHUHD + @DOANHTHUGD
	PRINT('Tổng doanh thu = '+ cast(@TONGDOANHTHU as nvarchar(20)))
END

--TEST
EXEC SP_TONG_DT @NAM = 2010
GO

--2. Tạo thủ tục sp_danhsach liệt kê n loại nước giải khát bán chạy nhất (doanh thu) trong tháng (với n và
--tháng là tham số đầu vào)
CREATE OR ALTER PROC SP_DANHSACH
@n INT = 1,
@THANG INT
AS
BEGIN
	SELECT TOP (@n) LOAINGK.MaLoaiNGK, LOAINGK.TenLoaiNGK
	FROM LOAINGK
	JOIN NGK ON NGK.MaLoaiNGK = LOAINGK.MaLoaiNGK
	JOIN (
		SELECT NGK.MaNGK, SUM(CTHD.SLKHMua * CTHD.DGBan) AS DOANHTHU
		FROM NGK 
		JOIN CT_HOADON CTHD ON CTHD.MaNGK= NGK.MaNGK 
		JOIN HOADON HD ON HD.SoHD = CTHD.SoHD
		WHERE MONTH(HD.NgaylapHD) = @THANG
		GROUP BY NGK.MaNGK

		UNION

		SELECT NGK.MaNGK, SUM(CT_PGH.SLGiao * CT_PGH.DGGiao) AS DOANHTHU
		FROM NGK 
		JOIN CT_PGH ON CT_PGH.MaNGK= NGK.MaNGK 
		JOIN PHIEUGH PGH ON PGH.SoPGH = CT_PGH.SoPGH
		WHERE MONTH(PGH.NgayGH) = @THANG
		GROUP BY NGK.MaNGK
	) AS A ON A.MaNGK = NGK.MaNGK
	GROUP BY LOAINGK.MaLoaiNGK, LOAINGK.TenLoaiNGK
	ORDER BY SUM(DOANHTHU) DESC	
END

--TEST
EXEC SP_DANHSACH @n = 2 , @THANG = 1
GO

--3. Tạo thủ tục sp_insert_CTPGH nhận vào các tham số tương ứng với thông tin của một dòng trong chi
--tiết phiếu giao hàng, nếu các điều kiện sau đây được thỏa mãn thì thêm dòng mới tương ứng với các
--thông tin đã cho vào Table CT_PGH:
-- + SoPGH phải tồn tại trong table PGH
-- + MaNGK ứng với SoDDH phải tồn tại trong table CT_DDH
-- + SLGiao<=SLDAT
--Thông báo nếu điều kiện trên bị vi phạm

CREATE OR ALTER PROC SP_INSERT_CTPGH --!!!!
@sopgh varchar(5),
@mangk varchar(5),
@slgiao int,
@dggiao int
AS
BEGIN
	IF(@sopgh NOT IN (SELECT SoPGH FROM PHIEUGH))
	BEGIN
		PRINT(N'SoPGH KHÔNG TỒN TẠI')
	END
	ELSE IF(NOT EXISTS (SELECT SoDDH FROM CT_DDH WHERE MaNGK = @mangk))
	BEGIN
		PRINT(N'MANGK KHÔNG TƯƠNG THÍCH')
	END
	ELSE IF(@slgiao <= (SELECT SUM(SLDat) AS SLDat FROM CT_DDH WHERE MaNGK = @mangk))
			-- CHƯA XÉT TRƯỜNG HỢP ĐÃ GIAO RỒI MÀ KO TRỪ ĐI SLDat: ví dụ đặt 30, 
			-- đã giao 15 nên chỉ có thế giao thêm 15
	BEGIN
		PRINT(N'SLGIAO VƯỢT QUÁ GIỚI HẠN')
	END
	ELSE
	BEGIN
		insert into CT_PGH values(@sopgh, @mangk,@slgiao,@dggiao)
	END

	-- CÁCH HIỂU KHÁC
	--DECLARE @SODDH VARCHAR(5);
	--SET @SODDH = (SELECT SODDH FROM PHIEUGH WHERE SoPGH = @sopgh);
	--IF (@SOPGH IN (SELECT SoPGH FROM PHIEUGH) 
	--	AND @slgiao <= (SELECT SLDAT FROM CT_DDH 
	--					WHERE MaNGK = @MANGK AND SoDDH = @SODDH))
	--	AND @mangk IN (SELECT MaNGK FROM CT_DDH WHERE SoDDH = @SODDH)
	--	INSERT INTO CT_PGH VALUES (@sopgh, @mangk, @slgiao, @dggiao)
	--ELSE PRINT('DIEU KIEN KHONG THOA MAN');
END

--TEST
EXEC SP_INSERT_CTPGH @sopgh ='PGH02', @mangk ='ST2'	,@slgiao = 15, @dggiao = 5000
GO

--4. Tạo thủ tục có tên sp_delete_CTPH nhận vào các tham số tương ứng với thông tin của một dòng
--trong chi tiết phiếu hẹn, thực hiện các yêu cầu sau:
--+ Xóa dòng trương ứng trong chi tiết phiếu hẹn
--+ Nếu phiếu hẹn tương ứng không còn dòng chi tiết thì xóa luôn phiếu hẹn đó
CREATE OR ALTER PROC SP_DELETE_CTPH
@SOPH VARCHAR(5),
@MANGK VARCHAR(5),
@SLHEN INT
AS
BEGIN
	IF EXISTS (SELECT * FROM CT_PH) 
	BEGIN
		DELETE FROM CT_PH WHERE SoPH = @SOPH AND MaNGK = @MANGK AND SLHen = @SLHEN
	END
	ELSE
	BEGIN
		drop table CT_PH
	END
END
GO

--TEST
EXEC SP_DELETE_CTPH @SOPH = 'PH01', @MANGK ='OD', @SLHEN = 8
GO		

-----------------
-- Function
-----------------

--1. Tạo hàm f_list có 2 tham số là @Ngay1 và @Ngay2 
--cho biết danh sách các NGK đã được bán trong khoảng thời gian trên. 
--Danh sách gồm các thuộc tính: MaNGK, TenNGK, DVT, SoLuong.
CREATE OR ALTER FUNCTION F_LIST(@NGAY1 INT, @NGAY2 INT)
RETURNS TABLE
AS
RETURN(	
	SELECT A.MaNGK, A.TenNGK, A.DVT, SUM(A.SoLuong) AS SoLuong
	FROM (
		--  hóa đơn
		SELECT NGK.MaNGK, NGK.TenNGK, NGK.Quycach AS DVT, SUM(SLKHMua)AS SoLuong
		FROM NGK
		JOIN CT_HOADON CTHD ON CTHD.MaNGK = NGK.MaNGK
		JOIN HOADON HD ON HD.SoHD = CTHD.SoHD
		WHERE DAY(HD.NgaylapHD) BETWEEN @NGAY1 AND @NGAY2
		GROUP BY NGK.MaNGK, NGK.TenNGK, NGK.Quycach
	
		UNION
		--  giao hàng
		SELECT NGK.MaNGK, NGK.TenNGK, NGK.Quycach AS DVT, SUM(SLGIAO)AS SoLuong
		FROM NGK
		JOIN CT_PGH ON NGK.MaNGK = CT_PGH.MaNGK
		JOIN PHIEUGH PGH ON CT_PGH.SoPGH = PGH.SoPGH
		WHERE DAY(PGH.NgayGH) BETWEEN @NGAY1 AND @NGAY2
		GROUP BY NGK.MaNGK, NGK.TenNGK, NGK.Quycach
	) AS A
	GROUP BY A.MaNGK, A.TenNGK, A.DVT
)
GO
--TEST
SELECT * FROM dbo.F_LIST(6,7)
GO

--2. Tạo hàm f_max cho biết ĐĐH đã đặt NGK với số lượng nhiều nhất 
--so với các ĐĐH khác có đặt NGK đó. 
--Thông tin hiển thị: SoDDH, MaNGK, [SL đặt nhiều nhất].
-- => LẤY RA MAX CỦA TỪNG LOẠI
CREATE OR ALTER FUNCTION F_MAX ()
RETURNS TABLE
RETURN (SELECT SoDDH, CT_DDH.MaNGK, B.SLDNN
		FROM CT_DDH
		JOIN(SELECT MaNGK, MAX(SLDat) AS SLDNN
			 FROM CT_DDH
			 GROUP BY MaNGK) AS B 
		ON B.MaNGK = CT_DDH.MaNGK AND B.SLDNN = CT_DDH.SLDat
)
GO
--TEST
SELECT * FROM dbo.F_MAX()
GO

--3. Tạo hàm f_kh hiển thị thông tin của khách hàng 
--có giao dịch với cửa hàng nhiều nhất (căn cứ vào số lần mua hàng).
CREATE OR ALTER FUNCTION F_KH()
RETURNS TABLE
RETURN (SELECT TOP 1 KH.MaKH, KH.TenKH, KH.DCKH, KH.DTKH
		FROM KH
		JOIN HOADON HD ON HD.MaKH = KH.MaKH
		GROUP BY KH.MaKH, KH.TenKH, KH.DCKH, KH.DTKH
		ORDER BY COUNT(KH.MaKH) DESC 
)
GO
--TEST
SELECT * FROM dbo.F_KH()
GO
--4. Tạo hàm f_xlkh nhận vào tham số @MaKH, 
-- tính tổng tiền khách hàng đã trả(TongTien=sum(SLKHMua*DGBan)). 
-- Sau đó hàm trả về kết quả xếp loại khách hàng như sau:
--+ Nếu TongTien>800.000 : xếp loại “KH VIP”
--+ Nếu TongTien>500.000 : xếp loại “KH THÀNH VIÊN”
--+ Nếu TongTien<=500.000 : xếp loại “KH THÂN THIẾT”
CREATE OR ALTER FUNCTION F_XLKH(@MaKH VARCHAR(5))
RETURNS NVARCHAR(50)
AS
BEGIN
	DECLARE @TONGTIEN INT = (	SELECT SUM(CTHD.SLKHMua * CTHD.DGBan) AS TONGTIEN
								FROM CT_HOADON CTHD
								JOIN HOADON HD ON HD.SoHD = CTHD.SoHD
								WHERE HD.MaKH = @MaKH)
	RETURN CASE WHEN (@TONGTIEN > 800000) THEN 'KH VIP'
				WHEN (@TONGTIEN > 500000) THEN N'KH THÀNH VIÊN'
				WHEN (@TONGTIEN <= 500000) THEN N'KH THÂN THIẾT' END
END
GO
--TEST
 SELECT dbo.F_XLKH('KH02') AS N'XẾP LOẠI'
GO

-----------------
-- Trigger
-----------------

--1. Tạo trigger PH _insert trên bảng PHIEUHEN kiểm tra ràng buộc toàn vẹn sau đây mỗi khi thêm một
--dòng vào bảng PHIEUHEN:
--+ MaKH phải tồn tại trong bảng KH
--+ Ngày hẹn giao không thể trước ngày lập phiếu hẹn.
CREATE OR ALTER TRIGGER PH_INSERT
ON PHIEUHEN
FOR INSERT
AS
BEGIN
	IF (NOT EXISTS (SELECT i.MaKH FROM KH 
					join inserted i
					on KH.MaKH = i.MaKH)) -- lỗi conflicted with the FOREIGN KEY nên ko chạy được
	BEGIN
		RAISERROR ('MAKH KHÔNG TỒN TẠI!',10,1)
		ROLLBACK
	END

	ELSE IF((SELECT DATEDIFF(DAY, NgaylapPH, NgayhenGiao) 
				FROM PHIEUHEN where SoPH = (select SoPH from inserted i)) < 0)
	BEGIN 
		RAISERROR ('Ngày giao sớm hơn ngày lập phiếu!',10,1)
		ROLLBACK
	END	
END

--TEST
INSERT INTO PHIEUHEN (SoPH,NgaylapPH ,NgayhenGiao, MaKH)
values ('PH07','08/05/2010','08/04/2010','KH04')
GO
--2. Tạo trigger CTPH _insert trên bảng CT_PH kiểm tra ràng buộc toàn vẹn sau đây mỗi khi thêm một
--dòng vào bảng CT_PH:”Tổng số lượng hẹn cho mỗi MaNGK không vượt quá 20”
CREATE OR ALTER TRIGGER TRIGGER_CTPH_INSERT
ON CT_PH
AFTER INSERT
AS
BEGIN
	IF(	SELECT SUM(SLHen) 
		FROM CT_PH WHERE MaNGK = (SELECT MaNGK FROM inserted)) > 20
	BEGIN
		RAISERROR ('Tổng số lượng hẹn cho mỗi MaNGK không vượt quá 20!',10,1)
		ROLLBACK
	END
END

--TEST
INSERT INTO CT_PH(SoPH,MaNGK,SLHen)
VALUES ('PH011','PS2',5)
GO

--3. Viết trigger PT_insert trên bảng PHIEUTRANO kiểm tra ràng buộc toàn vẹn sau đây
--mỗi khi thêm một dòng vào bảng PHIEUTRANO:“ Khách hàng chỉ được trả tối đa 3 lần cho mỗi hóa đơn”

CREATE OR ALTER TRIGGER TRIGGER_PT_INSERT
ON PHIEUTRANO
AFTER INSERT
AS
BEGIN
	IF(SELECT COUNT(SoHD) FROM PHIEUTRANO WHERE SoHD = (SELECT SoHD FROM inserted)) > 3
	BEGIN
		RAISERROR ('Khách hàng chỉ được trả tối đa 3 lần cho mỗi hóa đơn”!',10,1)
		ROLLBACK
	END
END

--TEST
INSERT INTO PHIEUTRANO VALUES('PTN9','08/14/2021',50000, 'HD01')
GO

--4. Viết trigger HD_update trên bảng HOADON kiểm tra ràng buộc toàn vẹn sau đây mỗi khi cập nhật
--một dòng trên bảng HOADON:
--+ Không được cập nhật SoHD
--+ MaKH phải tồn tại trong bảng KH
--+ NgaylapHD <= Ngày hiện tại

CREATE OR ALTER TRIGGER HD_update
ON HOADON
AFTER UPDATE
AS
BEGIN
	DECLARE @SoHD_MOI VARCHAR(4)= ( SELECT SoHD FROM inserted)
	DECLARE @SoHD_CU VARCHAR(4)= ( SELECT SoHD FROM deleted)
	--+ Không được cập nhật SoHD
	IF( @SoHD_CU NOT LIKE @SoHD_MOI)
	BEGIN
		RAISERROR ('Không được cập nhật SoHD',10,1)
		ROLLBACK
	END
	--+ MaKH phải tồn tại trong bảng KH
	ELSE IF NOT EXISTS (SELECT MaKH FROM KH WHERE MaKH = (SELECT MaKH FROM inserted))
	BEGIN
		RAISERROR (' MaKH phải tồn tại trong bảng KH!',10,1)
		ROLLBACK
	END
	--+ NgaylapHD <= Ngày hiện tại
	ELSE IF((SELECT DATEDIFF(DAY, i.NgaylapHD, GETDATE()) 
				FROM  inserted i) < 0)
	BEGIN
		RAISERROR ('NgaylapHD  <= Ngày hiện tại!',10,1)
		ROLLBACK
	END
END

--TEST
UPDATE  HOADON
SET NgaylapHD = '11/20/2021'
WHERE SoHD='HD06' 

GO