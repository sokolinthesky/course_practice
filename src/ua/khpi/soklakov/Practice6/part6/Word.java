package ua.khpi.soklakov.Practice6.part6;

/**
 * Class represents word.
 * 
 * @author Eugene Jurkov.
 *
 */
public class Word {
	
	/**
	 * Name word.
	 */
	private String name;
	
	/**
	 * Constructor class Word.
	 * 
	 * @param name word.
	 */
	public Word(String name){
		this.name = name;
	}
	
	/**
	 * Returned name of word.
	 * 
	 * @return	name of word.
	 */
	public String getName(){
		return name;
	}
}
