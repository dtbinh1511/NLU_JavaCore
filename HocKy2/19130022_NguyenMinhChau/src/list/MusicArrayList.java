package list;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

import object.Music;

public class MusicArrayList {
	private ArrayList<Music> musics;

	public MusicArrayList() {
		musics = new ArrayList<Music>();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Music music : musics) {
			stringBuilder.append(music.toString() + "\n");
		}
		return stringBuilder.toString();
	}

	//thêm
	public void add(Music music) {
		if (!musics.contains(music))
			musics.add(music);
		else
			JOptionPane.showMessageDialog(null, "Bài hát đã tồn tại!!!");
	}

	//xóa
	public void remove(Music music) {
		if (musics.contains(music))
			musics.remove(music);
		else
			JOptionPane.showMessageDialog(null, "Bài hát không có trong danh sách!!!");
	}
	
	//sắp xếp
	public void sort(Comparator<Music> c) {
		musics.sort(c);
	}
	
	//tạo danh sách theo tiêu chí cùng năm sáng tác
	public MusicArrayList listByCriteria(int yearCreation) {
		MusicArrayList musicArrayList = new MusicArrayList();
		for (Music music : musics) {
			if (music.isYearCreation(yearCreation))
				musicArrayList.add(music);
		}
		return musicArrayList;
	}
	
	public static void main(String[] args) {
		MusicArrayList musicArrayList = new MusicArrayList();
		musicArrayList.add(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp"));
		musicArrayList.add(new Music("Chắc vì mình chưa tốt", "Pop", 2020, "Thanh Hưng"));
		musicArrayList.add(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp"));
		musicArrayList.add(new Music("Ai mang cô đơn đi", "Pop", 2020, "K-ICM"));
		musicArrayList.sort(new Comparator<Music>() {
			@Override
			public int compare(Music o1, Music o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("danh sách trước khi xóa:\n" + musicArrayList);
		System.out.println("danh sách nhạc sản xuất năm 2020:\n" + musicArrayList.listByCriteria(2020));
		musicArrayList.remove(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp"));
		musicArrayList.remove(new Music("A", "Pop", 2015, "Sơn tùng mtp"));
		System.out.println("danh sách sau khi xóa:\n" + musicArrayList);
	}
}
