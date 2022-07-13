---------------------------
-- 19130017
-- Đỗ Thanh Bình
---------------------------

use QLGiaoVu
go

--1. Tạo thủ tục P_KQMH, cho biết bảng của điểm học viên (p_mahv).
-- Thông tin gồm: Mã học viên, tên học viên, mã môn học, tên môn học, điểm (chỉ lấy điểm của lần thi cuối cùng), kết quả
-- Thủ tục nhận tham số đầu vào là mã học viên (p_mahv)
CREATE OR ALTER PROC P_KQMH (@p_mahv CHAR(5))
AS
BEGIN
	SET NOCOUNT ON;
		-- KHAI BÁO BIẾN
		DECLARE @MAHV CHAR(5), 
				@TEN VARCHAR(10),
				@MAMH VARCHAR(10), 
				@TENMH VARCHAR(40), 
				@DIEM NUMERIC(4,2), 
				@KETQUA VARCHAR(10)
		-- TẠO CURSOR
		DECLARE KQMH_CURSOR CURSOR FOR 
				SELECT HV.MAHV, HV.TEN,MH.MAMH, MH.TENMH, KQT.DIEM, KQT.KQUA
				FROM QLGiaoVu.dbo.HOCVIEN HV 
				JOIN KETQUATHI KQT ON KQT.MAHV = HV.MAHV 
				JOIN MONHOC MH ON MH.MAMH = KQT.MAMH
				WHERE KQT.LANTHI = ( SELECT MAX(LANTHI) FROM KETQUATHI WHERE MAHV = @p_mahv) AND HV.MAHV = @p_mahv

		-- TẠO TABLE ẢO ĐỂ CHỨA
		create table #v_bangdiemhv (
					MAHV char(5),
					TENHV varchar(10),
					MAMH varchar(10),
					TEMH varchar(40),
					DIEM numeric(4,2),
					KQUA varchar(10));
		-- OPEN
		OPEN KQMH_CURSOR
			FETCH NEXT FROM KQMH_CURSOR INTO @MAHV, @TEN ,@MAMH, @TENMH, @DIEM, @KETQUA
			IF(@@FETCH_STATUS <> 0)
				PRINT ('---< < NONE > >-----')
			ELSE
				BEGIN
					WHILE @@FETCH_STATUS = 0
					BEGIN
						INSERT INTO #v_bangdiemhv VALUES (@MAHV, @TEN, @MAMH,@TENMH, @DIEM,@KETQUA)
						FETCH NEXT FROM KQMH_CURSOR INTO @MAHV, @TEN ,@MAMH, @TENMH, @DIEM,@KETQUA
					END
						SELECT * FROM #v_bangdiemhv
				END
		--CLOSE
		CLOSE KQMH_CURSOR
		DEALLOCATE KQMH_CURSOR
	SET NOCOUNT OFF;
END

EXEC P_KQMH @p_mahv = 'K1101'

GO
--2. Tạo thủ tục P_GVMH, cho biết danh sách sinh viên học môn (p_mamh) do giáo viên (p_mgv) phụ trách trong học kỳ (p_hocky), năm học (p_nam).
--Thông tin gồm: Mã GV, mã môn học, mahv, ho&ten hoc vien
--Thủ tục nhận các tham số đầu vào là mã môn học (p_mamh), mã giáo viên (p_mgv), học kỳ (p_hocky), năm học (p_nam).
CREATE OR ALTER PROC P_GVMH(@p_mamh varchar(10), @p_mgv char(4), @p_hocky int, @p_nam int )
AS
BEGIN
	SET NOCOUNT ON;
		-- KHAI BÁO BIẾN
		DECLARE @MAGV CHAR(4), 
				@MAMH VARCHAR(10), 
				@MAHV CHAR(5), 
				@HO VARCHAR(40), 
				@TEN VARCHAR(10), 
				@HOTEN VARCHAR(50)

		-- TẠO CURSOR
		DECLARE GVMH_CURSOR CURSOR FOR 
				SELECT GD.MAGV, GD.MAMH, HV.MAHV, HV.HO,HV.TEN  
				FROM HOCVIEN HV 
				JOIN GIANGDAY GD ON GD.MALOP = HV.MALOP
				WHERE GD.MAMH = @p_mamh AND GD.MAGV = @p_mgv AND GD.HOCKY = @p_hocky AND GD.NAM = @p_nam

		-- TẠO TABLE ẢO ĐỂ CHỨA
		CREATE TABLE #v_dsach_hv(
			MAGV CHAR(4),
			MAMH VARCHAR(10),
			MAHV CHAR(5),
			HOTEN VARCHAR(50)
		)
		-- OPEN
		OPEN GVMH_CURSOR
		FETCH NEXT FROM GVMH_CURSOR INTO @MAGV, @MAMH,@MAHV,@HO, @TEN
		IF(@@FETCH_STATUS <> 0)
			PRINT ('---< < NONE > >-----')
		ELSE
			BEGIN
				WHILE @@FETCH_STATUS = 0
				BEGIN
					SET @HOTEN = CONCAT(@HO, ' ', @TEN);
					INSERT INTO #v_dsach_hv VALUES (@MAGV, @MAMH,@MAHV, @HOTEN);
					FETCH NEXT FROM GVMH_CURSOR INTO @MAGV, @MAMH,@MAHV,@HO, @TEN
				END
				SELECT * FROM #v_dsach_hv
			END
		--CLOSE
		CLOSE GVMH_CURSOR
		DEALLOCATE GVMH_CURSOR;
	SET NOCOUNT OFF;
