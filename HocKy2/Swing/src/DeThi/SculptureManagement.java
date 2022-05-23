package DeThi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SculptureManagement extends JFrame {
	private JLabel title, artist, year, material, weight, height;
	private JTextField txTitle, txYear, txWeight, txHeight;
	String[] strArtist = { "Paige Bradley", "Fah Cheong", "Tom Frantzen", "Bruno Catalano" };
	private JComboBox jcbArtist = new JComboBox(strArtist);
	String[] strMaterial = { "Sáp", "Đồng", "Đá", "Gỗ", "Gốm", "Thạch Cao", "Xi măng" };
	private JComboBox jcbMaterial = new JComboBox(strMaterial);
	private JButton jbtAdd, jbtSort;
	private ImageIcon iAdd = new ImageIcon("ImageIcon/add.png");
	private ImageIcon iSort = new ImageIcon("ImageIcon/sort.png");
	Dimension dimText = new Dimension(130, 20);
	Dimension dimButton = new Dimension(105, 40);
	JScrollBar hBar = new JScrollBar(JScrollBar.HORIZONTAL, 50, 20, 0, 100);
	JScrollBar vBar = new JScrollBar(JScrollBar.VERTICAL, 50, 50, 0, 100);
	private JTextArea txa1, txa2, txa3;

	public SculptureManagement() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

		// panel1
		JPanel panel1 = new JPanel();
		add(panel1, BorderLayout.NORTH);
		JLabel label = new JLabel("QUẢN LÝ TÁC PHẨM ĐIÊU KHẮC");
		panel1.add(label);

		// panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2, 0, 15));
		add(panel, BorderLayout.CENTER);
		panel.add(title = new JLabel("Tên tác phẩm"));
		panel.add(txTitle = new JTextField(10));
		panel.add(artist = new JLabel("Tác giả"));
		panel.add(jcbArtist);
		panel.add(year = new JLabel("Năm sáng tác"));
		panel.add(txYear = new JTextField(10));
		panel.add(material = new JLabel("Vật liệu"));
		panel.add(jcbMaterial);
		panel.add(weight = new JLabel("Cân nặng"));
		panel.add(txWeight = new JTextField(10));
		panel.add(height = new JLabel("Chiều cao"));
		panel.add(txHeight = new JTextField(10));

		title.setPreferredSize(dimText);
		artist.setPreferredSize(dimText);
		year.setPreferredSize(dimText);
		weight.setPreferredSize(dimText);
		height.setPreferredSize(dimText);
		txTitle.setPreferredSize(dimText);
		txYear.setPreferredSize(dimText);
		txWeight.setPreferredSize(dimText);
		txHeight.setPreferredSize(dimText);
//panel2
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		add(panel2);
		panel2.add(jbtAdd = new JButton("Thêm", iAdd));
		panel2.add(jbtSort = new JButton("Sắp xếp", iSort));
		jbtAdd.setPreferredSize(dimButton);
		jbtSort.setPreferredSize(dimButton);

//panel3
		
		JPanel panel3 = new JPanel();
		add(panel3);
		panel3.setBorder(new TitledBorder("Thông tin về tác phẩm điêu khắc"));
//		panel3.add(hBar,BorderLayout.NORTH);
////		panel4.add(vBar,BorderLayout.WEST);
		txa1 = new JTextArea("1- Phụ nữ ngồi thiền \n2- Con người miền sông nước "
				+ "\n3- Bức tượng De Vaartkapoen\n4- Bức tượng sáp Expansion\n5- Không nguyên vẹn");
		txa2 = new JTextArea("Paige Bradley\n Fah Cheong \nTom Frantzen \nPaige Bradley\nBruno Catalano");
		txa3 = new JTextArea("Sáp\nĐồng\nĐồng\nSáp\nĐồng");
		
		txa1.setBackground(null);
		txa1.setEditable(false);
		txa2.setBackground(null);
		txa2.setEditable(false);
		txa3.setBackground(null);
		txa3.setEditable(false);
		panel3.add(txa1, BorderLayout.WEST);
		panel3.add(txa2, BorderLayout.CENTER);
		panel3.add(txa3, BorderLayout.EAST);
		
		
		// for jFrame
//		setSize(350, 500);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SculptureManagement();
	}
}
