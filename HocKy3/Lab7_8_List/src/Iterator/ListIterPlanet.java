package Iterator;

import java.util.Arrays;
import java.util.ListIterator;

public class ListIterPlanet {
	private ListIterator<Planet> list = null;
	private int size = 0;

	public ListIterPlanet(Planet[] planets) {
		list = Arrays.asList(planets).listIterator();
	}

	public String toString() {
		String s = "";
		while (list.hasNext()) {
			s += list.next() + "\n";
			size++;
		}
		return s;
	}

	public void refresh() {
		while (list.hasPrevious())
			list.previous();
	}

	public Planet findAreaMax() {
		Planet planet = list.next();
		while (list.hasNext()) {
			if (planet.getDienTich() < list.next().getDienTich())
				planet = list.previous();
		}
		return planet;
	}

	public Planet findWeighMax() {
		Planet planet = list.next();
		while (list.hasNext()) {
			if (planet.getKhoiLuong() < list.next().getKhoiLuong())
				planet = list.previous();
		}
		return planet;
	}

	public Planet findCycleMax() {
		Planet planet = list.next();
		while (list.hasNext()) {
			if (planet.getChuKy() < list.next().getChuKy())
				planet = list.previous();
		}
		return planet;
	}

	public Planet findByName(String name) {
		while (list.hasNext()) {
			if (list.next().getTenTV().equalsIgnoreCase(name))
				return list.previous();
		}
		while (list.hasPrevious()) {
			if (list.previous().getTenTA().equalsIgnoreCase(name))
				return list.next();
		}
		return null;
	}

	public Planet random() {
		int ran = (int) (Math.random() * size);
		while (list.hasNext()) {
			if (list.nextIndex() == ran)
				return list.previous();
		}
		return null;
	}

	public double compareWithEarth(Planet other) {
		Planet planet = findByName("Earth");
		if (planet.getChuKy() > other.getChuKy())
			return planet.getChuKy();
		return other.getChuKy();
	}

	public static void main(String[] args) {
		Planet mercury = new Planet("Sao Thủy", "Mercury", 58.646, 0.075, 0.330);
		Planet venus = new Planet("Sao Kim", "Venus", 243.686, 0.46, 4.869);
		Planet earth = new Planet("Trái Đất", "Earth", 0.997, 0.51, 5.974);
		Planet mars = new Planet("Sao Hỏa", "Mars", 1.026, 0.145, 0.642);
		Planet jupiter = new Planet("Sao Mộc", "Jupiter", 0.414, 61.4, 1899);
		Planet saturn = new Planet("Sao Thổ", "Saturn", 0.444, 42.7, 568.46);
		Planet uranus = new Planet("Sao Thiên Vương", "Uranus", 0.718, 8.084, 86.832);
		Planet neptune = new Planet("Sao Hải Vương", "Neptune", 0.671, 7.619, 102.43);

		Planet[] arrayPlanet = { mercury, venus, earth, mars, jupiter, saturn, uranus, neptune };
		ListIterPlanet list = new ListIterPlanet(arrayPlanet);
		System.out.println(list.toString());
		list.refresh();
		System.out.println("========================================");
//		System.out.println("The planet with the largest area: " + list.findAreaMax());
//		list.refresh();
//		System.out.println("The planet with the largest mass: " +list.findWeighMax());
//		list.refresh();
		System.out.println("The planet with the largest cycle: " +  list.findCycleMax());
//		list.refresh();
//		System.out.println(list.findByName("Sao mộc"));
//		list.refresh();
//		System.out.println(list.findByName("earth"));
//		list.refresh();
//		System.out.println(list.compareWithEarth(mercury));
	}
}
