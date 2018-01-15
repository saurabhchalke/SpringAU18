import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.Document;
import javax.xml.transform.dom.DOMSource;
import java.io.File;

class CsvConverter {

    public static void main(String args[]) throws Exception {
        File stylesheet = new File("src/format.xsl");
        File xmlInput = new File("src/input.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlInput);

        StreamSource stylesource = new StreamSource(stylesheet);
        Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(new File("src/output.csv"));
        transformer.transform(source, outputTarget);
    }
}