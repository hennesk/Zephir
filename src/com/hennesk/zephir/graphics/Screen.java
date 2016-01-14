package com.hennesk.zephir.graphics;

public class Screen {

	private int width;
	private int height;
	
	public int[] pixels;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void render() {
		for (int y = 0; y < height; y++) {
			if (y >= height || y < 0) break;
			
			for (int x = 0; x < width; x++) {
				if (x >= width || x < 0) break;
				
				pixels[x+y*width] = 0xff00ff;				
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
