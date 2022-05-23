package list;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

import object.TelevisionSeries;
import object.Time;

public class TelevisionSeriesArrayList {
	private ArrayList<TelevisionSeries> listTelevisionSeries;

	public TelevisionSeriesArrayList() {
		listTelevisionSeries = new ArrayList<TelevisionSeries>();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (TelevisionSeries televisionSeries : listTelevisionSeries) {
			stringBuilder.append(televisionSeries.toString() + "\n");
		}
		return stringBuilder.toString();
	}

	//thêm
	public void add(TelevisionSeries televisionSeries) {
		if (!listTelevisionSeries.contains(televisionSeries))
			listTelevisionSeries.add(televisionSeries);
		else
			JOptionPane.showMessageDialog(null, "Phim đã tồn tại!!!");
	}

	//xóa
	public void remove(TelevisionSeries televisionSeries) {
		if (listTelevisionSeries.contains(televisionSeries))
			listTelevisionSeries.remove(televisionSeries);
		else
			JOptionPane.showMessageDialog(null, "Phim không có trong danh sách!!!");
	}
	
	//sắp xếp
	public void sort(Comparator<TelevisionSeries> c) {
		listTelevisionSeries.sort(c);
	}
	
	//tạo danh sách theo tiêu chí
	public TelevisionSeriesArrayList listByCriteria(int yearCreation) {
		TelevisionSeriesArrayList televisionSeriesArrayList = new TelevisionSeriesArrayList();
		for (TelevisionSeries televisionSeries : listTelevisionSeries) {
			if (televisionSeries.isYearOfCreation(yearCreation))
				televisionSeriesArrayList.add(televisionSeries);
		}
		return televisionSeriesArrayList;
	}
	
	public static void main(String[] args) {
		TelevisionSeriesArrayList televisionSeriesArrayList = new TelevisionSeriesArrayList();
		televisionSeriesArrayList
				.add(new TelevisionSeries("The god of high school", "siêu nhiên", 2020, 13, new Time(0, 23, 30)));
		televisionSeriesArrayList.add(new TelevisionSeries("Deca-Dence", "giả tưởng", 2020, 12, new Time(0, 23, 30)));
		televisionSeriesArrayList.add(new TelevisionSeries("Dr. Stone", "viễn tưởng", 2019, 24, new Time(0, 23, 30)));
		televisionSeriesArrayList.add(new TelevisionSeries("Dr. Stone", "viễn tưởng", 2019, 24, new Time(0, 23, 30)));
		televisionSeriesArrayList.sort(new Comparator<TelevisionSeries>() {
			@Override
			public int compare(TelevisionSeries o1, TelevisionSeries o2) {
				return o1.compareTo(o2);
			}
		});;
		System.out.println("Danh sách phim bộ trước khi xóa:\n" + televisionSeriesArrayList);
		System.out.println("danh sách phim sản xuất năm 2019:\n" + televisionSeriesArrayList.listByCriteria(2019));
		televisionSeriesArrayList.remove(new TelevisionSeries("Deca-Dence", "giả tưởng", 2020, 12, new Time(0, 23, 30)));
		System.out.println("Danh sách phim bộ sau khi xóa:\n" + televisionSeriesArrayList);
	}
}
