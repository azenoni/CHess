import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Bishop extends Piece {
	private Color color;
	private Image white;
	private Image black;
	private int x;
	private int y;
	public Bishop(Color color, int x, int y) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.white = Piece.loadImage("bishop_white");
		this.black = Piece.loadImage("bishop_black");
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Color getColor() {
		return this.color;
	}
}