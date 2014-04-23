import java.applet.*;
import java.awt.*;
import java.util.*;
import java.*;

public class board extends Applet{
	public static void main(String[] args) {
		
	}
	public board(){
		int[][] board = {{16,15,14,13,12,14,15,16},
						 {11,11,11,11,11,11,11,11},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0},
						 {1,1,1,1,1,1,1,1},
<<<<<<< HEAD
						 {6,5,4,3,2,4,5,6},};
=======
						 {6,5,4,3,2,4,5,6}};
>>>>>>> 0586b3a5623f0da7118f203361c1d6d22bf3fd7a

		
	}

<<<<<<< HEAD
	
=======
	public void drawBoard(){

	}
>>>>>>> 0586b3a5623f0da7118f203361c1d6d22bf3fd7a

	public void paint(Graphics g) {
	    int w=0;
	    int h=0;
	    int y=0;

	    for(int j=1;j<=4;j++) {


	    	for(int i=0;i<=w;i=i+w/8) {

	        	g.setColor(Color.BLACK);
	        	g.fillRect(i,y,w/8,h/8);
	        	i=i+w/8;
	        	g.setColor(Color.WHITE);
	        	g.fillRect(i,y,w/8,h/8);

	    	}
	       	y=y+h/8;
	    	for( int i=0;i<=w;i=i+w/8) {
	        	g.setColor(Color.WHITE);
	        	g.fillRect(i,y,w/8,h/8);
	        	i=i+w/8;
	        	g.setColor(Color.BLACK);
	        	g.fillRect(i,y,w/8,h/8);
	    	}
	        y=y+h/8;
	    }

	}
}

