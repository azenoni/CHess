import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Queen extends Piece {
	private Color color;
	private Image white;
	private Image black;
	public Queen(Color color) {
		this.color = color;
		this.white = Piece.loadImage("queen_white");
		this.black = Piece.loadImage("queen_black");
	}
}