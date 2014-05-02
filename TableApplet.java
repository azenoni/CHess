import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class TableApplet extends Applet implements ActionListener{

	private JButton btn;
	//private Piece king, queen, knight, rook, bishop, pawn;
	private Queen queen;
	private King king;
	private Knight knight;
	private Rook rook;
	private Bishop bishop;
	private Pawn pawn;


	public void init() {

		for (int i = 0; i < 64; i++) {
			setLayout(new GridLayout(8,8));
			btn = new JButton();
			if (i > 7 && i < 16 || i > 23 && i < 32 || i > 39 && i < 48 || i>55 && i<64) {
				if (i % 2 == 0) {
					btn.setBackground(Color.BLACK);
				} else {
					btn.setBackground(Color.RED);
				}	
				
			} else {
				if (i % 2 == 0) {
					btn.setBackground(Color.RED);
				} else {
					btn.setBackground(Color.BLACK);
				}	
			}

			String path = null;
			Image image = null;
			if(i == 0 || i == 7) {
				rook.loadImage(Color.BLACK);
			}
			if (i == 1 || i == 6) {
				knight.loadImage(Color.BLACK);
			}
			if (i == 2 || i == 5) {
				bishop.loadImage(Color.BLACK);
			}
			if(i == 3) {
				queen.loadImage(Color.BLACK);
			}
			if (i == 4) {
				king = new King(Color.BLACK);
			}
			if (i > 7 && i<16) {
				pawn.loadImage(Color.BLACK);
			} else if (i > 47 &&  i < 56) {
				pawn.loadImage(Color.WHITE);
			}
			btn.setContentAreaFilled(false);
			btn.setForeground(Color.BLACK);
			btn.setOpaque(true);
			btn.addActionListener(this);
			this.add(btn);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
	}
	public void actionPerformed(ActionEvent ae) {
		
	}


	
}