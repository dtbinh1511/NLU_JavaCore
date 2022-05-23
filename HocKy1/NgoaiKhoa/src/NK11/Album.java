package NK11;

public abstract class Album {
	private String title;
	private int publisherYear;
	private IMusicItem iList;

	public Album(String title, int publisherYear, IMusicItem iList) {
		super();
		this.title = title;
		this.publisherYear = publisherYear;
		this.iList = iList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (iList == null) {
			if (other.iList != null)
				return false;
		} else if (!iList.equals(other.iList))
			return false;
		if (publisherYear != other.publisherYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int howMany() {
		return this.iList.howMany();
	}

	public int totalTime() {
		return this.iList.totalTime();
	}

	public IMusicItem thisActor(String singerBefore) {
		return this.iList.thisActor(singerBefore);
	}

	public IMusicItem sortByTime() {
		return this.iList.sortByTime();
	}
}
