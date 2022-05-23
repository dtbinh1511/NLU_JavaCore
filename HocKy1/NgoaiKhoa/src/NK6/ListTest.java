package NK6;

import junit.framework.TestCase;

public class ListTest extends TestCase {
	public void testConstructor() {

		AFileSystem f1 = new File("NMTH", new Date(18, 11, 2019), 100);
		AFileSystem f2 = new File("LTCB", new Date(18, 11, 2019), 800);
		AFileSystem f3 = new File("TOANCAOCAP", new Date(18, 11, 2019), 500);

		IList empty = new MTList();
		IList i1 = new ConsList(f1, empty);
		IList i2 = new ConsList(f2, i1);
		IList i3 = new ConsList(f3, i2);

		Folder F1 = new Folder("Hoc Tap", new Date(20, 10, 2019), i3);
		System.out.println(F1);
		System.out.println("SUM FILE IN FOLDER: " + F1.count() + " file");
		System.out.println("SUM DATA OF FOLDER: " + F1.getSizeFile() + ".MB");
		System.out.println("\n"+ "FILE BIGGEST: "+ F1.biggestFile());
	}
}
