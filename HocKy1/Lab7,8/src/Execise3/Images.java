package Execise3;

public class Images extends AGallery{
private int height;
private int width;
private String qualityImage;
protected Images(String files, int size, int height, int width, String qualityImage) {
	super(files, size);
	this.height = height;
	this.width = width;
	this.qualityImage = qualityImage;
}
}
