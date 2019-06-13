import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import cs101.sosgame.*;

/**
 * @(#)SOSGUIPanel.java
 *
 *
 * @author yunus umeyr kýlýç
 * @version 1.00 2015/4/7
 */


public class SOSGUIPanel extends JFrame{

    //properties
    JLabel label1, label2;
    JRadioButton button1, button2;
    int score1, score2;
    SOSCanvas canvas;
    Point point;
    int row, col;
    char letter;
    
    public SOSGUIPanel() 
    {
    	
    	//set operations
    	setName( "MySOS game");
    	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    	setLayout( new BorderLayout());
    	
    	//add an instance of SOSCanvas class and add mouse listener
    	canvas = new SOSCanvas();
    	canvas.addMouseListener( new MyMouseListener());
    	add(canvas, BorderLayout.CENTER);
    	
    	//Initialize the labels 
    	label1 = new JLabel( " Mustafa : " + score1);
    	label2 = new JLabel( " Ahmed : " + score2);
    	
    	
    	//Initialize the buttons and make them a group
    	button1 = new JRadioButton( "S" );
    	button2 = new JRadioButton( "0" );	
    	ButtonGroup group = new ButtonGroup();
    	group.add(button1);
    	group.add( button2);
    	//add action listeners
    	button1.addActionListener( new MyActionListener());
    	button2.addActionListener( new MyActionListener());
    	
    	//add labels and buttons
    	add( label1, BorderLayout.WEST);
    	add( label2, BorderLayout.EAST);
    	add( button1,BorderLayout.NORTH );
    	add( button2, BorderLayout.SOUTH);
    	
    	//initialize score as zero
    	score1 = 0;
    	score2 = 0;
    	
    	//show the first player
    	label1.setBackground(Color.RED);
    	
    	//set opaque true
    	label1.setOpaque( true);
    	label2.setOpaque( true);
    	
    	//sets opeartion
    	setBackground( Color.CYAN);
    	pack();
    	setVisible( true);
    }
    
    //inner class
    public class MyMouseListener implements MouseListener
    {
    	public void mousePressed( MouseEvent event)
    	{
    		// determines the rows and columns
    		point = event.getPoint();
    		System.out.println( point);
    		row = (int)( point.getY()) / 100 + 1;
    		col = (int) ( point.getX()) / 100 + 1;
    		System.out.println(row +"  " + col + " " + letter);
    		
    		//play the sos game
    		SOSCanvas.mysos.play( letter, row, col);
    		
    		//update the score
    		score1 = SOSCanvas.mysos.getPlayerScore1();
    		score2 = SOSCanvas.mysos.getPlayerScore2();
    		
    		//update the text of the label
    		label1.setText( " Mustafa : " + score1);
    		label2.setText( " Ahmed : " + score2);
    		
    		//show the turn of hte players
    		if( SOSCanvas.mysos.getTurn() == 1)
    		{
    			label1.setBackground(Color.RED);
    			label2.setBackground(Color.GRAY);
    		}
    		else
    		{
    			label1.setBackground(Color.GRAY);
    			label2.setBackground(Color.RED);
    		}
    		
    		//check whether the game is finished or not
    		if( SOSCanvas.mysos.isGameOver())
    		{
    			if( score1 > score2)
    			{
    				JOptionPane.showMessageDialog(null, " Mustafa is the winner");
    			}
    			if( score2 > score1)
    			{
    				JOptionPane.showMessageDialog(null, " Ahmed is the winner");
    			}
    			if( score1 == score2)
    			{
    				JOptionPane.showMessageDialog(null, " It's a draw");
    			}
    		}
    		//repaint
    		canvas.repaint();
    	}
    	
    	//unnecessary methods from mouselistener
    	public void mouseClicked(MouseEvent event) {}
    	public void mouseReleased(MouseEvent event) {}
    	public void mouseEntered(MouseEvent event) {}
    	public void mouseExited(MouseEvent event) {}
    }
    
    //inner class actionlistener
    public class MyActionListener implements ActionListener
    {
    	public void actionPerformed( ActionEvent event)
    	{
    		Object source = event.getSource();
    		
    		//determine which button is pressed
    		if( source == button1)
    			letter = 's';
    		else
    			letter = 'o';
    	}
    }
    
    
}