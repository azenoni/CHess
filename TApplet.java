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
	//private Piece piece;
	private King king;
	private Queen queen;
	private Rook rook;
	private Bishop bishop;
	private Pawn pawn;
	private Knight knight;
	private JButton[][] board;
	private JButton lastClicked, temp;
	private boolean selected = false;

	public void init() {
		
		btn = new JButton();
		setLayout(new GridLayout(8,8));
		board = new JButton[8][8];
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				Piece piece = null;
				if (i == 0 || i == 7) {
					if (x == 0 || x == 7) {
						//btn = new JButton("r");
						if (i == 0) {
							rook = new Rook(Color.BLACK,i,x);
							rook.setIcon(new ImageIcon(Piece.loadImage("rook_black")));
							piece = rook;
						} else {
							rook = new Rook(Color.WHITE,i,x);
							rook.setIcon(new ImageIcon(Piece.loadImage("rook_white")));
							piece = rook;
						}
					}
					if (x == 1 || x == 6) {
						//btn = new JButton("kn");
						if (i == 0) {
							knight = new Knight(Color.BLACK,i,x);
							knight.setIcon(new ImageIcon(Piece.loadImage("knight_black")));
							piece = knight;
						} else {
							knight = new Knight(Color.WHITE,i,x);
							knight.setIcon(new ImageIcon(Piece.loadImage("knight_white")));
							piece = knight;
						}
					}
					if (x == 2 || x == 5) {
						//btn = new JButton("b");
						if (i == 0) {
							bishop = new Bishop(Color.BLACK,i,x);
							bishop.setIcon(new ImageIcon(Piece.loadImage("bishop_black")));
							piece = bishop;
						} else {
							bishop = new Bishop(Color.WHITE,i,x);
							bishop.setIcon(new ImageIcon(Piece.loadImage("bishop_white")));
							piece = bishop;
						}
					}
					if (x == 3) {
						//btn = new JButton("q");
						if (i == 0) {
							queen = new Queen(Color.BLACK,i,x);
							queen.setIcon(new ImageIcon(Piece.loadImage("queen_black")));
							piece = queen;
						} else {
							queen = new Queen(Color.WHITE,i,x);
							queen.setIcon(new ImageIcon(Piece.loadImage("queen_white")));
							piece = queen;
						}
					}
					if (x == 4) {
						//btn = new JButton("ki");

						if (i == 0) {
							king = new King(Color.BLACK, i,x);
							king.setIcon(new ImageIcon(Piece.loadImage("king_black")));
							piece = king;
						} else {
							king = new King(Color.WHITE, i,x);
							king.setIcon(new ImageIcon(Piece.loadImage("king_white")));
							piece = king;
						}
					}

				} else if (i == 1 || i == 6) {
					//btn = new JButton("p");

					if (i == 1) {
						pawn = new Pawn(Color.BLACK,i,x);
						pawn.setIcon(new ImageIcon(Piece.loadImage("pawn_black")));
						piece = pawn;
					} else {
						pawn = new Pawn(Color.WHITE,i,x);
						pawn.setIcon(new ImageIcon(Piece.loadImage("pawn_white")));
						piece = pawn;
					}
				} else {
					if (piece == null) {
						System.out.println("null");
						if (i%2 == 0) {
							if (x%2 == 0) {
								btn.setBackground(Color.DARK_GRAY);
							} else {
								// dark color
								btn.setBackground(Color.LIGHT_GRAY);
							}
						} else {
							if (x%2 == 0) {
								// dark color
								btn.setBackground(Color.LIGHT_GRAY);
							} else {
								btn.setBackground(Color.DARK_GRAY);
							}
						}
						btn.setBorderPainted(false);
						btn.setOpaque(true);
						btn.addActionListener(this);
						board[i][x] = btn;
						this.add(btn);
						continue;
					}
					//btn = new JButton();
				} 
				if (i % 2 == 0) {
					if (x % 2 == 0) {
						piece.setBackground(Color.DARK_GRAY);
					} else {
						piece.setBackground(Color.LIGHT_GRAY);
					}
				} else{
					if (x % 2 == 1) {
						piece.setBackground(Color.DARK_GRAY);
					} else {
						piece.setBackground(Color.LIGHT_GRAY);
					}
				}
				piece.setBorderPainted(false);
				piece.setOpaque(true);
				piece.addActionListener(this);
				this.add(piece);
				board[i][x] = piece;
				board[i][x].addActionListener(this);
			}
			
		}
	}
	public void paint(Graphics g){
		super.paint(g);
	}
	public void actionPerformed(ActionEvent ae) {
		JButton currentlyClicked = (JButton)ae.getSource();
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				if (ae.getSource() == board[i][x] && !selected) {
					this.temp = new JButton();
					this.temp = board[i][x];
					board[i][x].setEnabled(false);
					selected = true;
				} else {
					//board[i][x] = this.temp.getMoveLocations();
				}
			}
		}
		//lastClicked = (JButton)ae.getSource();
		//board[0][0] = lastClicked;
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