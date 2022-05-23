package NK11;

public class SourceFile {
	private String fileName;
	private int size;
	public ClockTime duration;

	public SourceFile(String fileName, int size, ClockTime duration) {
		super();
		this.fileName = fileName;
		this.size = size;
		this.duration = duration;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceFile other = (SourceFile) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	public boolean CheckTimeDuration(int minute, int second) {
		return this.duration.checkTimeLonger(minute, second);
	}
}
