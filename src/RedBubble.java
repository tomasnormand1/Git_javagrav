import city.soi.platform.*;

/**
 * Pick-ups in a game. When the player collides with the red bubble
 * player gets another life
 */
public class RedBubble extends Body implements CollisionListener
{   
    /** The game in which the player is playing. */
    private Game game;
    
    /** use to determine whether the player has collided */
    private boolean hasCollided;

    /**
     * Initialise a new red bubble.
     * @param g The game.
     */
    public RedBubble(Game game)
    {
        super(game.getWorld(), new CircleShape(20));
        this.game = game;
        hasCollided = false;
        this.setImage(new BodyImage("src/resources/glossy-ball-icon.png"));
        getWorld().addCollisionListener(this);
    }
    
    public void collide(CollisionEvent e)
    {
        if(e.getOtherBody() == game.getPlayer()) {
            destroy();
            game.setImpulsePower(500);
            game.setPowerON(true);
            System.out.println("lol");
        }
    }
}
