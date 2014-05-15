import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class TApplet extends Applet implements ActionListener{
	private JButton btn;
	private King king;
	private Queen queen;
	private Rook rook;
	private Bishop bishop;
	private Pawn pawn;
	private Knight knight;
	private JButton[][] board;
	private JButton lastClicked;

	public void init() {
		setLayout(new GridLayout(8,8));
		board = new JButton[8][8];
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				if (i == 0 || i == 7) {
					if (x == 0 || x == 7) {
						btn = new JButton("r");
						if (i == 0) {
							rook = new Rook(Color.BLACK,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("rook_black")));
						} else {
							rook = new Rook(Color.WHITE,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("rook_white")));
						}
					}
					if (x == 1 || x == 6) {
						btn = new JButton("kn");
						if (i == 0) {
							knight = new Knight(Color.BLACK,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("knight_black")));
						} else {
							knight = new Knight(Color.WHITE,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("knight_white")));
						}
					}
					if (x == 2 || x == 5) {
						btn = new JButton("b");
						if (i == 0) {
							bishop = new Bishop(Color.BLACK,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("bishop_black")));
						} else {
							bishop = new Bishop(Color.WHITE,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("bishop_white")));
						}
					}
					if (x == 3) {
						btn = new JButton("q");
						if (i == 0) {
							queen = new Queen(Color.BLACK,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("queen_black")));
						} else {
							queen = new Queen(Color.WHITE,i,x);
							btn.setIcon(new ImageIcon(Piece.loadImage("queen_white")));
						}
					}
					if (x == 4) {
						btn = new JButton("ki");

						if (i == 0) {
							btn.setIcon(new ImageIcon(Piece.loadImage("king_black")));
							king = new King(Color.BLACK, i,x);
						} else {
							btn.setIcon(new ImageIcon(Piece.loadImage("king_white")));
							king = new King(Color.WHITE, i,x);
						}
					}
				} else if (i == 1 || i == 6) {
					btn = new JButton("p");
					if (i == 1) {
						btn.setIcon(new ImageIcon(Piece.loadImage("pawn_black")));
					} else {
						btn.setIcon(new ImageIcon(Piece.loadImage("pawn_white")));
					}
				} else {
					btn = new JButton();
				} 
				if (i % 2 == 0) {
					if (x % 2 == 0) {
						btn.setBackground(Color.DARK_GRAY);
					} else {
						btn.setBackground(Color.LIGHT_GRAY);
					}
				} else{
					if (x % 2 == 1) {
						btn.setBackground(Color.DARK_GRAY);
					} else {
						btn.setBackground(Color.LIGHT_GRAY);
					}
				}
				btn.setBorderPainted(false);
				btn.setOpaque(true);
				btn.addActionListener(this);
				this.add(btn);
				board[i][x] = btn;
			}
			
		}
	}
	public void paint(Graphics g){
		super.paint(g);
	}
	public void actionPerformed(ActionEvent ae) {
		lastClicked = (JButton)ae.getSource();
		board[0][0] = lastClicked;
		if ("p".equals(ae.getActionCommand())) {
			
		}
		if ("".equals(ae.getActionCommand())) {
			//btn.setEnabled(false);
		}
		repaint();

	}
	// public JButton[][] swap(Piece x, Piece y){
	// 	Piece temp = new Piece(x.getColor(),x.getX(),x.getY());
	// 	x = y;
	// 	y = temp;
	// }
}