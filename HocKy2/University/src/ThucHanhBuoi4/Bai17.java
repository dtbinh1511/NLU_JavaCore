package ThucHanhBuoi4;

public class Bai17 {

	public static void main(String[] args) {
		numberDiviveBy();
	}

	public static void numberDiviveBy() {
		int count = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		for (int i = 0; i <= 100; i++) {
			switch (i % 5) {
			case 0:
				count++;
				break;
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			case 4:
				count4++;
				break;
			default:
				System.out.println("Error");
			}
		}
		System.out.println("Total number Divive By 5:" + count);
		System.out.println("Total number Divive By 5 surplus 1: " + count1);
		System.out.println("Total number Divive By 5 surplus 2: " + count2);
		System.out.println("Total number Divive By 5 surplus 3: " + count3);
		System.out.println("Total number Divive By 5 surplus 4: " + count4);
	}
}
