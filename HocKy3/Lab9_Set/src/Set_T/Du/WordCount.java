package Set_T.Du;

public class WordCount {
	private String word;
	private int count;

	protected WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	public String toString() {
		return word + "-" + count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordCount other = (WordCount) obj;
		if (count != other.count)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

}
