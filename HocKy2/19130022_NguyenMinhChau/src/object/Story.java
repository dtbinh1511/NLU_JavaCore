package object;

public class Story {
	private String nameStory;
	private int yearOfCreation;
	private String authorName;

	public Story(String nameStory, int yearOfCreation, String authorName) {
		this.nameStory = nameStory;
		this.yearOfCreation = yearOfCreation;
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Tên truyện: " + this.nameStory + ", Tên tác giả: " + this.authorName + ", Năm sáng tác: "
				+ this.yearOfCreation;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (nameStory == null) {
			if (other.nameStory != null)
				return false;
		} else if (!nameStory.equals(other.nameStory))
			return false;
		if (yearOfCreation != other.yearOfCreation)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Story story = new Story("Dragon ball", 1984 , " Toriyama Akira");
		System.out.println(story);
		System.out.println(story.equals(new Story("Dragon ball", 1984 , " Toriyama Akira")));
		System.out.println(story.equals(new Story("Dragon ball", 1983 , " Toriyama Akira")));
	}
}
