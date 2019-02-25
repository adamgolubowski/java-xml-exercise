import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) throws Exception{

        String start = "src/test/resources/test-folders";

        Stream<Path> paths = DirContentsListing.getDirContents(start);
        XmlDocumentCreator xmlDocumentCreator= new XmlDocumentCreator();
        Document document = xmlDocumentCreator.prepareXmlDoc(paths);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(System.out);
        transformer.transform(domSource,streamResult);
    }
}
