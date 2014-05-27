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
	public Pawn(Color color, int x, int y) {
		super(color,x,y);
	
	 }

	 @Override
	 public boolean canMoveHere(int x, int y) {
	 	boolean retVal=false;
	 	System.out.println("From X:"+this.boardX+" Y:"+this.boardY);
	 	System.out.println("To X:"+x+" Y:"+y);
	 	if(color==Color.BLACK) {
	 		System.out.println("Blank");
	 		if(y == this.boardY) {
	 			System.out.println("1");
	 			if(x == this.boardX+1) {
	 				System.out.println("2");
	 				retVal = true;
	 			}
	 		}
	 	}
	 	else {
	 		if(y == this.boardY) {
	 			if(x == this.boardX-1) {
	 				retVal = true;
	 			}
	 		}
	 	}
	 	return retVal;
	 }

	 @Override
	 public boolean canTakePiece(Piece otherPiece) {
	 	//if Black
	 	//if otherpeice is white
	 	//if if other peice is x+1 and (y+1 or y-1)
	 	//return returen
	 	//else WHITe
	 	//bla bla bla
	 }
}