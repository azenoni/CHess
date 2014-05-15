import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Knight extends Piece {
	private Color color;
	private Image white;
	private Image black;
	private int x;
	private int y;
	public Knight(Color color, int x, int y) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.white = Piece.loadImage("knight_white");
		this.black = Piece.loadImage("knight_black");
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