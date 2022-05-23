package Copy;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CreateFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();// tạo jframe khung chứa
		// tạo nút;
		JButton button = new JButton("Ok");
		frame.add(button);
		
		frame.setTitle("Create Frame");
		frame.setSize(400, 300); // tạo size
		frame.setLocationRelativeTo(null);// vị trí hiển thị trung tâm
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// lệnh dừng khi tắt jframe
		frame.setVisible(true);//cho hiển thị trên màn hình
	}

}
