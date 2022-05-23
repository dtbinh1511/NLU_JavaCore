package NK6;

public class File extends AFileSystem {
	public int size;

	public File(String name, Date created, int size) {
		super(name, created);
		this.size = size;
	}

	public String toString() {
		return "\n" + "Name File:" + this.name + "\n" + "DATE CREATED: " + this.created + "\n" + "SIZE: " + this.size
				+ ".MB" + "\n";
	}

	public int count() {
		return 1;
	}

	public int getSizeFile() {
		return this.size;
	}
	public File biggestFile() {
		return new File(this.name, this.created, this.size);
	}

}
