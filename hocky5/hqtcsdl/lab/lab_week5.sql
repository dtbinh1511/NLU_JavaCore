use week5;
-- I, phần procedure
--3.Với tham số vào là dept_id, thủ tục sẽ 
--thay manager_id của phòng ban đó
-- bằng mã số của nhân viên có mức lương cao nhất phòng. 
go
 create proc proc_update_manager
@dept_id int
as
begin
		update employees
		set manager_id = (select employee_id from employees where salary = (select max(salary) from employees))
		where department_id = @dept_id

end
exec proc_update_manager @dept_id = 9 

go
--4.Cập nhật lương của nhân viên với điều kiện 
--nhân viên nào làm việc trên 2 năm thì tăng lương thêm $200, 
--nhân viên làm việc trên 1 năm và dưới 2 năm thì tăng lương thêm $100,
--nhân viên nào làm việc đúng 1 năm thì tăng $50, còn lại không tăng.

create proc proc_update_salary
as
declare @year int
begin
	
	select @year=(DATEDIFF(YEAR, YEAR(hire_date), year(getdate())))
	from employees;
	
	update employees
	set salary = salary + ( case when @year > 2 then 200
								when @year < 2 and @year > 1 then 100
								when @year = 1 then 50
									else 0 end)
end
go
--1.	In danh sách phòng ban có lương bình quân lớn hơn n. Với n là tham số của thủ tục
create proc proc_luongtb
@n int
as
begin
	select department_id
	from employees
	group by department_id
	having AVG(salary) > @n
end

go

--2.	In danh sách người quản lý (manager) có số nhân viên >n. Với n là tham số của thủ tục 
create proc proc_manager
@n int
as
begin
	select manager_id
	from employees
	group by manager_id
	having count(employee_id) > @n
end

go

--5.	Với tham số vào là title, thủ tục cho biết tên nhân viên đảm nhận vị trí đó đầu tiên



--function
--cau3
go
create function f_nhanvien (@manager_id int)
returns table as
return (select employee_id,first_name, last_name
from employees
where employees.manager_id=@manager_id)
select * from f_nhanvien('100')

go

--cau4

create function f_nhanthan (@employee_id int)
returns table as
return (select dependent_id, first_name, last_name, relationship
from dependents
where dependents.employee_id=@employee_id)
select * from f_nhanthan('100')
go

--1 của ý
create function f_tenql(@dept_id int)
returns varchar(10)
as
begin
return (select last_name from employees	where department_id = @dept_id)
end


go
--2 của ý
create function f_dscv(@employee_id int)
returns table
as
	return (select employee_id,Job_history.job_id,job_title,start_date,end_date 
			from Job_history
			inner join jobs on Job_history.job_id = jobs.job_id
			
			)
