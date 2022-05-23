package bt1;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	private String nameStu;
	private Date dateOfBirth;
	private Teacher teacher;
	private ArrayList<Register> registers = new ArrayList<>();

	public Student(String nameStu, Date dateOfBirth) {
		super();
		this.nameStu = nameStu;
		this.dateOfBirth = dateOfBirth;

	}

	public String getNameStu() {
		return nameStu;
	}

	public void setNameStu(String nameStu) {
		this.nameStu = nameStu;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(ArrayList<Register> registers) {
		this.registers = registers;
	}

	public boolean registerSub(Subject s) {
		return registers.add(new Register(s));
	}

	public boolean unregisterSub(Subject s) {
		for (Register r : registers) {
			if (r.getSubjects().getNameSub().equalsIgnoreCase(s.getNameSub())) {
				registers.remove(r);
				return true;
			}
		}
		return false;
	}

	public boolean updateScore(Subject subject, double score) {
		for (Register r : registers) {
			if (r.getSubjects().getNameSub().equalsIgnoreCase(subject.getNameSub())) {
				r.setScore(score);
				return true;
			}
		}
		return false;
	}

	public double avgScore() {
		double res = 0;
		int sumCredit = 0;
		for (Register r : registers) {
			sumCredit += r.getSubjects().getCredit();
			res += r.getScore() * r.getSubjects().getCredit();
		}
		return res / sumCredit;
	}

	public String rank() {
		double avg = avgScore();
		String res = "";
		if (avg >= 9) {
			res = "Xuat sac";
		} else if (avg >= 8) {
			res = "Gioi";
		} else if (avg >= 7) {
			res = "Kha";
		} else if (avg >= 6) {
			res = "Trung binh Kha";
		} else if (avg >= 5) {
			res = "Trung binh";
		} else {
			res = "rot";
		}
		return res;
	}

	public String show() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: " + getNameStu() + "\n");
		builder.append("Ngay sinh: " + getDateOfBirth() + "\n");
		builder.append("STT\t\tMon\tDiem\n");
		for (int i = 0; i < registers.size(); i++) {
			builder.append(i + "\t\t" + registers.get(i).getSubjects().getNameSub() + "\t" + registers.get(i).getScore()
					+ "\n");
		}
		builder.append("Diem tb: " + avgScore());
		builder.append("Xep loai: " + rank());
		return builder.toString();
	}
}
