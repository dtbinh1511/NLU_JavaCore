package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
	private Map<String, String> vocabulary;

	public Dictionary(String fileName) throws IOException {
		vocabulary = LoadData.readFile(fileName);
	}

	// tìm kiếm từ
	public String searchVocabulary(String vocabulary) {
		StringBuilder stringBuilder = new StringBuilder();
		Set<String> set = this.vocabulary.keySet();// vi map khong the duyet tung phan tu 
													// nen phai chuyen tu map sang set
		for (String string : set) {
			if (string.indexOf(vocabulary) != -1) 
				stringBuilder.append(" *" + string + ":\n   -" + this.vocabulary.get(string) + "\n");
		}
		
		return (stringBuilder.length() == 0) ? "Không tìm thấy!!!" : stringBuilder.toString();
	}

	//tao runnable de chay chuong trinh
	public static Runnable run() {
		Runnable runnable = new Runnable() {
			

			@Override
			public void run() {
				try {
					Dictionary dictionary = new Dictionary("data/data.txt");
					Scanner input = new Scanner(System.in);
					
					System.out.print("Nhập từ bạn muốn tìm: ");
					String vocabulary = input.nextLine();
					System.out.println("\nloading...");
					Thread.sleep(2000);//delay cau lenh tiep theo 2s
					System.out.println("\n" + dictionary.searchVocabulary(vocabulary));
					
					while (true) {
						System.out.println("Gõ <next> để tiếp tục, Gõ <exit> để thoát chương trình!!!");
						String option = input.nextLine();
						if (option.equals("next")) {
							System.out.print("\nNhập từ bạn muốn tìm: ");
							vocabulary = input.nextLine();
							System.out.println("\nloading...");
							Thread.sleep(2000);
							System.out.println("\n" + dictionary.searchVocabulary(vocabulary));
						}
						if (option.equals("exit")) {
							System.out.println("\nChương trình đã kết thúc!!!");
							System.exit(0);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		};

		return runnable;
	}

	public static void main(String[] args) {
		Thread thread = new Thread(run());
		thread.start();
	}

}
