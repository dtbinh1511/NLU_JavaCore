package NK11;

import junit.framework.TestCase;

public class AlbumTest extends TestCase {
	MusicItem Mu1 = new MusicItem(new Song("Hãy trao cho anh", "Sơn Tùng M-Tp", "Pop"),
			new SourceFile("Chúng ta", 5021, new ClockTime(3, 28)), 100000000, "Sơn Tùng M-TP");
	MusicItem Mu2 = new MusicItem(new Song("Lạc Trôi", "Sơn Tùng M-Tp", "Pop-Balad"),
			new SourceFile("Chúng ta", 5021, new ClockTime(3, 50)), 30000, "Sơn Tùng M-TP");
	MusicItem Mu3 = new MusicItem(new Song("Chạy ngay đi", "Sơn Tùng M-Tp", "Pop"),
			new SourceFile("Chúng ta", 5021, new ClockTime(4, 5)), 136000000, "Sơn Tùng M-TP");

	MusicItem Mu4 = new MusicItem(new Song("Nắm lấy tay anh", "Đỗ Binh", "Trữ tình"),
			new SourceFile("Chúng ta", 5021, new ClockTime(5, 28)), 1000, "Tuấn Hưng");

	IMusicItem empty = new MTMusicItem();
	IMusicItem Con1 = new ConsMusicItem(Mu1, empty);
	IMusicItem Con2 = new ConsMusicItem(Mu2, Con1);
	IMusicItem Con3 = new ConsMusicItem(Mu3, Con2);
	IMusicItem Con4 = new ConsMusicItem(Mu4, empty);

	Album As1 = new AblumSynthesis("Tổng hợp nhạc việt", 2017, Con4);
	Album Ao1 = new AblumOneSinger("Chúng ta", 2020, Con3, "Sơn Tùng M-TP");

	public void testMoreFavouriteThan() {
		assertTrue(Mu3.moreFavouriteThan(Mu1));
		assertFalse(Mu2.moreFavouriteThan(Mu3));

	}

	public void testLongerThan() {
		assertTrue(Mu1.longerThan(3, 20));
		assertFalse(Mu2.longerThan(5, 30));
	}

	public void testFavouriteRate() {
		assertEquals(Mu1.favouriteRate(), "Hot");
		assertEquals(Mu2.favouriteRate(), "Phổ biến");
		assertEquals(Mu4.favouriteRate(), "");
	}

	public void testHowMany() {
		assertEquals(As1.howMany(), 1);
		assertEquals(Ao1.howMany(), 3);
	}

	public void testTotalTime() {
		assertEquals(As1.totalTime(), 328);
		assertEquals(Ao1.totalTime(), 683);
	}

	public void testThisActor() {
		assertEquals(As1.thisActor("Đỗ Bình"), new MTMusicItem());
		assertEquals(Ao1.thisActor("Sơn Tùng M-TP"),
				new ConsMusicItem(Mu1, new ConsMusicItem(Mu2, new ConsMusicItem(Mu3, new MTMusicItem()))));
	}
}
