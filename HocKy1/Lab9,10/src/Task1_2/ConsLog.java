package Task1_2;

public class ConsLog implements ILog {
	protected Entry first;
	protected ILog rest;

	public ConsLog(Entry first, ILog rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

//check whether two lists are equals or not
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConsLog))
			return false;
		else {
			ConsLog other = (ConsLog) obj;
			return this.first.equals(other.first) && this.rest.equals(other.rest);
		}

	}

//  compute the total number of miles run
	@Override
	public double totalMilesRun() {
		return this.first.MilesRun() + this.rest.totalMilesRun();
	}

	@Override
	public ILog allLogInTime(int month, int year) {
		if (this.first.sameDate(month, year))

			return new ConsLog(this.first, this.rest.allLogInTime(month, year));
		else
			return this.rest.allLogInTime(month, year);
	}

	// compute distance run in a given month

	@Override
	public double totalDistanceInMonth(int month, int year) {
		return this.allLogInTime(month, year).totalMilesRun();

	}
	

//the maximum distance ever run
	@Override
	public double maxDistance() {
		if (this.first.MilesRun() > this.rest.maxDistance())
			return this.first.MilesRun();
		else
			return this.rest.maxDistance();
	}
	// according to the distance covered in each run, from the shortest to the
	// longest distance

	@Override
	public ILog sortByDistance() {
		return this.rest.sortByDistance().insertByDistance(first);
	}

	@Override
	public ILog insertByDistance(Entry other) {
		if (this.first.lessThan(other))
			return new ConsLog(this.first, this.rest.insertByDistance(other));
		else
			return new ConsLog(other, new ConsLog(first, rest));
	}

}