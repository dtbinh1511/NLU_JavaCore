package list;

import javax.swing.JOptionPane;

import object.Movie;
import object.Time;

public class MovieArray {
	private int capacity;
	private Movie[] movies;
	private int count;

	public MovieArray(int capacity) {
		this.capacity = capacity;
		this.movies = new Movie[capacity];
		this.count = 0;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			stringBuilder.append(movies[i] + "\n");
		}
		return stringBuilder.toString();
	}

	//xác định xem movie có tồn tại trong danh sách hay không
	public boolean contains(Movie movie) {
		for (int i = 0; i < this.count; i++) {
			if (movies[i].equals(movie))
				return true;
		}
		return false;
	}

	//thêm movie
	public void add(Movie movie) {
		if (count < capacity && !contains(movie)) {
			movies[count] = movie;
			count++;
		} else
			JOptionPane.showMessageDialog(null, "Phim đã tồn tại!!!");
	}

	//xóa movie
	public void remove(Movie movie) {
		if (count > 0 && contains(movie)) {
			movies[count - 1] = null;
			count--;
		} else
			JOptionPane.showMessageDialog(null, "Phim không có trong danh sách!!!");
	}

	//sắp xếp tăng dần theo tên
	public void sortAscending() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				if (movies[j].compareTo(movies[j + 1]) > 0) {
					Movie m = movies[j];
					movies[j] = movies[j + 1];
					movies[j + 1] = m;
				}
			}
		}
	}

	//tạo danh sách theo tiêu chí cùng năm sáng tác
	public MovieArray listByCriteria(int yearCreateFilm) {
		MovieArray movieArray = new MovieArray(count);
		for (int i = 0; i < count; i++) {
			if (movies[i].isYearOfCreation(yearCreateFilm))
				movieArray.add(movies[i]);
		}
		return movieArray;
	}

	public static void main(String[] args) {
		MovieArray movieArray = new MovieArray(3);
		movieArray.add(new Movie("Hello World", "viễn tưởng", 2019, new Time(1, 23, 00)));
		movieArray.add(new Movie("Đứa con của thời tiết", "tình cảm", 2019, new Time(1, 47, 00)));
		movieArray.add(new Movie("Your name", "học đường", 2016, new Time(1, 46, 00)));
		movieArray.sortAscending();
		System.out.println("danh sách đã được sắp xếp trước khi xóa:\n" + movieArray);
		System.out.println("danh sách phim sản xuất năm 2019:\n" + movieArray.listByCriteria(2019));
		movieArray.remove(new Movie("Your name", "học đường", 2016, new Time(1, 46, 00)));
		System.out.println("danh sách sau khi xóa:\n" + movieArray);
	}
}
