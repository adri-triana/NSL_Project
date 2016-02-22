/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierarchyList;

import java.util.Vector;
import nslj.src.lang.NslModule;
import nslj.src.lang.NslNumeric;
import nslj.src.nsls.struct.Executive;

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
        
        NslModule top;
	Vector children;
        String name = "MaxSelectorStimulus";
        NslModule child1;
        NslModule child2;
        NslModule child3;
	

	top = Executive.system.nslGetModelRef(); 
	if (top==null) {
	    System.out.println("******  Top module not found  ******");
       	}
        else { 
       	    System.out.println("*** Top Module:" + top.nslGetName());
	    
	}
	
        //Gets the children of the top module
        children = top.nslGetModuleChildrenVector();
        int i = 0;
        
        while(i < children.size())
        {
            System.out.println("Children of top module are: " + children.get(i));
            
            i++;
        }
        
        //top.nslPrintChildModules();
        
        child1 = Executive.system.nslGetModuleRef(name);
        if (child1 == null) { 
            System.out.println("*** Child1 Module:" + child1.nslGetName());
            
        }
        else {
            System.out.println("******  Child module not found  ******");
        }
        
    }
    
    
    
    
    
    
    
    
    
    
}
