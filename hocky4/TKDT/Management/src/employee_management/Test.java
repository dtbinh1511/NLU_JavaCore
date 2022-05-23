package employee_management;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
	public static void main(String[] args) {
		Company company = new Company("FIT Globle");

		Staff o1 = new OriginStaff("o1", "A", "Nam", new Date(12, 12, 2001), 1000, 12, 1.2, 300);
		Staff o2 = new OriginStaff("o2", "C", "Nam", new Date(12, 12, 2001), 2000, 22, 1.2, 300);
		Staff o3 = new OriginStaff("o3", "D", "Nam", new Date(12, 12, 2001), 3000, 32, 1.2, 300);
		Staff o4 = new OriginStaff("o4", "E", "Nu", new Date(12, 12, 2001), 4000, 42, 1.2, 300);

		Staff c1 = new ContractStaff("c1", "F", "Nam", new Date(21, 12, 2000), 700, 13);
		Staff c2 = new ContractStaff("c2", "G", "Nam", new Date(21, 12, 2000), 700, 13);
		Staff c3 = new ContractStaff("c3", "H", "Nam", new Date(21, 12, 2000), 700, 13);
		Staff c4 = new ContractStaff("c4", "J", "Nam", new Date(21, 12, 2000), 700, 13);

		Department d1 = new Department("d1", "Software");
		Department d2 = new Department("d2", "AI");
		Department d3 = new Department("d3", "Big Data");
		Department d4 = new Department("d4", "Design");

		d1.addStaff(o4);
		d1.addStaff(c4);
		d2.addStaff(o3);
		d2.addStaff(c2);
		d3.addStaff(o2);
		d3.addStaff(c3);
		d4.addStaff(c1);
		d4.addStaff(o1);

		company.add(d1, c4);
		company.add(d1, o4);
		company.add(d2, c2);
		company.add(d2, o3);
		company.add(d3, c3);
		company.add(d3, o2);
		company.add(d4, c1);
		company.add(d4, o1);
		
		System.out.println(company.showSalary());
	}
}
