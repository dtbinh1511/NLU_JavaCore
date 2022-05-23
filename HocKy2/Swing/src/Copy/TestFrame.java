package Copy;

import javax.swing.JFrame;

public class TestFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); // tạo một jframe
		frame.setTitle("JFrame Demo"); // tạo tiêu đề
		frame.setSize(400, 300); // kích cỡ hiển thị
//		frame.setLocation(200, 100);// vị trí hiển thị trên màn hình
		frame.setLocationRelativeTo(null);// vị trí trung tâm màn hình
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// thoát
		frame.setVisible(true); // hiển thị
	}

}
