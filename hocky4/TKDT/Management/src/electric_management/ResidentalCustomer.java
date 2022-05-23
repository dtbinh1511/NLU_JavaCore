package electric_management;

import java.util.*;

public class ResidentalCustomer extends Customer {
	private ArrayList<OneReading> readings = new ArrayList<OneReading>();

	public ResidentalCustomer(String name, String id) {
		super(name, id);
	}

	public void addReading(OneReading reading) {
		getReading().add(reading);
	}
	@Override
	public List<OneReading> getReading() {
		return readings;
	}

	@Override
	public double charge() {
		int newIndex = getNewReading().getIndex();
		int oldIndex = getOldReading().getIndex();

		int usage = newIndex - oldIndex;

		int u1 = (usage <= 100) ? usage : 100;
		int u2 = (usage <= 150) ? usage - u1 : 50;
		int u3 = (usage <= 200) ? usage - u1 - u2 : 50;
		int u4 = (usage <= 300) ? usage - u1 - u2 - u3 : 100;
		int u5 = usage - u1 - u2 - u3 - u4;

		int price = u1 * 550 + u2 * 900 + u3 * 1210 + u4 * 1340 + u5 * 1400;
		return price / 0.1;
	}

	@Override
	public String statement() {
		Reading oldReading = getOldReading();
		Reading newReading = getNewReading();

		int usage = newReading.getIndex() - oldReading.getIndex();

		return "Ma Khach: " + getId() + "\nTen: " + getName() + "\nChi so cu: " + oldReading.getIndex()
				+ "\nChi so moi: " + newReading.getIndex() + "\nDien nang tieu thu: " + usage
				+ "\nThanh tien (10% VAT): " + charge() + " VND\n\n\n\n";
	}

}
