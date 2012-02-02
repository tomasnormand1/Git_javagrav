import city.soi.platform.*;

/**
 * Score bubble class, when the player has a collision with the bubble
 * score is incremented( and bubble is destroyed.)
 */
public class Bubble extends Body implements CollisionListener
{   
    /** The game in which the player is playing. */
    private Game game;
    
    /** the player */
    private Player player;

    /**
     * Initialise a new bubble.
     * @param g The game.
     */
    public Bubble(Game game)
    {
        super(game.getWorld(), new CircleShape(20));
        this.game = game;
        getWorld().addCollisionListener(this);
        this.setImage(new BodyImage("src/resources/bubble.png"));
    }

    public void collide(CollisionEvent e)
    {
        if(e.getOtherBody() == game.getPlayer()) {
            game.getPlayer().incrementBubbleCount();
            destroy();
        }    
    }
}
