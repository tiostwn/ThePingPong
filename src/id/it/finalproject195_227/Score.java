package id.it.finalproject195_227;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle {
	
	//bikin warna sendiri
	Color myBlack = new Color(28, 28, 28);
	Color myWhite = new Color(238, 238, 238);
	
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_WIDTH = GAME_HEIGHT;
	}
	
	public void draw(Graphics g) {
		g.setColor(myWhite);
		g.setFont(new Font("Consolas", Font.PLAIN, 50));
		
		//g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1 % 10), 20, 50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2 % 10), 910, 50);
		//g.drawString(null, x, y)
	}

}
