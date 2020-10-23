package game;

import graphics.Arena;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private int x, y;
	private int speed, defaultSpeed, vX, vY;
	private int radius;
	private int damage, defaultDamage;
	private int hitCount;
	
	private final int HITS_UNTIL_SPEEDUP = 5;
	private final double MAX_ANGLE = 3*Math.PI / 8;
	
	public Ball(int width, int height) {
		x = width/2;
		y = height/2;
		
		vX = 10;
		vY = 10;
		radius = 10;
		
	}
	
	public void update(Arena arena) {
		if(x - radius <= arena.getLeft())
			vX = -vX;
		if(x + radius >= arena.getRight())
			vX = -vX;
		if(y - radius <= arena.getTop())
			vY = -vY;
		if(y + radius >= arena.getBot())
			vY = -vY;
		
		
		x += vX;
		y += vY;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
	}
	
}
