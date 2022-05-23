package list;

import javax.swing.JOptionPane;

import object.Movie;
import object.Music;
import object.Time;

public class MusicArray {
	private int capacity;
	private Music[] musics;
	private int count;

	public MusicArray(int capacity) {
		this.capacity = capacity;
		this.musics = new Music[capacity];
		this.count = 0;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			stringBuilder.append(musics[i] + "\n");
		}
		return stringBuilder.toString();
	}

	//xác định xem music có tồn tại trong danh sách không
	public boolean contains(Music music) {
		for (int i = 0; i < this.count; i++) {
			if (musics[i].equals(music))
				return true;
		}
		return false;
	}

	//thêm
	public void add(Music music) {
		if (count < capacity && !contains(music)) {
			musics[count] = music;
			count++;
		} else
			JOptionPane.showMessageDialog(null, "Bài hát đã tồn tại!!!");
	}

	//xóa
	public void remove(Music music) {
		if (count > 0 && contains(music)) {
			musics[count - 1] = null;
			count--;
		} else
			JOptionPane.showMessageDialog(null, "Bài hát không có trong danh sách!!!");
	}
	
	//sắp xếp tăng dần theo tên
	public void sortAscending() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				if (musics[j].compareTo(musics[j + 1]) > 0) {
					Music m = musics[j];
					musics[j] = musics[j + 1];
					musics[j + 1] = m;
				}
			}
		}
	}
	
	//tạo danh sách theo tiêu chí cùng năm sáng tác
	public MusicArray listByCriteria(int yearCreation) {
		MusicArray musicArray = new MusicArray(count);
		for (int i = 0; i < count; i++) {
			if(musics[i].isYearCreation(yearCreation)) {
				musicArray.add(musics[i]);
			}
		}
		return musicArray;
	}

	public static void main(String[] args) {
		MusicArray musicArray = new MusicArray(3);
		musicArray.add(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp"));
		musicArray.add(new Music("Chắc vì mình chưa tốt", "Pop", 2020, "Thanh Hưng"));
		musicArray.add(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp"));
		musicArray.add(new Music("Ai mang cô đơn đi", "Pop", 2020, "K-ICM"));
		musicArray.sortAscending();
		System.out.println("danh sách trước khi xóa:\n" + musicArray);
		System.out.println("danh sách nhạc sản xuất năm 2020:\n" + musicArray.listByCriteria(2020));
		musicArray.remove(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp"));
		System.out.println("danh sách sau khi xóa:\n" + musicArray);
	}
}
