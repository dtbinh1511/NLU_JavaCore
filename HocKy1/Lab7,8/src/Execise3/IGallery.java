package Execise3;

public interface IGallery {
	public double timeToDownload(int speed);

	public boolean smallerThan(double maxSize);

	public boolean sameName(String name);
}
