package b2;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QuanLySach managerDocument = new QuanLySach();
		while (true) {
			System.out.println("Application Manager Document");
			System.out.println("Enter 1: To insert document");
			System.out.println("Enter 2: To search document by category: ");
			System.out.println("Enter 3: To show information documents");
			System.out.println("Enter 4: To remove document by id");
			System.out.println("Enter 5: To exit:");
			String line = scanner.nextLine();
			switch (line) {
			case "1": {
				System.out.println("Enter a: to insert Book");
				System.out.println("Enter b: to insert Newspaper");
				System.out.println("Enter c: to insert Journal");
				String type = scanner.nextLine();
				switch (type) {
				case "a": {
					System.out.print("Enter ID: ");
					String id = scanner.nextLine();
					System.out.print("Enter nxb:");
					String nxb = scanner.nextLine();
					System.out.print("Enter number: ");
					int number = scanner.nextInt();
					System.out.print("Enter author: ");
					scanner.nextLine();
					String author = scanner.nextLine();
					System.out.print("Enter page number: ");
					int pageNumber = scanner.nextInt();
					TaiLieu book = new Sach(id, nxb, number, author, pageNumber);
					managerDocument.add(book);
					System.out.println(book.toString());
					scanner.nextLine();
					break;

				}
				case "b": {
					System.out.print("Enter ID: ");
					String id = scanner.nextLine();
					System.out.print("Enter nxb:");
					String nxb = scanner.nextLine();
					System.out.print("Enter number: ");
					int number = scanner.nextInt();
					System.out.print("Enter Day issue: ");
					int dayIssue = scanner.nextInt();
					TaiLieu newspaper = new Bao(id, nxb, number, dayIssue);
					managerDocument.add(newspaper);
					System.out.println(newspaper.toString());
					scanner.nextLine();
					break;
				}
				case "c": {
					System.out.print("Enter ID: ");
					String id = scanner.nextLine();
					System.out.print("Enter nxb:");
					String nxb = scanner.nextLine();
					System.out.print("Enter number: ");
					int number = scanner.nextInt();
					System.out.print("Enter issue number : ");
					int issueNumber = scanner.nextInt();
					System.out.print("Enter issue month : ");
					int issueMonth = scanner.nextInt();
					TaiLieu journal = new TapChi(id, nxb, number, issueNumber, issueMonth);
					managerDocument.add(journal);
					System.out.println(journal.toString());
					scanner.nextLine();
					break;
				}
				default:
					break;
				}
				break;
			}
			case "2": {
				System.out.println("Enter a to search book");
				System.out.println("Enter b to search newspaper");
				System.out.println("Enter a to search journal");
				String choise = scanner.nextLine();
				switch (choise) {
				case "a": {
					managerDocument.searchByBook();
					break;
				}
				case "b": {
					managerDocument.searchByNewspaper();
					break;
				}
				case "c":
					managerDocument.searchByTapChi();
					break;
				default:
					System.out.println("Invalid");
					break;
				}
				break;
			}
			case "3": {
				System.out.println(managerDocument.print());
				break;
			}
			case "4": {
				System.out.print("Enter id to remove: ");
				String id = scanner.nextLine();
				System.out.println(managerDocument.delete(id) ? "Success" : "Fail");
			}
				break;
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
