import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class King extends Piece {
	private Color color;
	private Image white;
	private Image black;
	private int x;
	private int y;
	public King(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
		if (color == Color.BLACK) {
			this.black = Piece.loadImage("king_black");
		} else {
			this.white = Piece.loadImage("king_white");
		}
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