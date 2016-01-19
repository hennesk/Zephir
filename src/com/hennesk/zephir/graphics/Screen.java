package com.hennesk.zephir.graphics;

import java.util.Random;

public class Screen {

	private int width;
	private int height;
	
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
			for (int x = 0; x < width; x++) {
				int xx = x + xoffset;
				//int tileIndex = (xx / 16)+(yy/16)*64;
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK)+((yy >> 4) & MAP_SIZE_MASK)*MAP_SIZE;
				pixels[x+y*width] = tiles[tileIndex];				
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
