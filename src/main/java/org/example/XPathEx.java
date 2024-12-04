package org.example;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class XPathEx {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/resources/train.xml"));

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            String expression = "/trains/train[name = 'Стрела']";
            NodeList expensiveTrains = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            for (int i = 0; i < expensiveTrains.getLength(); i++) {
                Element train = (Element) expensiveTrains.item(i);
                System.out.println("Model: " + train.getElementsByTagName("model").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

