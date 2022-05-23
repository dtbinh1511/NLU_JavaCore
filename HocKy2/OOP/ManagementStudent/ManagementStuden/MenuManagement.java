package ManagementStuden;

import java.util.Scanner;

public class MenuManagement {

	public static void main(String[] args) {
		ManagementStudent ms = new ManagementStudent();
		Scanner input = new Scanner(System.in);
		int choose;
		do {
			showMenu();
			choose = input.nextInt();
			switch (choose) {
			case 0:
				break;
			case 1:
				ms.addStu();
				break;
			case 2:
				ms.addSub();
				break;
			case 3:
				ms.showList();
				break;
			case 4:
				ms.sortName();
				break;
			case 5:
				ms.sortID();
				break;
			case 6:
				ms.showAvg();
				break;
			case 7:
				ms.searchStu();
				break;
			case 8:
				ms.removeStu();
				break;
			case 9:
				ms.chMark();
				break;
			case 10:
				ms.showClassification();
				break;
			default:
				System.err.println("Nhập lại");
				break;

			}
		} while (choose != 0);
	}

	public static void showMenu() {
		System.out.println("1. Thêm sinh viên");
		System.out.println("2. Thêm môn học theo mã sinh viên");
		System.out.println("3. Xuất tất cả thông tin trong danh sách");
		System.out.println("4. Sắp xếp theo tên sinh viên");
		System.out.println("5. Sắp xếp theo mã số sinh viên");
		System.out.println("6. Xem điểm trung bình theo mã số sinh viên");
		System.out.println("7. Tìm sinh viên theo mã số sinh viên");
		System.out.println("8. Xóa sinh viên theo mã số sinh viên");
		System.out.println("9. Thêm hoặc thay đổi điểm cho sinh viên");
		System.out.println("10. Xem xếp loại của sinh viên");
		System.out.println("0. Thoát");

	}
}
