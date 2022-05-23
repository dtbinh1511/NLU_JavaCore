package list;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

import object.Movie;
import object.Time;

public class MovieArrayList {
	private ArrayList<Movie> movies;

	public MovieArrayList() {
		movies = new ArrayList<Movie>();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Movie movie : movies) {
			stringBuilder.append(" " + movie.toString() + "\n");
		}
		return stringBuilder.toString();
	}

	//thêm
	public void add(Movie movie) {
		if (!movies.contains(movie))
			movies.add(movie);
		else
			JOptionPane.showMessageDialog(null, "Phim đã tồn tại!!!");
	}

	//xóa
	public void remove(Movie movie) {
		if (movies.contains(movie))
			movies.remove(movie);
		else
			JOptionPane.showMessageDialog(null, "Phim không có trong danh sách!!!");
	}

	//sắp xếp theo tiêu chí c
	public void sort(Comparator<Movie> c) {
		movies.sort(c);
	}
	
	//tạo danh sách theo tiêu chí năm sáng tác
	public MovieArrayList listByCriteria(int yearCreation) {
		MovieArrayList movieArrayList = new MovieArrayList();
		for (Movie movie : movies) {
			if (movie.isYearOfCreation(yearCreation))
				movieArrayList.add(movie);
		}
		return movieArrayList;
	}

	public static void main(String[] args) {
		MovieArrayList movieArrayList = new MovieArrayList();
		movieArrayList.add(new Movie("Hello World", "viễn tưởng", 2019, new Time(1, 23, 00)));
		movieArrayList.add(new Movie("Đứa con của thời tiết", "tình cảm", 2019, new Time(1, 47, 00)));
		movieArrayList.add(new Movie("Your name", "học đường", 2016, new Time(1, 46, 00)));
		movieArrayList.sort(new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("danh sách trước khi xóa:\n" + movieArrayList);
		System.out.println("danh sách phim sản xuất năm 2019:\n" + movieArrayList.listByCriteria(2019));
		movieArrayList.remove(new Movie("Your name", "học đường", 2016, new Time(1, 46, 00)));
		System.out.println("danh sách sau khi xóa:\n" + movieArrayList);
	}
}
