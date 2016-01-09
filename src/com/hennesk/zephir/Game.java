package com.hennesk.zephir;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1911000474969878048L;

	public static int width = 300;
	public static int height = width / 16*9;
	public static int scale = 3;
	
	private boolean running = true;
	private Thread thread;
	private JFrame frame;
	
	public Game() {
		Dimension size = new Dimension(width*scale,height*scale);
		setPreferredSize(size);
		
		frame = new JFrame();
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (running) {
			
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Zephir");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
