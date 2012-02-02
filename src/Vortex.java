import city.soi.platform.*;


/**
 * the vortex to end the level and load a new level
 * @author tomas
 *
 */
public class Vortex extends Body implements CollisionListener 
{
	/** the game class */
	private Game game;
		
	/**
	 * constructor for the vortex class
	 * creates a body with specific attributes eg, 0 mass, and slight rotation
	 * @param game
	 */
	public Vortex(Game game)
	{
		super(game.getWorld(), new CircleShape(50));
		this.game = game;
        getShapeList().getFirst().setDensity(0);
        setGravityStrength(0);
        setAngularVelocity(0.3f);
        getWorld().addCollisionListener(this); 
        this.setImage(new BodyImage("src/resources/vortex.png"));
	}
	
	/**
	 * set conditions for collision with the vortex, ie, progess to next level
	 */
	public void collide(CollisionEvent e)
	{
		if(e.getOtherBody() == game.getPlayer()) {
			game.goToNext();
		}
	}
	
}
