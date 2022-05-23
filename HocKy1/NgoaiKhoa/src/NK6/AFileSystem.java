package NK6;

public abstract class AFileSystem {
	protected String name;
	protected Date created;

	public AFileSystem(String name, Date created) {
		super();
		this.name = name;
		this.created = created;
	}

	public abstract String toString();

	public abstract int count();
	
	public abstract int getSizeFile();
	
	public abstract File biggestFile();
	
	}

