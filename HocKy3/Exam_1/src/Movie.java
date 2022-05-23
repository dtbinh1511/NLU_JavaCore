import java.util.Arrays;

public class Movie {
	public String id;
	public String name;
	public String directorName;
	public int expenses;
	public IncomeFromCinema[] incomeArray;

	public Movie(String id, String name, String directorName, int expenses, IncomeFromCinema[] incomeArray) {
		super();
		this.id = id;
		this.name = name;
		this.directorName = directorName;
		this.expenses = expenses;
		this.incomeArray = incomeArray;
	}

	public Movie() {
		super();
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", directorName=" + directorName + ", expenses=" + expenses
				+ ", incomeArray=" + Arrays.toString(incomeArray) + "]";
	}

	public int tottalIncome() {
		int sum = 0;
		for (int i = 0; i < incomeArray.length; i++) {
			sum += incomeArray[i].getIncome();
		}
		return sum;
	}

// interest = tổng doanh thu - kinh phí
	public int interest() {
		return tottalIncome() - expenses;
	}

	public IncomeFromCinema[] sortIncomArrayByBubbleSort() {
		for (int i = 0; i < incomeArray.length - 1; i++) {
			for (int j = 0; j < incomeArray.length - 1 - i; j++) {
				if (incomeArray[j].getIncome() > incomeArray[j + 1].getIncome()) {
					IncomeFromCinema temp = incomeArray[j];
					incomeArray[j] = incomeArray[j + 1];
					incomeArray[j + 1] = temp;
				}
			}
		}
		return incomeArray;
	}

	public static void main(String[] args) {
		IncomeFromCinema i1 = new IncomeFromCinema("01", "Mắt biếc", 800);
		IncomeFromCinema i2 = new IncomeFromCinema("02", "Ròm", 200);
		IncomeFromCinema i3 = new IncomeFromCinema("03", "Hai Phượng", 800);
		IncomeFromCinema[] cinemas = { i2, i1, i3 };

		Movie movie = new Movie("01", "Rạp", "Abc", 1000, cinemas);

		System.out.println(movie.tottalIncome());
		System.out.println(movie.interest());
		System.out.println(Arrays.toString(movie.sortIncomArrayByBubbleSort()));
	}
}
