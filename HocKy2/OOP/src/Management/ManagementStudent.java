package Management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ManagementStudent {
	ArrayList<Student> listStu = new ArrayList<Student>();

// add student vào danh sách
	public void addStu(Student std) {
		listStu.add(std);
	}

// print list
	public void print() {
		for (Student student : listStu) {
			System.out.println(student);
		}
	}

//thêm danh sách môn học cho student
	public void addListSub(String numID, ArrayList<Subject> listSub) {
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIDStu().equals(numID)) {
				listStu.get(i).setListSub(listSub);
			}
		}
	}

// xem điểm trung bình của student
	public void avgGrade(String numID) {
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIDStu().equals(numID)) {
				System.out.println(
						"Điểm trung bình của " + listStu.get(i).getNameStu() + " là: " + listStu.get(i).avgGrade());
			}
		}
	}

// xem điểm trung bình của student 2
	public void avgGrade2(String numID) {
		double avg = 0;
		for (Student student : listStu) {
			if (student.getIDStu().equals(numID)) {
				for (Subject subject : student.getListSub()) {
					avg += subject.getGrade();
				}
				avg = avg / listStu.size();
			}
		}
		System.out.println("Điểm trung bình là: " + avg);
	}

// tìm kiếm student theo họ tên + ID
	public void search(String numID, String name) {
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIDStu().equals(numID) && listStu.get(i).getNameStu().equals(name)) {
				System.out.println(listStu.get(i));
			}
		}
	}

// tìm kiếm theo tên
	public void searchName(String name) {
		String[] strSplit;
		for (int i = 0; i < listStu.size(); i++) {
			strSplit = listStu.get(i).getNameStu().split(" ");
			if (strSplit[strSplit.length - 1].equals(name)) {
				System.out.println(listStu.get(i));
			} else {
				System.out.println("Tên không tồn tại");
				break;
			}
		}
	}

	// sắp xếp danh sách theo tên
	public void sortName() {
		Collections.sort(listStu, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getNameStu().compareToIgnoreCase(o2.getNameStu()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
	}

	// sắp xếp theo ID
	public void sortID() {
		Collections.sort(listStu, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getIDStu().compareToIgnoreCase(o2.getIDStu()) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
	}

// sắp xếp theo điểm trung bình
	public void sortAvgMark() {
		Collections.sort(listStu, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.avgGrade() > o2.avgGrade()) {
					return -1;
				} else {
					return 1;
				}
			}
		});

	}

// sửa điểm cho sinh viên
	public void chGrade(String IDStu, String IDSub, double grade) {
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIDStu().equals(IDStu)) {
				listStu.get(i).changeGrade(grade, IDSub);
			}
		}
	}

// sửa điểm cho sinh viên 2
	public void chGrade2(String IDStu, String IDSub, double grade) {
		for (Student student : listStu) {
			if (student.getIDStu().equals(IDSub)) {
				for (Subject subject : student.getListSub()) {
					if (subject.getIDSub().equals(IDSub)) {
						subject.setGrade(grade);
					}
				}

			}
		}

	}

// tín chỉ. điểm trung bình tính sao !!!!!!!!!!!!!!!!!!!!!!!!!!!
	public static void main(String[] args) {
		ManagementStudent ms = new ManagementStudent();
//		ArrayList<Student> listStu = new ArrayList<Student>();
		Student st1 = new Student("Trần Hoàng B", "19130001", new Date(5, 1, 2001), null);
		Student st2 = new Student("Nguyễn Văn B", "19130002", new Date(3, 5, 2000), null);
		// add student
		ms.addStu(st1);
		ms.addStu(st2);

		// khởi tạo list subject
		ArrayList<Subject> lsub1 = new ArrayList<Subject>();
		Subject sub1 = new Subject("LTNC", "L01", 5);
		Subject sub2 = new Subject("Toán", "T01", 6);
		lsub1.add(sub1);
		lsub1.add(sub2);
		// thêm vào student danh sách môn học
		ms.addListSub("19130001", lsub1);

		// khởi tạo list subject khác
		ArrayList<Subject> lsub2 = new ArrayList<Subject>();
		Subject sub3 = new Subject("Marketing căn bản", "M002", 7);
		Subject sub4 = new Subject("Toán", "T01", 8);
		lsub2.add(sub3);
		lsub2.add(sub4);
		// thêm vào studetn danh sách môn học
		ms.addListSub("19130002", lsub2);
		ms.print();
		// điểm trung bình
		System.out.println("==================================");
		ms.avgGrade("19130001");
		ms.avgGrade2("19130002");
		System.out.println("==================================");
		// tìm student
		ms.search("19130002", "Nguyễn Văn B");
		System.out.println("==================================");
		// sort theo tên
		ms.sortName();
		ms.print();
		System.out.println("==================================");
		// sort theo ID
		ms.sortID();
		ms.print();
		System.out.println("==================================");
		System.out.println("After change grade");
		// thay đổi điểm
		ms.chGrade("19130001", "L01", 8.3);
//		ms.chGrade2("19130002", "M002", 10);  ko chạy dc 
		ms.print();
		// tìm theo tên
		System.out.println("==================================");
		ms.searchName("A");
		// sắp xếp theo điểm trung bình
		System.out.println("==================================");
		ms.sortAvgMark();
		ms.print();
	}
}
