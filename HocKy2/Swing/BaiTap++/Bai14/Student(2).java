package Bai14;

public class Student {
	public String name;
	public String sex;
	public Date date;
	public String favorite;

	public Student(String name, String sex, Date date, String favorite) {
		super();
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.favorite = favorite;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Họ tên: " + name + ", giới tính" + sex + ", ngày sinh" + date + ", sở thích" + favorite + ".";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

}
