package ua.khpi.soklakov.Practice4.part3;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.khpi.soklakov.Practice4.ReaderFromFile;


/**
 * This class show how types are contain in string. 
 * 
 * @author Eugene Jurkov
 *
 */
public class Part3 {
	
	/**
	 * The string types will be searched in.
	 */
	String parseStr;
	
	/**
	 * Constructor in which initialized parse string.
	 * 
	 * @param str The string types will be searched in.
	 */
	public Part3(String str){
		parseStr = str;
	}
	
	/**
	 * This method finds type which the user enters.
	 * 
	 * @param type data which contain in string
	 * @return string of data.
	 */
	public String getData(String type){
		if(type.equals("int")){
			return getInt();
		}
		
		if(type.equals("double")){
			return getDouble();
		}
		
		if(type.equals("char")){
			return getChar();
		}
		
		if(type.equals("String")){
			return getString();
		}
		else{
			return "";
		}
	}
	
	/**
	 * Returned value whose type represents int.
	 * 
	 * @return value whose type represents int.
	 */
	private String getInt(){
		String result = "";
		
		List<String> typeNumber = getString("(?:\\d*\\.)?\\d+");
		
		for(String number : typeNumber){
			if(!number.contains(".")){
				result = result + number + " ";
			}
		}
		
		return result;
	}
	
	/**
	 * Returned value whose type represents Double.
	 * 
	 * @return value whose type represents Double.
	 */
	private String getDouble(){
		String result = "";
		
		List<String> typeNumber = getString("(?:\\d*\\.)?\\d+");
		
		for(String number : typeNumber){
			if(number.contains(".")){
				result = result + number + " ";
			}
		}
		
		return result;
	}
	
	/**
	 * Returned value whose type represents char.
	 * 
	 * @return value whose type represents char.
	 */
	private String getChar(){
		String result = "";
		
		List<String> typeString = getString("[^0-9.\\s]+");
		
		for(String str : typeString){
			if(str.length() < 2){
				result = result + str + " ";
			}
		}
		
		return result;
	}
	
	/**
	 * Returned value whose type represents String.
	 * 
	 * @return value whose type represents String.
	 */
	private String getString(){
		String result = "";
		
		List<String> typeString = getString("[^0-9.\\s]+");
		
		for(String str : typeString){
			if(str.length() > 1){
				result = result + str + " ";
			}
		}
		
		return result;
	}
	
	/**
	 * Get the String on regular expression.
	 * 
	 * @param regExp regular expression on which parse string.
	 * @return The list of string on condition regular exp.
	 */
	public List<String> getString(String regExp){
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(parseStr);

		List<String> result = new ArrayList<>();

		while(matcher.find()){
			String str = parseStr.substring(matcher.start(), 
									    matcher.end());
			result.add(str);
		}
		return result;
	}
	
	/**
	 * Test main.
	 * 
	 * @param args test.
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException{
		String testTxt = ReaderFromFile.getStringFromFile("src/", "part3.txt");	
		
		Part3 p3 = new Part3(testTxt);
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String type = "";
		for(int i = 0; i < 4; i++ ){
			type = scan.nextLine();
			System.out.println(p3.getData(type));
		}
	}
}
