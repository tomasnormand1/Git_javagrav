import org.jbox2d.common.Vec2;

import city.soi.platform.*;

/** Basic players in a game. */
public class Player extends Actor implements CollisionListener
{
    /** The number of bubbless the player currently has. */
    private int bubbles;
    
    /** score **/
    private float levelXP;
    
    private int level;
    
    /**
     * number of lives available to the player
     */
    private int lives;
    
    /** health count */
    private int health;

    /** The game. */
    private Game game;

    /**
     * Initialise a new player.
     * @param game  The game in which the player will be playing.
     */
    public Player(Game game, String image)
    {
        super(game.getWorld(), new PolygonShape(0f,15f, 20f,-5f, 15f,-22.5f, -15f,-22.5f, -20f,-5f));
        getWorld().addCollisionListener(this);
        this.game = game;
        bubbles = 0;
        lives = 3;
        levelXP = 0;
        level = 0;
        health = 10;
        setGravityStrength(1);
        this.setImage(new BodyImage(image));
    }

    /**
     * Number of available lives
     */
    public int lifeCount()
    {
        return lives;
    }

    /**
     * increment life count
     */
    public void incrementLife()
    {
        lives ++;
    }

    /**
     * decrement life count
     */
    public void decrementLife()
    {
        lives --;    
    }
    
    /**
     * reset lives back to 3
     */
    public void resetLives()
    {
    	lives = 3;
    }

    /**
     * health points
     */
    public int healthCount()
    {
    	return health;
    }
    /**
     * decrement health
     */
    public void decHealth() {
    	health--;
    }
    
    /**
     * increase bubble count
     */
    public void incrementBubbleCount()
    {
        bubbles++;
    }

    /** Decrease the bubble count. */
    public void decrementBubbleCount()
    {
        bubbles--;
    }

    /**
     * number of bubbles player has
     */
    public int getBubbles()
    {
        return bubbles;
    }

    /**
     * experience points when bubbles are collected
     */
    public float getXP()
    {
        levelXP = bubbles * 5.5f;
        return levelXP;
    }
    
    /**
     * increment player level
     */
    public void levelIncrement()
    {
        level ++;    
    }
    
    /**
     * get level
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     * decrease health and reset to start on impact
     */
    public void dieOnImpact()
    {
    	decrementLife();
    	game.getLevel().putPlayerAtStart();
    	game.getLevel().putPlayerAtStart2();
    	setLinearVelocity(new Vec2(0, 0));
    }
    
    /**
     * colision event
     */
    public void collide(CollisionEvent e)
    {
    	Body eBody = e.getOtherBody();
    	if (!(eBody instanceof StandardShell || eBody instanceof Bubble || eBody instanceof RedBubble || eBody instanceof Vortex)) {
    		decHealth();
    		if(health == 0) {
        		dieOnImpact();
        		health = 10;
        		decrementLife();
    		}
    	}
    }
}
