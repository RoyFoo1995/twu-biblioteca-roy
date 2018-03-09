package biblioteca.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XMLUtil {

    public static org.dom4j.Element getRootElement(String url) {
        SAXReader reader = new SAXReader();
        Document doc = null;
        org.dom4j.Element root = null;
        try {
            doc = reader.read(XMLUtil.class.getResource(url));
            root = doc.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return root;
    }

}
