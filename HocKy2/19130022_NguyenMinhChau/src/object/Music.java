package object;

public class Music {
	private String nameSong;
	private String category;
	private int yearOfCreation;
	private String musicianName;

	public Music(String nameSong, String category, int yearOfCreation, String musicianName) {
		this.nameSong = nameSong;
		this.category = category;
		this.yearOfCreation = yearOfCreation;
		this.musicianName = musicianName;
	}

	@Override
	public String toString() {
		return this.nameSong + "\t\t" + this.category + "\t\t" + this.musicianName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (musicianName == null) {
			if (other.musicianName != null)
				return false;
		} else if (!musicianName.equals(other.musicianName))
			return false;
		if (nameSong == null) {
			if (other.nameSong != null)
				return false;
		} else if (!nameSong.equals(other.nameSong))
			return false;
		if (yearOfCreation != other.yearOfCreation)
			return false;
		return true;
	}
	
	public int compareTo(Music that) {
		return this.nameSong.compareToIgnoreCase(that.nameSong);
	}
	
	public boolean isYearCreation(int yearCreation) {
		return this.yearOfCreation == yearCreation;
	}
	
	public static void main(String[] args) {
		Music music = new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp");
		System.out.println(music);
		System.out.println(music.equals(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp")));
	}
}
