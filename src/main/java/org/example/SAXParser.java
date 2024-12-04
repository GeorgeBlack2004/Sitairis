package org.example;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.io.File;

public class SAXParser extends DefaultHandler {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("A:/IntelIdea/Projects/SitairisLaba7/src/main/resources/train.xml"), new SAXParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("train")) {
            System.out.println("Train №: " + attributes.getValue("num"));
        } else if (!qName.equals("trains")) {
            System.out.print(qName + ": ");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            System.out.println(content);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (!qName.equals("trains")) {
            System.out.println(" ");
        }
    }
}

