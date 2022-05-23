package object;

public class Game {
	private String name;
	private int numberOfPlayers;
	private String nationalProduction;

	public Game(String name, int numberOfPlayers, String nationalProduction) {
		this.name = name;
		this.numberOfPlayers = numberOfPlayers;
		this.nationalProduction = nationalProduction;
	}

	@Override
	public String toString() {
		return "Tên game: " + this.name + ", Số lượng người chơi: " + this.numberOfPlayers + ", Quốc gia sản xuất: "
				+ this.nationalProduction;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationalProduction == null) {
			if (other.nationalProduction != null)
				return false;
		} else if (!nationalProduction.equals(other.nationalProduction))
			return false;
		if (numberOfPlayers != other.numberOfPlayers)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Game g = new Game("League of legends", 10, "USA");
		System.out.println(g);
		System.out.println(g.equals(new Game("League of legends", 10, "USA")));
		System.out.println(g.equals(new Game("Flappy Bird", 1, "VietNam")));
	}
}
