package ua.khpi.soklakov.SummaryTask3;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * Test class.
 * 
 * @author O.Soklakov
 *
 */
public class Demo {

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
		Main.main(new String[] { "input.xml" });
	}
}
