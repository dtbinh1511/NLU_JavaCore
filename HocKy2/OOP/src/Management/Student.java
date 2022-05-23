package Management;

import java.util.ArrayList;

public class Student {
	private String nameStu;
	private String IDStu;
	private Date date;
	private ArrayList<Subject> listSub;

	public Student(String nameStu, String iDStu, Date date, ArrayList<Subject> listSub) {
		super();
		this.nameStu = nameStu;
		IDStu = iDStu;
		this.date = date;
		this.listSub = new ArrayList<Subject>();
	}

	public Student() {

	}

	public String getNameStu() {
		return nameStu;
	}

	public void setNameStu(String nameStu) {
		this.nameStu = nameStu;
	}

	public String getIDStu() {
		return IDStu;
	}

	public void setIDStu(String iDStu) {
		IDStu = iDStu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Subject> getListSub() {
		return listSub;
	}

	public void setListSub(ArrayList<Subject> listSub) {
		this.listSub = listSub;
	}

	@Override
	public String toString() {
//		return "nameStu: " + nameStu + ", IDStu:" + IDStu + ", điểm trung bình: " + this.avgGrade();

		return "nameStu: " + nameStu + ", IDStu:" + IDStu + ", date: " + date.toString() + ", listSub: " + listSub;
	}

	public double avgGrade() {
		double sum = 0;
		double avg = 0;
		for (int i = 0; i < listSub.size(); i++) {
			sum += listSub.get(i).getGrade();
		}
		avg = sum / listSub.size();
		return avg;
	}

	// thay đổi điểm
	public void changeGrade(double grade, String IDSub) {
		for (int i = 0; i < listSub.size(); i++) {
			if (listSub.get(i).getIDSub().equals(IDSub)) {
				listSub.get(i).setGrade(grade);
			}
		}
	}

}
