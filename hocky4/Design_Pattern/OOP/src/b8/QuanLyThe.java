package b8;

import java.util.ArrayList;

public class QuanLyThe {
	private ArrayList<The> list;

	public QuanLyThe() {
		list = new ArrayList<The>();
	}

	public boolean add(The t) {
		return list.add(t);
	}

	public boolean delete(String ma) {
		for (The the : list) {
			if (the.getMaPM().equals(ma)) {
				return list.remove(the);
			}
		}
		return false;
	}
}
