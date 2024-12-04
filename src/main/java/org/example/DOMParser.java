package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class DOMParser {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/resources/train.xml"));
            NodeList trainList = doc.getElementsByTagName("train");

            for (int i = 0; i < trainList.getLength(); i++) {
                Element train = (Element) trainList.item(i);
                System.out.println("Train name: " + train.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Train model: " + train.getElementsByTagName("model").item(0).getTextContent());
                System.out.println("Train type: " + train.getElementsByTagName("type").item(0).getTextContent());
                System.out.println("Train number of cars: " + train.getElementsByTagName("numOfCars").item(0).getTextContent());
                System.out.println("========================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}