package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private boolean[] keys = new boolean[200];
	public boolean up1, up2, down1, down2;
	
	public void update() {
		up1 = keys[KeyEvent.VK_UP];
		down1 = keys[KeyEvent.VK_DOWN];
		up2 = keys[KeyEvent.VK_W];
		down2 = keys[KeyEvent.VK_S];
		
	//	System.out.println(up1);
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
