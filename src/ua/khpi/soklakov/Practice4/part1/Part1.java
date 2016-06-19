package ua.khpi.soklakov.Practice4.part1;

import ua.khpi.soklakov.Practice4.ReaderFromFile;

/**
 * This class converts a string from a file.
 * 
 * @author Eugene Jurkov
 *
 */
public class Part1 {
	
	/**
	 * String which store strings read from file.
	 */
	private String stringFromFile;
	
	/**
	 * Constructor this class which create file and read strings from 
	 * file write to stringFromFile. 
	 * 
	 * @param pathFile to file.
	 * @param nameFile name of file.
	 */
	public Part1(String str){
		stringFromFile = str;
	}
	
	/**
	 * This method upper case words if length of words more 3.
	 * At first it split String.
	 * Iterate by array of String and validate length of String.   
	 * If condition true add to result string with in upper case.
	 * Else add to result string without changes.
	 * 
	 * @return String sorted by condition.
	 */
	public String toUpperCaseWords(){
		String[] words = stringFromFile.split(" ");
		
		String result = "";
		
		for(String word : words){
			
			if(word.length() >= 4){
				word = word.toUpperCase();
				result = result + word + " ";
			}
			else{
				result = result + word + " ";
			}
		}
		return result;
	}
	
	/**
	 * Test main.
	 * 
	 * @param args test.
	 */
	public static void main(String[] args){
		String testTxt = ReaderFromFile.getStringFromFile("src/", "part1.txt");	
		
		Part1 p1 = new Part1(testTxt);
		
		System.out.println(p1.toUpperCaseWords());
	}
}
