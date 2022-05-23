package list;

import javax.swing.JOptionPane;

import object.Movie;
import object.TelevisionSeries;
import object.Time;

public class TelevisionSeriesArray {
	private int capacity;
	private TelevisionSeries[] listTelevisionSeries;
	private int count;

	public TelevisionSeriesArray(int capacity) {
		this.capacity = capacity;
		this.listTelevisionSeries = new TelevisionSeries[capacity];
		this.count = 0;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			stringBuilder.append(listTelevisionSeries[i] + "\n");
		}
		return stringBuilder.toString();
	}

	//xác định xem phim có tồn tại trong danh sách hay không
	public boolean contains(TelevisionSeries televisionSeries) {
		for (int i = 0; i < this.count; i++) {
			if (listTelevisionSeries[i].equals(televisionSeries))
				return true;
		}
		return false;
	}

	//thêm
	public void add(TelevisionSeries televisionSeries) {
		if (count < capacity && !contains(televisionSeries)) {
			listTelevisionSeries[count] = televisionSeries;
			count++;
		} else
			JOptionPane.showMessageDialog(null, "Phim đã tồn tại!!!");
	}

	//xóa
	public void remove(TelevisionSeries televisionSeries) {
		if (count > 0 && contains(televisionSeries)) {
			listTelevisionSeries[count - 1] = null;
			count--;
		} else
			JOptionPane.showMessageDialog(null, "Phim không có trong danh sách!!!");
	}

	//sắp xếp
	public void sortAscending() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				if (listTelevisionSeries[j].compareTo(listTelevisionSeries[j + 1]) > 0) {
					TelevisionSeries t = listTelevisionSeries[j];
					listTelevisionSeries[j] = listTelevisionSeries[j + 1];
					listTelevisionSeries[j + 1] = t;
				}
			}
		}
	}

	//tạo danh sách theo tiêu chí
	public TelevisionSeriesArray listByCriteria(int yearCreation) {
		TelevisionSeriesArray televisionSeriesArray = new TelevisionSeriesArray(count);
		for (int i = 0; i < count; i++) {
			if (listTelevisionSeries[i].isYearOfCreation(yearCreation))
				televisionSeriesArray.add(listTelevisionSeries[i]);
		}
		return televisionSeriesArray;
	}

	public static void main(String[] args) {
		TelevisionSeriesArray televisionSeriesArray = new TelevisionSeriesArray(10);
		televisionSeriesArray
				.add(new TelevisionSeries("The god of high school", "siêu nhiên", 2020, 13, new Time(0, 23, 30)));
		televisionSeriesArray.add(new TelevisionSeries("Deca-Dence", "giả tưởng", 2020, 12, new Time(0, 23, 30)));
		televisionSeriesArray.add(new TelevisionSeries("Dr. Stone", "viễn tưởng", 2019, 24, new Time(0, 23, 30)));
		televisionSeriesArray.add(new TelevisionSeries("Dr. Stone", "viễn tưởng", 2019, 24, new Time(0, 23, 30)));
		televisionSeriesArray.sortAscending();
		System.out.println("Danh sách phim bộ trước khi xóa:\n" + televisionSeriesArray);
		System.out.println("danh sách phim sản xuất năm 2019:\n" + televisionSeriesArray.listByCriteria(2019));
		televisionSeriesArray.remove(new TelevisionSeries("Deca-Dence", "giả tưởng", 2020, 12, new Time(0, 23, 30)));
		System.out.println("Danh sách phim bộ sau khi xóa:\n" + televisionSeriesArray);
	}
}
