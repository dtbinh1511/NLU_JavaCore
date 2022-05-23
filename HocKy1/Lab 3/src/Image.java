// represent information about an image
public class Image {
	private int width; // pixels
	private int height; // pixels
	private String source; // file name
	private String quality; // informal

	public Image(int width, int height, String source, String quality) {

		this.width = width;
		this.height = height;
		this.source = source;
		this.quality = quality;

	}

	public boolean isPortrait() {
		if (this.height > this.width) {
			return true;
		} else
			return false;
	}

	public double size() {
		return this.height * this.width;

	}

	public boolean isLarger(Image that) {
		if (this.size() > that.size()) {
			return true;
		} else
			return false;
	}

	public boolean same(Image that) {
//		return (this.height == that.height)
//				&& (this.width == that.width)
//				&& (this.quality.equals(that.quality))
//				&& (this.source.equals(that.source));
		if ((this.height == that.height) && (this.width == that.width) && (this.quality.equals(that.quality))
				&& (this.source.equals(that.source))) {
			return true;
		}
		return true;

	}

	public String sizeString() {
		if (this.size() < 10000)
			return "small";
		else if (this.size() < 1000000)
			return "medium";
		else
			return "large";
	}
}
