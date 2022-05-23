package Bai15;

public class Painting extends ArtObject {
	public String paintType;
	public String style;

	public Painting(String artist, String title, String description, int year, String paintType, String style) {
		super(artist, title, description, year);
		this.paintType = paintType;
		this.style = style;
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
