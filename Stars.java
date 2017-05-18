package Asteroids;

import java.util.*;

public class Stars extends Circle{
	

	public Stars(){
		super(position(),size());
	}
	
	
	 // Method size: creates and returns a random radius for star

	public static int size(){
		Random r = new Random();
		int size = r.nextInt(5);
		return size;
	}
	
	 // Method pos: creates and returns a random Point representing position of a star
	public static Point position(){
		Random r = new Random();
		int x = r.nextInt((800));
		int y = r.nextInt(600);
		System.out.println(x  + " " + y);
		Point pos = new Point(x,y);
		return pos;
	}
	
	 // Method starArray creates and returns an array of Star
	 
	public static Stars[] starArray(int n){
		Stars[] output = new Stars[n];
		for(int i = 0; i < n; i++){
			output[i] = new Stars();
		}
		return output;
	}

}
