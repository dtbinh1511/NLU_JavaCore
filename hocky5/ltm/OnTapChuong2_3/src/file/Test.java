package file;

public class Test {
	public static void main(String[] args) {
		BaiTap btChuong1 = new BaiTap();
		String path = "E:\\Test\\Client1";
//		System.out.println(btChuong1.deleteFile("E:\\Test\\Client1"));

		String[] exts = { ".pdf", ".accdb" };
//		btChuong1.findAll(path, exts);

		String pat1 = "Student.accdb";
		String pat2 = "*.accdb";
		String pat3 = "Product*";
		String pat4 = "*";
//		btChuong1.printList(btChuong1.findAll(path, pat1));
		
//		btChuong1.dirTree(path);
		btChuong1.deleteAll(path, exts);
	}
}
