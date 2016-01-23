package com.hennesk.zephir.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	public final int SHEET_SIZE;
	public int[] pixels;
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SHEET_SIZE = size;
		pixels = new int[SHEET_SIZE*SHEET_SIZE];
		load();
	}
	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0,w,h,pixels,0,w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
