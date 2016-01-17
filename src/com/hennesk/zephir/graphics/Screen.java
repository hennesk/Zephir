package com.hennesk.zephir.graphics;

import java.util.Random;

public class Screen {

	private int width;
	private int height;
	
	public int[] pixels;
	public int[] tiles = new int[64*64];
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for (int i = 0; i < 64*64; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void render() {
		for (int y = 0; y < height; y++) {
			if (y >= height || y < 0) break;
			
			for (int x = 0; x < width; x++) {
				if (x >= width || x < 0) break;
				int tileIndex = (x / 16)+(y/16)*64;
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
