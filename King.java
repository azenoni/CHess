import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class King extends Piece {

	public King(Color color, int x, int y) {
		super(color,x,y);
	
	}

	@Override
	public boolean canMoveHere(JButton board[][] ,int x,int y) {
		boolean retVal = false;
		if (boardX ==x || boardY == y) {
			retVal = true;
		}
		if (boardX + 1 == x || boardX - 1 == x) {
			retVal = true;
		}
		if (boardY + 1 == y || boardY - 1 == y) {
			retVal = true;
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