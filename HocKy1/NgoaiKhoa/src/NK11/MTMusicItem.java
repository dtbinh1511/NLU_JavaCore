package NK11;

public class MTMusicItem implements IMusicItem {

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTMusicItem))
			return false;
		return true;
	}

	@Override
	public int howMany() {
		return 0;
	}

	@Override
	public int totalTime() {
		return 0;
	}

	@Override
	public IMusicItem thisActor(String singerBefore) {
		return new MTMusicItem();
	}

	@Override
	public IMusicItem sortByTime() {
		return new MTMusicItem();
	}

	@Override
	public IMusicItem insertByTime(MusicItem other) {
		return new ConsMusicItem(other, new MTMusicItem());
	}

}
