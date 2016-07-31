package ua.khpi.soklakov.SummaryTask3.controllers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.khpi.soklakov.SummaryTask3.entity.Author;
import ua.khpi.soklakov.SummaryTask3.entity.Card;
import ua.khpi.soklakov.SummaryTask3.entity.OldCards;
import ua.khpi.soklakov.SummaryTask3.entity.Type;

/**
 * DOM Controller.
 * 
 * @author O.Soklakov
 *
 */
public class DOMController {
	private String xmlFile;

	private OldCards oldCards;

	public DOMController(String xmlFileName) {
		this.xmlFile = xmlFileName;
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
		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		// make parser validating
		if (validate) {
			// turn validation on
			dbf.setFeature("http://xml.org/sax/features/validation", true);

			// turn on xsd validation
			dbf.setFeature("http://apache.org/xml/features/validation/schema", true);
		}

		DocumentBuilder db = dbf.newDocumentBuilder();

		// set error handler
		db.setErrorHandler(new DefaultHandler() {

		});

		Document document = db.parse(xmlFile);
		Element root = document.getDocumentElement();

		this.oldCards = new OldCards();

		NodeList cardNodes = root.getElementsByTagName("Card");

		for (int j = 0; j < cardNodes.getLength(); j++) {
			Card card = getCard(cardNodes.item(j));
			// add question to container
			oldCards.getCards().add(card);
		}
	}

	/**
	 * Return Card from xml document.
	 * 
	 * @param cNode
	 *            specified node.
	 * @return Card from xml.
	 */
	private Card getCard(Node cNode) {
		Card card = new Card();

		Element cElement = (Element) cNode;

		Node themeNode = cElement.getElementsByTagName("Thema").item(0);
		card.setThema(themeNode.getTextContent());

		Node typeNode = cElement.getElementsByTagName("Type").item(0);
		card.setType(getType(typeNode));

		Node yearNode = cElement.getElementsByTagName("Year").item(0);
		card.setYear(Integer.parseInt(yearNode.getTextContent()));

		Node authorNode = cElement.getElementsByTagName("Author").item(0);
		card.getAuthors().add(getAuthor(authorNode));

		Node valuableNode = cElement.getElementsByTagName("Valuable").item(0);
		card.setValuable(valuableNode.getTextContent());

		return card;
	}

	/**
	 * Return Type from xml document.
	 * 
	 * @param tNode
	 *            specified node.
	 * @return Type from xml document.
	 */
	private Type getType(Node tNode) {
		Type type = new Type();
		Element tElement = (Element) tNode;

		String send = tElement.getAttribute("send");
		type.setSend(Boolean.valueOf(send));

		String sType = tElement.getTextContent();
		type.setType(sType);

		return type;
	}

	/**
	 * Return Author element from xml file.
	 * 
	 * @param aNode
	 *            specified node.
	 * @return Author element.
	 */
	private Author getAuthor(Node aNode) {
		Author author = new Author();
		Element aElement = (Element) aNode;

		String famous = aElement.getAttribute("famous");
		author.setFamous(Boolean.parseBoolean(famous));

		String name = aElement.getTextContent();
		author.setName(name);

		return author;
	}

	/**
	 * Get document.
	 * 
	 * @param oldCards
	 *            specified OldCards.
	 * @return document object.
	 * @throws ParserConfigurationException
	 */
	public static Document getDocument(OldCards oldCards) throws ParserConfigurationException {

		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		// create root element
		Element tElement = document.createElement("OldCards");

		// add root element
		document.appendChild(tElement);

		// add questions elements
		for (Card card : oldCards.getCards()) {

			// add question
			Element cardElement = document.createElement("Card");
			tElement.appendChild(cardElement);

			Element themaElement = document.createElement("Thema");
			themaElement.setTextContent(card.getThema());
			cardElement.appendChild(themaElement);
			// add question text
			Element typeElement = document.createElement("Type");
			if (card.getType().isSend()) {
				typeElement.setAttribute("send", "true");
			}
			typeElement.setTextContent(card.getType().getType());
			cardElement.appendChild(typeElement);

			Element countryElement = document.createElement("Country");
			countryElement.setTextContent(String.valueOf(card.getCountry()));

			Element yearElement = document.createElement("Year");
			yearElement.setTextContent(String.valueOf(card.getYear()));

			for (Author auth : card.getAuthors()) {
				Element authorElement = document.createElement("Author");
				if (auth.isFamous()) {
					authorElement.setAttribute("famous", "true");
				}

				authorElement.setTextContent(auth.getName());
				cardElement.appendChild(authorElement);
			}

			Element valuableElement = document.createElement("Valuable");
			valuableElement.setTextContent(String.valueOf(card.getValuable()));

			cardElement.appendChild(valuableElement);
			cardElement.appendChild(countryElement);
			cardElement.appendChild(yearElement);
		}

		return document;
	}

	/**
	 * Saves Test object to XML file.
	 * 
	 * @param oldCards
	 *            Test object to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public static void saveToXML(OldCards oldCards, String xmlFileName)
			throws ParserConfigurationException, TransformerException {
		// Test -> DOM -> XML
		saveToXML(getDocument(oldCards), xmlFileName);
	}

	/**
	 * Save DOM to XML.
	 * 
	 * @param document
	 *            DOM to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public static void saveToXML(Document document, String xmlFileName) throws TransformerException {

		StreamResult result = new StreamResult(new File(xmlFileName));

		// set up transformation
		TransformerFactory transformer = TransformerFactory.newInstance();
		javax.xml.transform.Transformer tr = transformer.newTransformer();
		tr.setOutputProperty(OutputKeys.INDENT, "yes");

		// run transformation
		tr.transform(new DOMSource(document), result);
	}

}
