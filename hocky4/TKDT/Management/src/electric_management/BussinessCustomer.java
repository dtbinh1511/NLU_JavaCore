package electric_management;

import java.util.*;

public class BussinessCustomer extends Customer {
	private int numBanks;
	private ArrayList<ThreeReading> readings = new ArrayList<ThreeReading>();

	public BussinessCustomer(String name, String id, int numBanks) {
		super(name, id);
		this.numBanks = numBanks;
	}

	public int getNumBanks() {
		return numBanks;
	}

	public void addReading(ThreeReading reading) {
		getReading().add(reading);
	}

	@Override
	public ArrayList<ThreeReading> getReading() {
		return readings;
	}

	@Override
	public double charge() {
		ThreeReading oldReading = (ThreeReading) getOldReading();
		ThreeReading newReading = (ThreeReading) getNewReading();

		int price = getHighUsage(newReading, oldReading) * 1480 + getLowUsage(newReading, oldReading) * 505
				+ getNormalUsage(newReading, oldReading) * 895;
		return price / 0.1;
	}

	public int getHighUsage(ThreeReading newReading, ThreeReading oldReading) {
		return newReading.getHighIndex() - oldReading.getHighIndex();
	}

	public int getLowUsage(ThreeReading newReading, ThreeReading oldReading) {
		return newReading.getLowIndex() - oldReading.getLowIndex();
	}

	public int getNormalUsage(ThreeReading newReading, ThreeReading oldReading) {
		return newReading.getIndex() - oldReading.getIndex() - getHighUsage(newReading, oldReading)
				- getLowUsage(newReading, oldReading);
	}

	@Override
	public String statement() {
		ThreeReading oldReading = (ThreeReading) getOldReading();
		ThreeReading newReading = (ThreeReading) getNewReading();
		int usage = newReading.getIndex() - oldReading.getIndex();
		return "Ma Nha SX: " + getId() + "\nTen Nha SX: " + getName() + "\nSo tai khoan: " + getNumBanks()
				+ "\nChi So Cu: " + oldReading.getIndex() + "\nChi so moi: " + newReading.getIndex()
				+ "\nDien nang tieu thu: " + usage + "\nGio binh thuong: " + getNormalUsage(newReading, oldReading)
				+ "\nGio cao diem: " + getHighUsage(newReading, oldReading) + "\nGio thap diem: "
				+ getLowUsage(newReading, oldReading) + "\nThanh tien(10%VAT): " + charge() + " VND\n\n\n\n";

	}

}
