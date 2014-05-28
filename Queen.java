import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Queen extends Piece {

	public Queen(Color color, int x, int y) {
		super(color,x,y);
	
	}

	@Override
	public boolean canMoveHere(JButton board[][] ,int x,int y) {
		boolean retVal = false;
		// if (color == Color.BLACK && whiteTurn) {
		// 	return false;
		// } else if (color == Color.WHITE && !whiteTurn) {
		// 	return false;
		// }
		int z;
		for (z = 0; z < 8; z++) {
			if ((boardX + z) == x && boardY + z == y) {
				retVal = true;
			}
			if (Math.abs(boardX - z) == x && boardY + z == y) {
				retVal = true;
			}
			if ((boardX + z) == x && Math.abs(boardY - z) == y) {
				retVal = true;
			}
			if (Math.abs(boardX - z) == x && Math.abs(boardY - z) == y) {
				retVal = true;
			}
		}
		if (y == boardY || x == boardX) {
			retVal = true;
		}
		if (retVal) {
			if (y == boardY) {
				for (z = 1; z < x; z++) {
					if (!board[Math.abs(x-z)][y].equals(EmptyPiece.class)) {
						System.out.println("ends zzzz");
						return false;
					} 
				}
			}else if (x == boardX) {
				if (x > boardX) {
					//going up
					for (z = 1; z < y-1; z++) {
						if (!board[x][y+z].equals(EmptyPiece.class)) {
							System.out.println("ends up");
							return false;
						}
					}
				}				
			}
		}
		// if (whiteTurn) {
		// 	whiteTurn = false;
		// } else {
		// 	whiteTurn = true;
		// }

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