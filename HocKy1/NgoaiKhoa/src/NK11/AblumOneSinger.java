package NK11;

public class AblumOneSinger extends Album {
	private String singer;

	public AblumOneSinger(String title, int publisherYear, IMusicItem iList, String singer) {
		super(title, publisherYear, iList);
		this.singer = singer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AblumOneSinger other = (AblumOneSinger) obj;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		return true;
	}

}
