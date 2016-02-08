package SCS;
// Copyright: Copyright (c) 1997 University of Southern California Brain Project.
// Copyright: This software may be freely copied provided the toplevel
// Copyright: COPYRIGHT file is included with each such copy.
// Copyright: Email nsl@java.usc.edu.

/**
 * StringModuleV  - A wrapper class  
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
import java.util.Vector;
import java.io.*;

class StringModuleV extends Vector{

    /**
     * Constructor of this class
     */

    public  StringModuleV () {
	super();
    }

    //---------------------------------------------------------------------
    public boolean add(Object stringModule) {
	boolean worked=false;
	//System.out.println("Debug:StringModuleV:add: using Object");
	if (!(stringModule instanceof StringModule)) {

	    return(worked=false);
	} else if (this.contains(stringModule)) {
	    return(worked=false);
	} else {
	    addElement(stringModule);
	    return (worked=true);
	}

    }
    //---------------------------------------------------------------------
    public boolean add(StringModule stringModule) {
	//System.out.println("Debug:StringModuleV:add: using StringModule");
	boolean worked=false;
	if (this.contains(stringModule)) {
	    //System.out.println("Debug:StringModuleV:add:worked = false");
	    return(worked=false);
	} else {
	    addElement(stringModule);
	    //System.out.println("Debug:StringModuleV:add:worked = true");
	    int sz=this.size();
	    if (sz>0) {
		StringModule sm=(StringModule)this.get(sz-1);
		//System.out.println("Debug:StringModuleV:add: "+sm.string1);
		//System.out.println("Debug:StringModuleV:add: "+sm.module1.moduleName);
	    }
	    return (worked=true);
	}
    }
    //---------------------------------------------------------------------
    public boolean addInPieces(String instring1,Module inmod) {
	boolean worked=false;
	//System.out.println("Debug:StringModuleV:addInPieces: "+instring1+" "+inmod.moduleName);
	StringModule vElement=new StringModule(instring1,inmod);
	worked=add(vElement);

	return(worked);
    }
    //---------------------------------------------------------------------

    public boolean contains(String instring, Module inmod) {
	boolean found=false;
	int sz=this.size();
	for (int i=0; i<sz; i++) {
	    StringModule vElement=(StringModule)this.elementAt(i);
	    if ((vElement.string1.equals(instring))&&
	        (vElement.module1.mostlyEquals(inmod))) {
		return(found=true);
	    }
	}
	return(found=false);
    }

    //---------------------------------------------------------------------
    public boolean containsString1(StringModule stringModule) {
	boolean found=false;
	int sz=this.size();
        String edName=stringModule.string1;
	for (int i=0; i<sz; i++) {
	    StringModule vElement=(StringModule)this.elementAt(i);
	    String edNameV=vElement.string1;
	    if (edName.equals(edNameV)) {
		return(found=true);
	    }
	}
	return(found=false);
    }
    //---------------------------------------------------------------------
    public boolean containsString1(String string1) {
	boolean found=false;
	int sz=this.size();
        String edName=string1;
	for (int i=0; i<sz; i++) {
	    StringModule vElement=(StringModule)this.elementAt(i);
	    String edNameV=vElement.string1;
	    if (edName.equals(edNameV)) {
		return(found=true);
	    }
	}
	return(found);
    }
    //---------------------------------------------------------------------
    public boolean containsModule(StringModule stringModule) {
	boolean found=false;
	int sz=this.size();
	if (stringModule==null) return (found=false);
        String libNickName=stringModule.module1.libNickName;
        String moduleName=stringModule.module1.moduleName;
        String versionName=stringModule.module1.versionName;
	for (int i=0; i<sz; i++) {
	    StringModule vElement=(StringModule)this.elementAt(i);
	    found=(vElement.module1).mostlyEquals(stringModule.module1);
	    if (found) {
		return (found);
	    }
	}
	return(found);
    }
    //---------------------------------------------------------------
    public boolean containsModule(String libNickName,String moduleName,String versionName) {
	if (indexOfModule(libNickName,moduleName,versionName)>=0) {
	    return (true);
	} else {
	    return (false);
	}

    }
    //---------------------------------------------------------------
    public int indexOfModule(String libNickName,String moduleName,String versionName) {
	int foundi=-1;
	int sz=this.size();
	if (sz==0) return(foundi=-1);
	Module m2=new Module(libNickName,moduleName,versionName);
	boolean eq=false;
	for (int i=0; i<sz; i++) {
	    Module m1=((StringModule)this.elementAt(i)).module1;
	    eq=m1.mostlyEquals(m2);
	    if (eq) {
		return (foundi=i);
	    }
	}
	return(foundi);
    }
    //---------------------------------------------------------------
    public int indexOfModule(Module mod2) {
	int foundi=-1;
	int sz=this.size();
	if (sz==0) return(foundi=-1);
	boolean eq=false;
	for (int i=0; i<sz; i++) {
	    Module m1=((StringModule)this.elementAt(i)).module1;
	    eq=m1.mostlyEquals(mod2);
	    if (eq) {
		return (foundi=i);
	    }
	}
	return(foundi);
    }
    //----------------------------------------------------
    public StringModule getElement(String libNickName,String moduleName,String versionName) {
	// in this method we do not care what the editor is
	boolean worked=false;
	int sz=this.size();
	if (sz==0) return(null);
	//System.out.println("Debug:StringModuleV:getElement1: "+libNickName+" "+moduleName);

	Module m2=new Module(libNickName,moduleName,versionName);

	int ii=indexOfModule(m2);
	if (ii<0) {
	    return (null);
	} else {
	    return((StringModule)elementAt(ii));
	}
    }
    //---------------------------------------------------------------
    public StringModule getElement(String string1, String libNickName,String moduleName,String versionName) {
	boolean worked=false;
	int sz=this.size();
	if (sz==0) return(null);
	//System.out.println("Debug:StringModuleV:getElement2: "+libNickName+" "+moduleName);

	Module m2=new Module(libNickName,moduleName,versionName);
	StringModule sm2=new StringModule(string1, m2);
	int ii=indexOf(sm2);
	if (ii<0) {
	    return (null);
	} else {
	    return((StringModule)elementAt(ii));
	}
    }

    //----------------------------------------------------
    public boolean replace(String string1, Module mod1,String string2,Module mod2) {
	boolean worked=false;
	if (string1==null) return(worked=false);
	if (mod1==null) return(worked=false);
	if (string2==null) return(worked=false);
	if (mod2==null) return(worked=false);

	int sz=this.size();
	if (sz==0) return(worked=false);
	StringModule sm1=new StringModule(string1,mod1);
	StringModule sm2=new StringModule(string2,mod2);
	int ii=indexOf(sm1);
	if (ii<0) {
	    return (worked=false);
	} else {
	    set(ii,sm2);
	    return(worked=true);
	}
    }
    //----------------------------------------------------
    public boolean remove(StringModule sm1) {
	boolean worked=false;
	if (sm1==null) return(worked=false);

	int sz=this.size();
	if (sz==0) return(worked=false);
	//System.out.println("StringModuleV:size: "+sz);
	int ii=indexOf(sm1);
	//System.out.println("StringModuleV:ii: "+ii);
	if (ii<0) {
	    return (worked=false);
	} else {
	    Object objii=remove(ii);
	    return(worked=true);
	}
    }

    //----------------------------------------------------
    public boolean remove(String string1, Module mod1) {
	boolean worked=false;
	if (string1==null) return(worked=false);
	if (mod1==null) return(worked=false);

	int sz=this.size();
	if (sz==0) return(worked=false);
	StringModule sm1=new StringModule(string1,mod1);
	int ii=indexOf(sm1);
	//System.out.println("StringModuleV:ii: "+ii);
	if (ii<0) {
	    return (worked=false);
	} else {
	    Object objii=remove(ii);
	    return(worked=true);
	}
    }
    //----------------------------------------------------
} //end StringModuleV class






