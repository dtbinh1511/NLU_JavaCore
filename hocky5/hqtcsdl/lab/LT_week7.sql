use sample

SET NOCOUNT ON;
DECLARE @dept_no char(4),@dept_name char(25), @message char(80),@emp_fname char(20)
PRINT '-------- Department Report --------';
DECLARE dept_cursor CURSOR FOR SELECT dept_no, dept_name FROM Sample.dbo.department
OPEN dept_cursor
FETCH NEXT FROM dept_cursor INTO @dept_no, @dept_name
WHILE @@FETCH_STATUS = 0
BEGIN
PRINT ' '
SELECT @message = '----- Employee From Department: ' + @dept_name
PRINT @message
-- Declare an inner cursor based on dept_no from the outer cursor.
DECLARE emp_cursor CURSOR FOR
SELECT e.emp_fname
FROM Sample.dbo.employee e
WHERE dept_no=@dept_no -- Variable value from the outer cursor
OPEN emp_cursor
FETCH NEXT FROM emp_cursor INTO @emp_fname
IF @@FETCH_STATUS <> 0
PRINT ' <<None>>'
WHILE @@FETCH_STATUS = 0
BEGIN
SELECT @message = ' ' + @emp_fname
PRINT @message
FETCH NEXT FROM emp_cursor INTO @emp_fname
END
CLOSE emp_cursor
DEALLOCATE emp_cursor
-- Get the next department.
FETCH NEXT FROM dept_cursor INTO @dept_no, @dept_name
END
CLOSE dept_cursor;
DEALLOCATE dept_cursor;



---------------------
go
create proc update_cursor
as
SET NOCOUNT ON;
DECLARE
@EMP_ID AS INT,
@RANDOM_GEN_NO AS CHAR(25),
@TEMP AS CHAR(25)
DECLARE EMP_CURSOR CURSOR FOR
SELECT emp_no, domicile  FROM sample.dbo.employee FOR UPDATE OF domicile
OPEN EMP_CURSOR
FETCH NEXT FROM EMP_CURSOR
INTO @EMP_ID, @RANDOM_GEN_NO
WHILE (@@FETCH_STATUS = 0)
BEGIN
SELECT @TEMP = FLOOR(RAND()*1000000000)
UPDATE sample.dbo.employee SET domicile = @TEMP WHERE CURRENT OF
EMP_CURSOR
FETCH NEXT FROM EMP_CURSOR
INTO @EMP_ID, @RANDOM_GEN_NO
END
select * from sample.dbo.employee
CLOSE EMP_CURSOR
DEALLOCATE EMP_CURSOR
SET
NOCOUNT OFF

go

---------------
CREATE PROCEDURE SHOW_EMP(@PRO_ID CHAR(4)) WITH RECOMPILE
AS
SET NOCOUNT ON;
DECLARE @EM_ID INTEGER, @EM_FNAME CHAR(20), @EM_LNAME CHAR(20), @RESULT CHAR(80)
PRINT '-----LIST OF EMPLOYEE-------'
DECLARE EM_CURSOR CURSOR FOR SELECT EMP.emp_no, emp_fname, emp_lname  FROM BAITH2_VIEW.dbo.employee EMP JOIN works_on WO
												ON EMP.emp_no = WO.emp_no WHERE WO.project_no = @PRO_ID
OPEN EM_CURSOR
FETCH NEXT FROM EM_CURSOR INTO @EM_ID, @EM_FNAME, @EM_LNAME
WHILE (@@FETCH_STATUS = 0)
BEGIN
SELECT @RESULT = CONCAT(@EM_ID, '| ', @EM_FNAME, '|' ,@EM_LNAME)
PRINT @RESULT
FETCH NEXT FROM EM_CURSOR INTO @EM_ID, @EM_FNAME, @EM_LNAME
END 
CLOSE EM_CURSOR
DEALLOCATE EM_CURSOR
SET NOCOUNT OFF;
GO
EXECUTE SHOW_EMP @PRO_ID  = 'p1'
DROP PROCEDURE SHOW_EMP