package NK6;

public class Folder extends AFileSystem {
	private IList contents;

	public Folder(String name, Date created, IList contents) {
		super(name, created);
		this.contents = contents;
	}

	public String toString() {
		return "Name Folder: " + this.name + "    " + "DATE CREATED: " + this.created + "\n" + this.contents + "\n"
				+ "\n";

	}

	public int getSizeFile() {
		return this.contents.sumData();
	}

	@Override
	public int count() {
		return this.contents.sumFileInFolder();
	}

	@Override
	public File biggestFile() {
		return this.contents.biggestFile();
	}
}
