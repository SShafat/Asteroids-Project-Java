/*Extra features
 * 
 * 1. Stars on the background.
 * 2. Stars blink.
 * 3. Ship has a body color and border.
 * 4. Press Space for a speed boost.
 * 5. Stars are two different colors, yellow and white
 * 
 */

package Asteroids;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
Original code by Dan Leyzberg and Art Simon
Modified by Megan Owen
Re-modified by Safa Shafat
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Asteroids extends Game {
	private int score = 0;
	Point [] p = {new Point (1,1)};
	Point [] q = {new Point (10,10), new Point(10,20),  new Point (20,20), new Point(20,10)};
	Point [] shipsPoint = {new Point(50,50),new Point(60,65),new Point(50,75), new Point(80,65), new Point(50,50)};
	Point [] asteroidPoints = {new Point(10,10),new Point(20,20), new Point(10,30), new Point(20,40), new Point(10,50)
			, new Point(0,40)};
	Stars[] stars = Stars.starArray(500);
	Random random = new Random();
	
	Asteroid meteor = new Asteroid(q, new Point(400,360),45.0);
	Ship ship = new Ship(shipsPoint,new Point(400,300),0.0);
	Asteroid a1 = new Asteroid (asteroidPoints, new Point(200,200), 90.0);
	Asteroid a2 = new Asteroid (asteroidPoints, new Point(300, 400), 35.0);
	Asteroid a3 = new Asteroid (asteroidPoints, new Point(400, 500), 75.0);
	Asteroid a4 = new Asteroid (asteroidPoints, new Point(100,100), 45.0);
	Asteroid a5 = new Asteroid (asteroidPoints, new Point(660,660),270.0);
	
	
	
	
	
	 

	public Asteroids() {
		super("Asteroids!",800,600);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(ship);
	}

	public void paint(Graphics brush) {
		brush.setColor(Color.black);
		brush.fillRect(0,0,width,height);
		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		score++;
		brush.setColor(Color.white);
		brush.drawString("Score is " + score,10,10);
	
		
		
		for (int i = 0; i < stars.length; i++) {
			int blink = random.nextInt(stars.length + 100);
			if (i != blink) {
				int toss = random.nextInt(2);
				if (toss == 0) {
					brush.setColor(Color.yellow);
				} else {
					brush.setColor(Color.white);
				}
				stars[i].paint(brush);
			}
		}
		
		brush.drawString("Lives" , 760, 10);
		
		meteor.paint(brush);
		ship.paint(brush);
		a1.paint(brush);
		a2.paint(brush);
		a3.paint(brush);
		a4.paint(brush);
		a5.paint(brush);
		ship.move();
		meteor.aMove();
		a1.aMove();
		a2.aMove();
		a3.aMove();
		a4.aMove();
		a5.aMove();
		
		if(ship.collisonCheck(meteor)){
			brush.drawString("Collison", 400, 300);
		}
		
		
		
		
		
	}

	public static void main (String[] args) {
		Asteroids a = new Asteroids();
		a.repaint();
		
	}
}