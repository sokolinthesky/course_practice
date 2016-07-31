package ua.khpi.soklakov.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;
import ua.khpi.soklakov.SummaryTask3.controllers.DOMController;
import ua.khpi.soklakov.SummaryTask3.controllers.SAXController;
import ua.khpi.soklakov.SummaryTask3.controllers.STAXController;
import ua.khpi.soklakov.SummaryTask3.entity.OldCards;

/**
 * Main class.
 * 
 * @author O.Soklakov
 *
 */
public class Main {

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws IOException
	 * @throws XMLStreamException
	 */
	public static void main(String[] args)
			throws ParserConfigurationException, TransformerException, SAXException, IOException, XMLStreamException {
		if (args.length != 1) {
			helper();
			return;
		}

		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);

		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////

		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		OldCards oldCards = domController.getOldCards();

		// sort (case 1)
		Sorter.sortGunsBySendContain(oldCards);

		// save
		String outputXmlFile = "output.dom.xml";
		DOMController.saveToXML(oldCards, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		////////////////////////////////////////////////////////
		// SAX
		////////////////////////////////////////////////////////

		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		oldCards = saxController.getOldCards();

		// sort (case 2)
		Sorter.sortGunsByType(oldCards);

		// save
		outputXmlFile = "output.sax.xml";

		// other way:
		DOMController.saveToXML(oldCards, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);

		////////////////////////////////////////////////////////
		// StAX
		////////////////////////////////////////////////////////

		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		oldCards = staxController.getOldCards();

		// sort (case 3)
		Sorter.sortGunsByYear(oldCards);

		// save
		outputXmlFile = "output.stax.xml";
		DOMController.saveToXML(oldCards, outputXmlFile);
		System.out.println("Output ==> " + outputXmlFile);
	}
	
	/**
	 * Print help message for user.
	 */
	public static void helper() {
		System.out.println("java ua.nure.your_last_name.SummaryTask3.Main xmlFileName");
		System.out.println("Usage:\njava -jar ST3ExampleSimple.jar xmlFileName");
	}

}
