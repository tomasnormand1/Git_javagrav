import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class HUD extends JPanel implements ChangeListener {
	
		//private static final long serialVersionUID = 1L;
		private Game game;
		
		// the print stats string to go in label 6
		private String printStats;
		
		// multiplayer flag
		private boolean multiFlag;
		
		// score label
		private JLabel label1;
		// lives label 2
		private JLabel label2;
		// XP label 3
		private JLabel label3;
		// level label 4
		private JLabel label4;
		// levelup label5
		private JLabel label5;
		
		// lives label 2
		private JLabel label22;
		// levelup label5
		private JLabel label52;
		
		//restart button
		private JButton restart;
		//pause button
		private JButton pause;
		// new player button
		private JButton player2;
		// restart game button
		private JButton hubLevel;
		// high score
		private JButton highScore;
		
		/**
		 * add all the labels to the HUD, labels include, health, lives, xp etc
		 * @param game
		 */
		public HUD(Game game) {
			super();
			this.game = game;
			multiFlag = false;
			setLayout(new GridLayout(2,4));
			label1 = new JLabel("HP: " + game.getPlayer().healthCount() + "   ", JLabel.LEFT);
			add(label1);
			
			label2 = new JLabel("Lives: " + game.getPlayer().lifeCount() + "   ", JLabel.LEFT);
			add(label2);
			
			label3 = new JLabel("XP: " + game.getPlayer().getXP() + "   ", JLabel.LEFT);
			add(label3);
			
			label4 = new JLabel("Level: " + game.getPlayer().getLevel() + "   ", JLabel.LEFT);
			add(label4);
			
			label5 = new JLabel("Shellsig: " + game.getShellSig() + "   ", JLabel.LEFT);
			add(label5);
			if(getFlag() == true) {
				label22 = new JLabel("Lives: " + game.getPlayer().lifeCount() + "   ", JLabel.LEFT);
				add(label22);
			
				label52 = new JLabel("Shellsig: " + game.getShellSig() + "   ", JLabel.LEFT);
				add(label52);
			}
			/**
			 * restart button
			 */
			restart = new JButton("NEW GAME");
			add(restart);
			restart.addActionListener(
				new ActionListener()		
					{
						public void actionPerformed(ActionEvent e)
						{
							restartAction(e);
						}
					}
			);
			restart.setFocusable(false);
			
			/**
			 * pause button
			 */
			pause = new JButton("PAUSE");
			add(pause);
			pause.addActionListener(
				new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							pauseAction(e);
						}
					}
			);
			pause.setFocusable(false);
			
			game.getWorld().addChangeListener(this);
			
			
			/**
			 * new player button
			 */
			player2 = new JButton("NEW CHALLENGER!");
			add(player2);
			player2.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent e) 
						{
							addPlayer(e);
						}
					}
			);
			player2.setFocusable(false);
			
			game.getWorld().addChangeListener(this);
			

			/**
			 * return to level 1 button
			 */
			hubLevel = new JButton("Return to HUB");
			add(hubLevel);
			hubLevel.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						multiFlag = false;
						loadHubButton();
					}
				}
			);
			hubLevel.setFocusable(false);
			
			game.getWorld().addChangeListener(this);
			
			/**
			 * button to view the high scores in a new window
			 */
			highScore = new JButton("High Scores");
			add(highScore);
			highScore.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						loadHighScores();
					}
				}
			);
			highScore.setFocusable(false);
			
			game.getWorld().addChangeListener(this);
		}

		
		
		public void stateChanged(ChangeEvent e)
		{
			label1.setText("HP: " + game.getPlayer().healthCount() + "   ");
			label1.setForeground(Color.WHITE);
			label2.setText("Lives: " + game.getPlayer().lifeCount() + "   ");
			label2.setForeground(Color.WHITE);
			label3.setText("XP: " + game.getPlayer().getXP() + "   ");
			label3.setForeground(Color.WHITE);
			label4.setText("Level: " + game.getPlayer().getLevel() + "   ");
			label4.setForeground(Color.WHITE);
			label5.setText("Shellsig: " + game.getShellSig() + "   ");
			label5.setForeground(Color.WHITE);
			if(getFlag() == true) {
				/*
				label22.setText("Lives: " + game.getPlayer2().lifeCount() + "   ");
				label22.setForeground(Color.YELLOW);
				label52.setText("Shellsig: " + game.getShellSig() + "   ");
				label52.setForeground(Color.YELLOW);
				*/
			}
			
			setBackground(Color.BLACK);
		}
		
		public void setString(String s)
		{
			printStats = s;	
		}
		
		/**
		 * method to print the stats of the game.
		 * @return
		 */
		public String getString()
		{
			return printStats;
		}
		/**
		 * restart button action listener
		 * @param e
		 */
		public void restartAction(ActionEvent e)
		{
			game.restartGame();
		}
		
		/**
		 * pause action listener
		 * @param e
		 */
		public void pauseAction(ActionEvent e)
		{
			game.pauseGame();
		}
		
		/**
		 * add a new player to the game if the multiplayer flag = true
		 */
		public void addPlayer(ActionEvent e)
		{
			multiFlag = true;
			game.loadArena();
		}
		
		/**
		 * @return multiplayer flag
		 */
		public boolean getFlag() {
			return multiFlag;
		}
		
		/**
		 * load the hub level
		 */
		public void loadHubButton() {
			game.loadHub();
		}
		
		/**
		 * load the high score list
		 */
		public void loadHighScores() {
	        FileReader2 reader = new FileReader2();
	        reader.loadFile();
	        reader.readFile();
	        
			Collections.sort(reader.getArrayStuff());		
	        
			JOptionPane.showMessageDialog(this, reader.getArrayStuff());

	        reader.closeFile();
		}
}