package id.it.finalproject195_227;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	
	//GamePanel buat gambar atau nampilin visual
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 15;
	static final int PADDLE_WIDTH = 15;
	static final int PADDLE_HEIGHT = 120;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle p1;
	Paddle p2;
	Ball ball1;
	Ball ball2;
	Score score;
	String[] responses = {"Play Again","Main Menu"};
	ImageIcon iconP1 = new ImageIcon("P1.png");
	ImageIcon iconP2 = new ImageIcon("P2.png");

	
	
	//Konstruktor
	GamePanel(){
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.setName("Game Thread");
		gameThread.start();
		
		
	}
	
	public void newBall() {
		random = new Random();
		ball1 = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
		
	}
	
	public void newPaddles() {
		p1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		p2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
		
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
		
	}
	
	public void draw(Graphics g) {
		p1.draw(g);
		p2.draw(g);
		ball1.draw(g);
		score.draw(g);
		Toolkit.getDefaultToolkit().sync(); 
	}
	
	public void move() {
		p1.move();
		p2.move();
		ball1.move();
	}
	
	public void checkCollision() {
		
		//bola mantul paddle
		if(ball1.intersects(p1)) {
			ball1.xSpeed = Math.abs(ball1.xSpeed);
			ball1.xSpeed++; //optional for more difficulty
			if(ball1.ySpeed>0)
				ball1.ySpeed++; //optional for more difficulty
			else
				ball1.ySpeed--;
			ball1.setXDirection(ball1.xSpeed);
			ball1.setYDirection(ball1.ySpeed);
		}
		if(ball1.intersects(p2)) {
			ball1.xSpeed = Math.abs(ball1.xSpeed);
			ball1.xSpeed++; //optional for more difficulty
			if(ball1.ySpeed>0)
				ball1.ySpeed++; //optional for more difficulty
			else
				ball1.ySpeed--;
			ball1.setXDirection(-ball1.xSpeed);
			ball1.setYDirection(ball1.ySpeed);
		}
		
		//biar bola mantul
		if(ball1.y <= 0) {
			ball1.setYDirection(-ball1.ySpeed);
		}
		if(ball1.y > GAME_HEIGHT-BALL_DIAMETER) {
			ball1.setYDirection(-ball1.ySpeed);
		}
		
		//biar paddle tidak melewati window
		if(p1.y <=0) {
			p1.y = 0;
		}
		if(p1.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) {
			p1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
		if(p2.y <=0) {
			p2.y = 0;
		}
		if(p2.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) {
			p2.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
		
		//atur poin + bikin bola baru
		if(ball1.x <=0) {
			score.player2++;
			//newPaddles();
			newBall();
			if(score.player1 == 1 || score.player2 == 1) {
				newBall();
			}
			//System.out.println("Score:" + score.player1 + "-" + score.player2);
		}
		
		if(ball1.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			//newPaddles();
			newBall();
			if(score.player1 == 1 || score.player2 == 1) {
				newBall();
			}
			//System.out.println("Score:" + score.player1 + "-" + score.player2);
		}
		
		
		
	}
	
	public void checkScore(){
//		System.out.println(Thread.activeCount());
//		System.out.println(Thread.currentThread().getName());
		
		
		if(score.player1 == 2) {

			  int answer = JOptionPane.showOptionDialog(
			    null,
			    "Player 1 Menangggg! :D", 
			    "YEYYYYY", 
			    JOptionPane.PLAIN_MESSAGE, 
			    0, 
			    iconP1, 
			    responses, 
			    responses[0]);
			 
//			System.out.println(answer);
//			System.out.println(Thread.currentThread().isAlive());
			
			if(answer == 0) {
				newBall();
				newPaddles();
				score = new Score(GAME_WIDTH, GAME_HEIGHT);			
			}else if(answer == 1 || answer == -1) {
				JFrame thisFrame1 = (JFrame) SwingUtilities.getWindowAncestor(this);
				thisFrame1.dispose();
				//JOptionPane.getRootFrame().dispose();  
				MenuFrame frame = new MenuFrame();
				gameThread.stop();

				
			}
			
		}
		
		if(score.player2 == 2) {
			
			
			  int answer = JOptionPane.showOptionDialog(
			    null,
			    "Player 2 Menangggg! :D", 
			    "ANJAYYYY MENANGG", 
			    JOptionPane.PLAIN_MESSAGE, 
			    0, 
			    iconP2, 
			    responses, 
			    responses[0]);
//			System.out.println(Thread.currentThread().isAlive());
//			System.out.println(answer);

			if(answer == 0) {
				newBall();
				newPaddles();
				score = new Score(GAME_WIDTH, GAME_HEIGHT);				
			}else if(answer == 1 || answer == -1) {
				JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
				thisFrame.dispose();
				//JOptionPane.getRootFrame().dispose();  
				MenuFrame frame = new MenuFrame();
				gameThread.stop();
				
				
			}
			
			
		}
		
	}
	
	
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				checkScore();
				repaint();
				delta--;
				//System.out.println("Test");
			}
		}
	}
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			p1.keyPressed(e);
			p2.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			p1.keyReleased(e);
			p2.keyReleased(e);
		}
	}
	

}
