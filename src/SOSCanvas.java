import javax.swing.*;
import java.awt.*;
import cs101.sosgame.*;

/**
 * @(#)SOSCanvas.java
 *
 *
 * @author yunus umeyr kýlýç
 * @version 1.00 2015/4/7
 */


public class SOSCanvas extends JPanel{

    //properties
    static SOS mysos;
    String text = "";
    
    
    //constructor
    public SOSCanvas() 
    {
    	mysos = new SOS( 5);// create a new 5 by 5 sos game
    	//set operations
    	setPreferredSize( new Dimension( 500,500));
    	setBackground( Color.CYAN);
    }
    
    //methods
    
    //override the paint method
    public void paintComponent( Graphics page)
    {
 		super.paintComponent( page); //call the parent method 
 		
 		int x, y;// coordinates of sos squares
 		final int SIDE = 100;//each side of squares
 		
 		for( x = 0; x <= 400; x += 100)
 		{
 			for( y = 0; y <= 400; y += 100)
 			{
 				page.drawRect( x, y, SIDE, SIDE);//draw rectangles in accordance with the given parameter
 				
 				text = "" + mysos.getCellContents( y/100, x/100);//get the contents of sos
 				
 				page.drawString( text, x + SIDE/2, y + SIDE/2);//paint the string of each cells
 			}
 		} 	
    }
}