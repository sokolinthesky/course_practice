package ua.khpi.soklakov.Practice6.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class parse text file by frequency, 
 * length and duplicates word.
 * 
 * @author Eugene Jurkov
 *
 */
public class Part6 {
	
	/**
	 * Returned the most frequency three word in the text.
	 * 
	 * @param pathFile path to file.
	 * @return the most frequency word in the text.
	 */
	public List<WordFreq> frequency(String pathFile){
		String textFile = ReaderFromFile.getStringFromFile(pathFile);
		
		List<WordFreq> words = new ArrayList<WordFreq>();
	
		List<String> stringsTextFile = getString("([A-Za-z])+", textFile);
		
		for(String str : stringsTextFile){
			int freq = Collections.frequency(stringsTextFile, str);
			
			words.add(new WordFreq(str, freq));
		}
		
		Set<WordFreq> sortWordsByFrequency = new TreeSet<WordFreq>(words);
		
		WordFreq[] r = new WordFreq[sortWordsByFrequency.size()];
		sortWordsByFrequency.toArray(r);
		
		List<WordFreq> result = lastNWords(3, r);
		
		Collections.sort(result, new Comparator<WordFreq>(){

			@Override
			public int compare(WordFreq word1, WordFreq word2) {
				return word1.getName().compareToIgnoreCase(word2.getName());
			}
			
		});
		
		Collections.reverse(result);
		
		return result;
	}
	
	
	/**
	 * Returned the biggest length three word in the text.
	 * 
	 * @param pathFile path to file.
	 * @return the biggest length three word in the text.
	 */
	public List<WordLength> length(String pathFile){
		String textFile = ReaderFromFile.getStringFromFile(pathFile);
		
		List<WordLength> words = new ArrayList<WordLength>();
	
		List<String> stringsTextFile = getString("([A-Za-z])+", textFile);
		
		for(String str : stringsTextFile){
			words.add(new WordLength(str));
		}
		
		Set<WordLength> sortWordsByLength = new TreeSet<WordLength>(words);
		
		WordLength[] r = new WordLength[sortWordsByLength.size()];
		sortWordsByLength.toArray(r);
		
		List<WordLength> result = lastNWords(3, r);
		
		Collections.reverse(result);
		
		return result;	
	}
	
	/**
	 * Returned first three word which have duplicates 
	 * in the text.
	 * 
	 * @param pathFile path to file.
	 * @return first three word which have duplicates 
	 * 		   in the text.
	 */
	public List<String> duplicates(String pathFile){
		String textFile = ReaderFromFile.getStringFromFile(pathFile);
		
		List<String> wordsDuplicates = new ArrayList<String>();
	
		List<String> stringsTextFile = getString("([A-Za-z])+", textFile);
		
		int freq = 0;
		for(String str : stringsTextFile){
			freq = Collections.frequency(stringsTextFile, str);
			
			if(freq > 1){
				
				if(!wordsDuplicates.contains(str)){
					wordsDuplicates.add(str);
				}
			}
		}
		
		Collections.reverse(wordsDuplicates);
		
		String[] wordsDuplicatesArray = new String[wordsDuplicates.size()];
		
		wordsDuplicates.toArray(wordsDuplicatesArray);
		
		List<String> result = lastNWords(3, wordsDuplicatesArray);
		
		result = inverseUpperCase(result);
		
		return result;
	}
	
	private List<String> inverseUpperCase(List<String> list){
		
		List<String> result = new ArrayList<>();
		
		for(String str : list){
			 result.add(reverse(str).toUpperCase());
		}
		
		return result;
	}
	
	private String reverse(String str) {
	    int i = str.length();
	    int len = str.length();
	    
	    StringBuilder dest = new StringBuilder(len);
	    
	    for (i = (len - 1); i >= 0; i--) {
	      dest.append(str.charAt(i));
	    }
	    
	    return dest.toString();
	  }
	
	private <T> List<T> lastNWords(int n, T[] array){
		List<T> result = new ArrayList<>();
		
		for(int i = array.length - 3; i <= array.length - 1; i++){
			result.add(array[i]);
		}
		
		return result;
	}
	
	/**
	 * Get the String on regular expression.
	 * 
	 * @param regExp
	 *            regular expression on which parse string.
	 * @return The list of string on condition regular exp.
	 */
	private List<String> getString(String regExp, String stringToParse) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(stringToParse);

		List<String> result = new ArrayList<>();

		while (matcher.find()) {
			String str = stringToParse.substring(matcher.start(), matcher.end());
			result.add(str);
		}
		return result;
	}
	
	/**
	 * Main.
	 * 
	 * @param args //
	 */
	public static void main(String[] args){
		Part6 part6 = new Part6();
		String pathFile;
		String howMethod;
		
		if(args.length < 1){
			pathFile = "src/text";
			howMethod = "frequency";
		}
		else{
			pathFile = args[0];
			howMethod = args[1];
		}
		
		if(howMethod.equals("frequency")){
			System.out.println("Part1 ===================>");
		
			List<WordFreq> resultFreq =	part6.frequency(pathFile);
		
			StringBuilder resultWordFreq = new StringBuilder(); 
			for(WordFreq word : resultFreq){
				resultWordFreq.append(word.getName().concat(" ==> ").concat(
						String.valueOf(word.getFrequency()).concat("\n")));
			}
		
			System.out.println(resultWordFreq.toString());
		}
			
		if(howMethod.equals("length")){
			System.out.println("Part2 ===================>");
		
			List<WordLength> resultLength =	part6.length(pathFile);
		
			StringBuilder resultWordLength = new StringBuilder(); 
			for(WordLength word : resultLength){
				resultWordLength.append(word.getName().concat(" ==> ").concat(
						String.valueOf(word.getLength()).concat("\n")));
			}
		
			System.out.println(resultWordLength.toString());
		}
		
		if(howMethod.equals("duplicates")){
			System.out.println("Part3 ===================>");
		
			List<String> resultDuplicates = part6.duplicates((pathFile));
		
			for(String s : resultDuplicates){
				System.out.println(s);
			}
		}
	}
}
