package ManagementSculpture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManagementSculpture {
	ArrayList<Sculpture> listScu = new ArrayList<Sculpture>();

	public void print() {
		for (Sculpture sculpture : listScu) {
			System.out.println(sculpture);
		}
	}

	public void addScul(Sculpture sculpture) {
		listScu.add(sculpture);
	}

	public void sortSculpture() {
		Collections.sort(listScu, new Comparator<Sculpture>() {

			@Override
			public int compare(Sculpture o1, Sculpture o2) {
				if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
					return -1;
				} else {
					return 1;
				}
			}

		});
		print();
	}

	public static void main(String[] args) {
		ManagementSculpture manScu = new ManagementSculpture();
		Sculpture sp1 = new Sculpture("Phụ nữ ngồi thiền", "Paige Bradley", 1998, null, "Sắp", 1.3, 50);
		Sculpture sp2 = new Sculpture("Con người miền sông nước", "Fah Cheong", 1972, null, "Đồng", 10.5, 100);
		Sculpture sp3 = new Sculpture("Bức tượng De Voortkapoen", "Tom Frantzen", 1956, null, "Đồng", 2.5, 35);
		Sculpture sp4 = new Sculpture("Bức tượng sáp Expansion", "Paige Bradley", 0, null, "Sắp", 4.5, 67);
		Sculpture sp5 = new Sculpture("Bruno Catalano", "Botero", 0, null, "Đồng", 5.7, 78);

		manScu.addScul(sp1);
		manScu.addScul(sp2);
		manScu.addScul(sp5);
		manScu.addScul(sp3);
		manScu.addScul(sp4);
		manScu.print();
		System.out.println("=======================");
		manScu.sortSculpture();
	}

}