END

EXEC P_GVMH @p_mamh='CSDL', @p_mgv = 'GV05', @p_hocky = 2, @p_nam = 2006
GO
--3. Tạo thủ tục P_LOP cho biết danh sách học viên của lớp (p_malop).
--Thông tin gồm: mã lớp, mgvcn, tên gv chủ nhiệm, tên trưởng lớp, mahv, ho&ten học viên.
--Thủ tục nhận 1 tham số đầu vào là mã lớp (p_malop).
CREATE OR ALTER PROC P_LOP (@p_malop CHAR(3))
AS
BEGIN
	SET NOCOUNT ON;
		-- KHAI BÁO BIẾN
		DECLARE @MALOP CHAR(3), 
				@MGVCN CHAR(4), 
				@TENGV VARCHAR(40), 
				@TENTRGLOP VARCHAR(10), 
				@MAHV CHAR(5), 
				@HO VARCHAR(40), 
				@TEN VARCHAR(10), 
				@HOTEN VARCHAR(50)

		-- TẠO CURSOR
		DECLARE LOP_CURSOR CURSOR FOR 
				SELECT LOP.MALOP, GV.MAGV, GV.HOTEN, HV.TEN FROM LOP 
				JOIN HOCVIEN HV ON HV.MAHV = LOP.TRGLOP 
				JOIN GIAOVIEN GV ON GV.MAGV = LOP.MAGVCN
				WHERE LOP.MALOP = @p_malop

		-- TẠO TABLE ẢO ĐỂ CHỨA
		CREATE TABLE #v_DSHV_LOP(
			MALOP CHAR(3),
			MAGVCN CHAR(4),
			TENGV VARCHAR(40),
			TENLOPTRG VARCHAR(10),
			MAHV CHAR(5),
			HOTEN VARCHAR(50)
		)
		--OPEN
		OPEN LOP_CURSOR
		FETCH NEXT FROM LOP_CURSOR INTO @MALOP, @MGVCN,@TENGV,@TENTRGLOP
		IF(@@FETCH_STATUS <> 0)
			PRINT ('---< < NONE > >-----')
		ELSE
			BEGIN
				WHILE @@FETCH_STATUS = 0
				BEGIN
					-- TẠO CURSOR
					DECLARE hv_cursor CURSOR FOR 
							SELECT HV.MAHV, HV.HO, HV.TEN 
							FROM QLGiaoVu.dbo.HOCVIEN HV 
							WHERE HV.MALOP = @MALOP
					-- OPEN
					OPEN hv_cursor
					FETCH NEXT FROM hv_cursor INTO @MAHV, @HO, @TEN
					IF(@@FETCH_STATUS <> 0)
						PRINT ('---< < NONE > >-----')
					ELSE
						BEGIN
							WHILE @@FETCH_STATUS = 0
							BEGIN
								SET @HOTEN = CONCAT(@HO,' ', @TEN)
								INSERT INTO #v_DSHV_LOP VALUES (@MALOP, @MGVCN, @TENGV, @TENTRGLOP, @MAHV, @HOTEN)
								FETCH NEXT FROM hv_cursor INTO @MAHV, @HO, @TEN
							END
						END
						-- CLOSE
					CLOSE hv_cursor
					DEALLOCATE hv_cursor
					-- LĂP LẠI CURSOR CHA
					FETCH NEXT FROM LOP_CURSOR INTO @MALOP, @MGVCN,@TENGV,@TENTRGLOP
				END
				-- IN RA
				SELECT * FROM #v_DSHV_LOP
			END

		-- CLOSE
		CLOSE LOP_CURSOR
		DEALLOCATE LOP_CURSOR;
	SET NOCOUNT OFF;
END

