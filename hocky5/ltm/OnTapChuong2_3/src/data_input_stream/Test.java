package data_input_stream;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		BaiTap bt = new BaiTap();
		String destFolder = "E:\\Test\\Client2";
		String sFolder = "E:\\Test\\Client";
		String archiveName = "E:\\Test\\Client.dat";

		bt.pack(sFolder, archiveName);
		bt.unpack(destFolder, archiveName);
	}
}
