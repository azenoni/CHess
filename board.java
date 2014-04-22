	import java.applet.*;
	import java.awt.*;
	import java.util.*;

	public class board extends Applet
	{
		public void drawBoard() {
			paint(g);
		}

	    public void paint(Graphics g) {
	        int w=getWidth();
	        int h=getHeight();
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