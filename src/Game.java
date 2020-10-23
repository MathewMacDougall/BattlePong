import game.Ball;
import game.Paddle;
import graphics.Arena;
import graphics.HUD;
import graphics.Screen;
import input.Keyboard;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;



public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static Rectangle defaultDimensions = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	public static int height = (int) ((defaultDimensions.getHeight() * 0.97)/ 1);
	public static int width = height * 17 / 13;
	public static int scale = 1;
	
	private Arena arena;
	private HUD hud;
	private Ball ball;
	private Paddle player1;
	
	private Thread gameThread;
	private JFrame frame;
	private Keyboard key;
	private boolean running = false;
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		System.out.println(width + ", " + height);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		
	
		arena = new Arena(0, 0, width, 3*height/4);
		//hud = new HUD(0, 3*height/4, width, height/4);
		//ball = new Ball(width, height);
		player1 = new Paddle();
		
		
		addKeyListener(key);
	}
	
	public synchronized void start() {
		running = true;
		gameThread = new Thread(this, "Pong Game");
		gameThread.start();
	}
	
	
	public synchronized void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;//used to convert time in nanos to milliseconds
		double delta = 0;
		int frames = 0;//frames/second
		int updates = 0;//updates/second
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update();//only runs 60 times/second
				delta--;
				updates++;
			}
			
			render();//let run as fast as possible
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle("Pong  |  " + updates + " ups, " + frames + " fps");
				frames = 0;
				updates = 0;
			}
			
		}
	}
	
	
	public void update() {
		key.update();
		player1.update();
		//ball.update(arena);
		//hud.update();
	}
	
	
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();//clears screen for next render (pixel array)
		
		/*
		//Transfers pixel data to game pixel array
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		*/
		
		Graphics g = bs.getDrawGraphics();
		//Graphics must be displayed here before g.dispose
		arena.paint(g);
		player1.render(g);
		
		
		
		g.dispose();
		bs.show();
	}
	
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("PONG");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.frame.requestFocus();
		game.frame.requestFocusInWindow();
		
		game.start();
	}
	
}