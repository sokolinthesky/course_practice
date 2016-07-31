package ua.khpi.soklakov.SummaryTask3.controllers;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;
import ua.khpi.soklakov.SummaryTask3.entity.Author;
import ua.khpi.soklakov.SummaryTask3.entity.Card;
import ua.khpi.soklakov.SummaryTask3.entity.OldCards;
import ua.khpi.soklakov.SummaryTask3.entity.Type;

/**
 * STAX controller.
 * 
 * @author O.Soklakov.
 *
 */
public class STAXController {
	private String xmlFileName;
	private OldCards oldCards;

	public OldCards getOldCards() {
		return oldCards;
	}

	public STAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
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
	public void parse() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		String currentElem = null;
		Card card = null;
		Type type = null;
		Author author = null;

		XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
		XMLEventReader xmlReader = xmlFactory.createXMLEventReader(new StreamSource(xmlFileName));

		while (xmlReader.hasNext()) {
			XMLEvent event = xmlReader.nextEvent();

			if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
				continue;
			}

			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				currentElem = startElement.getName().getLocalPart();

				if (currentElem.equals("OldCards")) {
					oldCards = new OldCards();
					continue;
				}

				if (currentElem.equals("Card")) {
					card = new Card();
					continue;
				}

				if (currentElem.equals("Type")) {
					type = new Type();
					Attribute attribute = startElement.getAttributeByName(new QName("send"));
					if (attribute != null) {
						type.setSend(Boolean.parseBoolean(attribute.getValue()));
					}
					continue;
				}

				if (currentElem.equals("Author")) {
					author = new Author();
					Attribute attribute = startElement.getAttributeByName(new QName("famous"));
					if (attribute != null) {
						author.setFamous(Boolean.parseBoolean(attribute.getValue()));
					}
					continue;
				}
			}

			if (event.isCharacters()) {
				Characters characters = event.asCharacters();

				if (currentElem.equals("Thema")) {
					card.setThema(characters.getData());
					continue;
				}

				if (currentElem.equals("Type")) {
					type.setType(characters.getData());
					continue;
				}
				if (currentElem.equals("Country")) {
					card.setCountry(characters.getData());
					continue;
				}

				if (currentElem.equals("Year")) {
					card.setYear(Integer.parseInt(characters.getData()));
					continue;
				}
				if (currentElem.equals("Author")) {
					author.setName(characters.getData());
					continue;
				}
				if (currentElem.equals("Valuable")) {
					card.setValuable(characters.getData());
					continue;
				}
			}

			if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				String localName = endElement.getName().getLocalPart();

				if (localName.equals("Card")) {
					oldCards.getCards().add(card);
					continue;
				}

				if (localName.equals("Type")) {
					card.setType(type);
					continue;
				}

				if (localName.equals("Author")) {
					card.getAuthors().add(author);
					continue;
				}
			}

		}
		xmlReader.close();
	}

}
