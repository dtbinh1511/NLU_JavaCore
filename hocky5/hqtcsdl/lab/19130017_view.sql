CREATE DATABASE sample

GO
USE sample

CREATE TABLE employee  (emp_no INTEGER NOT NULL, 
                        emp_fname CHAR(20) NOT NULL,
                        emp_lname CHAR(20) NOT NULL,
                        dept_no CHAR(4) NULL)
						
CREATE TABLE department(dept_no CHAR(4) NOT NULL,
                        dept_name CHAR(25) NOT NULL,
                        location CHAR(30) NULL)
CREATE TABLE project   (project_no CHAR(4) NOT NULL,
                        project_name CHAR(15) NOT NULL,
                        budget FLOAT NULL)
CREATE TABLE works_on	(emp_no INTEGER NOT NULL,
                        project_no CHAR(4) NOT NULL,
                        job CHAR (15) NULL,
                        enter_date DATEtime NULL)
insert into employee values(25348, 'Matthew', 'Smith','d3')
insert into employee values(10102, 'Ann', 'Jones','d3')
insert into employee values(18316, 'John', 'Barrimore', 'd1')
insert into employee values(29346, 'James', 'James', 'd2')
insert into employee values(9031, 'Elsa', 'Bertoni', 'd2')
insert into employee values(2581, 'Elke', 'Hansel', 'd2')
insert into employee values(28559, 'Sybill', 'Moser', 'd1')
insert into department values ('d1', 'research','Dallas')
insert into department values ('d2', 'accounting', 'Seattle')
insert into department values ('d3', 'marketing', 'Dallas')
insert into project values ('p1', 'Apollo', 120000.00)
insert into project values ('p2', 'Gemini', 95000.00)
insert into project values ('p3', 'Mercury', 186500.00)
insert into works_on values (10102,'p1', 'analyst', '2006.10.1')
insert into works_on values (10102, 'p3', 'manager', '2008.1.1')
insert into works_on values (25348, 'p2', 'clerk', '2007.2.15')
insert into works_on values (18316, 'p2', NULL, '2007.6.1')
insert into works_on values (29346, 'p2', NULL, '2006.12.15')
insert into works_on values (2581, 'p3', 'analyst', '2007.10.15')
insert into works_on values (9031, 'p1', 'manager', '2007.4.15')
insert into works_on values (28559, 'p1', NULL, '2007.8.1')
insert into works_on values (28559, 'p2', 'clerk', '2008.2.1')
insert into works_on values (9031, 'p3', 'clerk', '2006.11.15')  
insert into works_on values (29346, 'p1','clerk', '2007.1.4')

SELECT  emp_no, emp_fname, emp_lname, dept_no 
   INTO employee_enh 
   FROM employee; 
ALTER TABLE employee_enh 
          ADD domicile CHAR(25) NULL;


           UPDATE employee_enh SET domicile = 'San Antonio' 
              WHERE emp_no = 25348; 
UPDATE employee_enh SET domicile = 'Houston' 
               WHERE emp_no = 10102; 
UPDATE employee_enh SET domicile = 'San Antonio' 
              WHERE emp_no = 18316; 
UPDATE employee_enh SET domicile = 'Seattle' 
              WHERE emp_no = 29346; 
           UPDATE employee_enh SET domicile = 'Portland' 
              WHERE emp_no = 9031; 
           UPDATE employee_enh SET domicile = 'Tacoma' 
              WHERE emp_no = 2581; 
           UPDATE employee_enh SET domicile = 'Houston' 
               WHERE emp_no = 28559;


--1) Tạo view chứa thông tin của tất cả nhân viên làm việc cho phòng d1
GO 
CREATE VIEW emp_view
AS SELECT *
FROM employee 
WHERE dept_no = 'd1'


--2) Tạo view gồm tất cả thông tin của bảng project, ngoại trừ cột budget
GO
CREATE VIEW project_view
AS SELECT project_no, project_name
FROM project

--3) Tạo view bao gồm họ và tên của tất cả nhân viên đã gia nhập dự án vào nửa cuối năm 2007
GO 
CREATE VIEW work_view
AS SELECT emp.emp_fname , emp.emp_lname
FROM employee emp
JOIN works_on w on emp.emp_no = w.emp_no
WHERE MONTH(w.enter_date) > 6 and YEAR(w.enter_date) = 2007


