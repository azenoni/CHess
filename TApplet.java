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
	private Piece currentPiece;

	public void init() {
		System.out.println("init");
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
					piece = new EmptyPiece(getBoardColor(i,x),i,x);						
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
				//board[i][x].addActionListener(this);
			}
			
		}
	}

	private Color getBoardColor(int x,int y)
	{
		if (x% 2 == 0) {
			if (y % 2 == 0) {
				return Color.DARK_GRAY;
			} else{
				return Color.LIGHT_GRAY;
			}
		} else {
			if (y % 2 == 1) {
				return Color.DARK_GRAY;
			} else{
				return Color.LIGHT_GRAY;
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
	}
	public void actionPerformed(ActionEvent ae) {
 		if (ae.getSource().getClass() != EmptyPiece.class) {
			currentPiece = (Piece)ae.getSource();
		}
		else if(currentPiece != null) {
			EmptyPiece temp = (EmptyPiece)ae.getSource();
			if(currentPiece.canMoveHere(temp.getBoardX(),temp.getBoardY()))
			{
				System.out.println("button");
				board[temp.getBoardX()][temp.getBoardY()] = currentPiece;
				Point xy = currentPiece.getLocation();
				int x = currentPiece.getBoardX();
				int y = currentPiece.getBoardY();
				System.out.println("Empyt x:"+temp.getX()+" y:"+temp.getY());
				currentPiece.setLocation(temp.getLocation());
				currentPiece.setBoardX(temp.getBoardX());
				currentPiece.setBoardY(temp.getBoardY());
				//swapPieces(currentPiece, temp)
				board[currentPiece.getBoardX()][currentPiece.getBoardY()] = temp;
				temp.setLocation(xy);
				temp.setBoardX(x);
				temp.setBoardY(y);
				System.out.println("current x:"+xy.getX()+" y:"+xy.getY());
				currentPiece.setBackground(getBoardColor(currentPiece.getBoardX(),currentPiece.getBoardY()));
				temp.setBackground(getBoardColor(temp.getBoardX(),temp.getBoardY()));
				currentPiece = null;
			}
		}
 		else if (ae.getSource().getClass() != EmptyPiece.class && currentPiece !=null) {
 			Piece otherPiece = (Piece)ae.getSource();
 			if(currentPiece.canTakePiece(otherPiece)) {
 				//make new empty piece,
 				//move current piece to otherPiece
 				//move empty peice where current peiece was
 			}
		}		
		//JButton temp = new JButton();
		
		// if (ae.getSource) {
			
		// }
		// temp = (JButton)ae.getSource();
		//int x = temp.
		// if (!selected) {
		// 	JButton lastClicked = (JButton)ae.getSource();
		// 	selected = true;
		// } else if (selected) {
		// 	System.out.println("swap");
		// 	btn = (JButton)ae.getSource();
		// 	JButton temp = lastClicked;
		// 	lastClicked = btn;
		// 	btn = lastClicked;
		// 	selected = false;
		// }
		
		// for (int i = 0; i < 8; i++) {
		// 	for (int x = 0; x < 8; x++) {
		// 		if (ae.getSource() == board[i][x]) {
		// 			if (board[i][x] == rook) {
		// 				System.out.println("rook");
		// 			}
		// 			//System.out.println("Rook");
		// 			break;
		// 		}
		// 		// if (ae.getSource() == board[i][x] && !selected) {
		// 		// 	System.out.println("1");
		// 		// 	int xP = ((Piece)board[i][x]).getX();
		// 		// 	int y = ((Piece)board[i][x]).getY();
		// 		// 	Color color = ((Piece)board[i][x]).getColor();
		// 		// 	Piece piece = new Piece(color,xP,y);
		// 		// 	ptemp = piece;
		// 		// 	selected = true;
		// 		// } else if ((JButton)ae.getSource() == board[i][x] && selected) {
		// 		// 	System.out.println("2");
		// 		// 	temp = board[i][x];
		// 		// 	board[i][x] = ptemp;

		// 		// }
		// 		// if ((JButton)ae.getSource() == board[i][x] && !selected) {
		// 		// 	System.out.println("swap");
		// 		// 	this.temp = new JButton();
		// 		// 	this.temp = board[i][x];
		// 		// 	board[i][x].setEnabled(false);
		// 		// 	selected = true;
		// 		// 	break;
		// 		// } else if(selected) {
		// 		// 	System.out.println("Swapped");
		// 		// 	board[i][x] = temp;
		// 		// 	selected = false;
		// 		// 	break;
		// 		// }
		// 	}
		// 	//break;
		// }
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