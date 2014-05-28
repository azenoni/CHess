import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Bishop extends Piece {
	
	public Bishop(Color color, int x, int y) {
		super(color,x,y);
	
	}

	@Override
	public boolean canMoveHere(JButton board[][] ,int x,int y) {
		boolean retVal = false;
		if (Math.abs(boardX - x) == Math.abs(boardY - y)) {
			retVal = true;
		}
		if (retVal) {
			for (int z = 0; z < Math.abs(boardX - x) - 1; z++) {
					if (x < boardX) {
						if (y < boardY) {
							if (board[boardX-z][boardY-z].getClass() != (EmptyPiece.class)) {
								System.out.println("bust");
								retVal = false;
							} else {
								//retVal = false;
							}
						}
						if (y > boardY) {
							if (board[boardX-z][boardY+z].getClass() != (EmptyPiece.class)) {
								System.out.println("bust");
								retVal = false;
							} else {
								//retVal = false;
							}
						}
					}
					if (x > boardX) {
						if (y < boardY) {
							if (board[boardX+z][boardY-z].getClass() != (EmptyPiece.class)) {
								System.out.println("bust");
								retVal = false;
							} else {
								//retVal = false;
							}
						}
						if (y > boardY) {
							if (board[boardX+z][boardY+z].getClass() != (EmptyPiece.class)) {
								System.out.println("bust");
								retVal = false;
							} else {
								//retVal = false;
							}
						}
					}
					// if (board[boardX+z][boardY+z].getClass() != (EmptyPiece.class)) {
					// 	System.out.println("bust");
					// 	retVal = false;
					// } else {
					// 	//retVal = false;
					// }
				
				// if (Math.abs(boardX - z) == x && boardY + z == y) {
				// 	retVal = true;
				// }
				// if ((boardX + z) == x && Math.abs(boardY - z) == y) {
				// 	retVal = true;
				// }
				// if (Math.abs(boardX - z) == x && Math.abs(boardY - z) == y) {
				// 	retVal = true;
				}
		}

		return retVal;
	}
	@Override
	 public boolean canTakePiece(Piece otherPiece) {
	 	boolean retVal = false;

	 	if (color == Color.BLACK) {
	 		if (otherPiece.getColor() == Color.WHITE) {
	 			if (canMoveHere(board,otherPiece.getBoardX(),otherPiece.getBoardY())) {
	 				System.out.println("black take white");
	 				retVal = true;
	 			}
	 		}
	 	}
	 	if (color == Color.WHITE) {
	 		if (otherPiece.getColor() == Color.BLACK) {
	 			if (canMoveHere(board,otherPiece.getBoardX(),otherPiece.getBoardY())) {
	 				System.out.println("white take black");
	 				retVal = true;
	 			}
	 		}
	 	}
	 	//if Black
	 	//if otherpeice is white
	 	//if if other peice is x+1 and (y+1 or y-1)
	 	//return returen
	 	//else WHITe
	 	//bla bla bla
	 	return retVal;
	 }
}