package travel_management;

public class Register {
	private Tour tour;
	private Trip trip;

	public Register(Tour tour, Trip trip) {
		super();
		this.tour = tour;
		this.trip = trip;
	}

	public Tour getTour() {
		return tour;
	}

	public Trip getTrip() {
		return trip;
	}

	
}
