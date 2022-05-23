package NK11;

public class AblumSynthesis extends Album {

	public AblumSynthesis(String title, int publisherYear, IMusicItem iList) {
		super(title, publisherYear, iList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
