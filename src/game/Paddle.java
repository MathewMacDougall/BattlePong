package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import graphics.Screen;
import graphics.Sprite;

public class Paddle {

	private int paddleNumber;
	private int x, y;
	private int width, height;
	private int speed, defaultSpeed;
	private int health, maxHealth;
	
	
	public Paddle() {
		x = 10;
		y = 300;
		width = 50;
		height = 50;
	}
	
	public void update() {
		//x++;
	}
	
	public void render(Graphics g) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		for(int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(0, 0, width, height, Sprite.p1.pixels, 0, width);
				//image.setRGB(x, y, Sprite.p1.pixels[x+x*y]);
			}
		}
		
		g.drawImage(image, x, y, x+width, y+height, 0, 0, image.getWidth(), image.getHeight(), null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
