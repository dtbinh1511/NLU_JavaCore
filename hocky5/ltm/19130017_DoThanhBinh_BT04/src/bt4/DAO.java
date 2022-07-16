package bt4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private final String PATH_DATABASE = "db\\Product.txt";
	private final String CHARSET = "UTF-8";
	private final String DELIMITED = "\t";

	public List<Product> loadData() throws MyException {
		List<Product> list = new ArrayList<Product>();
		File file = new File(PATH_DATABASE);
		try {
			if (file.exists()) {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(file), CHARSET);
				BufferedReader br = new BufferedReader(isr);
				String line = "";
				while ((line = br.readLine()) != null) {
					Product product = new Product();
					product.read(line, DELIMITED);
					list.add(product);
				}
				br.close();
			}
		} catch (IOException e) {
			throw new MyException("load data error");
		}
		return list;
	}

	public void updateData(List<Product> list) throws MyException {
		PrintWriter pr;
		try {
			pr = new PrintWriter(PATH_DATABASE, CHARSET);
			for (Product product : list) {
				pr.print(product.save(DELIMITED));
			}
			pr.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			throw new MyException("update data error");
		}

	}

	public boolean saveProduct(Product p) throws MyException {
		boolean result = false;
		List<Product> list = loadData();
		if (list.isEmpty()) {
			list.add(p);
			result = true;
		} else {
			for (Product product : list) {
				if (!product.getId().equals(p.getId())) {
					list.add(p);
					result = true;
					break;
				}
			}
		}
		updateData(list);
		return result;
	}

	public boolean deleteById(String id) throws MyException {
		boolean result = false;
		List<Product> list = loadData();
		for (Product product : list) {
			if (product.getId().equalsIgnoreCase(id)) {
				list.remove(product);
				result = true;
				break;
			}
		}

		updateData(list);

		return result;
	}

	public Product findById(String id) throws MyException {
		try {
			List<Product> list = loadData();
			for (Product product : list) {
				if (product.getId().equalsIgnoreCase(id)) {
					return product;
				}
			}
		} catch (MyException e) {
			throw new MyException("");
		}

		return null;
	}

	public boolean editPrice(String id, double newPrice) throws MyException {
		boolean result = false;
		List<Product> list = loadData();
		for (Product product : list) {
			if (product.getId().equalsIgnoreCase(id)) {
				product.setPrice(newPrice);
				result = true;
				break;
			}
		}

		updateData(list);
		return result;
	}

}
