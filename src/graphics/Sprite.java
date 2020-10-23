package graphics;

public class Sprite {

	public final int SIZE;//size of sprite
	private int x, y;//location on spritesheet
	public int[] pixels;
	private SpriteSheet sheet;//the spritesheet the sprite is from
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite p1 = new Sprite(50, 4, 0, SpriteSheet.tiles); 
	
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	private void load() {
		for(int y = 0; y < SIZE; y++) {
			for(int x = 0; x < SIZE; x++) {
				//extracts sprite's pixels from sheet
				pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

	
}
