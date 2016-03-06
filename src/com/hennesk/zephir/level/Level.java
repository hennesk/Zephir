package com.hennesk.zephir.level;

import com.hennesk.zephir.graphics.Screen;

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
	
}
private void time() {
	
}
}
