package DeThi;

import java.util.ArrayList;

public class ListManagement {
	public static ArrayList<ArtObject> list;

	public ListManagement() {
		super();
		this.list = new ArrayList<ArtObject>();
	}

	public static ArrayList<ArtObject> createSculptureList() {
		ArtObject l1 = new Sculpture("Phụ nữ ngồi thiền", "Paige Bradley", 1998, "", "Sáp", 1.3, 50);
		ArtObject l2 = new Sculpture("Con người miền sông nước", "Fah Cheong", 1972, "", "Đồng", 10.5, 100);
		ArtObject l3 = new Sculpture("Bức tượng De Vaartkapoen", "Tom Frantzen", 1956, "", "Đồng", 2.5, 35);
		ArtObject l5 = new Sculpture("Botero", "Bruno Catalano", 0, "", "Đồng", 5.7, 78);
		ArtObject l4 = new Sculpture("Bức tượng sáp Expansion", "Paige Bradley", 0, "", "Sáp", 4.5, 67);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);
		return list;
	}

	public void sortList() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i).sort(list.get(j))) {
					ArtObject temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

	public static void main(String[] args) {
		ListManagement l = new ListManagement();
		l.createSculptureList();
		System.out.println("Art Object: ");
		System.out.println(list);
		l.sortList();
		System.out.println(l.list);
	}
}
