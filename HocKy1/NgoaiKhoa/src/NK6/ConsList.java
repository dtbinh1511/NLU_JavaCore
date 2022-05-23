package NK6;

public class ConsList implements IList {
	protected AFileSystem first;
	protected IList rest;

	public ConsList(AFileSystem first, IList rest) {
		super();
		this.first = first;
		this.rest = rest;

	}

	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	@Override
	public int sumFileInFolder() {
		return this.first.count() + this.rest.sumFileInFolder();
	}

	@Override
	public int sumData() {
		return this.first.getSizeFile() + this.rest.sumData();
	}

	@Override
	public File biggestFile() {
		if (this.first.biggestFile().getSizeFile() > this.rest.biggestFile().getSizeFile())
			return this.first.biggestFile();
		else 
			return this.rest.biggestFile();
	}
}
