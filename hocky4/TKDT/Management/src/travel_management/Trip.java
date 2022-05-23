package travel_management;

import java.util.Date;

public class Trip {
	private Date dateStart;

	public Trip(Date dateStart) {
		super();
		this.dateStart = dateStart;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public int getDate() {
		Date now = new Date();
		long duration = dateStart.getTime() - now.getTime();
		if (duration < 0)
			return 0;
		long registerDay = duration / (24 * 3600000);
		if (duration % (24 * 3600000) > 2 * 3600000)
			registerDay++;
		return (int) registerDay;
	}

}
