package Task1_2;

public interface ILog {
	public String toString();

	public boolean equals(Object obj);
	
	public double totalMilesRun();
	
	public ILog allLogInTime(int month, int year);
	
	public double totalDistanceInMonth(int month, int year);
	
	public double maxDistance();
	
	public ILog sortByDistance();

	public ILog insertByDistance(Entry other);
}
