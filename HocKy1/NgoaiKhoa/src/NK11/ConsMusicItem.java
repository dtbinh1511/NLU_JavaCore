package NK11;

public class ConsMusicItem implements IMusicItem {
	private MusicItem first;
	private IMusicItem rest;

	public ConsMusicItem(MusicItem first, IMusicItem rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsMusicItem other = (ConsMusicItem) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (rest == null) {
			if (other.rest != null)
				return false;
		} else if (!rest.equals(other.rest))
			return false;
		return true;
	}

	@Override
	public int howMany() {
		if (this.first instanceof MusicItem)
			return 1 + this.rest.howMany();
		return this.rest.howMany();
	}

	@Override
	public int totalTime() {
		return this.first.totalTime() + this.rest.totalTime();
	}

	@Override
	public IMusicItem thisActor(String singerBefore) {
		if (this.first.sameSinger(singerBefore))
			return new ConsMusicItem(first, rest.thisActor(singerBefore));
		return this.rest.thisActor(singerBefore);
	}

	@Override
	public IMusicItem sortByTime() {
		return this.rest.sortByTime().insertByTime(first);
	}

	@Override
	public IMusicItem insertByTime(MusicItem other) {
		if (this.first.file.duration.checkTimeBigger(other.file.duration))
			return new ConsMusicItem(first, rest.insertByTime(other));
		return new ConsMusicItem(other, this);
	}

}
