package ArrayLists_CoQuynh;

import java.io.IOException;
import java.util.ArrayList;

public class Award {
	private ArrayList<Customer> list = new ArrayList<>();

	public void loadFile(String name) throws IOException {
		list = FileUtils.loadFile(name);
	}

	public String toString() {
		String result = "fullname\t|\tscore\t|\tsuperMarketID" + "\n";
		for (Customer c : this.list) {
			result += c + "\n";
		}
		return result;
	}

	public Customer getScoreMax() {
		int score = list.get(0).getScore();
		int index = 0;
		for (int i = 1; i < list.size(); i++) {
			if (score < list.get(i).getScore()) {
				score = list.get(i).getScore();
				index = i;
			}
		}
		return list.get(index);
	}

	public String customerRandom(int n) {
		int[] check = new int[list.size()];
		for (int i = 0; i < check.length; i++) {
			check[i] = 1;
		}
		String result = "";
		int count = 0;
		while (count < n) {
			int ran = (int) (Math.random() * list.size());
			if (check[ran] != 0) {
				result += list.get(ran) + "\n";
				count++;
				check[ran] = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		Award award = new Award();
		award.loadFile("C:\\Users\\Admin\\Desktop\\CTDL_T.Dũ\\Lab 7_List\\sweepstakes.txt");
		System.out.println(award.toString());
		System.out.println("=================");
		System.out.println(award.getScoreMax());
		System.out.println("=================");

		System.out.println(award.customerRandom(2));
	}
}
