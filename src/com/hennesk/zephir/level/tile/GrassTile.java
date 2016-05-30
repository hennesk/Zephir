package com.hennesk.zephir.level.tile;

import com.hennesk.zephir.graphics.Screen;
import com.hennesk.zephir.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}
	public void render(int x, int y, Screen screen){
		screen.renderTile(x, y, this);
	}

}
