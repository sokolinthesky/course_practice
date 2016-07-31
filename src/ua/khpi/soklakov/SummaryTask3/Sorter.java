package ua.khpi.soklakov.SummaryTask3;

import java.util.Collections;
import java.util.Comparator;

import ua.khpi.soklakov.SummaryTask3.entity.Card;
import ua.khpi.soklakov.SummaryTask3.entity.OldCards;

/**
 * Sorter class.
 * @author O.Soklakov
 *
 */
public class Sorter {
	
	/**
	 * Sort cards by type.
	 */
	public static final Comparator<Card> SORT_CARDS_BY_TYPE = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			return o1.getType().getType().compareTo(o2.getType().getType());
		}
	};

	/**
	 * Sort cards by year.
	 */
	public static final Comparator<Card> SORT_CARDS_BY_YEAR = new Comparator<Card>() {
		public int compare(Card o1, Card o2) {
			return o1.getYear() - o2.getYear();
		};
	};

	/**
	 * Sort cards by send contain.
	 */
	public static final Comparator<Card> SORT_CARDS_BY_SEND_CONTAIN = new Comparator<Card>() {
		@Override
		public int compare(Card o1, Card o2) {
			if (o1.getType().isSend() && !o2.getType().isSend()) {
				return -1;
			}
			if (o2.getType().isSend() && !o1.getType().isSend()) {
				return 1;
			}
			return 0;
		}
	};

	/**
	 * Return comparator where Sort cards by type.
	 * @param oldCards
	 */
	public static final void sortGunsByType(OldCards oldCards) {
		Collections.sort(oldCards.getCards(), SORT_CARDS_BY_TYPE);
	}

	/**
	 * Return comparator where Sort cards by year.
	 * @param oldCards
	 */
	public static final void sortGunsByYear(OldCards oldCards) {
		Collections.sort(oldCards.getCards(), SORT_CARDS_BY_YEAR);
	}

	/**
	 * Return comparator where Sort cards by send contain.
	 * @param oldCards
	 */
	public static final void sortGunsBySendContain(OldCards oldCards) {
		Collections.sort(oldCards.getCards(), SORT_CARDS_BY_SEND_CONTAIN);
	}
}
