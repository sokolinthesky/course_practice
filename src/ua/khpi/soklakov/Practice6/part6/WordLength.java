package ua.khpi.soklakov.Practice6.part6;

/**
 * Class represent word length.
 * 
 * @author Oleg Soklakov
 *
 */
public class WordLength extends Word implements Comparable<WordLength> {
	private Integer length;

	/**
	 * Init fields.
	 * 
	 * @param name
	 *            specified name.
	 * @param frequency
	 *            specified frequency.
	 */
	public WordLength(String name) {
		super(name);
		length = name.length();
	}

	public int getLength() {
		return length;
	}

	@Override
	public int compareTo(WordLength word) {
		return length.compareTo(word.getLength());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((length == null) ? 0 : length.hashCode());
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
		WordLength other = (WordLength) obj;
		if (length == null) {
			if (other.length != null) {
				return false;
			}
		} else if (!length.equals(other.length)) {
			return false;
		}
		return true;
	}

}
