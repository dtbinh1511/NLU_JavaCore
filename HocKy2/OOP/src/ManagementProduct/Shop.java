package ManagementProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	ArrayList<Product> listProduct = new ArrayList<Product>();
	Scanner input = new Scanner(System.in);

	void addProduct(Product product) {
		System.out.println("Enter name product");
		product.setName(input.nextLine());
		System.out.println("Enter decription product");
		product.setDecription(input.nextLine());
		System.out.println("Enter cost product");
		product.setCost(input.nextDouble());
		listProduct.add(product);
	}

	void showProduct() {
		if (listProduct.size() == 0) {
			System.out.println("Shop hasn't product. ");
		} else {
			for (Product product : listProduct) {
				product.showProduct();
			}
		}
	}

	void searchProduct() {
		if (listProduct.size() == 0) {
			System.out.println("Shop hasn't product.");
		} else {
			System.out.println("Enter the low price");
			double cost1 = input.nextDouble();
			System.out.println("Enter the high price");
			double cost2 = input.nextDouble();
			boolean check = false;

			for (Product product : listProduct) {
				if (product.getCost() >= cost1 && product.getCost() <= cost2) {
					product.showProduct();
					check = true;
				}
			}
			if (check == false) {
				System.out.println("Product not found");
			}
		}
	}

	void delProduct() {
		System.out.println("Enter product want delete: ");
		String name = input.nextLine();
		boolean check = false;
		if (name.equals("")) {
			name = input.nextLine();
		}
		for (Product product : listProduct) {
			if (product.getName().equals(name)) {
				listProduct.remove(product);
				check = true;
				System.out.println("Product deleted");
				break;
			}
		}
		if (check == false) {
			System.out.println("Product not exist");
		}
	}
}
