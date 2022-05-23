package NK11;

public class MusicItem {
	private Song song;
	public SourceFile file;
	private int hitCounts;
	private String singer;

	public MusicItem(Song song, SourceFile file, int hitCounts, String singer) {
		super();
		this.song = song;
		this.file = file;
		this.hitCounts = hitCounts;
		this.singer = singer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicItem other = (MusicItem) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (hitCounts != other.hitCounts)
			return false;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		if (song == null) {
			if (other.song != null)
				return false;
		} else if (!song.equals(other.song))
			return false;
		return true;
	}

	// kiem tra ban nhac nao co luot truy cap nhieu hon
	public boolean moreFavouriteThan(MusicItem other) {
		return this.hitCounts > other.hitCounts;
	}

	// kiem tra xem ban nhac nao co thoi gian dai hon thoi gian cho truoc
	public boolean longerThan(int minute, int second) {
		return this.file.CheckTimeDuration(minute, second);
	}

	// kiem tra muc do ua thich
	public String favouriteRate() {
		if (this.hitCounts >= 40000)
			return "Hot";
		else if (this.hitCounts > 20000)
			return "Phổ biến";
		return "";
	}

	public boolean sameSinger(String singerBefore) {
		return this.singer.equals(singerBefore);
	}

	public int totalTime() {
		return this.file.duration.totalTime();
	}
}
