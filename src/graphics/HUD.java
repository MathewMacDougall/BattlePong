package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HUD {

	private int x, y, width, height;//location and size of the graphic on the screen
	private int border, pBorder, hBorder;//panel, powerup, and health border size
	private int healthWidth, healthHeight, healthOffset, healthFontSize;
	private String title1, title2, h1, h2;
	private Font titleFont, healthFont;
	private int titleOffsetX, titleOffsetY, titleFontSize;
	
	private Rectangle health1, health2;
	
	public HUD(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		border = 20;
		titleFontSize = 25;
		healthFontSize = 43;
		
		title1 = "Player 1";
		title2 = "Player 2";
		titleFont = new Font("Tahoma", Font.BOLD, titleFontSize);
		titleOffsetX = (int) (titleFontSize * 10.5);
		titleOffsetY = (int) ((height - 2*border) * 0.125 + titleFontSize);
		
		healthWidth = (int) ((width - 2*border) * 0.35);
		healthHeight = (int) ((height - 2*border) * 0.2);
		healthOffset = (int) ((width - 2*border) * 0.025);
		hBorder = 5;
		healthFont = new Font("Tahoma", Font.BOLD, healthFontSize);
		
		health1 = new Rectangle(x + width/2 + healthOffset, y + height/2 - (int) (1.3 * healthHeight), healthWidth, healthHeight);
		health2 = new Rectangle(x + border + healthOffset, y + height/2 - (int) (1.3 * healthHeight), healthWidth, healthHeight);
	}
	
	public void update() {
		h1 = "99/99";
		h2 = "99/99";
	}
	
	
	public void paint(Graphics g) {
		//paint border
		g.setColor(Color.gray);
		g.fillRect(x, y, width, height);
		
		//paint background
		g.setColor(Color.lightGray);
		g.fillRect(x + border, y + border, width - 2*border, height - 2*border);
		
		//paint titles
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString(title1, x + width/2 + titleOffsetX, y + titleOffsetY);
		g.drawString(title2, x + border + titleOffsetX, y + titleOffsetY);
	
		//paint p1 health
		g.setColor(Color.black);
		g.fillRect(health1.x, health1.y, healthWidth, healthHeight);
		g.setColor(Color.red);
		g.fillRect(health1.x + hBorder, health1.y + hBorder, healthWidth - 2*hBorder, healthHeight - 2*hBorder);
	
		//paint p2 health
		g.setColor(Color.black);
		g.fillRect(health2.x, health2.y, healthWidth, healthHeight);
		g.setColor(Color.blue);
		g.fillRect(health2.x + hBorder, health2.y + hBorder, healthWidth - 2*hBorder, healthHeight - 2*hBorder);
		
		//paint player 1 health #
		g.setColor(Color.black);
		g.setFont(healthFont);
		g.drawString(h1, health1.x + health1.width + (int) (0.5*healthOffset), health1.y + (int) (0.9 * health1.height));
		
		//paint player 2 health #
		g.setColor(Color.black);
		g.setFont(healthFont);
		g.drawString(h2, health2.x + health2.width + (int) (0.5*healthOffset), health2.y + (int) (0.9 * health2.height));
		
		
	}
	
}
