package ua.khpi.soklakov.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Old Cards bean.
 * 
 * @author O.Soklakov
 *
 */
public class OldCards {

	private List<Card> cards;

	public List<Card> getCards() {
		if (cards == null) {
			cards = new ArrayList<>();
		}
		return cards;
	}

	@Override
	public String toString() {
		return "OldCards [cards=" + cards + "]";
	}

}
