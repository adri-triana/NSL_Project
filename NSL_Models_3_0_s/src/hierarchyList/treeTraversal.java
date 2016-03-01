/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierarchyList;

import java.util.Enumeration;
import java.util.Vector;
import nslj.src.lang.*;
import nslj.src.nsls.struct.Executive;
import xmlUtility.xmlParser;

/**
 *
 * @author Adri
 * This will look through the whole tree composed of modules, in-ports, out-ports, and variables and return references to these specific 
 * places to be able to set values directly.
 */
public class treeTraversal {
    
    /**
     *  Prints the tree structure starting from the top module all the way down to the children and their corresponding 
     *  variables.
     */
    public void printHierarchy()
    {
        String name = "maxSelectorModel.stimulus";
        NslModule top;
	Vector children;
        NslData temp;
        
	

	top = Executive.system.nslGetModelRef(); 
	if (top==null) {
	    System.out.println("******  Top module not found  ******");
       	}
        else { 
       	    System.out.println("*** Top Module:" + top.nslGetName());
	    
	}
	
        
       Executive.system.printModuleVariablesRecursively(top);
        
       temp = Executive.system.nslGetValue(name);
       System.out.println(name + " value is " + temp );
       
       NslModule temp2 = Executive.system.nslGetModuleRef(name);
       System.out.println("Should print out module stimulus" + temp2);






        //Gets the children of the top module
//        children = top.nslGetModuleChildrenVector();
//        
//        int i = 0;
//        
//        while(i < children.size())
//        {
//            System.out.println("Children of top module are: " + children.get(i));
//            
//            i++;
//        }
//        
//        top.nslPrintChildModules();
//        
//        child1 = Executive.system.nslGetModuleRef(name);
//        if (child1 == null) { 
//            System.out.println("*** Child1 Module not found.***");
//            
//        }
//        else {
//            System.out.println("*** Child1 Module:" + child1.nslGetName());
//        }
        
    }
    
    public void setVariables(NslDoutDouble1 s_out){
        
        //This function will attempt to set the s_out variable that is found in the hierarchy using maxSelectorModel.stimulus.s_out and xml
        
        xmlParser parse = new xmlParser();
        parse.parseMaxSelector();
        
        
        
        
    }
    
    
    
    
    
    
    
    
}
