import city.soi.platform.*;

import java.util.List;

/**
 * abstract class to clear and populate the game levels with new bodies
 * also sets the player at the start of each level
 * sets a finish point of the level
 * @author tomas
 *
 */

public abstract class Levels {

	/** the game in which the levels are created */
	protected Game game;
	
	public Levels(Game game) {
		this.game = game;
	}
	
	/**
	 * play the music for the level
	 */
	public abstract void playMusic();
	/** stop the music */
	public abstract void stopMusic();
	
	/**
	 * populate the level with bodies etc
	 */
	public abstract void populate();
	
	/**
	 * layers 1-3 of the 3 background layers (1 being furthest back)
	 */
	public abstract Body layer1();
	public abstract Body layer2();
	public abstract Body layer3();
	/**
	 * powerups that require steplistener from the game class
	 */
	public abstract Body redBubble1();
	
	/**
	 * flag when objective is complete
	 */
	public abstract boolean isCompleted();
	
	/**
	 * places the player at the starting point of the level
	 */
	public abstract void putPlayerAtStart();
	public abstract void putPlayerAtStart2();
	/**
	 * cleans level of its contents
	 */
	public void cleanLevel()
	{
        List<Body> bodies = game.getWorld().getBodies();
        Player player = game.getPlayer();
        for (Body b : bodies) {
            if (b != player) b.destroy();
        }
	}
	
	
}
