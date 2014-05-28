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
	private JButton lastClicked;
	private boolean selected = false;
	private Piece currentPiece;
	private boolean notFirst = false;
	private Color tempColor;

	public void init() {
		System.out.println("init");
		btn = new JButton();
		setLayout(new GridLayout(8,8));
		board = new JButton[8][8];
		for (int x= 0; x< 8; x++) {
			for (int y = 0; y < 8; y++) {
				Piece piece = null;
				if (x== 0 || x== 7) {
					if (y == 0 || y == 7) {
						//btn = new JButton("r");
						if (x== 0) {
							rook = new Rook(Color.BLACK,x,y);
							rook.setIcon(new ImageIcon(Piece.loadImage("rook_black")));
							piece = rook;
						} else {
							rook = new Rook(Color.WHITE,x,y);
							rook.setIcon(new ImageIcon(Piece.loadImage("rook_white")));
							piece = rook;
						}
					}
					if (y == 1 || y == 6) {
						//btn = new JButton("kn");
						if (x== 0) {
							knight = new Knight(Color.BLACK,x,y);
							knight.setIcon(new ImageIcon(Piece.loadImage("knight_black")));
							piece = knight;
						} else {
							knight = new Knight(Color.WHITE,x,y);
							knight.setIcon(new ImageIcon(Piece.loadImage("knight_white")));
							piece = knight;
						}
					}
					if (y == 2 || y == 5) {
						//btn = new JButton("b");
						if (x== 0) {
							bishop = new Bishop(Color.BLACK,x,y);
							bishop.setIcon(new ImageIcon(Piece.loadImage("bishop_black")));
							piece = bishop;
						} else {
							bishop = new Bishop(Color.WHITE,x,y);
							bishop.setIcon(new ImageIcon(Piece.loadImage("bishop_white")));
							piece = bishop;
						}
					}
					if (y == 3) {
						//btn = new JButton("q");
						if (x== 0) {
							queen = new Queen(Color.BLACK,x,y);
							queen.setIcon(new ImageIcon(Piece.loadImage("queen_black")));
							piece = queen;
						} else {
							queen = new Queen(Color.WHITE,x,y);
							queen.setIcon(new ImageIcon(Piece.loadImage("queen_white")));
							piece = queen;
						}
					}
					if (y == 4) {
						//btn = new JButton("ki");

						if (x== 0) {
							king = new King(Color.BLACK, x,y);
							king.setIcon(new ImageIcon(Piece.loadImage("king_black")));
							piece = king;
						} else {
							king = new King(Color.WHITE, x,y);
							king.setIcon(new ImageIcon(Piece.loadImage("king_white")));
							piece = king;
						}
					}

				} else if (x== 1 || x== 6) {
					//btn = new JButton("p");

					if (x== 1) {
						pawn = new Pawn(Color.BLACK,x,y);
						pawn.setIcon(new ImageIcon(Piece.loadImage("pawn_black")));
						piece = pawn;
					} else {
						pawn = new Pawn(Color.WHITE,x,y);
						pawn.setIcon(new ImageIcon(Piece.loadImage("pawn_white")));
						piece = pawn;
					}
				} else {
					piece = new EmptyPiece(getBoardColor(x,y),x,y);						
				} 
				if (x% 2 == 0) {
					if (y % 2 == 0) {
						piece.setBackground(Color.DARK_GRAY);
					} else {
						piece.setBackground(Color.LIGHT_GRAY);
					}
				} else{
					if (y % 2 == 1) {
						piece.setBackground(Color.DARK_GRAY);
					} else {
						piece.setBackground(Color.LIGHT_GRAY);
					}
				}
				piece.setBorderPainted(false);
				piece.setOpaque(true);
				piece.addActionListener(this);
				//this.add(piece);
				board[x][y] = piece;
			}
			
		}
		buildBoard();
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
		if (ae.getSource().getClass() != EmptyPiece.class && currentPiece == null) {
			System.out.println("getting piece");
			if (currentPiece != null) {
				currentPiece.setBackground(tempColor);
			}
			currentPiece = (Piece)ae.getSource();
			tempColor = currentPiece.getBackground();
			if (currentPiece.getBackground() != Color.GREEN) {
				currentPiece.setBackground(Color.GREEN);
			}
			//currentPiece.setEnabled(false);
		} else if (ae.getSource().getClass() != EmptyPiece.class && currentPiece !=null) {
 			System.out.println("taking piece");
 			//currentPiece.setBackground(tempColor);
 			if (currentPiece.canTakePiece((Piece)ae.getSource())) {
 				Piece oldPiece = (Piece)ae.getSource();
 				int x = oldPiece.getBoardX();
 				int y = oldPiece.getBoardY();
 				//this.remove(oldPiece);

				for(ActionListener act : oldPiece.getActionListeners()) {
				    oldPiece.removeActionListener(act);
				}
				System.out.println("x:"+x+" y:"+y);
 				EmptyPiece temp = new EmptyPiece(getBoardColor(x,y),x,y);
				temp.setBorderPainted(false);
				temp.setOpaque(true);
				temp.addActionListener(this);
				this.add(temp);
				board[x][y] = temp;
 				swapPieces(temp, currentPiece);
 				buildBoard();
				validate();
/*

 				int x = currentPiece.getBoardX();
 				int y = currentPiece.getBoardY();
 				Color color = currentPiece.getBackground();
 				EmptyPiece temp = new EmptyPiece(color,x,y);
 				piece = temp;
 				System.out.println("X: " + x + " Y: " + y);
 				Piece sample = (Piece)ae.getSource();
 				swapPieces(sample, piece);
 				board[sample.getBoardX()][sample.getBoardY()] = temp;
*/ 				
 				
 				//swapPieces(sample,temp);

 			}
 			else {
				tempColor = getBoardColor(currentPiece.getBoardX(),currentPiece.getBoardY());
 				currentPiece.setBackground(tempColor); 				
 			}

 			currentPiece = null;

 				//make new empty piece,
 				//move current piece to otherPiece
 				//move empty peice where current peiece was
 		} else if(currentPiece != null) {
			currentPiece.setBackground(tempColor);
			System.out.println("moving piece to empty spot");
			EmptyPiece temp = (EmptyPiece)ae.getSource();
			if(currentPiece.canMoveHere(board,temp.getBoardX(),temp.getBoardY())) {
				swapPieces(currentPiece, temp);
				currentPiece = null;
			}
			
		}
		buildBoard();
		validate();
		//repaint();
	}		
		
	private void buildBoard() {
		removeAll();
		setLayout(new GridLayout(8,8));
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				btn = board[x][y];
				this.add(btn);
			}
		}
		//validate();
		
	}
		


	
	public void swapPieces(Piece currentPiece, Piece temp) {
		Point xy = currentPiece.getLocation();
		int x = currentPiece.getBoardX();
		int y = currentPiece.getBoardY();
		System.out.println("swapPieces x:"+x+" y:"+y);
		System.out.println("with       x:"+temp.getBoardX()+" y:"+temp.getBoardY());

		//currentPiece.setLocation(temp.getLocation());
		currentPiece.setBoardX(temp.getBoardX());
		currentPiece.setBoardY(temp.getBoardY());
		board[currentPiece.getBoardX()][currentPiece.getBoardY()] = temp;
		//temp.setLocation(xy);
		board[temp.getBoardX()][temp.getBoardY()] = currentPiece;
		temp.setBoardX(x);
		temp.setBoardY(y);
		currentPiece.setBackground(getBoardColor(currentPiece.getBoardX(),currentPiece.getBoardY()));
		temp.setBackground(getBoardColor(temp.getBoardX(),temp.getBoardY()));
		board[x][y] = temp;
		//currentPiece = null;
	}
	
}