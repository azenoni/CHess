import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Pawn extends Piece {
	private Image white;
	private Image black;
	private boolean firstMove = true;;
	public Pawn(Color color, int x, int y) {
		super(color,x,y);
	
	 }

	 @Override
	public boolean canMoveHere(JButton board[][] ,int x,int y) {
	 	boolean retVal=false;
	 	//System.out.println("From X:"+this.boardX+" Y:"+this.boardY);
	 	//System.out.println("To X:"+x+" Y:"+y);
	 	if(color==Color.BLACK) {
	 		//System.out.println("Blank");
	 		if(y == this.boardY) {
	 			//System.out.println("1");
	 			if (firstMove && x == this.boardX + 2) {
	 				retVal = true;
	 				firstMove = false;
	 			}
	 			if(x == this.boardX+1) {
	 				//System.out.println("2");
	 				retVal = true;
	 				firstMove = false;
	 			}
	 		}
	 	}
	 	else {
	 		if(y == this.boardY) {
	 			if (firstMove && x == this.boardX - 2) {
	 				retVal = true;
	 				firstMove = false;
	 			}
	 			if(x == this.boardX-1) {
	 				retVal = true;
	 				firstMove = false;
	 			}
	 		}
	 	}
	 	return retVal;
	 }

	 @Override
	 public boolean canTakePiece(Piece otherPiece) {
	 	boolean retVal = false;
	 	if (color == Color.BLACK) {
	 		if (otherPiece.getColor() == Color.WHITE) {
	 			if (this.boardX == otherPiece.getBoardX() + 1 || this.boardY == otherPiece.getBoardY() + 1 || this.boardY == otherPiece.getBoardY() - 1) {
	 				System.out.println("black take white");
	 				retVal = true;
	 			}
	 		}
	 	}
	 	if (color == Color.WHITE) {
	 		if (otherPiece.getColor() == Color.BLACK) {
	 			if (this.boardX == otherPiece.getBoardX() + 1 || this.boardY == otherPiece.getBoardY() + 1 || this.boardY == otherPiece.getBoardY() - 1) {
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