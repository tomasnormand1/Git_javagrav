import java.awt.Color;

import org.jbox2d.common.Vec2;

import city.soi.platform.*;


/**
 * @author tomas
 * Jungle is the class for the second level of the game
 * a jungle level.
 * extends Levels class to inherit the abstract methods from the Levels class.
 * Uses dynamic backgrounds of a jungle theme.
 */
public class Tundra extends Levels {
    /** background */
    private Background background;
    /** asteroid belt 1 */
    private Background layer2;
    /** asteroid belt 2 */
    private Background layer3;
    /** redbubble1 */
    private RedBubble redBubble1;
    /** use to track how long the player has had the power-up */
    private float timeSincePower;
    /** sound clip */
    private SoundClip l1;
    /** targets */
    private Body target2;
    private Body target3;
    private Body target4;
    
    
    
	public Tundra(Game game)
	{
		super(game);
		
        /**
         * initial time since power-up
         */
        timeSincePower = 0f;
		background = new Background(game, new Vec2(0,0), "src/resources/tundra.jpg");
		layer2 = new Background(game, new Vec2(0,0), "src/resources/tundra.jpg");
		layer3 = new Background(game, new Vec2(0,0), "src/resources/tundra.jpg");
		game.getPlayer().setGravityStrength(0);

	}
	
	public void populate() {        
        /**
         * make new score bubbles
         */
        Body bubble1 = new Bubble(game);
        bubble1.setPosition(new Vec2(50, -1500));
		
        /**
         * make some red bubbles
         */
        redBubble1 = new RedBubble(game);
        redBubble1.setPosition(new Vec2(0, -150));

        /**
         * make targets
         */
        Body target2 = new Target(game);
        this.target2 = target2;
        target2.setPosition(new Vec2(200, 300));
        Body target3 = new Target(game);
        this.target3 = target3;
        target3.setPosition(new Vec2(0, 350));
        Body target4 = new Target(game);
        this.target4 = target4;
        target4.setPosition(new Vec2(-200, 300));

        /**
         * make the grounds
         */

        Body ground1 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground1.setPosition(new Vec2(0, -200));
        ground1.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground1.setAlwaysOutline(true);
        
        Body n1 = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        n1.setPosition(new Vec2(0, -300));
        n1.setImage(new BodyImage("src/resources/nebula4.png"));

        /**
         * make the ceilings 
         */

        Body staticPlatformT1 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT1.setPosition(new Vec2(0, 400));
        staticPlatformT1.setAlwaysOutline(true);
        staticPlatformT1.setImage(new BodyImage("src/resources/Hexagon2.png"));

        /**
         * make sticks
         */
        Body stickL = new Body(game.getWorld(), PolygonShape.makeBox(100, 285), Body.Type.STATIC);
        stickL.setPosition(new Vec2(-450, 100));
        stickL.setFillColor(Color.black);
        Body stickR = new Body(game.getWorld(), PolygonShape.makeBox(100, 285), Body.Type.STATIC);
        stickR.setPosition(new Vec2(450, 100));
        stickR.setFillColor(Color.black);
        
        //bricks
        
        Body brickL11 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL11.setPosition(new Vec2(-150, -150));
        brickL11.setFillColor(Color.black);
        Body brickL12 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL12.setPosition(new Vec2(-150, -100));
        brickL12.setFillColor(Color.black);
        Body brickL13 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL13.setPosition(new Vec2(-150, -50));
        brickL13.setFillColor(Color.black);
        Body brickL14 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL14.setPosition(new Vec2(-150, 0));
        brickL14.setFillColor(Color.black);
        Body brickL15 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL15.setPosition(new Vec2(-150, 50));
        brickL15.setFillColor(Color.black);
        Body brickL16 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL16.setPosition(new Vec2(-150, 100));
        brickL16.setFillColor(Color.black);
        
        Body brickL17 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL17.setPosition(new Vec2(150, -150));
        brickL17.setFillColor(Color.black);
        Body brickL18 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL18.setPosition(new Vec2(150, -100));
        brickL18.setFillColor(Color.black);
        Body brickL19 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL19.setPosition(new Vec2(150, -50));
        brickL19.setFillColor(Color.black);
        Body brickL20 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL20.setPosition(new Vec2(150, 0));
        brickL20.setFillColor(Color.black);
        Body brickL21 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL21.setPosition(new Vec2(150, 50));
        brickL21.setFillColor(Color.black);
        Body brickL22 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL22.setPosition(new Vec2(150, 100));
        brickL22.setFillColor(Color.black);
        
	}
	
	/**
	 * layers 1-3 of the background layers. 1 being furthest back
	 */
	public Body layer1() {
		return background;
	}
	public Body layer2() {
        return layer2;
	}
	public Body layer3() {
        return layer3;
	}
	
	/**
	 * get targets
	 */
	public Body getTarget2() {
		return target2;
	}
	public Body getTarget3() {
		return target3;
	}
	public Body getTarget4() {
		return target4;
	}
	
	/**
	 * music for background
	 */
	public void playMusic() {
		try {
			l1 = new SoundClip("src/resources/l1.au");
			l1.loop();
		} catch (Exception e) {
        	System.out.println("Unable to play sound");
		}
	}
	
	public void stopMusic()
	{
		l1.close();
	}
	
	/**
	 * getters for the powerups
	 */
	public Body redBubble1() {
		return redBubble1;
	}
	
	public boolean isCompleted() {
		return false;
	}
	
    /**
     * put player at start
     */
	public void putPlayerAtStart() {
        game.getPlayer().setPosition(new Vec2(0, 100));
	}
	public void putPlayerAtStart2() {
	}
}
