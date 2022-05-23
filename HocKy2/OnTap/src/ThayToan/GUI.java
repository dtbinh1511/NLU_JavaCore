package ThayToan;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {
	private JButton jbtThem, jbtXoa, jbtThoat;
	private JLabel lbTen, lbNgSinh, lbGioiTinh, lbLuong;
	private JTextField tfTen, tfNgSinh, tfGioiTinh, tfLuong;
	private JTextArea jta;
	private Dimension dim = new Dimension(120, 25);
	private String text = "Ten NV" + "\t\t" + "Ngày Sinh" + "\t" + "Giới tính" + "\t" + "Lương Cơ Bản" + "\n";
	private CongTyNhanSu nhanSu = new CongTyNhanSu();

	public GUI() {
		this.setLayout(new FlowLayout());
		add(createInfor());
		add(createButton());
		add(new JScrollPane(createFrameShow()));
		setJframe();
	}

	public static void main(String[] args) {
		new GUI();
	}

	public void setJframe() {
		setTitle("^0^");
		setSize(550, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JPanel createButton() {
		JPanel panel = new JPanel();
		panel.add(jbtThem = new JButton("Thêm"));
		panel.add(jbtXoa = new JButton("Xóa tất cả"));
		panel.add(jbtThoat = new JButton("Thoát"));
		jbtThem.addActionListener(this);
		jbtXoa.addActionListener(this);
		jbtThoat.addActionListener(this);
		jbtXoa.setEnabled(false);
		return panel;
	}

	public JPanel createInfor() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		//
		JPanel p1 = new JPanel();
		panel.add(p1);
		p1.add(lbTen = new JLabel("Tên Nhân Viên"));
		p1.add(tfTen = new JTextField(15));
		lbTen.setPreferredSize(dim);
		//
		JPanel p2 = new JPanel();
		panel.add(p2);
		p2.add(lbNgSinh = new JLabel("Ngày sinh"));
		p2.add(tfNgSinh = new JTextField(15));
		lbNgSinh.setPreferredSize(dim);
//
		JPanel p3 = new JPanel();
		panel.add(p3);
		p3.add(lbGioiTinh = new JLabel("Giới tính"));
		p3.add(tfGioiTinh = new JTextField(15));
		lbGioiTinh.setPreferredSize(dim);

//
		JPanel p4 = new JPanel();
		panel.add(p4);
		p4.add(lbLuong = new JLabel("Lương cơ bản"));
		p4.add(tfLuong = new JTextField(15));
		lbLuong.setPreferredSize(dim);

		return panel;
	}

	public JPanel createFrameShow() {
		JPanel panel = new JPanel();
		panel.add(jta = new JTextArea(text, 5, 35));
		jta.setEditable(false);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtThoat) {
			System.exit(0);
		}
		if (e.getSource() == jbtXoa) {
			jbtXoa.setEnabled(false);
			nhanSu.xoaNhanVien();
			//
			jta.setText("");
			jta.append(text);
			tfTen.setText("");
			tfNgSinh.setText("");
			tfGioiTinh.setText("");
			tfLuong.setText("");
			tfTen.requestFocus();
		}
		if (e.getSource() == jbtThem) {
			NhanVien nhanVien = new NhanVien(null, tfTen.getText(), tfNgSinh.getText(), tfGioiTinh.getText(),
					tfLuong.getText());
			if (tfTen.getText().equals("") || tfNgSinh.getText().equals("") || tfGioiTinh.getText().equals("")
					|| tfLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Dien day du thong tin");
			} else if (nhanSu.danhSachNhanVien.contains(nhanVien)) {
				JOptionPane.showMessageDialog(this, "Nhan Vien da ton tai");
			} else {
				nhanSu.themNhanVien(nhanVien);
				jbtXoa.setEnabled(true);
				jta.setText("");
				jta.append(text);
				for (int i = 0; i < nhanSu.danhSachNhanVien.size(); i++) {
					if (nhanSu.danhSachNhanVien.get(i).getTenNV().length() >= 15) {
						jta.append(nhanSu.danhSachNhanVien.get(i).getTenNV() + "\t"
								+ nhanSu.danhSachNhanVien.get(i).getNgaySinh() + "\t"
								+ nhanSu.danhSachNhanVien.get(i).getGioiTinh() + "\t"
								+ nhanSu.danhSachNhanVien.get(i).getLuongCoban() + "\n");
					} else if (nhanSu.danhSachNhanVien.get(i).getTenNV().length() < 14) {
						jta.append(nhanSu.danhSachNhanVien.get(i).getTenNV() + "\t\t"
								+ nhanSu.danhSachNhanVien.get(i).getNgaySinh() + "\t"
								+ nhanSu.danhSachNhanVien.get(i).getGioiTinh() + "\t"
								+ nhanSu.danhSachNhanVien.get(i).getLuongCoban() + "\n");
					}
				}
				tfTen.setText("");
				tfNgSinh.setText("");
				tfGioiTinh.setText("");
				tfLuong.setText("");
				tfTen.requestFocus();
			}
		}
	}
}
