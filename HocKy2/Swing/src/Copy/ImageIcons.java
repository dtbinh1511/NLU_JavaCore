package Copy;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageIcons extends JFrame {
	JLabel jl;

	public ImageIcons() {
		setLayout(new FlowLayout());
		ImageIcon iNorthHolland = new ImageIcon("ImageIcon/NorthHolland.png");
		
		
		add(jl=new JLabel(iNorthHolland));
		
	}

	public static void main(String[] args) {
		ImageIcons frame = new ImageIcons();
		frame.setTitle("Flag");
		frame.setSize(250, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
