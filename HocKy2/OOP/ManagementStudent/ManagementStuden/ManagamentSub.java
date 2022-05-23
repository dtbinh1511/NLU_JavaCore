package ManagementStuden;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagamentSub {
	public ArrayList<Subject> listSub = new ArrayList<Subject>();

	public ManagamentSub() {

	}

	public void addSub() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập vào số môn học cần thêm");
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			Subject subject = new Subject();
			subject.subList();
			listSub.add(subject);
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < listSub.size(); i++) {
			s += listSub.get(i).toString();

		}
		return s;
	}

	public double avgMark() {
		double sum = 0;
		double avg = 0;
		for (int i = 0; i < listSub.size(); i++) {
			sum += listSub.get(i).getGrade();
		}
		avg = sum / listSub.size();
		return avg;
	}

	public void chMark() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập môn cần thay đổi");
		String subject = input.nextLine();
		System.out.println("Nhập điểm cần thay đổi");
		double newMark = input.nextDouble();
		for (int i = 0; i < listSub.size(); i++) {
			if (listSub.get(i).getNameSub().equals(subject)) {
				listSub.get(i).setGrade(newMark);
			}
		}
	}

	public void showClassification() {
		if (avgMark() >= 8) {
			System.out.println("Giỏi");
		} else if (avgMark() >= 6.5) {
			System.out.println("Khá");
		} else if (avgMark() >= 5) {
			System.out.println("Trung bình");
		} else {
			System.out.println("Kém");
		}
	}
}
