package com.hennesk.zephir.level;

import com.hennesk.zephir.graphics.Screen;
import com.hennesk.zephir.level.tile.Tile;

public class Level {
protected int width, height;
protected int[] tiles;

public Level(int w, int h) {
	this.width = w;
	this.height = h;
	tiles = new int[width*height];
	generateLevel();
}
protected void generateLevel(){}
public Level(String path){
	loadLevel(path);
}
private void loadLevel(String path){
	
}

public void update(){
	
}
public void render(int xPosition, int yPosition, Screen screen) {
	screen.setOffset(xPosition, yPosition);
	int x0 = xPosition >> 4;//same as div by 16, but much faster
	int x1 = (xPosition + screen.width) >> 4;
	int y0 = yPosition >> 4;//basically going from pixel to tile precision
	int y1 = (yPosition + screen.height) >> 4;
	
	for (int y = y0; y < y1; y++ ){
		for (int x = x0;x<x1;x++) {
			getTile(x,y).render(x, y, screen);
		}
	}
		
}

public Tile getTile(int x, int y){
	if (x < 0  || y < 0 || x >= width || y >= height) return Tile.voidTile;
	if (tiles[x+y*width] == 0) return Tile.grass;	
	return Tile.voidTile;
}

private void time() {
	
}
}
