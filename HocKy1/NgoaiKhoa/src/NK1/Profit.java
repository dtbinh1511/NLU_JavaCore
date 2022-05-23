package NK1;

public class Profit {
	private int numberCustormer;
	private int numberPerformance;

	public Profit(int numberCustormer, int numberPerformance) {
		super();
		this.numberCustormer = numberCustormer;
		this.numberPerformance = numberPerformance;

	}
// Tổng lợi nhuận mà rạp hát thu được

	public double totalProfit() {
		return (this.numberCustormer * 5 - this.numberPerformance * 20 - 0.5 * this.numberCustormer);
	}
}
