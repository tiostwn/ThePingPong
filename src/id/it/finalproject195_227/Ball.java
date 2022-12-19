package id.it.finalproject195_227;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{
	
	Color myOrange = new Color(255, 160, 107);
	
	Random random;
	int xSpeed;
	int ySpeed;
	int initialSpeed = 2;
	
	//konstruktor
	Ball(int x, int y, int width, int height){
		super(x, y, width, height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0) {
			randomXDirection--;
		}
		setXDirection(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0) {
			randomYDirection--;
		}
		setYDirection(randomYDirection*initialSpeed);
	}
	
	public void setXDirection(int randomXDirection) {
		xSpeed = randomXDirection;
	}
	
	public void setYDirection(int randomYDirection) {
		ySpeed = randomYDirection;
	}
	
	public void move() {
		x += xSpeed;
		y += ySpeed;
	}
	
	public void draw(Graphics g) {
		g.setColor(myOrange);
		g.fillOval(x, y, height, width);
		
	}

}
