package Execise3;

public class Sounds extends AGallery {
	private int timeRecording; // in second

	protected Sounds(String files, int size, int timeRecording) {
		super(files, size);
		this.timeRecording = timeRecording;
	}

}
