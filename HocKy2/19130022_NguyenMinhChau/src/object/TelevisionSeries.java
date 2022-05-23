package object;

public class TelevisionSeries extends AFilm {
	private int episodeNumber;
	private Time timePerEpisode;

	public TelevisionSeries(String name, String category, int yearOfCreation, int episodeNumber, Time timePerEpisode) {
		super(name, category, yearOfCreation);
		this.episodeNumber = episodeNumber;
		this.timePerEpisode = timePerEpisode;
	}
	
	@Override
	public String toString() {
		return this.name + "\t\t" + this.category + "\t\t" + this.episodeNumber + " tập";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof TelevisionSeries))
			return false;
		else {
			TelevisionSeries that = (TelevisionSeries) obj;
			return this.name.equals(that.name) && this.category.equals(that.category)
					&& this.yearOfCreation == that.yearOfCreation && this.episodeNumber == that.episodeNumber
					&& this.timePerEpisode.equals(that.timePerEpisode);
		}
	}
	
	public static void main(String[] args) {
		TelevisionSeries televisionSeries = new TelevisionSeries("B", "X", 999, 10, new Time(0, 20, 00));
		System.out.println(televisionSeries);
		System.out.println(televisionSeries.equals(new TelevisionSeries("B", "X", 999, 10, new Time(0, 20, 00))));
	}
}
