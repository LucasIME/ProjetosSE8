
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meireles
 */
public class FreteCalculator {

    String CEPOrigem, CEPDestino, Formato, PrecoPAC, PrecoSedex, Peso;

    public FreteCalculator(String CEPOrigem, String CEPDestino, String Peso, String formato) {
        this.CEPOrigem = CEPOrigem;
        this.CEPDestino = CEPDestino;
        this.Peso = Peso;
        this.Formato = formato;
    }

    public void process() throws MalformedURLException, IOException, ParserConfigurationException, XPathExpressionException, SAXException {
        InputStream APIContent = null;
        APIContent = new URL("http://developers.agenciaideias.com.br/correios/frete/" + this.Formato + "/" + this.CEPOrigem + "/" + this.CEPDestino + "/" + this.Peso + "/").openConnection().getInputStream();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("//sedex");
            
            Document doc = builder.parse(APIContent);
            
            NodeList nodi = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            
            //NodeList nodi = doc.getElementsByTagName("sedex");
            
            if (nodi.getLength() > 0)
            {
                Element nodo = (Element)nodi.item(0);
                this.PrecoSedex = nodo.getTextContent();
            }
            
            expr = xpath.compile("//pac");
            
            nodi = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            
            if (nodi.getLength() > 0)
            {
                Element nodo2 = (Element)nodi.item(0);
                this.PrecoPAC = nodo2.getTextContent();
            }
    }
    

    public String getPrecoSedex() {
        return PrecoSedex;
    }

    public String getPrecoPAC() {
        return PrecoPAC;
    }

}
