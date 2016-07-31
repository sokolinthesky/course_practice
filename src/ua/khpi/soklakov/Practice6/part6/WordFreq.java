package ua.khpi.soklakov.Practice6.part6;

/**
 * Class represent word frequency.
 * 
 * @author Oleg Soklakov
 *
 */
public class WordFreq extends Word implements Comparable<WordFreq> {
	private Integer frequency;

	/**
	 * Init fields.
	 * 
	 * @param name
	 *            specified name.
	 * @param frequency
	 *            specified frequency.
	 */
	public WordFreq(String name, int frequency) {
		super(name);
		this.frequency = frequency;
	}

	public void setFrequency(int n) {
		frequency = n;
	}

	public Integer getFrequency() {
		return frequency;
	}

	@Override
	public int compareTo(WordFreq word) {
		return frequency.compareTo(word.getFrequency());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		WordFreq other = (WordFreq) obj;
		if (frequency == null) {
			if (other.frequency != null) {
				return false;
			}
		} else if (!frequency.equals(other.frequency)) {
			return false;
		}
		return true;
	}

}
