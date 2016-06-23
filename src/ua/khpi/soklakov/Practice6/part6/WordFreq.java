package ua.khpi.soklakov.Practice6.part6;

/**
 * 
 * 
 * @author JAVA__)
 *
 */
public class WordFreq extends Word 
					implements Comparable<WordFreq>{
	private Integer frequency;
	
	public WordFreq(String name, int frequency){
		super(name);
		this.frequency = frequency ;
	}
	
	public void setFrequency(int n){
		frequency = n;
	}
	
	public Integer getFrequency(){
		return frequency;
	}

	@Override
	public int compareTo(WordFreq word) {
		return frequency.compareTo(word.getFrequency());
	}
}
