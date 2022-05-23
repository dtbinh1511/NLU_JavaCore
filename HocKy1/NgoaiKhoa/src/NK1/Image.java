package NK1;

public class Image {
	private int width, height;
	private String source, quality;

	public Image(int width, int height, String source, String quality) {
		super();
		this.width = width;
		this.height = height;
		this.source = source;
		this.quality = quality;
	}

//Kiểm tra xem chiều cao có rộng hơn chiều ngang hay không?
	public boolean isPortrait() {
		return this.height > this.width;
	}

//Tinh kích thức của hình
	public int size() {
		return this.height * this.width;
	}

// Kiểm tra xem kích cỡ của hình này có hơn hình khác không
	public boolean isLarger(Image other) {
		return this.size() > other.size();
	}

//Kiểm tra xem hình này có giống hình kia không?e
	public boolean same(Image other) {
		return (this.height == other.height && this.width == this.width && this.source.equals(other.source)
				&& this.quality.equals(other.quality));
	}

	// Kiểm tra xem hình ảnh thuộc kiểu kích cỡ nào?
	public String sizeString() {
		if (this.size() < 10000)
			return "small";
		else if (this.size() <= 1000000)
			return "medium";
		else
			return "large";
	}
}
