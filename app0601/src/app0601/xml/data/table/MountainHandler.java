package app0601.xml.data.table;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	Vector<Mountain> mtList; //산 VO을 여러개 담게될 컬렉션!!
	
	boolean isItems;
	boolean isItem;
	boolean isMntiadd;
	boolean isMntidetails;
	boolean isMntihigh;
	boolean isMntilistno;
	boolean isMntiname;
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
	}

	public void characters(char[] ch, int start, int length) throws SAXException {

	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

	}
	
	public void endDocument() throws SAXException {

	}
}
