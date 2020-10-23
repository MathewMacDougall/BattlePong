package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Arena {
	
	private int x, y, width, height;
	private int left, right, top, bot;
	private int powerupWidth, powerupHeight, powerupOffset;
	private int wallWidth, wallHeight;
	private int cLineWidth;
	private int cCircleR, cCircleThickness;
	public int pixels[];
	private BufferedImage image;
	
	public Arena(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		pixels = new int[width * height];
		 image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		wallWidth = (int) (20.0 / 1306.0 * width);
		wallHeight = (int) (40.0 / 999.0 * height);
		left = wallWidth;
		right = width - wallWidth;
		top = wallHeight;
		bot = height - wallHeight;
		
		powerupWidth = (int) (150.0 / 1306.0 * width);
		powerupHeight = (int) (2 * wallHeight / 3);
		powerupOffset = (int) (150.0 / 1306.0 * width);//how far from center are the powerups
		
		cLineWidth = (int) (22.0 / 999.0 * height);
		cCircleR = (int) (110.0 / 999.0 * height);//radius of inside of center circle
		cCircleThickness = cLineWidth;
	}
	
	
	/*
	public void render(Screen screen) {
		paint(image.getGraphics());
		image.getRGB(0, 0, width, height, pixels, 0, width);
		for(int i = 0; i < pixels.length; i++) {
			screen.pixels[i] = pixels[i];
		}
		
	}
	*/
	
	public void paint(Graphics g) {
		//Color background
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		
		//Color centerline
		g.setColor(new Color(50, 50, 50, 40));
		g.fillRect(x + width/2 - cLineWidth/2, y + wallHeight, cLineWidth, height - 2*wallHeight);
		g.fillOval(x + width/2 - (cCircleR + cCircleThickness), y + height/2 - (cCircleR + cCircleThickness), 2 * (cCircleR + cCircleThickness), 2 * (cCircleR + cCircleThickness));
		g.setColor(Color.white);
		g.fillOval(x + width/2 - cCircleR, y + height/2 - cCircleR, 2 * cCircleR, 2 * cCircleR);
		
		//Color top and bottom walls
		g.setColor(Color.black);
		g.fillRect(x, y, width, wallHeight);
		g.fillRect(x, y + bot, width, wallHeight);
		
		//Color side walls
		g.setColor(new Color(50, 50, 50));
		g.fillRect(x, y + top, wallWidth, height - 2*wallHeight);
		g.fillRect(x + right, y + top, wallWidth, height - 2*wallHeight);
		
		//Color powerup pads
		g.setColor(Color.orange);
		g.fillRect(x + width/2 - (powerupOffset + powerupWidth), y + wallHeight - powerupHeight, powerupWidth, powerupHeight);//top left
		g.fillRect(x + width/2 + powerupOffset, y + wallHeight - powerupHeight,powerupWidth, powerupHeight);//top right
		g.fillRect(x + width/2 - (powerupOffset + powerupWidth), y + height - wallHeight, powerupWidth, powerupHeight);//bottom left
		g.fillRect(x + width/2 + powerupOffset, y + height - wallHeight, powerupWidth, powerupHeight);//bottom right
		
	}
	
	
	
	
	public int getLeft() {
		return this.left;
	}
	
	public int getRight() {
		return this.right;
	}
	
	public int getTop() {
		return this.top;
	}
	
	public int getBot() {
		return this.bot;
	}
	
}
