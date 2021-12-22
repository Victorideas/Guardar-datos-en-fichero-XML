/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearxml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author DAM
 */
public class XML {

    public void crearElemento(String dato, String valor, Element raiz, Document documento) {
        Element matricula = documento.createElement(dato);
        Text text = documento.createTextNode(valor);
        matricula.appendChild(text);
        raiz.appendChild(matricula);
        
    }

    public void crearConstructor(Coche coche) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //Creamos el constructor
            DocumentBuilder docBuilder = factory.newDocumentBuilder();

            DOMImplementation implementation = docBuilder.getDOMImplementation();
            Document document = implementation.createDocument(null, "coche", null); //Creamos nodo padre
            document.setXmlVersion("1.0");

            Element raiz = document.createElement("coche"); // Creamos el elemento
            document.getDocumentElement().appendChild(raiz);

            crearElemento("Matricula", coche.getMatricula(), raiz, document);
            crearElemento("Modelo", coche.getModelo(), raiz, document);
            crearElemento("Color", coche.getColor(), raiz, document);
            crearElemento("Año", String.valueOf(coche.getAño()), raiz, document);

            //Se escribe el contenido del XML en un archivo
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File("C:\\Users\\Víctor\\Desktop\\Prueba.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            //Mostrar en pantalla
            // Result console = new StreamResult(System.out);
            // transformer.transform(source, console);
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public void leerXML() {
        DocumentBuilderFactory instancia = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructor;
        try {
            constructor = instancia.newDocumentBuilder(); //Cargamos el documento creado antes
            Document document = constructor.parse(new File("C:\\Users\\Víctor\\Desktop", "Prueba.xml"));
            //document.getDocumentElement().normalize();
            //System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            //int coches = document.getElementsByTagName("coche").item(0).getChildNodes().getLength(); //lista de nodos
            //System.out.println("Nodos coches: " + coches);
                    
            String matricula = document.getElementsByTagName("Matricula").item(0).getFirstChild().getNodeValue();
            String modelo = document.getElementsByTagName("Modelo").item(0).getFirstChild().getNodeValue();
            String color = document.getElementsByTagName("Color").item(0).getFirstChild().getNodeValue();
            String año = document.getElementsByTagName("Año").item(0).getFirstChild().getNodeValue();
            

            System.out.println("Matricula: " + matricula + " Modelo: " + modelo + " Color: " + color + " Año: " + año);
        } catch (Exception ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
