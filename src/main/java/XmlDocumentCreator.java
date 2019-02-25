import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class XmlDocumentCreator {
    private Document document;
    private Element root;

    public XmlDocumentCreator() {
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            this.document = documentBuilder.newDocument();

            root = this.document.createElement("files");
            this.document.appendChild(root);
        } catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }
    }

    public Document prepareXmlDoc(Stream<Path> paths){
        paths.forEach(path -> {
            Path fileName = path.getFileName();
            Element file = this.document.createElement("file");
            Attr attr = this.document.createAttribute("fileName");
            attr.setValue(fileName.toString());
            file.setAttributeNode(attr);
            Element filePath = this.document.createElement("filePath");
            filePath.appendChild(this.document.createTextNode(path.toString()));
            file.appendChild(filePath);
            root.appendChild(file);
        });
        return document;
    }
}
