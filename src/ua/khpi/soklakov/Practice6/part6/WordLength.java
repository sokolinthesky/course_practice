package ua.khpi.soklakov.Practice6.part6;

public class WordLength extends Word 
				implements Comparable<WordLength>{
	private Integer length;
	
	public WordLength(String name){
		super(name);
		length = name.length();
	}
	
	public int getLength(){
		return length;
	}

	@Override
	public int compareTo(WordLength word) {
		return length.compareTo(word.getLength());
	}
}
