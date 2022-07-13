use sample
go

CREATE OR ALTER TRIGGER trigger_project_delete
ON project
for DELETE
AS
	IF EXISTS (SELECT W.emp_no
				FROM works_on W JOIN deleted D
				ON W.project_no = D.project_no)
	begin
		RAISERROR ('KHONG THE XOA PROJECT NAY!',10,1)
		ROLLBACK
	end

	delete from project where project.project_no = 'd1'

	--
	alter table employee
	add  emp_total int

	CREATE OR ALTER TRIGGER employee_insert
	ON department
	AFTER INSERT
	AS
		UPDATE employee
		SET emp_total += 1
		where dept_no = (select dept_no from inserted)
