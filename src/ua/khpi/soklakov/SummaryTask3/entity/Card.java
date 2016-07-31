package ua.khpi.soklakov.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Card bean.
 * 
 * @author O.Soklakov.
 *
 */
public class Card {

	private String valuable;
	private Type type;
	private String thema;
	private String country;
	private List<Author> authors;
	private int year;

	public String getValuable() {
		return valuable;
	}

	public void setValuable(String valuable) {
		this.valuable = valuable;
	}
	
	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Author> getAuthors() {
		if (authors == null) {
			authors = new ArrayList<>();
		}

		return authors;
	}

	@Override
	public String toString() {
		return "Card [thema=" + thema + ", type=" + type + ", country=" + country + ", year=" + year + ", authors="
				+ authors + ", valuable=" + valuable + "]";
	}

}
