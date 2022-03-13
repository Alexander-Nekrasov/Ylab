package xml;

import entities.Bot;
import entities.Human;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class SaveToXML {

    private static final File file = new File(SaveToXML.class.getResource("/").getPath()
            .replace("out/production/Ylab", "homework_3/additionalTask")+"/info.xml");

    public static Document doc;

    static {
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static Element root = doc.createElement("GamePlay");
    public static Element player1 = doc.createElement("Player");
    public static Element player2 = doc.createElement("Player");
    public static Element game = doc.createElement("Game");
    public static ArrayList<Element> listStep = getListElement();
    public static Element gameResult = doc.createElement("GameResult");
    public static Element winPlayer = doc.createElement("Player");

    public static ArrayList<Element> getListElement() {
        ArrayList<Element> step = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            step.add(doc.createElement("step"));

            step.get(i).setAttribute("num", String.valueOf(i + 1));
            step.get(i).setAttribute("playerId", String.valueOf(Human.id));
            step.get(i).setTextContent(String.format("%d %d", 0, 0));

            if (i % 2 != 0) {
                step.get(i).setAttribute("playerId", String.valueOf(Bot.id));
            }
        }
        return step;
    }

    public static void getTransformer() {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        if (transformer != null) transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            transformer.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(file)));
        } catch (TransformerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void XmlToConsole() {

        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(file));
            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                    if (xmlr.getLocalName().equals("Player") || xmlr.getLocalName().equals("step")
                            || xmlr.getLocalName().equals("GameResult") || xmlr.getLocalName().equals("Game"))
                        if (xmlr.getLocalName().equals("GameResult") || xmlr.getLocalName().equals("Game"))
                            System.out.println(String.format("    <%s>", xmlr.getLocalName()));
                        else {
                            if(xmlr.getLocalName().equals("Player"))
                                System.out.print(String.format("    <%s %s=%s, %s=%s, %s=%s>"
                                        , xmlr.getLocalName(), xmlr.getAttributeLocalName(0)
                                        , xmlr.getAttributeValue(0), xmlr.getAttributeLocalName(1)
                                        , xmlr.getAttributeValue(1), xmlr.getAttributeLocalName(2)
                                        , xmlr.getAttributeValue(2)));
                            else System.out.print(String.format("        <%s %s=%s, %s=%s>"
                                    , xmlr.getLocalName(), xmlr.getAttributeLocalName(0)
                                    , xmlr.getAttributeValue(0), xmlr.getAttributeLocalName(1)
                                    , xmlr.getAttributeValue(1)));
                        }
                    else System.out.println(String.format("<%s>", xmlr.getLocalName()));
                } else if (xmlr.isEndElement()) {
                    if (xmlr.getLocalName().equals("GameResult") || xmlr.getLocalName().equals("Game"))
                        System.out.println(String.format("    </%s>", xmlr.getLocalName()));
                    else System.out.print("</" + xmlr.getLocalName() + ">\n");
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    System.out.print(xmlr.getText());
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(file.getAbsolutePath());
    }
}
