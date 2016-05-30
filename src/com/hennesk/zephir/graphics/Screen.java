package com.hennesk.zephir.graphics;

import java.util.Random;

import com.hennesk.zephir.level.tile.Tile;

public class Screen {

	public int width;
	public int height;
	
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE -1;
	
	public int[] tiles = new int[MAP_SIZE*MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < MAP_SIZE*MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render(int xoffset, int yoffset) {
		for (int y = 0; y < height; y++) {
			int yy = y + yoffset;
			if (yy < 0 || yy >= height) continue;
			for (int x = 0; x < width; x++) {
				int xx = x + xoffset;
				if (xx < 0 || xx >= width) continue;
				//int tileIndex = (xx / 16)+(yy/16)*64;
				//int tileIndex = ((xx >> 4) & MAP_SIZE_MASK)+((yy >> 4) & MAP_SIZE_MASK)*MAP_SIZE;
				pixels[xx+yy*width] = Sprite.grass.pixels[(x&15)+(y&15)*Sprite.grass.SIZE];			
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile){
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;			
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= width) break;//if tile were to exit viewable screen, stop drawing it
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	public void clear() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x+y*width] = 0;				
			}
		}
	}
}
