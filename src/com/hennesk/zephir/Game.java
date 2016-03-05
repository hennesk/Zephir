package com.hennesk.zephir;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.hennesk.zephir.graphics.Screen;
import com.hennesk.zephir.input.Keyboard;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1911000474969878048L;	
	private static final double NANOSECOND_MULTIPLIER = 1000000000.0 / 60.0;
	
	public static int width = 300;
	public static int height = width / 16*9;//162
	public static int scale = 3;

	private String title = "Zephir";
	private boolean running = true;
	private Thread thread;
	private JFrame frame;
	private Screen screen;
	private Keyboard key;
	
	private BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		System.out.println(width + " x " + height);
		Dimension size = new Dimension(width*scale,height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width,height);
		frame = new JFrame();		
		key = new Keyboard();
		
		addKeyListener(key);
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
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		
		double delta = 0;
		int frames = 0;
		int updates = 0;
		
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / NANOSECOND_MULTIPLIER;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;		
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer +=1000;
				frame.setTitle(this.title+" | "+updates+ " ups " + frames + "fps");
				updates = 0;
				frames = 0;
			}
		}
	}
	private int xloc = 0;
	private int yloc = 0;
	public void update(){
		
		key.update();
		if (key.up) {
			yloc++;
			System.out.println("x,y = "+xloc+","+yloc);
		}
		if (key.down){
			yloc--;
			System.out.println("x,y = "+xloc+","+yloc);
		}
		if (key.left){
			xloc++;
			System.out.println("x,y = "+xloc+","+yloc);
		}
		if (key.right){
			xloc--;
			System.out.println("x,y = "+xloc+","+yloc);
		}
		
		
	}
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs ==null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		screen.render(xloc,yloc);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g =  bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
