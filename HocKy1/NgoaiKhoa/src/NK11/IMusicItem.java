package NK11;

public interface IMusicItem {
	public int howMany();

	public boolean equals(Object obj);

	public int totalTime();

	public IMusicItem thisActor(String singerBefore);

	public IMusicItem sortByTime();

	public IMusicItem insertByTime(MusicItem other);
}
