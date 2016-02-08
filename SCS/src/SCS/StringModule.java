package SCS;
// Copyright: Copyright (c) 1997 University of Southern California Brain Project.
// Copyright: This software may be freely copied provided the toplevel
// Copyright: COPYRIGHT file is included with each such copy.
// Copyright: Email nsl@java.usc.edu.

/**
 * StringModule  - A wrapper class  
 *
 * @author       Alexander
 * @version     %I%, %G%
 *
 * @param       instring1
 * @param       currModule
 *
 * @since       JDK1.3
 */
import java.lang.*;

class StringModule {
    String string1="";
    Module module1=null;

    /**
     * Constructors of this class
     */

    StringModule () {
	string1="";
	module1=null;
    }

    StringModule (String instring1,Module currModule) {
	string1=instring1;
	module1=currModule;
    }

    StringModule (String instring1,String libNickName, String moduleName, String versionName) {
	string1=instring1;
	module1=new Module(libNickName, moduleName, versionName);
    }
    //----------------------------------------------------
    public boolean equals(StringModule insm) {
	boolean found=false;
	if (insm==null) return (found=false);
	if (insm.string1==null) {
	    //System.out.println("Debug:StringModule: insm.string1: null");
	    return (found=false);
	}
	if (insm.module1==null) {
	    //System.out.println("Debug:StringModule: insm.module1:null");
	    return (found=false);
	}

	if (this.string1==null){ 
	    //System.out.println("Debug:StringModule: this.string1: null");
            return (found=false);
	}

	if (this.module1==null) {
	    //System.out.println("Debug:StringModule: this.module1:null");
            return (found=false);
	}

	if (((this.string1).equals(insm.string1)) &&
	    ((this.module1).mostlyEquals(insm.module1))) {
	    //System.out.println("StringModule: equals: true");
	    return(found=true);
	} else {
	    //System.out.println("StringModule: equals: false");
	    return(found=false);
	}
    }
    //--------------------------

    public boolean equals(Object insm) {
	boolean found=false;
	if (insm==null) return (found=false);
	if (insm instanceof StringModule) {
	    if (((StringModule)insm).string1==null) {return (found=false);}
	    if (((StringModule)insm).module1==null) {return (found=false);}

	    return(found=equals((StringModule)insm));
	} else {
	    return(found=false);
	}
    }
    //--------------------------
} //end StringModule







