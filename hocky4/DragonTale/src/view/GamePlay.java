package view;

import javax.swing.JFrame;

import observer.DataTime;

public class GamePlay extends JFrame{
	
	public GamePlay(DataTime data) {
		this.setTitle("Dragon Tale");
		this.setContentPane(new GamePanel(data));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
}
