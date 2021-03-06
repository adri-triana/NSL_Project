/* 
 * JavaInstanceofCmd.java --
 *
 *	This class implements the built-in "instanceof" command in Tcl.
 *
 * Copyright (c) 1997 by Sun Microsystems, Inc.
 *
 * See the file "license.terms" for information on usage and redistribution
 * of this file, and for a DISCLAIMER OF ALL WARRANTIES.
 *
 * RCS: @(#) $Id: JavaInstanceofCmd.java,v 1.1.1.1 1998/10/14 21:09:14 cvsadmin Exp $
 */

package tcl.lang;

class JavaInstanceofCmd implements Command {

/*
 *----------------------------------------------------------------------
 *
 * cmdProc --
 *
 *	This procedure is invoked to process the "java::instanceof" Tcl
 *      command.  See the user documentation for details on what it
 *      does.
 *
 * Results:
 *	None.
 *
 * Side effects:
 *	A standard Tcl result is stored in the interpreter.
 *
 *----------------------------------------------------------------------
 */

public void
cmdProc(
    Interp interp,              // The current interpreter.
    TclObject argv[])           // The command arguments.
throws
    TclException		// Standard Tcl Exception.
{
    if (argv.length != 3) {
	throw new TclNumArgsException(interp, 1, argv, "object class");
    }
    
    Class cls = null;
    Object obj = null;
    
    obj = ReflectObject.get(interp, argv[1]);
    cls = ClassRep.get(interp, argv[2]);
    
    if (obj == null) {
	interp.setResult(false);
    } else {
	interp.setResult(cls.isInstance(obj));
    }
}

}  // end JavaInstanceofCmd


