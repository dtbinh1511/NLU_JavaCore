package b1;

public class KySu extends CanBo {
	private String nghanhDaoTao;

	public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nghanhDaoTao) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.nghanhDaoTao = nghanhDaoTao;
	}

	public String getNgayDaoTao() {
		return nghanhDaoTao;
	}

	public void setNgayDaoTao(String nghanhDaoTao) {
		this.nghanhDaoTao = nghanhDaoTao;
	}

	@Override
	public String toString() {
		return super.toString() + "nghanhDaoTao: " + nghanhDaoTao;
	}

}
