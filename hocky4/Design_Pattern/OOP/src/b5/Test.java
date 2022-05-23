package b5;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		KhachSan hotel = new KhachSan();
		while (true) {
			System.out.println("Application Manager Candidate");
			System.out.println("Enter 1: To insert person for rent");
			System.out.println("Enter 2: To remove person by passport");
			System.out.println("Enter 3: To calculator price by passport");
			System.out.println("Enter 4: To show infor");
			System.out.println("Enter 5: To exit:");
			String line = scanner.nextLine();
			switch (line) {
			case "1": {
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter age: ");
				int age = scanner.nextInt();
				System.out.print("Enter passport: ");
				scanner.nextLine();
				int passport = scanner.nextInt();
				System.out.println("Choise a to rent room type A");
				System.out.println("Choise b to rent room type B");
				System.out.println("Choise c to rent room type C");
				String choise = scanner.nextLine();
				Phong room;
				if (choise.equals("a")) {
					room = new PhongA();
				} else if (choise.equals("b")) {
					room = new PhongB();
				} else if (choise.equals("c")) {
					room = new PhongC();
				} else {
					continue;
				}
				System.out.print("Enter number day for rent: ");
				int numberRent = scanner.nextInt();
				Nguoi person = new Nguoi(name, age, passport, numberRent, room);
				hotel.add(person);
				scanner.nextLine();
				break;
			}
			case "2": {
				System.out.print("Enter passport: ");
				int passport = scanner.nextInt();
				hotel.delete(passport);
				break;
			}
			case "3": {
				System.out.print("Enter passport: ");
				int passport = scanner.nextInt();
				System.out.println("Price: " + hotel.thanhTien(passport));
				break;
			}
			case "4": {
				hotel.show();
				break;
			}
			case "5": {
				return;
			}
			default:
				System.out.println("Invalid");
				continue;
			}
		}

	}

}
