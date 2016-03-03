package com.hennesk.zephir.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x;
	private int y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16,0,0, SpriteSheet.terrain);
	
	public Sprite (int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.sheet = sheet;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.pixels = new int[SIZE * SIZE];
		load();		
	}
	private void load() {
		for (int y=0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[x+this.x+((y+this.y)*sheet.SHEET_SIZE)];
			}
		}	
	}
}
