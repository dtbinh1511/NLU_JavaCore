import junit.framework.TestCase;

public class QuanLyTest extends TestCase {
	public void testQuanLyConstructor() {
		Date d1 = new Date(15, 11, 1980);
		GiaoSu gs1 = new GiaoSu("102", "Nguyen Van A", 1967, "CNTT");
		GiaoSu gs2 = new GiaoSu("107", "Ho Ly Ti", 1960, "CNTT");
		QuanLyNCS ql1 = new QuanLyNCS("19130017", "Do Thanh Binh", d1, gs1, gs2);
	}

	public void testSameKhoa() {
		GiaoSu gs1 = new GiaoSu("102", "Nguyen Van A", 1967, "CNTT");
		GiaoSu gs2 = new GiaoSu("107", "Ho Ly Ti", 1960, "CNTT");
		assertTrue(gs1.sameKhoa(gs2));
	}

	public void testTooAge35() {
		Date d2 = new Date(15, 11, 1980);
		assertTrue(d2.tooAge35());
		Date d3 = new Date(15, 11, 1990);
		assertFalse(d3.tooAge35());
	}
}
