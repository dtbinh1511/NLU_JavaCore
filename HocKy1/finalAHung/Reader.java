package finalAHung;

public class Reader {
	private String name;
	private String email;
	private IRentItems rentItems;

	public Reader(String name, String email, IRentItems rentItems) {
		super();
		this.name = name;
		this.email = email;
		this.rentItems = rentItems;
	}

}
