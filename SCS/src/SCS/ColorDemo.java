package SCS;
// Copyright: Copyright (c) 1997 University of Southern California Brain Project.
// Copyright: This software may be freely copied provided the toplevel
// Copyright: COPYRIGHT file is included with each such copy.
// Copyright: Email nsl@java.usc.edu.



import java.awt.*; 
import javax.swing.*;
import java.io.*;
import java.lang.Math;
import java.awt.event.*;

class ColorDemo extends Canvas
{
  private String fillcol = "RED"  ;
  Color testcol ;

  public void ColorDemo () {

    fillcol = "RED" ;
    testcol = Color.red ;
    repaint();
  }

  public void paint ( Graphics g )
    {
	// The real size of the popup window is being set in SchEditorFrame and IconEditorFrame
	// The following 
	//System.out.print("Debug:ColorDemo:paint called..");

      //This is changing the color at the top of the ColorDemo frame
	g.drawRect(0,0,100,30); 
      
             
      g.setColor(  SCSUtility.returnCol(  fillcol  ) ) ;

      g.fillRect(0,0,100,30); //
    }

  public void setColorFunc(String col )
    {
      fillcol = col  ;
    }
  public String getColorFunc( )
    {
      return(fillcol) ;
    }
}






