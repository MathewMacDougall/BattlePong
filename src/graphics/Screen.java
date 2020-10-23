package graphics;


public class Screen {

	private int width;
	private int height;
	public int[] pixels;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;//sets to black
		}
	}
	
	/*
	public void render() {
		for(int y = 0; y < height; y++) {
			if(y < 0 || y >= height) break;
			for(int x = 0; x < width; x++) {
				if(x < 0 || x >= width) break;
				
				pixels[x + y * width] = 0xFF0033;//Sprite.grass.pixels[(x&15) + (y&15) * Sprite.grass.SIZE];
			}
		}
	}*/
	
	
}
