use QLGiaoVu;
go
--CAU1
drop procedure KQ_MH
GO

create procedure KQ_MH 
@mamonhoc varchar(10), 
@masinhvien char(5)
as
begin
	select HV.MAHV, HV.TEN, MH.MAMH, MH.TENMH, KQ.LANTHI, KQ.NGTHI, KQ.DIEM, KQ.KQUA
	from KETQUATHI KQ 
	JOIN HOCVIEN HV ON HV.MAHV = KQ.MAHV
	JOIN MONHOC MH ON MH.MAMH = KQ.MAMH
	WHERE HV.MAHV = @masinhvien and MH.MAMH = @mamonhoc
end
GO
execute KQ_MH  @masinhvien = 'K1101' , @mamonhoc = 'CSDL'

go


--CAU2
drop procedure GV_MH
go

create procedure GV_MH
@magiaovien char(4),
@namhoc smallint
as
begin
	select GV.MAGV, GV.HOTEN, MH.MAMH,MH.TENMH, MH.TCLT, MH.TCTH
	FROM GIAOVIEN GV
	JOIN GIANGDAY GD ON GD.MAGV = GV.MAGV
	JOIN MONHOC MH ON MH.MAMH = GD.MAMH
	WHERE GV.MAGV = @magiaovien AND GD.NAM = @namhoc
end

execute GV_MH @magiaovien = 'GV06', @namhoc = 2006;
GO

--CAU3
drop procedure MH_TRUOC
GO

CREATE PROCEDURE MH_TRUOC
@mamonhoc varchar(10)
as 
begin
	select MH.MAMH, MH.TENMH
	FROM DIEUKIEN DK
	JOIN MONHOC MH ON MH.MAMH = DK.MAMH_TRUOC
	WHERE DK.MAMH = 'CSDL'
end
execute MH_TRUOC @mamonhoc = 'CSDL'
GO

--cau4
DROP PROCEDURE TOP_N
GO
create procedure TOP_N
@n int
as
begin
	select top (@n) *
	FROM KETQUATHI 
	order by DIEM desc
end
execute TOP_N @n = 10;
GO

--cau5
DROP PROCEDURE THONGKE
GO

create procedure THONGKE
@makhoa varchar(4)
as
begin
	select	COUNT(MAGV)AS SL , avg(MUCLUONG) as BQ
	from GIAOVIEN 
	where MAKHOA = @makhoa 
end
execute THONGKE @makhoa = 'KHMT';
go