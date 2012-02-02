import city.soi.platform.*;

/**
 * class for the standard bullet type
 */
public class StandardShell extends Body implements CollisionListener
{   
    /** The game in which the player is playing. */
    private Game game;
    
    /** the counter for the step events */
    private int counter;
    
    
    /**
     * initialise a new bullet
     */
    public StandardShell(Game game)
    {
        super(game.getWorld(), new PolygonShape(-3,-6, -3,6, 0,8, 3,6, 3,-6));
        this.game = game;
        counter = 0;
        getWorld().addCollisionListener(this);
        setFillColor(java.awt.Color.YELLOW);
        setGravityStrength(0); 
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
    
    public void collide(CollisionEvent e)
    {
    	stepCounterUP();
        if(getStepCounter() == 10) {	
            destroy();
        }
    }
}
