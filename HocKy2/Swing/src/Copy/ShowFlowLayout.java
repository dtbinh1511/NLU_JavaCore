package Copy;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShowFlowLayout extends JFrame {
	// constructor
	public ShowFlowLayout() {
		setLayout(new FlowLayout(FlowLayout.LEFT,12,25)); 
		// hgap 12 : cách bên trái 12 ô
		// vgao 25: cách trên 25 ô
		
		add(new JLabel("First name")); // tạo ô
		add(new JTextField(8)); // tạo độ dài của ô
		add(new JLabel("MI"));// tạo ô
		add(new JTextField(1));// tạo độ dài ô
		add(new JLabel("Last name")); // tạo ô
		add(new JTextField(8));// tạo độ dài ô
		
	}

	public static void main(String[] args) {
		ShowFlowLayout frame = new ShowFlowLayout();
		frame.setTitle("Show Flow Layout");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
