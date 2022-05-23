package Task2_3;

public interface IList {

	@Override
	public String toString();

	public int howManyCredits();

	public double totalGrade();

	public double gradeAverage();

	public boolean equals(Object obj);

	public IList sortByGradeDec();

	public IList insertByGradeDec(GradeRecord that);

	public IList greaterThanList(double grade);
}
