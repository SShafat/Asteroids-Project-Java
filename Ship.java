package Asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends Polygon implements KeyListener {

	boolean isKeyUp = false; // forward
	boolean isKeyLeft = false; // left
	boolean isKeyRight = false; // right
	boolean isKeyDown = false; // down
	boolean isKeySpace = false; // speed
	boolean isAnotherKey = false;
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) { 
			case KeyEvent.VK_UP:
				isKeyUp = false;
				break;
			case KeyEvent.VK_LEFT:
			isKeyLeft = false;
				break;
			case KeyEvent.VK_RIGHT:
				isKeyRight = false;
				break;
			case KeyEvent.VK_DOWN:
				isKeyDown = false;
				break;
	        case KeyEvent.VK_SPACE:
	        	isKeySpace = false;
	        	break;
	        	
			default:
				isAnotherKey = false;
		}
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		shape = inShape;
		position = inPosition;
		rotation = inRotation;
		
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
	
	public void move(){
		if (isKeyUp == true) {
			// move ship forward
			position.addToY(Math.sin(Math.toRadians(rotation)));
			position.addToX(Math.cos(Math.toRadians(rotation)));	
		}
		if (isKeyLeft == true) {
			// move ship left
			rotation = rotation -2;
		}
		if (isKeyRight == true) {
			// move ship right
			rotation = rotation +2;
		}
		if(isKeySpace == true) {
			// move ship down
			position.addToX((Math.cos(Math.toRadians(rotation))));
			position.addToY((Math.sin(Math.toRadians(rotation))));
		
			
		}
			
			if (position.getX() >= 800){
				position.setX(1);
				position.setY(position.getY());
			}
			if (position.getY() >= 600){
				position.setY(1);
				position.setX(position.getX());
			}
			if (position.getX() < 0){
				position.setX(799);
				position.setY(position.getY());
			}
			if (position.getY() < 0){
				position.setY(599);
				position.setX(position.getX());
			}
			
			
			System.out.println(position.getX() + "// " + position.getY());
			
		
		
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
		
		brush.setColor(Color.blue);
		brush.fillPolygon(xValues,yValues,w.length);
		brush.setColor(Color.white);
		brush.drawPolygon(xValues,yValues,w.length);
		
		
		
		
	}
	
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch(keyCode) { 
			case KeyEvent.VK_UP:
				isKeyUp = true;
				break;
			case KeyEvent.VK_LEFT:
			isKeyLeft = true;
				break;
			case KeyEvent.VK_RIGHT:
				isKeyRight = true;
				break;
			case KeyEvent.VK_DOWN:
				isKeyDown = true;
				break;
			case KeyEvent.VK_SPACE:
				isKeySpace = true;
				break;
			default:
				isAnotherKey = true;
		}
		
	}

}
