package id.it.finalproject195_227;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuFrame extends JFrame implements ActionListener{
	
	JButton playButton = new JButton("Play Game");
	JButton aboutButton = new JButton("About");
	JButton backButton = new JButton("Back");
	JLabel label = new JLabel(); //JLabel Creation
    

	
	MenuFrame(){
		this.setTitle("The Ping-Pong");
		this.setResizable(false);
		this.add(label);
		this.add(playButton);
		this.add(aboutButton);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setSize(420,420);
		
		label.setIcon(new ImageIcon("LOGO.png")); //Sets the image to be displayed as an icon
	    Dimension size = label.getPreferredSize(); //Gets the size of the image
	    label.setBounds(110, 80, size.width, size.height);
		
		
		playButton.setBounds(110, 230, 200, 40);
		playButton.setFocusable(false);
		playButton.addActionListener(this);
		
		aboutButton.setBounds(110, 270, 200, 40);
		aboutButton.setFocusable(false);
		aboutButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == playButton) {
			this.dispose();
			GameFrame gameFrame = new GameFrame();
		}else if(e.getSource() == aboutButton) {

		}
		
	}

}
