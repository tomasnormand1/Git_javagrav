import city.soi.platform.*;

/**
 * class for the high density bullet type
 * 
 * initialises the class and counts the number of 
 * collisions to know when to destroy()
 */

public class HighDShell extends Body implements CollisionListener
{   
    /** The game in which the player is playing. */
    private Game game;

    private Shape hDShell;
    
    /** count the number of collisions */
    private int counter;

    /**
     * initialise a new bullet
     */
    public HighDShell(Game game)
    {
        super(game.getWorld(), new PolygonShape(-3,-6, -3,6, 0,8, 3,6, 3,-6));
        this.game = game;
        counter = 0;
        getShapeList().getFirst().setDensity(10);
        setFillColor(java.awt.Color.RED);
        setGravityStrength(4f);
        getWorld().addCollisionListener(this);
    }
    
    /**
     * counter to increase the number of collisions
     */
    public void stepCounterUP()
    {
    	counter++;
    }
    

    /**
     * TOTAL COUNT
     */
    public int getStepCounter()
    {
    	return counter;
    }
    
    /**
     * if the number of collisions is equal to 10, then destroy the bullet
     */
    public void collide(CollisionEvent e)
    {
    	stepCounterUP();
    	if(getStepCounter() == 10) {
    		destroy();
    	}
    }
}
