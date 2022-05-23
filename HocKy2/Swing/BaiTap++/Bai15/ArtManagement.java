package Bai15;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ArtManagement extends JPanel implements ActionListener {
	private JLabel jlTitle, jlName, jlYear, jlCategory, jlStyle, jlAuthor;
	private JButton jbtAdd, jbtArrange, jbtExit;
	private JTextField txTitle, txYear;
	private ArrayList<Painting> listArt = new ArrayList<Painting>();
	private ImageIcon iAdd, iArrange, iExit;
	private JTextArea jta = new JTextArea();
	String[] category = { "Sơn dầu", "Sơn mài", "Gốm", "Đơn sắc", "Men", "Thủy tinh" };
	String[] style = { "Hiện đại", "Trừu tượng", "Không rõ" };
	String[] material = { "Đá", "Đồng", "Gỗ", "Gốm", "Thạch cao", "Xi măng", "Sáp" };
	String[] author = { "Bruno Catalano", "Paige Bradley", "Fah Cheong", "Tom Frantzen", "Bùi Xuân Phái" };
	JComboBox<String> jcbCategory = new JComboBox<String>(category);
	JComboBox<String> jcbStyle = new JComboBox<String>(style);
	JComboBox<String> jcbMaterial = new JComboBox<String>(material);
	JComboBox<String> jcbAuthor = new JComboBox<String>(author);
	Dimension dim = new Dimension(300, 200);

	public ArtManagement() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(createTitle());
		add(createLable());
		add(createButton());
		add(new JScrollPane(createList()));
	}

	public JPanel createTitle() {
		JPanel panel = new JPanel();
		panel.add(jlTitle = new JLabel("QUẢN LÝ TÁC PHẨM HỘI HỌA"));
		return panel;
	}

	public JPanel createLable() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2, 5, 5));
		panel.add(jlName = new JLabel("Tên tác phẩm:"));
		panel.add(txTitle = new JTextField(15));
		panel.add(jlYear = new JLabel("Năm sáng tác:"));
		panel.add(txYear = new JTextField(15));
		panel.add(jlCategory = new JLabel("Loại tranh:"));
		panel.add(jcbCategory);
		panel.add(jlStyle = new JLabel("Phong cách:"));
		panel.add(jcbStyle);
		panel.add(jlName = new JLabel("Tác giả:"));
		panel.add(jcbAuthor);
		panel.setPreferredSize(dim);
		return panel;
	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		iAdd = new ImageIcon("ImageIcon/add.png");
		iArrange = new ImageIcon("ImageIcon/sort.png");
		iExit = new ImageIcon("ImageIcon/exit.png");
		panel.add(jbtAdd = new JButton("Thêm", iAdd));
		panel.add(jbtArrange = new JButton("Sắp xếp", iArrange));
		panel.add(jbtExit = new JButton("Thoát", iExit));

		// event
		jbtAdd.addActionListener(this);
		jbtArrange.addActionListener(this);
		jbtExit.addActionListener(this);

		return panel;
	}

	public JPanel createList() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Thông tin về tác phẩm hội họa"));
		panel.add(jta);
		jta.setSize(new Dimension(500, 200));
//		jta.setLayout(new BorderLayout(0,0));
		jta.setEnabled(false);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtAdd) {
			if (txTitle.getText().equals("")) {
				JOptionPane.showMessageDialog(jbtAdd, "Chưa nhập tên tác phẩm");
			} else if (txYear.getText().equals("")) {
				JOptionPane.showMessageDialog(jbtAdd, "Chưa nhập năm");
			} else {
				Painting paint = new Painting(author[jcbAuthor.getSelectedIndex()], txTitle.getText(), null,
						Integer.parseInt(txYear.getText()), category[jcbCategory.getSelectedIndex()],
						style[jcbStyle.getSelectedIndex()]);
				listArt.add(paint);

			}
			jta.setText("");
			for (int i = 0; i < listArt.size(); i++) {
				jta.append((i + 1) + " --" + listArt.get(i).getTitle() + "\t" + listArt.get(i).getYear() + "\t"
						+ listArt.get(i).getPaintType() + "\t" + listArt.get(i).getStyle() + "\t"
						+ listArt.get(i).getArtist() + "\n");
			}

			txTitle.setText("");
			txYear.setText("");
			txTitle.requestFocus();
		}
		if (e.getSource() == jbtArrange) {
			Collections.sort(listArt, new Comparator<Painting>() {

				@Override
				public int compare(Painting o1, Painting o2) {
					return o1.getTitle().compareToIgnoreCase(o2.getTitle());
				}

			});
			jta.setText("");
			for (int i = 0; i < listArt.size(); i++) {
				jta.append((i + 1) + " --" + listArt.get(i).getTitle() + "\t" + listArt.get(i).getYear() + "\t"
						+ listArt.get(i).getPaintType() + "\t" + listArt.get(i).getStyle() + "\t"
						+ listArt.get(i).getArtist() + "\n");
			}
		}
		if (e.getSource() == jbtExit) {
			System.exit(0);
		}
	}

}
