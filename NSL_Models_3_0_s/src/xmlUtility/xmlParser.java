/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlUtility;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import nslj.src.system.NslSystem;

/**
 *
 * @author Adri
 * This file parses different xml documents that correspond to the three models available in the project.
 * There will be 3 functions corresponding to the MaxSelector, Hopfield, and BackPropagation models.
 */
public class xmlParser {
    
    
    public void parseMaxSelector()
    {
    /* Code for parsing maxSelector xml document and retrieving the data that will be used to initialzie model variables. */
        
        
        
        
         try {	
         File inputFile = new File("maxSelector.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
                  
         System.out.println("Root element :" 
            + doc.getDocumentElement().getNodeName());
        
        //getElementsByTagName searches the xml document and returns an array of elements with specified name
        //in this case the array is of size 1 because there is only one element with simEndTime as the name
        NodeList nList = doc.getElementsByTagName("simEndTime");
        int temp = 0;
        //currNode is then set to be the node in the array that we are currently at in nList which is simEndTime
        Node currNode = nList.item(temp);
        System.out.println("Current Element that we are at in XML is " + currNode.getNodeName());
        //Gets the first child of the currNode (simEndTime) which is the text node, then gets the node value of the text node which is
        //the value inside the simEndTime tags in the xml doc.
        System.out.println(currNode.getFirstChild().getNodeValue());
        
        
        
         }
         catch (Exception e) {
         e.printStackTrace();
         }
    
    
    
    }


}