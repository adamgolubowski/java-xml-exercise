import org.junit.Test;
import org.w3c.dom.Document;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class XmlDocumentCreatorTest {

    String start = "src/test/resources/test-folders";
    XmlDocumentCreator xmlDocumentCreator = new XmlDocumentCreator();
    Path path1 = Paths.get("src/test/resources/test-folders");
    Path path2 = Paths.get("src/test/resources/test-folders/t1");
    Path path3 = Paths.get("src/test/resources/test-folders/t1/f1");
    Path path4 = Paths.get("src/test/resources/test-folders/t2");
    List<Path> listOfPaths = Arrays.asList(path1,path2,path3,path4);
    Stream<Path> paths = listOfPaths.stream();

    @Test
    public void prepareXmlDocTest() {
        XmlDocumentCreator xmlDocumentCreator = new XmlDocumentCreator();
        Document resultDocument = xmlDocumentCreator.prepareXmlDoc(paths);
        assertEquals(4,resultDocument.getElementsByTagName("file").getLength());
        assertEquals("src/test/resources/test-folders",
                      resultDocument.getElementsByTagName("file").item(0).getTextContent());
        assertEquals("src/test/resources/test-folders/t1",
                resultDocument.getElementsByTagName("file").item(1).getTextContent());
    }
}