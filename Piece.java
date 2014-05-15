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



public class Piece{
	private Color color;
	private int x;
	private int y;

	
	public Piece(Color color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
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