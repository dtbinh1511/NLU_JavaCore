package NK4;

public class Manufactor {
	private String companyName;
	private String country;

	public Manufactor(String companyName, String country) {
		this.companyName = companyName;
		this.country = country;
	}
// kiểm tra xem có là một quốc gia hay không?
	public boolean inCountry(String country) {
		return this.country.equals(country);
	}

}
