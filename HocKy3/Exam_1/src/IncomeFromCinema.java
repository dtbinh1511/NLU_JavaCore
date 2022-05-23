
public class IncomeFromCinema {
	public String idCinema;
	public String nameCinema;
	public int income;

	public IncomeFromCinema(String idCinema, String nameCinema, int income) {
		super();
		this.idCinema = idCinema;
		this.nameCinema = nameCinema;
		this.income = income;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncomeFromCinema other = (IncomeFromCinema) obj;
		if (idCinema == null) {
			if (other.idCinema != null)
				return false;
		} else if (!idCinema.equals(other.idCinema))
			return false;
		if (income != other.income)
			return false;
		if (nameCinema == null) {
			if (other.nameCinema != null)
				return false;
		} else if (!nameCinema.equals(other.nameCinema))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "IncomeFromCinema [idCinema=" + idCinema + ", nameCinema=" + nameCinema + ", income=" + income + "]";
	}

	/**
	 * @return the income
	 */
	public int getIncome() {
		return income;
	}

}
