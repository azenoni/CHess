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
	private JButton pawnB, queenB, kingB, knightB, rookB, bishopB;
	private String s;
	//private Icon icon;


	public void init() {

		for (int i = 0; i < 64; i++) {
			setLayout(new GridLayout(8,8));
			s = "";
			btn = new JButton(s);
			if (i > 7 && i < 16 || i > 23 && i < 32 || i > 39 && i < 48 || i>55 && i<64) {
				if (i % 2 == 0) {
					btn.setBackground(Color.DARK_GRAY);
				} else {
					btn.setBackground(Color.LIGHT_GRAY);
				}	
				
			} else {
				if (i % 2 == 0) {
					btn.setBackground(Color.LIGHT_GRAY);
				} else {
					btn.setBackground(Color.DARK_GRAY);
				}	
			}

			String path = null;
			Image image = null;
			Image img = null;
			

			if(i == 0 || i == 7) {
				
				try{
					path = "img" + File.separator + "rook_black.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			} else if(i == 56 || i == 63) {
				
				try{
					path = "img" + File.separator + "rook_white.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			}
			if (i == 1 || i == 6) {
				try{
					path = "img" + File.separator + "knight_black.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			} else if(i == 57 || i == 62) {
				try{
					path = "img" + File.separator + "knight_white.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			}
			if (i == 2 || i == 5) {
				try{
					path = "img" + File.separator + "bishop_black.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			} else if (i == 58 || i == 61) {
				try{
					path = "img" + File.separator + "bishop_white.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			}
			if(i == 3) {
				try{
					path = "img" + File.separator + "queen_black.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			} else if (i == 59) {
				try{
					path = "img" + File.separator + "queen_white.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			}
			if (i == 4) {
				try{
					path = "img" + File.separator + "king_black.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			} else if (i == 60) {
				try{
					path = "img" + File.separator + "king_white.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			}
			if (i > 7 && i<16) {
				s = "p";
				btn = btn;
				try{
					path = "img" + File.separator + "pawn_black.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			} else if (i > 47 &&  i < 56) {
				s = "p";
				btn = btn;
				try{
					path = "img" + File.separator + "pawn_white.png";
					image = ImageIO.read(new File(path));
					img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
					btn.setIcon(new ImageIcon(img));
				} catch(IOException e) {
					System.out.println("Could not load image at path: " + path);
					System.exit(1);
				}
			}
			
			btn.setContentAreaFilled(false);
			btn.setForeground(Color.BLACK);
			btn.setOpaque(true);
			btn.setBorderPainted(false);
			btn.addActionListener(this);
			this.add(btn);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
	}
	public void actionPerformed(ActionEvent ae) {
		if ("p".equals(ae.getActionCommand())) {
			pawnSelected();
			if(btn.isEnabled()){
				btn = pawnB;
			}
		}
	}
	public void pawnSelected() {
		// queenB.setEnabled(false);
		// kingB.setEnabled(false);
		// rookB.setEnabled(false);
		// bishopB.setEnabled(false);
		// knightB.setEnabled(false);

	}



	
}