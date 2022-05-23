package T.Du;

public class Publication {
	private String title;
	private String journal;
	private int pubYear;
	private int grade;

	public Publication(String title, String journal, int pubYear, int grade) {
		super();
		this.title = title;
		this.journal = journal;
		this.pubYear = pubYear;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Publication [title=" + title + ", journal=" + journal + ", pubYear=" + pubYear + ", grade=" + grade
				+ "\n";
	}

	public int getGrade() {
		return grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((journal == null) ? 0 : journal.hashCode());
		result = prime * result + pubYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publication other = (Publication) obj;
		if (grade != other.grade)
			return false;
		if (journal == null) {
			if (other.journal != null)
				return false;
		} else if (!journal.equals(other.journal))
			return false;
		if (pubYear != other.pubYear)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
