/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozensorteerder;

import Models.Station;
import Models.StationVerzameling;
import Models.XMLObject;
import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.w3c.dom.NodeList;

/**
 *
 * @author thomv
 */
public class XMLReader {
    public ArrayList<XMLObject> readJSON() throws JAXBException{
        ArrayList<XMLObject> producten = new ArrayList<>();
        
        for(int sec = 0; sec < 60; sec++){
            for(int min = 0; min < 60; min++){
                for (int hour = 0; hour < 24; hour++){
                    for (int day = 1; day < 2; day++){
                        int month = 3;
                        int year = 2019;
                        
                        File file = new File("D:\\Documenten\\NetBeansProjects\\RozenSorteerder\\v0.2\\RozenSorteerder\\xml\\" + year + "-" + month + "-" + day + "_" + hour + "-" + min + "-" + sec + ".xml");
                        if (file.exists()){
                            String min2 = new String();
                            if (min < 10){min2 = "0"+min;}else{min2=Integer.toString(min);}
                            System.out.println("Rozen van " + day + " " + new DateFormatSymbols().getMonths()[month-1] + " " + year + " " + hour+ ":" + min2 + " ophalen.");
                            OneXML(producten, file);
                        }
                    }
                }
            }
        }
        
        
        return producten;
    };
    
    public void OneXML(ArrayList<XMLObject> producten, File file) throws JAXBException{
        try {
            
            
            
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            NodeList nodeList = document.getElementsByTagName("product");
            for(int x=0,size= nodeList.getLength(); x<size; x++) {
                /*
                System.out.println("__________________");
                System.out.println("++Roos " + x + "++");
                System.out.println("Programmanummer: " + nodeList.item(x).getAttributes().getNamedItem("ProgrammaNummer").getNodeValue());
                System.out.println("lengte: " + nodeList.item(x).getAttributes().getNamedItem("GemetenLengte").getNodeValue());
                System.out.println("steeldikte: " + nodeList.item(x).getAttributes().getNamedItem("GemetenSteeldikte").getNodeValue());
                System.out.println("knophoogte: " + nodeList.item(x).getAttributes().getNamedItem("GemetenKnophoogte").getNodeValue());
                System.out.println("knopbreedte: " + nodeList.item(x).getAttributes().getNamedItem("GemetenKnopbreedte").getNodeValue());
                System.out.println("kleurwaarde: " + nodeList.item(x).getAttributes().getNamedItem("GemetenKleurwaarde").getNodeValue());
                System.out.println("rijpheid: " + nodeList.item(x).getAttributes().getNamedItem("GemetenRijpheid").getNodeValue()); 
                System.out.println("Station: " + nodeList.item(x).getAttributes().getNamedItem("Stationnummer").getNodeValue());
                */
                
                XMLObject product = new XMLObject();
                product.setGemetenCoderingBoven(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenCodering").getNodeValue()));
                product.setGemetenCoderingOnder(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenCodering").getNodeValue()));
                product.setGemetenKleurwaarde(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenKleurwaarde").getNodeValue()));
                product.setGemetenKnopHoogte(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenKnophoogte").getNodeValue()));
                product.setGemetenKnopbreedte(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenKnopbreedte").getNodeValue()));
                product.setGemetenLengte(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenLengte").getNodeValue()));
                product.setGemetenRijpheid(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenRijpheid").getNodeValue()));
                product.setGemetenSteeldikte(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenSteeldikte").getNodeValue()));
                //product.setInserttime(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenCoderingOnder").getNodeValue()));
                product.setProgrammanummer(Integer.parseInt(nodeList.item(x).getAttributes().getNamedItem("ProgrammaNummer").getNodeValue()));
                product.setStationnummer(Integer.parseInt(nodeList.item(x).getAttributes().getNamedItem("Stationnummer").getNodeValue()));
                
                SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                Date date = ymd.parse(nodeList.item(x).getAttributes().getNamedItem("insertTime").getNodeValue());
                product.setInserttime(date);
                
                producten.add(product);
            }
            
        } catch (Exception e) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void OneStation(StationVerzameling producten, File file) throws JAXBException{
        try {
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            NodeList nodeList = document.getElementsByTagName("product");
            for(int x=0,size= nodeList.getLength(); x<size; x++) {
                int stationnummer;
                double ingesteldeLengte;
                double ingesteldeSteeldikte;
                double ingesteldeKnophoogte;
                double ingesteldeKnopbreedte;
                double ingesteldeKleurMin;
                double ingesteldeKleurMax;
                double ingesteldeRijpheid;
                double ingesteldeRijpheidMin;
                double ingesteldeRijpheidMax;
                int ingesteldeCodering;
                
                ingesteldeLengte = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeLengte").getNodeValue());
                ingesteldeSteeldikte = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeSteeldikte").getNodeValue());
                ingesteldeKnophoogte = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeKnophoogte").getNodeValue());
                ingesteldeKnopbreedte = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeKnopbreedte").getNodeValue());
                ingesteldeKleurMin = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeKleurwaarde").getNodeValue());
                
                ingesteldeKleurMax = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeKleurwaardeMax").getNodeValue());
                ingesteldeRijpheid = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeRijpheid").getNodeValue());
                ingesteldeRijpheidMin = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeRijpheid").getNodeValue());
                ingesteldeRijpheidMax = Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("IngesteldeRijpheid").getNodeValue());
                //product.setInserttime(Double.parseDouble(nodeList.item(x).getAttributes().getNamedItem("GemetenCoderingOnder").getNodeValue()));
                stationnummer = Integer.parseInt(nodeList.item(x).getAttributes().getNamedItem("Stationnummer").getNodeValue());
                ingesteldeCodering = (Integer.parseInt(nodeList.item(x).getAttributes().getNamedItem("IngesteldeCodering").getNodeValue()));

                
                producten.voegToe(stationnummer, ingesteldeLengte, ingesteldeSteeldikte, ingesteldeKnophoogte, ingesteldeKnopbreedte, ingesteldeKleurMin, ingesteldeKleurMax, ingesteldeRijpheid, ingesteldeRijpheidMin, ingesteldeRijpheidMax, ingesteldeCodering);
            }
            
        } catch (Exception e) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, e);
        }
        
    } 
    
    public StationVerzameling checkStations() throws JAXBException{
        StationVerzameling stations = new StationVerzameling();
        
        for(int sec = 0; sec < 60; sec++){
            for(int min = 0; min < 60; min++){
                for (int hour = 0; hour < 24; hour++){
                    for (int day = 1; day < 2; day++){
                        int month = 3;
                        int year = 2019;
                        File file = new File("D:\\Documenten\\NetBeansProjects\\RozenSorteerder\\v0.2\\RozenSorteerder\\xml\\" + year + "-" + month + "-" + day + "_" + hour + "-" + min + "-" + sec + ".xml");
                        if (file.exists()){
                            OneStation(stations, file);
                        }
                    }
                }
            }
        }
        

        
        
        return stations;
    };
    
}
