package Asteroids;

import java.awt.*;

public class Circle {
	
	public Point position;
	public int radius;
	
	public Circle(Point pos, int r){
		position = pos;
		radius = r;
		
	}
	
	
	
	public void paint(Graphics brush){
		brush.drawOval((int)position.getX(), (int)position.getY(), radius, radius);
		//brush.fillOval((int)position.getX(), (int)position.getY(), radius, radius); // to fill the stars
	}
}
