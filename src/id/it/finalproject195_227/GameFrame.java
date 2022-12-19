package id.it.finalproject195_227;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	
	Color myWhite = new Color(238, 238, 238);
	Color myBlack = new Color(30, 30, 30);
	
	//GameFrame -> frame untuk GamePanel
	
	GamePanel panel;
	
	GameFrame(){
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("The Ping-Pong");
		this.setResizable(false);
		this.setBackground(myBlack);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}

}
