package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

import list.MovieArrayList;
import object.Movie;
import object.Time;

public class MovieArrayListGUI extends JFrame implements ActionListener {
	/**
	 * phần mềm dùng để quản lý bộ sưu tập phim lẻ điền đầy đủ thông tin sau đó nhấn
	 * ADD để thêm vào bộ sưu tập hoặc nhấn REMOVE để xóa khỏi bộ sưu tập thông tin
	 * bộ sưu tập sẽ được hiển thị ở bên dưới
	 */
	private static final Dimension DIM_LB = new Dimension(100, 25);
	private static final Dimension DIM_TF = new Dimension(175, 25);
	private static final Dimension DIM_TIMETF = new Dimension(30, 25);

	private JLabel titleLb, nameLb, categoryLb, yearOfCretionLb, timeLb, hoursLb, minuteLb, secondsLb, filterLb;
	private JPanel titlePn, namePn, categoryPn, yearOfCreationPn, timePn, btPn, filterPn, displayPn;
	private JTextField nameTf, categoryTf, yearOfCreationTf, hoursTf, minuteTf, secondsTf, filterTf;
	private JButton addBt, removeBt, sortBt, filterBt, displayAllBt;
	private JTextArea headerTa, displayTa;

	private MovieArrayList movieArrayList;

	public MovieArrayListGUI() {
		movieArrayList = new MovieArrayList();
		creatList();
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		// add component
		add(titlePn = new JPanel());
		titlePn.add(titleLb = new JLabel("QUẢN LÝ PHIM LẺ"));
		titleLb.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));

		add(namePn = new JPanel());
		namePn.add(nameLb = new JLabel("Tên phim: "));
		nameLb.setPreferredSize(DIM_LB);
		namePn.add(nameTf = new JTextField());
		nameTf.setPreferredSize(DIM_TF);

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

		add(timePn = new JPanel());
		timePn.add(timeLb = new JLabel("Thời lượng: "));
		timeLb.setPreferredSize(DIM_LB);
		timePn.add(hoursTf = new JTextField());
		hoursTf.setPreferredSize(DIM_TIMETF);
		timePn.add(hoursLb = new JLabel("Giờ"));
		timePn.add(minuteTf = new JTextField());
		minuteTf.setPreferredSize(DIM_TIMETF);
		timePn.add(minuteLb = new JLabel("Phút"));
		timePn.add(secondsTf = new JTextField());
		secondsTf.setPreferredSize(DIM_TIMETF);
		timePn.add(secondsLb = new JLabel("Giây"));

		add(btPn = new JPanel());
		btPn.add(addBt = new JButton("Thêm"));
		btPn.add(removeBt = new JButton("Xóa"));
		btPn.add(sortBt = new JButton("Sắp xếp"));
		addBt.addActionListener(this);
		removeBt.addActionListener(this);
		sortBt.addActionListener(this);

		add(filterPn = new JPanel());
		filterPn.add(filterLb = new JLabel("Lọc theo năm: "));
		filterPn.add(filterTf = new JTextField());
		// chỗ này setPreferredSize(DIM_LB); tại vì kích thước của DIM_LB hợp với kích
		// thước cần
		filterTf.setPreferredSize(DIM_LB);
		filterPn.add(filterBt = new JButton("Lọc"));
		filterBt.addActionListener(this);
		filterPn.add(displayAllBt = new JButton("Hiển thị tất cả"));
		displayAllBt.addActionListener(this);

		add(displayPn = new JPanel());
		displayPn.setBorder(new TitledBorder("Thông tin phim lẻ"));
		displayPn.setLayout(new BorderLayout());
		displayPn.add(headerTa = new JTextArea(), BorderLayout.NORTH);
		headerTa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		headerTa.setEditable(false);
		headerTa.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		headerTa.setText("Tên phim\t\tThể loại\t\tThời lượng");
		displayPn.add(displayTa = new JTextArea(6, 0), BorderLayout.CENTER);
		displayTa.setFont(new Font(Font.DIALOG, Font.HANGING_BASELINE, 13));
		displayTa.setEditable(false);
		displayPn.add(new JScrollPane(displayTa));
		display();

		// frame
		setSize(500, 500);
		setTitle("Quản lý phim lẻ");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// tạo danh sách ban đầu
	public void creatList() {
		movieArrayList.add(new Movie("Hello World", "Viễn tưởng", 2019, new Time(1, 23, 00)));
		movieArrayList.add(new Movie("AK-47", "Hành động", 2020, new Time(1, 50, 00)));
		movieArrayList.add(new Movie("Your name", "Học đường", 2016, new Time(1, 46, 00)));
		movieArrayList.add(new Movie("Hoa mộc lan", "Hành động", 2020, new Time(1, 55, 8)));
	}

	// hiển thị
	public void display() {
		displayTa.setText(movieArrayList.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// tạo sự kiện thêm
		if (addBt == e.getSource()) {
			try {
				String name = nameTf.getText();
				String category = categoryTf.getText();
				int yearOfCreation = Integer.parseInt(yearOfCreationTf.getText());
				int hours = Integer.parseInt(hoursTf.getText());
				int minute = Integer.parseInt(minuteTf.getText());
				int seconds = Integer.parseInt(secondsTf.getText());
				if (yearOfCreation < 0 || hours < 0 || minute < 0 || seconds < 0)
					throw new NumberFormatException();
				Time time = new Time(hours, minute, seconds);
				Movie movie = new Movie(name, category, yearOfCreation, time);
				movieArrayList.add(movie);
				display();
				nameTf.setText("");
				categoryTf.setText("");
				yearOfCreationTf.setText("");
				hoursTf.setText("");
				minuteTf.setText("");
				secondsTf.setText("");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Có thông tin chưa nhập hoặc nhập sai!!!");
			}
		}
		// tạo sự kiện xóa
		if (removeBt == e.getSource()) {
			try {
				String name = nameTf.getText();
				String category = categoryTf.getText();
				int yearOfCreation = Integer.parseInt(yearOfCreationTf.getText());
				int hours = Integer.parseInt(hoursTf.getText());
				int minute = Integer.parseInt(minuteTf.getText());
				int seconds = Integer.parseInt(secondsTf.getText());
				if (yearOfCreation < 0 || hours < 0 || minute < 0 || seconds < 0)
					throw new NumberFormatException();
				Time time = new Time(hours, minute, seconds);
				Movie movie = new Movie(name, category, yearOfCreation, time);
				movieArrayList.remove(movie);
				display();
				nameTf.setText("");
				categoryTf.setText("");
				yearOfCreationTf.setText("");
				hoursTf.setText("");
				minuteTf.setText("");
				secondsTf.setText("");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Có thông tin chưa nhập hoặc nhập sai!!!");
			}
		}
		// tạo sự kiện sắp xếp
		if (sortBt == e.getSource()) {
			movieArrayList.sort(new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return o1.compareTo(o2);
				}
			});
			display();
		}
		// tạo sự kiện hiện thị theo chỉ tiêu năm
		if (filterBt == e.getSource()) {
			try {
				int yearCreation = Integer.parseInt(filterTf.getText());
				if (yearCreation < 0)
					throw new NumberFormatException();
				displayTa.setText(movieArrayList.listByCriteria(yearCreation).toString());
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
		new MovieArrayListGUI();
	}
}
