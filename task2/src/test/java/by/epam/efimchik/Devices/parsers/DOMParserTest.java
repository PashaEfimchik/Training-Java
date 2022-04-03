package by.epam.efimchik.Devices.parsers;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParserTest extends TestCase {
    private DocumentBuilder documentBuilder;
    private Document document;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        document = documentBuilder.parse(new File("src/main/resources/computers.xml"));
        document.getDocumentElement().normalize();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testReadXmlDomParser() {
        NodeList deviceList = document.getElementsByTagName("device");
        Node firstDevice = deviceList.item(0);

        assertEquals(8, deviceList.getLength());
        assertEquals(Node.ELEMENT_NODE, firstDevice.getNodeType());
        assertEquals("device", firstDevice.getNodeName());

        Node first = document.getElementsByTagName("device").item(0);
        NamedNodeMap attrList = first.getAttributes();

        assertEquals(1, attrList.getLength());
        assertEquals("id", attrList.item(0).getNodeName());
        assertEquals("1", attrList.item(0).getNodeValue());
    }
}
