/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlUtility;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import nslj.src.lang.*;
import nslj.src.nsls.struct.Executive;
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
    
      
    
    public void setSystemVar()
    {
        String simEndTime = "simEndTime";
        String simDelta = "simDelta";
        
        
               
         try 
         {	
            File inputFile = new File("maxSelector.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

           //getElementsByTagName searches the xml document and returns an array of elements with specified name
           //in this case the array is of size 1 because there is only one element with simEndTime as the name
           NodeList nList = doc.getElementsByTagName("system");
           int temp = 0;

           //currNode is then set to be the node in the array that we are currently at in nList which is u1
           Node currNode = nList.item(temp);

           //Gets the children of the u1 module
           NodeList children = currNode.getChildNodes();
           int i=0;
           while(i <children.getLength())
           {
               Node node = children.item(i);
               if(node.getNodeType() == Node.ELEMENT_NODE)
               {
                   if(node.getNodeName().equals(simEndTime))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       Executive.system.setRunEndTime(val);
                   }
                   else if(node.getNodeName().equals(simDelta))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       Executive.system.nslSetRunDelta(val);
                       
                   }

               }
               i++;
           }
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    
    
        
    }
    
    
    public String setModel() //Later, move this function to its own folder because it can be used for any model
    {
        String model = "model";
        
         try 
         {	
            File inputFile = new File("maxSelector.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

           //getElementsByTagName searches the xml document and returns an array of elements with specified name
           //in this case the array is of size 1 because there is only one element with simEndTime as the name
           NodeList nList = doc.getElementsByTagName("system");
           int temp = 0;

           //currNode is then set to be the node in the array that we are currently at in nList which is u1
           Node currNode = nList.item(temp);

           //Gets the children of the u1 module
           NodeList children = currNode.getChildNodes();
           int i=0;
           while(i <children.getLength())
           {
               Node node = children.item(i);
               if(node.getNodeType() == Node.ELEMENT_NODE)
               {
                   if(node.getNodeName().equals(model))
                   {
                       return node.getTextContent();
                       
                   }
                  

               }
               i++;
           }
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return "error";
        
    }
    
    
    
    
    public double getRunDelta()
    {
        
        String simDelta = "simDelta";
               
         try 
         {	
            File inputFile = new File("maxSelector.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

           //getElementsByTagName searches the xml document and returns an array of elements with specified name
           //in this case the array is of size 1 because there is only one element with simEndTime as the name
           NodeList nList = doc.getElementsByTagName("system");
           int temp = 0;

           //currNode is then set to be the node in the array that we are currently at in nList which is u1
           Node currNode = nList.item(temp);

           //Gets the children of the u1 module
           NodeList children = currNode.getChildNodes();
           int i=0;
           while(i <children.getLength())
           {
               Node node = children.item(i);
               if(node.getNodeType() == Node.ELEMENT_NODE)
               {
                   if(node.getNodeName().equals(simDelta))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       return val;
                   }

               }
               i++;
           }
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
         
         return -1;
    }  
        
    public double getapproxDelta()
    {
        
        String approxDelta = "delta";
               
         try 
         {	
            File inputFile = new File("maxSelector.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

           //getElementsByTagName searches the xml document and returns an array of elements with specified name
           //in this case the array is of size 1 because there is only one element with simEndTime as the name
           NodeList nList = doc.getElementsByTagName("diff");
           int temp = 0;

           //currNode is then set to be the node in the array that we are currently at in nList which is u1
           Node currNode = nList.item(temp);

           //Gets the children of the u1 module
           NodeList children = currNode.getChildNodes();
           int i=0;
           while(i <children.getLength())
           {
               Node node = children.item(i);
               if(node.getNodeType() == Node.ELEMENT_NODE)
               {
                   if(node.getNodeName().equals(approxDelta))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       return val;
                   }

               }
               i++;
           }
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
         
         return -1;
    }  
       
    
    
    public void setULayer(NslDouble0 w1, NslDouble0 w2, NslDouble0 h1, NslDouble0 k, NslDoutDouble1 uf, NslDouble1 up)
    {
    /* Code for parsing maxSelector xml document and retrieving the data that will be used to initialzie model variables. */
        
        String wOne = "w1";
        String wTwo = "w2";
        String hOne = "h1";
        String K = "k";
        String outport = "uf";
        String size = "up";
               
         try 
         {	
            File inputFile = new File("maxSelector.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

           //getElementsByTagName searches the xml document and returns an array of elements with specified name
           //in this case the array is of size 1 because there is only one element with simEndTime as the name
           NodeList nList = doc.getElementsByTagName("u1");
           int temp = 0;

           //currNode is then set to be the node in the array that we are currently at in nList which is u1
           Node currNode = nList.item(temp);

           //Gets the children of the u1 module
           NodeList children = currNode.getChildNodes();
           int i=0;
           while(i <children.getLength())
           {
               Node node = children.item(i);
               if(node.getNodeType() == Node.ELEMENT_NODE)
               {
                   if(node.getNodeName().equals(wOne))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       w1.set(val);
                   }
                   else if(node.getNodeName().equals(wTwo))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       w2.set(val);
                   }
                   else if(node.getNodeName().equals(hOne))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       h1.set(val);
                   }
                   else if(node.getNodeName().equals(K))
                   {
                       double val = Double.parseDouble(node.getTextContent());
                       k.set(val);
                   }
                   else if(node.getNodeName().equals(outport))
                   {
                       String numbers = node.getTextContent();
                       String[] parts = numbers.split(" ");    //splits the numbers by the spaces between them.
                       double[] ufArray = new double[parts.length];
                       for(int n = 0; n < parts.length; n++)
                       {
                           ufArray[n] = Double.parseDouble(parts[n]);
                           uf.set(n, ufArray[n]);
                       }

                   }
                   else if(node.getNodeName().equals(size))
                   {
                       String numbers = node.getTextContent();
                       String[] parts = numbers.split(" ");    //splits the numbers by the spaces between them.
                       double[] upArray = new double[parts.length];
                       for(int n = 0; n < parts.length; n++)
                       {
                           upArray[n] = Double.parseDouble(parts[n]);
                           up.set(n, upArray[n]);
                       }

                   }
               }

               i++;
           }

        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    
    }
    
    
    public void setVLayer(NslDoutDouble0 vf, NslDouble0 vp, NslDouble0 h2)
    {
        
        String vF = "vf";
        String vP = "vp";
        String hTwo = "h2";
        
               
         try 
         {	
         File inputFile = new File("maxSelector.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
        
        //getElementsByTagName searches the xml document and returns an array of elements with specified name
        //in this case the array is of size 1 because there is only one element with simEndTime as the name
        NodeList nList = doc.getElementsByTagName("v1");
        int temp = 0;
        
        //currNode is then set to be the node in the array that we are currently at in nList which is v1
        Node currNode = nList.item(temp);
        
        //Gets the children of the u1 module
        NodeList children = currNode.getChildNodes();
        int i=0;
        while(i <children.getLength())
        {
            Node node = children.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                if(node.getNodeName().equals(vF))
                {
                    double val = Double.parseDouble(node.getTextContent());
                    vf.set(val);
                }
                else if(node.getNodeName().equals(vP))
                {
                    double val = Double.parseDouble(node.getTextContent());
                    vp.set(val);
                }
                else if(node.getNodeName().equals(hTwo))
                {
                    double val = Double.parseDouble(node.getTextContent());
                    h2.set(val);
                }
                
            }
            
            i++;
        }
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
        
    }
    
    public void setStimulus(NslDoutDouble1 s_out)
    {
        String stimulus = "s_out";
        
         try 
         {	
         File inputFile = new File("maxSelector.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
        
        //getElementsByTagName searches the xml document and returns an array of elements with specified name
        //in this case the array is of size 1 because there is only one element with simEndTime as the name
        NodeList nList = doc.getElementsByTagName("stimulus");
        int temp = 0;
        
        //currNode is then set to be the node in the array that we are currently at in nList which is stimulus
        Node currNode = nList.item(temp);
        
        //Gets the children of the u1 module
        NodeList children = currNode.getChildNodes();
        int i=0;
        while(i <children.getLength())
        {
            Node node = children.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                if(node.getNodeName().equals(stimulus))
                {
                    String numbers = node.getTextContent();
                    String[] parts = numbers.split(" ");    //splits the numbers by the spaces between them.
                    double[] s_outArray = new double[parts.length];
                    for(int n = 0; n < parts.length; n++)
                    {
                        s_outArray[n] = Double.parseDouble(parts[n]);
                        s_out.set(n, s_outArray[n]);
                    }
                    
                }
                
                
                
            }
            
            i++;
        }
        
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    

}