--4) Giải lại câu 3, đặt lại tên cho cột emp_fname, emp_lname là first và last
GO 
CREATE VIEW work_view_rename (first,last)
AS SELECT emp.emp_fname as first , emp.emp_lname as last
FROM employee emp
JOIN works_on w on emp.emp_no = w.emp_no
WHERE MONTH(w.enter_date) > 6 and YEAR(w.enter_date) = 2007

--5) Sử dụng view trong câu 1, hiển thị đầy đủ thông tin của nhân viên có tên bắt đầu với chữ M.
GO
SELECT * FROM emp_view
WHERE emp_lname like 'M%';


--6) Tạo view bao gồm thông tin của tất cả các dự án mà nhân viên có tên Smith làm việc.
GO
CREATE VIEW work_emp_view
AS SELECT p.project_no, p.project_name,p.budget
FROM project p
JOIN works_on w on p.project_no = w.project_no
JOIN employee e on e.emp_no = w.emp_no
WHERE e.emp_lname = 'Smith'

--7) Sử dụng câu lệnh ALTER VIEW, chỉnh sửa điều kiện trong view bài 1 bao gồm dữ liệu
--của tất cả các nhân viên làm việc cho phòng d1 hoặc d2.
GO
ALTER VIEW emp_view
AS SELECT *
FROM employee
WHERE dept_no in ('d1','d2')

--8) Xóa view được tạo ra trong câu 3. Điều gì xảy ra với view được tạo ra trong câu 4?
GO
DROP VIEW work_view -- VIEW Ở CÂU 4 KHÔNG BỊ MẤT DỮ LIỆU DO 2 BẢNG VIEW KHÁC NHAU

--9) Sử dụng view câu 2, chèn thêm chi tiết của dự án mới với mã dự án p2 và tên Moon 
GO 
SELECT * FROM project_view
INSERT INTO project_view
VALUES ('p2', 'Moon')

--10) Tạo view (với mệnh đề WITH CHECK OPTION) bao gồm họ và tên của tất cả
--nhân viên có số nhân viên dưới 10.000. Sau đó, sử dụng view để chèn dữ liệu
--cho một nhân viên mới có tên Kohn với số nhân viên 22123, làm việc cho
--phòng d3.
GO
CREATE VIEW v_check_emp
AS SELECT emp_fname, emp_lname
FROM employee 
WHERE emp_no < 10000
WITH CHECK OPTION

--1, không chèn được do chỉ lấy ra có họ và tên,
--2, nếu dùng select * cũng sẽ không chèn được do fname không được null
--3, nếu fname không null cũng sẽ không chèn được do thỏa điều kiện của with check option emp_no < 10000
GO
INSERT INTO v_check_emp
VALUES(22123, null,'Kohn', 'd3')

--11) Giải quyết câu 10 mà không có mệnh đề WITH CHECK OPTION và tìm sự
--khác biệt liên quan đến việc chèn dữ liệu
GO
CREATE VIEW v_no_check_emp
AS SELECT emp_fname, emp_lname
FROM employee 
WHERE emp_no < 10000

--1, không chèn được do chỉ lấy ra có họ và tên,
--2, nếu dùng select * cũng sẽ không chèn được do fname không được null
--3, nếu fname không null sẽ chèn
GO
INSERT INTO v_no_check_emp
values(22123, null, 'Kohn','d3')

--12) Tạo view (với mệnh đề WITH CHECK OPTION) với đầy đủ thông tin từ bảng
--works_on cho tất cả nhân viên tham gia dự án của họ trong những năm 2007
--và 2008. Sau đó, sửa đổi ngày gia nhập của nhân viên có mã số 29346 thành
--ngày mới là 06/01/2006.
GO
CREATE VIEW  v_check_work
AS SELECT *
FROM works_on
WHERE YEAR(enter_date) IN (2007,2008)
WITH CHECK OPTION

--không chèn được do with check option bắt buộc sử phải thỏa điều kiện year = 2007 or year = 2008
UPDATE v_check_work
SET enter_date = '01/06/2006'
WHERE emp_no = 29346

--13) Giải quyết câu 12 mà không có mệnh đề WITH CHECK OPTION và tìm ra sự
--khác biệt liên quan đến việc sửa đổi dữ liệu.
GO
CREATE VIEW  v_no_check_work
AS SELECT *
FROM works_on
WHERE YEAR(enter_date) IN (2007,2008)

--chèn được do không có with check option
UPDATE v_no_check_work
SET enter_date = '01/06/2006'
WHERE emp_no = 29346