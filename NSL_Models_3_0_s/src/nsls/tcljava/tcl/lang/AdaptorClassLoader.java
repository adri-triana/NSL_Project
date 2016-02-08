/*
 * AdaptorClassLoader.java --
 *
 *	ClassLoader for loading event adaptor classes.
 *
 * Copyright (c) 1997 Sun Microsystems, Inc.
 *
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL
 * WARRANTIES.
 *
 * RCS: @(#) $Id: AdaptorClassLoader.java,v 1.1.1.1 1998/10/14 21:09:14 cvsadmin Exp $
 */

package tcl.lang;

import java.util.*;
import java.lang.reflect.*;
import java.beans.*;

/*
 * This class is a ClassLoader which loads event adaptor classes
 * generated by AdaptorGen.
 */

class AdaptorClassLoader extends ClassLoader {

/*
 * Number of classes generated so far.
 */

private static int genCount = 0;

/*
 * The event adaptor generator.
 */

private AdaptorGen adaptorGen = new AdaptorGen();


/*
 *----------------------------------------------------------------------
 *
 * getNewClassName --
 *
 *	Generate a unique class name for a new adaptor class. The
 *	first adaptor class is tcl.lang.Adaptor0, the second is
 *	tcl.lang.Adaptor1, and so on.
 *
 * Results:
 *	A unique name for an adaptor class.
 *
 * Side effects:
 *	None.
 *
 *----------------------------------------------------------------------
 */

private synchronized String
getNewClassName()
{
    return "tcl.lang.Adaptor" + (genCount ++);
}

/*
 *----------------------------------------------------------------------
 *
 * loadEventAdaptor --
 *
 *	Generates and loads an event adaptor class to handle the given
 *	event set.
 *
 * Results:
 *	The Class object of the newly generated adaptor class.
 *
 * Side effects:
 *	The adaptor class is generated and loaded into the JVM.
 *
 *----------------------------------------------------------------------
 */

synchronized Class
loadEventAdaptor(
    Interp interp,		// Current interpreter.
    EventSetDescriptor desc)	// The descriptor of the event interface
				// to generate an adaptor for.
{
    String classToGen = getNewClassName();
    byte classData[] = adaptorGen.generate(desc, EventAdaptor.class,
	    classToGen);
    Class cls = defineClass(classToGen, classData, 0, classData.length);
    resolveClass(cls);

    return cls;
}

/*
 *----------------------------------------------------------------------
 *
 * loadClass --
 *
 *	Loads the given class in the JVM. We simply calls Class.forName()
 *	to load the class using the default class loader.
 *
 * Results:
 *	The Class object of the requested class.
 *
 * Side effects:
 *	The class is loaded into the JVM.
 *
 *----------------------------------------------------------------------
 */

protected synchronized Class
loadClass(
    String className,		// The name of the class to load.
    boolean resolve)		// True if we must resolve the class now.
throws
    ClassNotFoundException	// If the class cannot be found.
{
    Class cls = Class.forName(className);

    if (resolve) {
	resolveClass(cls);
    }
    return cls;
}

} // end AdaptorClassLoader

