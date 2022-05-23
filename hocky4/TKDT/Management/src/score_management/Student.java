package score_management;

import java.util.*;

public class Student {
	private String name;
	private Date dateOfBirth;
	private Lecturer lecture;
	private List<Register> registers = new ArrayList<Register>();

	public Student(String name, Date dateOfBirth) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	// getter

	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	// register course
	public void register(Course course) {
		registers.add(new Register(course, 0));
	}

	// update score
	public void updateScore(Course course, double score) {
		for (Register register : registers) {
			if (register.getCoure().getNameSub().equals(course.getNameSub()))
				register.setScore(score);
		}
	}

	// calculation average
	public double average() {
		double totalScore = 0;
		int totalCredit = 0;
		for (Register register : registers) {
			totalScore += register.getScore() * register.getCoure().getCredits();
			totalCredit += register.getCoure().getCredits();
		}
		return totalScore / totalCredit;
	}

	// Ratings graduate

	public String ratingGraduate() {
		String rank = "";
		double avg = average();
		if (avg > 9)
			rank = "High Distinction";
		if (avg > 8)
			rank = "Distinction";
		if (avg > 7)
			rank = "Credit";
		if (avg > 6)
			rank = "Strong Pass";
		if (avg > 5)
			rank = "Pass";
		if (avg < 5)
			rank = "Fail";
		return rank;
	}

	//
	public String statement() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: " + getName());
		builder.append("\nDate of birth: " + getDateOfBirth());
		builder.append("\nSTT\tNameCourse\t\t\tScore");
		for (int i = 0; i < registers.size(); i++) {
			builder.append("\n" + (i + 1) + "\t" + registers.get(i).getCoure().getNameSub() + "\t\t"
					+ registers.get(i).getScore());
		}
		builder.append("\nAverage Graduate: " + average() + "\n");
		builder.append("Ratings Graduate: " + ratingGraduate() + "\n");
		return builder.toString();
	}
}
