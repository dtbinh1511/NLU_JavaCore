package b1;

import java.util.ArrayList;

public class QuanLyCanBo {
	private ArrayList<CanBo> list;

	public QuanLyCanBo() {
		super();
		this.list = new ArrayList<>();
	}

//	Thêm mới cán bộ.
	public boolean themCanBo(CanBo cb) {
		return list.add(cb);
	}

//	Tìm kiếm theo họ tên.
	public ArrayList<CanBo> timKiem(String hoTen) {
		ArrayList<CanBo> res = new ArrayList<>();
		for (CanBo canBo : list) {
			if (canBo.getHoTen().contains(hoTen))
				res.add(canBo);
		}

		return res;
	}

//	Hiện thị thông tin về danh sách các cán bộ.
	public String printList() {
		StringBuilder builder = new StringBuilder();
		for (CanBo canBo : list) {
			builder.append(canBo.toString() + "\n");
		}

		return builder.toString();
	}

//	Thoát khỏi chương trình.
}
