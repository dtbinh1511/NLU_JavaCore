package DeThi;

public abstract class ArtObject {
	protected String title;
	protected String artist;
	protected int year;
	protected String description;

	public ArtObject(String title, String artist, int year, String description) {
		super();
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.description = description;
	}

	@Override
	public String toString() {
		return "title:" + title + ", artist: " + artist + ", year:" + year + ", description: " + description;
	}

	public boolean sort(ArtObject other) {
		if (this.title.compareTo(other.title) > 0) {
			return true;
		}
		return false;
	}
}