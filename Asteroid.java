package Asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Asteroid extends Polygon {
	public boolean moving = true;
	

	public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		Point origin = shape[0].clone();
		for (Point p : shape) {
			if (p.getX() < origin.getX()) {
				origin.setX(p.getX());
			}
			if (p.getY() < origin.getY())  {
				origin.setY(p.getY());
			}
		}
	}
		
	public void paint(Graphics brush) {
		
		Point [] w = getPoints();
		
		int [] xValues = new int [w.length];
		int [] yValues = new int [w.length];
		
		for (int i = 0; i < w.length; i++){
			xValues[i] = (int) w[i].getX();
		}
		
		for (int j = 0; j < w.length; j++){
			yValues[j] = (int) w[j].getY();
		}
		brush.setColor(Color.CYAN);
		brush.drawPolygon(xValues,yValues,w.length);
	}
	
	public void aMove() {
		
		if (this.position.getX() >= 800){
			this.position.setX(Math.random()*800);
			position.addToX(Math.cos(Math.toRadians(rotation)));
			//position.addToY(Math);
		}
		if (this.position.getY() >= 600){
			this.position.setY(Math.random()*600);
			position.addToY(Math.sin(Math.toRadians(rotation)));
			
		}
		
		if(moving == true){
			position.addToX(2);
			position.addToY(2);
		}
	}
	
	
	

}
