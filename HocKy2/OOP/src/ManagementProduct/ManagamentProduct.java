package ManagementProduct;

import java.util.Scanner;

public class ManagamentProduct {
	static void Menu() {
		System.out.println("=============================");
		System.out.println("HỆ THỐNG QUẢN LÝ SẢN PHẨM");
		System.out.println("1. Thêm sản phẩm");
		System.out.println("2. Xem sản phẩm");
		System.out.println("3. Tìm sản phẩm");
		System.out.println("4. Xóa sản phẩm");
		System.out.println("5. Thoát");
		System.out.println("=============================");

	}

	public static void main(String[] args) {
		int choice;
		Shop shop = new Shop();
		Scanner input = new Scanner(System.in);
		while (true) {
			Menu();
			System.out.println("Chọn để thực hiện thao tác");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				shop.addProduct(new Product());
				break;
			case 2:
				shop.showProduct();
				break;
			case 3:
				shop.searchProduct();
				break;
			case 4:
				shop.delProduct();
				break;
			case 5:
				return;
			default:
				System.out.println("Enter error");
			}
		}
	}
}
