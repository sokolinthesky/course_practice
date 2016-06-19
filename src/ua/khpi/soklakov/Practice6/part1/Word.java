package ua.khpi.soklakov.Practice6.part1;

import java.util.Comparator;

public class Word {
	private static final int DEFAULT_FREQUENCY = 1; 

	private String word;
	private Integer frequency = DEFAULT_FREQUENCY;

	public Word(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public void increm() {
		frequency++;
	}

	@Override
	public String toString() {
		return word + ": " + frequency;
	}

	static Comparator<Word> snorderer = new Comparator<Word>() {

		public int compare(Word o1, Word o2) {
			if(!o1.getFrequency().equals(o2.getFrequency()) ) {
				return o1.getFrequency().compareTo(o2.getFrequency());
			} else {
				return o2.getWord().compareTo(o1.getWord());
			}
			
		}
	};

}
