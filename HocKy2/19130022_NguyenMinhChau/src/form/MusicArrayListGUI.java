package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import list.MusicArrayList;
import object.Music;

public class MusicArrayListGUI extends JFrame implements ActionListener {
	/**
	 * phần mềm dùng để quản lý bộ sưu tập âm nhạc điền đầy đủ thông tin sau đó nhấn
	 * ADD để thêm vào bộ sưu tập hoặc nhấn REMOVE để xóa bài hát ra khỏi bộ sưu tập
	 * thông tin bộ sưu tập âm nhạc sẽ hiển thị bên dưới
	 */
	private static final Dimension DIM_LB = new Dimension(100, 25);
	private static final Dimension DIM_TF = new Dimension(175, 25);
	private static final Dimension DIM_TIMETF = new Dimension(30, 25);

	private JLabel titleLb, nameMusicLb, categoryLb, yearOfCretionLb, musicanNameLb, filterLb;
	private JPanel titlePn, nameMusicPn, categoryPn, yearOfCreationPn, musicanNamePn, btPn, displayPn, filterPn;
	private JTextField nameMusicTf, categoryTf, yearOfCreationTf, musicanNameTf, filterTf;
	private JButton addBt, removeBt, sortBt, filterBt, displayAllBt;
	private JTextArea headerTa, displayTa;

	private MusicArrayList musicArrayList;

	public MusicArrayListGUI() {
		musicArrayList = new MusicArrayList();
		creatList();
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		// add các component
		add(titlePn = new JPanel());
		titlePn.add(titleLb = new JLabel("QUẢN LÝ ÂM NHẠC"));
		titleLb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		add(nameMusicPn = new JPanel());
		nameMusicPn.add(nameMusicLb = new JLabel("Tên bài hát: "));
		nameMusicLb.setPreferredSize(DIM_LB);
		nameMusicPn.add(nameMusicTf = new JTextField());
		nameMusicTf.setPreferredSize(DIM_TF);

		add(categoryPn = new JPanel());
		categoryPn.add(categoryLb = new JLabel("Thể loại: "));
		categoryLb.setPreferredSize(DIM_LB);
		categoryPn.add(categoryTf = new JTextField());
		categoryTf.setPreferredSize(DIM_TF);

		add(yearOfCreationPn = new JPanel());
		yearOfCreationPn.add(yearOfCretionLb = new JLabel("Năm sản xuất: "));
		yearOfCretionLb.setPreferredSize(DIM_LB);
		yearOfCreationPn.add(yearOfCreationTf = new JTextField());
		yearOfCreationTf.setPreferredSize(DIM_TF);

		add(musicanNamePn = new JPanel());
		musicanNamePn.add(musicanNameLb = new JLabel("Nhạc sĩ: "));
		musicanNameLb.setPreferredSize(DIM_LB);
		musicanNamePn.add(musicanNameTf = new JTextField());
		musicanNameTf.setPreferredSize(DIM_TF);

		add(btPn = new JPanel());
		btPn.add(addBt = new JButton("Thêm"));
		btPn.add(removeBt = new JButton("Xóa"));
		btPn.add(sortBt = new JButton("Sắp xếp"));
		addBt.addActionListener(this);
		removeBt.addActionListener(this);
		sortBt.addActionListener(this);

		add(filterPn = new JPanel());
		filterPn.add(filterLb = new JLabel("Lọc theo năm:"));
		filterLb.setPreferredSize(DIM_LB);
		filterPn.add(filterTf = new JTextField());
		// chỗ này setPreferredSize(DIM_LB); tại vì kích thước của DIM_LB hợp với kích
		// thước cần
		filterTf.setPreferredSize(DIM_LB);
		filterPn.add(filterBt = new JButton("Lọc"));
		filterBt.addActionListener(this);
		filterPn.add(displayAllBt = new JButton("Hiển thị tất cả"));
		displayAllBt.addActionListener(this);

		add(displayPn = new JPanel());
		displayPn.setBorder(new TitledBorder("Thông tin âm nhạc"));
		displayPn.setLayout(new BorderLayout());
		displayPn.add(headerTa = new JTextArea(), BorderLayout.NORTH);
		headerTa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		headerTa.setEditable(false);
		headerTa.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		headerTa.setText("Tên bài hát\t\tThể loại\t\tNhạc sĩ");
		displayPn.add(displayTa = new JTextArea(6, 0), BorderLayout.CENTER);
		displayTa.setFont(new Font(Font.DIALOG, Font.HANGING_BASELINE, 13));
		displayTa.setEditable(false);
		displayPn.add(new JScrollPane(displayTa));
		display();

		// frame
		setSize(500, 525);
		setTitle("Quản lý âm nhạc");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// tạo danh sách ban đầu
	public void creatList() {
		musicArrayList.add(new Music("Chắc ai đó sẽ về", "Pop", 2015, "Sơn tùng mtp"));
		musicArrayList.add(new Music("Chắc vì mình chưa tốt", "Pop", 2020, "Thanh Hưng"));
		musicArrayList.add(new Music("Ai mang cô đơn đi", "Pop", 2020, "K-ICM"));
	}

	// hiển thị
	public void display() {
		displayTa.setText(musicArrayList.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// tạo sự kiện thêm
		if (addBt == e.getSource()) {
			try {
				String nameMusic = nameMusicTf.getText();
				String category = categoryTf.getText();
				int yearOfCreation = Integer.parseInt(yearOfCreationTf.getText());
				if (yearOfCreation < 0)
					throw new NumberFormatException();
				String musicianName = musicanNameTf.getText();
				Music music = new Music(nameMusic, category, yearOfCreation, musicianName);
				musicArrayList.add(music);
				display();
				nameMusicTf.setText("");
				categoryTf.setText("");
				yearOfCreationTf.setText("");
				musicanNameTf.setText("");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Có thông tin chưa nhập hoặc nhập sai!!!");
			}
		}
		// tạo sự kiện xóa
		if (removeBt == e.getSource()) {
			try {
				String nameMusic = nameMusicTf.getText();
				String category = categoryTf.getText();
				int yearOfCreation = Integer.parseInt(yearOfCreationTf.getText());
				if (yearOfCreation < 0)
					throw new NumberFormatException();
				String musicianName = musicanNameTf.getText();
				Music music = new Music(nameMusic, category, yearOfCreation, musicianName);
				musicArrayList.remove(music);
				display();
				nameMusicTf.setText("");
				categoryTf.setText("");
				yearOfCreationTf.setText("");
				musicanNameTf.setText("");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Có thông tin chưa nhập hoặc nhập sai!!!");
			}
		}
		// tạo sự kiện sắp xếp
		if (sortBt == e.getSource()) {
			musicArrayList.sort(new Comparator<Music>() {
				@Override
				public int compare(Music o1, Music o2) {
					return o1.compareTo(o2);
				}
			});
			display();
		}
		// tạo sự kiện hiển thị theo tiêu chí
		if (filterBt == e.getSource()) {
			try {
				int yearCreation = Integer.parseInt(filterTf.getText());
				if (yearCreation < 0)
					throw new NumberFormatException();
				displayTa.setText(musicArrayList.listByCriteria(yearCreation).toString());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Năm chỉ được nhập số lớn hơn hoặc bằng 0");
			}
		}
		//hiển thị đầy đủ
		if (displayAllBt == e.getSource()) {
			display();
			filterTf.setText("");
		}
	}

	public static void main(String[] args) {
		new MusicArrayListGUI();
	}
}
