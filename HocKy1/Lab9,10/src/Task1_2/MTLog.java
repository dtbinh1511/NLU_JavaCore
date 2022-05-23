package Task1_2;

public class MTLog implements ILog {
	public String toString() {
		return "";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTLog))
			return false;
		return true;
	}

	@Override
	public double totalMilesRun() {
		return 0;
	}

	@Override
	public ILog allLogInTime(int month, int year) {
		return new MTLog();
	}

	@Override
	public double totalDistanceInMonth(int month, int year) {
		return 0.0 ;
	}

	@Override
	public double maxDistance() {
		return 0.0;
	}

	@Override
	public ILog sortByDistance() {
		return new MTLog();
	}

	@Override
	public ILog insertByDistance(Entry other) {
		return new ConsLog(other, new MTLog());
	}
}
