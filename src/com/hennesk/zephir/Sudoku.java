package com.hennesk.zephir;

import java.util.Random;

public class Sudoku {
	public Random random;
	public static final int NINE = 9;
	public int[] grid = new int[NINE];
	public int[] seeds = new int[NINE];
	public Sudoku(){
		random = new Random();
		for (int i = 0; i < NINE; i++)
			seeds[i] = i+1;
		for (int i = 0; i < NINE; i++) {
			shuffle(i,seeds);
			print(seeds);
		}
	}
	
	public int[] shuffle(int start, int[] array) {
		for (int i = start; i < array.length -2; i++) {
			int j = random.nextInt(array.length-i);
			int tmp = array[i];
			array[i] = array[i+j];
			array[i+j] = tmp;
		}
		return array;
	}
	
	public void print(int[] array){
		for (int y = 0; y < NINE; y++) {
			if (y*NINE >= array.length) continue;
			for (int x= 0; x < NINE; x++){
				if (x+y*NINE >= array.length) continue;
				  System.out.print(array[x+y*NINE]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku();
	}

}
