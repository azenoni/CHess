import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;



public class Piece extends JButton{
	protected Color color;
	protected int boardX;
	protected int boardY;

	
	public Piece(Color color, int boardX, int boardY) {
		this.color = color;
		this.boardX = boardX;
		this.boardY = boardY;
	}
	public static Image loadImage(String name) {
		String path = null;
		Image image = null;
		Image img = null;
		

		try{
			 path = "img" + File.separator + name + ".png";
			image = ImageIO.read(new File(path));
			img = image.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
		} catch(IOException e) {
			System.out.println("Could not load image at path: " + path);
			System.exit(1);
		}

		return img;

	}
	public boolean canMoveHere(int x, int y) {
		return false;
	}
	public boolean canTakePiece(Piece piece) {
		return false;
	}
	public int getBoardX() {
		return boardX;
	}
	public int getBoardY() {
		return boardY;
	}
	public Color getColor() {
		return this.color;
	}
	public void setBoardX(int boardX) {
		this.boardX = boardX;
	}
	public void setBoardY(int boardY) {
		this.boardY =boardY;
	}
}