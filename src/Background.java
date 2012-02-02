import org.jbox2d.common.Vec2;
import city.soi.platform.*;

/**
 * the very bottom layer of background images
 * uses the background of the planet
 */
public class Background extends Body
{   
    /** The game in which the player is playing. */
    private Game game;
    
    /**
     * Initialise a new background
     * @param g The game.
     */
    public Background(Game game, Vec2 pos, String image)
    {
        super(game.getWorld(), PolygonShape.makeBox(10, 10));
        this.game = game;
        this.setImage(new BodyImage(image, pos, 1f));
        this.setRenderLayer(-3);   
        this.setGhostly(true);
    }
}
