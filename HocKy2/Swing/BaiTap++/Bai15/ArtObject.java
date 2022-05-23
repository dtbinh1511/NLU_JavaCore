package Bai15;

public class ArtObject {
	public String artist;
	public String title;
	public String description;
	public int year;

	public ArtObject(String artist, String title, String description, int year) {
		super();
		this.artist = artist;
		this.title = title;
		this.description = description;
		this.year = year;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
