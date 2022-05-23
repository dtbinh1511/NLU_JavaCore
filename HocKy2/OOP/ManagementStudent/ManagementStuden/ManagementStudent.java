package ManagementStuden;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagementStudent {
	private ArrayList<Student> listStu = new ArrayList<Student>();
	Scanner input = new Scanner(System.in);

	public ManagementStudent() {

	}

	public void addStu() {
		Student std = new Student();
		std.addStudent();
		listStu.add(std);
	}

	public void addSub() {
		Student std = new Student();
		System.out.println("Nhập mã số sinh viên muốn thêm môn học");
		String numID = input.nextLine();
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIdStu().equals(numID)) {
				listStu.get(i).addSubInStu();
			}
		}
	}

	public void showList() {
		for (int i = 0; i < listStu.size(); i++) {
			listStu.get(i).output();
		}
	}

	public void sortName() {

		System.out.println("1. Sắp xếp tăng dần");
		System.out.println("2. Sắp xếp giảm dần");
		int choose = input.nextInt();
		if (choose == 1) {
			Collections.sort(listStu, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					int check = o1.getNameStu().compareToIgnoreCase(o2.getNameStu());
					if (check > 0) {
						return 1;
					}
					return -1;
				}
			});
			showList();
		} else if (choose == 2) {
			Collections.sort(listStu, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					int check = o1.getNameStu().compareToIgnoreCase(o2.getNameStu());
					if (check > 0) {
						return -1;
					}
					return 1;
				}
			});
			showList();
		}
	}

	public void sortID() {
		System.out.println("1. Sắp xếp tăng dần");
		System.out.println("2. Sắp xếp giảm dần");
		int choose = input.nextInt();
		if (choose == 1) {
			Collections.sort(listStu, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					int check = o1.getIdStu().compareTo(o2.getIdStu());
					if (check > 0) {
						return -1;
					}
					return 1;
				}
			});
			showList();
		} else if (choose == 2)

		{
			Collections.sort(listStu, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					int check = o1.getIdStu().compareTo(o2.getIdStu());
					if (check > 0) {
						return -1;
					}
					return 1;
				}

			});
			showList();
		}
	}

	public void showAvg() {
		System.out.println("Nhập mã số sinh viên cần xem điểm trung bình");
		String numID = input.nextLine();
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIdStu().equals(numID)) {
				System.out.println("Điểm trung bình là: " + listStu.get(i).avgMark());
			}
		}
	}

	public void searchStu() {
		System.out.println("Nhập mã số sinh viên cần tìm");
		String numID = input.nextLine();
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIdStu().equals(numID)) {
				listStu.get(i).output();
			}
		}
	}

	public void removeStu() {
		System.out.println("1. Xóa một sinh viên");
		System.out.println("2. Toàn bộ sinh viên");
		int choose = input.nextInt();
		if (choose == 1) {
			System.out.println("Nhập mã số sinh viên cần xóa");
			String numID = input.nextLine();
			for (int i = 0; i < listStu.size(); i++) {
				if (listStu.get(i).getIdStu().equals(numID)) {
					listStu.remove(i);
				}
			}
		} else if (choose == 2) {
			listStu.removeAll(listStu);
		}
	}

	public void chMark() {
		System.out.println("Nhập mã số sinh viên cần thay đổi điểm");
		String numID = input.nextLine();
		for (int i = 0; i < listStu.size(); i++) {
			if (listStu.get(i).getIdStu().equals(numID)) {
				listStu.get(i).chMark();
			}
		}
	}

	public void showClassification() {
		System.out.println("1. Xem toàn bộ danh sách");
		System.out.println("2. Xem xếp loại học lực bằng mã số sinh viên");
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			for (int i = 0; i < listStu.size(); i++) {
				System.out.print(listStu.get(i).getNameStu() + " học lực: ");
				listStu.get(i).showClassification();
			}
			break;
		case 2:
			System.out.println("Nhập mã số sinh viên");
			String numID = input.next();
			for (int i = 0; i < listStu.size(); i++) {
				if (listStu.get(i).getIdStu().equals(numID)) {
					System.out.print(listStu.get(i).getNameStu() + " học lực: ");
					listStu.get(i).showClassification();
				}
			}
			break;
		default:
			System.err.println("Nhập lại");
			break;
		}

	}
}
