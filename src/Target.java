import java.awt.Color;

import city.soi.platform.*;


public class Target extends Body implements CollisionListener{
	/** the game class */
	private Game game;
	
	/**
	 * constructor for target
	 * @param game
	 */
	public Target(Game game)
	{
		super(game.getWorld(), new CircleShape(50));
		this.game = game;
        getShapeList().getFirst().setDensity(0);
        setGravityStrength(0);
        getWorld().addCollisionListener(this); 
        setFillColor(Color.DARK_GRAY);

	}
	
	/**
	 * set the conditions for a collision of a standard shell bullet
	 */
	public void collide(CollisionEvent e)
	{
		
		if(e.getOtherBody() instanceof StandardShell) {
			game.incKillCount();
			System.out.println("target destroyed");
			System.out.println(game.getKillCount());

			destroy();
		}
		
	}	
}
