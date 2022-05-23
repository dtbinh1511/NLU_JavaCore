package Sweepstakes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Award {
	private ArrayList<Customer> list = new ArrayList<Customer>();

	private void loadFile(String fileName) throws IOException {
		list = FileUtils.loadFile(fileName);
	}

// in danh sách khách hàng tham gia rút thăm trúng thưởng
	public String toString() {
		String result = "fullname\t|\tscore\t|\tsuperMarketID" + "\n";
		for (Customer c : this.list) {
			result += c + "\n";
			
		}
		return result;
	}

// tìm khách hàng trúng thưởng có điểm cao nhất
	public Customer findScoreMax() {
		int scoreMax = list.get(0).getScore();
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getScore() > scoreMax) {
				scoreMax = list.get(i).getScore();
				index = i;
			}
		}
		return list.get(index);
	}

// tìm N khách hàng ngẫu nhiên trúng giải
	public String randomLucky(int n) {
		int[] check = new int[list.size()];
		for (int j = 0; j < check.length; j++) {
			check[j] = 1;
		}
		int i = 0;
		String result = "";
		while (i < n) {
			int ran = (int) (Math.random() * list.size());
			if (check[ran] != 0) {
				result += list.get(ran) + "\n";
				check[ran] = 0;
				i++;
			}
		}
		return result;
	}

// in ra danh sách khách hàng tham gia rút thăm trúng thưởng ngẫu nhiên
	public ArrayList<Customer> listLucky() {
		int[] check = new int[list.size()];
		for (int j = 0; j < check.length; j++) {
			check[j] = 1;
		}
		int i = 0;
		ArrayList<Customer> newList = new ArrayList<>();
		while (i < list.size()) {
			int ran = (int) (Math.random() * list.size());
			if (check[ran] != 0) {
				newList.add(list.get(ran));
				check[ran] = 0;
				i++;
			}
		}
		return newList;
	}

// in ra danh sách trúng thưởng đặc biệt
	public String listSpecial(int prizeSpecial, int prizeFirst) {
		if (prizeFirst + prizeSpecial > list.size())
			return null;
		int[] check = new int[list.size()];
		for (int j = 0; j < check.length; j++) {
			check[j] = 1;
		}
		int i = 0;
		StringBuilder result = new StringBuilder();
		result.append("Danh sách giải đặc biệt\n");
		while (i < prizeSpecial) {
			int ran = (int) (Math.random() * list.size());
			if (check[ran] != 0) {
				result.append(list.get(ran) + "\n");
				check[ran] = 0;
				i++;
			}
		}
		i = 0;
		result.append("\nDanh sách trung giải nhất\n");
		while (i < prizeFirst) {
			int ran = (int) (Math.random() * list.size());
			if (check[ran] != 0) {
				result.append(list.get(ran) + "\n");
				check[ran] = 0;
				i++;
			}
		}
		return result.toString();
	}

	public static void main(String[] args) throws IOException {
		Award award = new Award();
		award.loadFile("C:\\Users\\Admin\\Desktop\\CTDL_T.Dũ\\Lab 7_List\\sweepstakes.txt");
//		System.out.println("DANH SÁCH KHÁCH HÀNG \n" + award.toString());
//		System.out.println("=======================");
//		System.out.println("Khách hàng trúng thưởng có điểm cao nhất:\n " + award.findScoreMax());
//		System.out.println("Khách hàng ngẫu nhiên trúng thưởng:\n " + award.randomLucky(2));
//		System.out.println("Khách hàng trúng thưởng giải :\n " + award.listSpecial(1, 2));

	}
}
