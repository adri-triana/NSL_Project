/*  SCCS - @(#)NslDoutString0.java	1.3 - 09/01/99 - 00:16:56 */

// Copyright: Copyright (c) 1997 University of Southern California Brain Project.
// Copyright: This software may be freely copied provided the toplevel
// Copyright: COPYRIGHT file is included with each such copy.
// Copyright: Email nsl@java.usc.edu.

// NslDoutString0.java
////////////////////////////////////////////////////////////////////////////////

package nslj.src.lang;

public class NslDoutString0 extends NslString0 {

    NslOutport outport=null;

    public NslDoutString0(NslModule owner) {
	super(); 
	attachPort(owner);
    }

    public NslDoutString0(NslModule owner,NslString0 n) {
      super(n); 
      attachPort(owner);
    }

    public NslDoutString0(NslModule owner,String name) {
       super(name); 
       attachPort(owner);
    }
    
    public NslDoutString0(String name,NslModule owner) {
       super(name,owner);
       attachPort(owner);
    }

    public NslDoutString0(NslModule owner,String name, String value) {
	super(name,owner,value);
	attachPort(owner);
    }

    public NslDoutString0(NslModule owner,String name, NslString0 value) {
    	super(name,owner,value);
    	attachPort(owner);
    }

    public NslDoutString0(String name, NslModule owner, String value) {
	super(name,owner,value);
	attachPort(owner);
    }

    public NslDoutString0(String name, NslModule owner,NslString0 value) {
	super(name,owner,value);
	attachPort(owner);
    }

    private void attachPort(NslModule owner) {
	// System.out.println("Attaching "+this+" to module "+owner);
	outport=new NslOutport(this);
	outport.owner=owner;
	owner.nslAddExistingOutport(outport);  /* Add to owners outport list */
    }

    public NslOutport getOutport() { 
    	return(outport); 
    }
    
    public NslPort nslGetPort() { 
    	return(outport); 
    }

    public void nslSetBuffering(boolean v) {
    	outport.nslSetBuffering(v);
    }

}

// NslDoutString0.java
////////////////////////////////////////////////////////////////////////////////
