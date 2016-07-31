package ua.khpi.soklakov.SummaryTask3.controllers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.khpi.soklakov.SummaryTask3.entity.Author;
import ua.khpi.soklakov.SummaryTask3.entity.Card;
import ua.khpi.soklakov.SummaryTask3.entity.OldCards;
import ua.khpi.soklakov.SummaryTask3.entity.Type;

/**
 * SAX controller.
 * 
 * @author O.Soklakov
 *
 */
public class SAXController extends DefaultHandler {

	private String xmlFileName;
	private String currentElement;

	private OldCards oldCards;
	private Card card;
	private Author author;
	private Type type;

	public SAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public OldCards getOldCards() {
		return this.oldCards;
	}

	/**
	 * Parse specified xml document.
	 * 
	 * @param validate
	 *            'true' start parse.
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);

		// set validation
		if (validate) {
			factory.setFeature("http://xml.org/sax/features/validation", true);
			factory.setFeature("http://apache.org/xml/features/validation/schema", true);
		}

		SAXParser parser = factory.newSAXParser();
		parser.parse(xmlFileName, this);

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentElement = localName;

		if (currentElement.equals("OldCards")) {
			oldCards = new OldCards();
			return;
		}

		if (currentElement.equals("Card")) {
			card = new Card();
			return;
		}

		if (currentElement.equals("Type")) {
			this.type = new Type();
			type.setSend(Boolean.parseBoolean(attributes.getValue(uri, "send")));
			return;
		}

		if (currentElement.equals("Author")) {
			this.author = new Author();
			author.setFamous(Boolean.parseBoolean(attributes.getValue(uri, "famous")));
			return;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals("Card")) {
			this.oldCards.getCards().add(card);
			return;
		}

		if (localName.equals("Type")) {
			this.card.setType(type);
			return;
		}

		if (localName.equals("Author")) {
			this.card.getAuthors().add(author);
			return;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) {
		String elementText = new String(ch, start, length).trim();

		if (currentElement.equals("Thema")) {
			if (!elementText.equals("")) {
				this.card.setThema(elementText);
			}
			return;
		}

		if (currentElement.equals("Type")) {
			if (!elementText.equals("")) {
				this.type.setType(elementText);
			}
			return;
		}

		if (currentElement.equals("Country")) {
			if (!elementText.equals("")) {
				this.card.setCountry(elementText);
			}
			return;
		}

		if (currentElement.equals("Year")) {
			if (!elementText.equals("")) {
				this.card.setYear(Integer.parseInt(elementText));
			}
			return;
		}

		if (currentElement.equals("Author")) {
			if (!elementText.equals("")) {
				this.author.setName(elementText);
			}
			return;
		}

		if (currentElement.equals("Valuable")) {
			if (!elementText.equals("")) {
				this.card.setValuable(elementText);
			}
			return;
		}

	}

}