EXEC P_LOP @p_malop = 'K12'
GO
--4. Tạo thủ tục P_TOPN liệt kê danh sách n môn học có số lượng học viên đăng ký học nhiều nhất.
-- Thông tin gồm: Mã môn học, tên môn học, số lượng học viên
-- Thủ tục nhận 1 tham số đầu vào là n.
CREATE OR ALTER PROC P_TOPN(@n int)
AS
BEGIN
	SET NOCOUNT ON;
		--KHAI BÁO BIẾN
		DECLARE @MAMH VARCHAR(10), 
				@TENMH VARCHAR(40), 
				@SLHV INT

		-- TẠO CURSOR
		DECLARE DS_TOPN_CURSOR CURSOR FOR 
				SELECT TOP (@n) MH.MAMH, MH.TENMH, SUM(LOP.SISO) AS SL
				FROM MONHOC MH 
				JOIN GIANGDAY GD ON GD.MAMH = MH.MAMH
				JOIN LOP ON LOP.MALOP = GD.MALOP
				GROUP BY MH.MAMH, MH.TENMH
				ORDER BY SL DESC

		-- TẠO TABLE ẢO ĐỂ CHỨA
		CREATE TABLE #v_TOPMH(
			MAMH VARCHAR(10),
			TENMH VARCHAR(40),
			SLHV INT
		)
		-- OPEN
		OPEN DS_TOPN_CURSOR
		FETCH NEXT FROM DS_TOPN_CURSOR INTO @MAMH, @TENMH, @SLHV
		IF(@@FETCH_STATUS <> 0)
			PRINT ('---< < NONE > >-----')
		ELSE
			BEGIN
				WHILE @@FETCH_STATUS = 0
					BEGIN
						INSERT INTO #v_TOPMH VALUES (@MAMH, @TENMH, @SLHV)
						FETCH NEXT FROM DS_TOPN_CURSOR INTO @MAMH, @TENMH, @SLHV
					END
				SELECT * FROM #v_TOPMH
			END
		-- CLOSE
		CLOSE DS_TOPN_CURSOR
		DEALLOCATE DS_TOPN_CURSOR
	SET NOCOUNT OFF
END
EXEC P_TOPN @n = 3
GO
--5. Tạo thủ tục P_TK, thống kê số lượng học viên của từng môn học mà giáo viên (p_magv)đã phụ trách giảng dạy.
--Thông tin gồm: MAGV, tên gv, mamh, tenmh, số lượng học viên
--Thủ tục nhận 1 tham số đầu vào là mã giáo viên (p_magv)
CREATE OR ALTER PROC P_TK 
@p_magv CHAR(4)
AS
BEGIN
	SET NOCOUNT ON;
		--KHAI BÁO BIẾN
		DECLARE @MAGV CHAR(4), 
				@TENGV VARCHAR(40), 
				@MAMH VARCHAR(10), 
				@TENMH VARCHAR(40), 
				@SLHV INT

		-- TẠO CURSOR
		DECLARE DSHV_GV_CURSOR CURSOR FOR 
				SELECT GV.MAGV, GV.HOTEN, MH.MAMH,MH.TENMH, SUM(LOP.SISO) AS SLHV
				FROM GIAOVIEN GV 
				JOIN GIANGDAY GD ON GD.MAGV = GV.MAGV
				JOIN MONHOC MH ON MH.MAMH = GD.MAMH
				JOIN LOP ON LOP.MALOP = GD.MALOP
				GROUP BY GV.MAGV, GV.HOTEN, MH.MAMH,MH.TENMH
				HAVING GV.MAGV = @p_magv

		-- TẠO TABLE ẢO ĐỂ CHỨA
		CREATE TABLE #DSHV_GV(
			MAGV CHAR(4),
			TENGV VARCHAR(40),
			MAMH VARCHAR(10),
			TENMH VARCHAR(40),
			SLHV INT
		)
		-- OPEN
		OPEN DSHV_GV_CURSOR
		FETCH NEXT FROM DSHV_GV_CURSOR INTO @MAGV, @TENGV , @MAMH , @TENMH , @SLHV
		IF(@@FETCH_STATUS <> 0)
		PRINT ('---< < NONE > >-----')
		ELSE
			BEGIN
				WHILE @@FETCH_STATUS = 0
				BEGIN
					-- INSERT VÀO TABLE
					INSERT INTO #DSHV_GV VALUES (@MAGV, @TENGV , @MAMH , @TENMH , @SLHV)
					FETCH NEXT FROM DSHV_GV_CURSOR INTO @MAGV, @TENGV , @MAMH , @TENMH , @SLHV			
				END
				SELECT * FROM #DSHV_GV
			END
		-- CLOSE
		CLOSE DSHV_GV_CURSOR
		DEALLOCATE DSHV_GV_CURSOR
	SET NOCOUNT OFF;
END

EXEC P_TK @p_magv = 'GV15'
GO