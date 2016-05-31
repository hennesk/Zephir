package com.hennesk.zephir.level.tile;

import com.hennesk.zephir.graphics.Screen;
import com.hennesk.zephir.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}
}
