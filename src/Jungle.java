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
public class Jungle extends Levels {
    /** background */
    private Background background;
    /** asteroid belt 1 */
    private Background layer2;
    /** asteroid belt 2 */
    private Background layer3;
    /** redbubble1 */
    private RedBubble redBubble1;
    /** vortex */
    private Vortex vortex;
    /** use to track how long the player has had the power-up */
    private float timeSincePower;
    /** sound clip */
    private SoundClip sunset;
    
    
	public Jungle(Game game)
	{
		super(game);
		

        /**
         * initial time since power-up
         */
        timeSincePower = 0f;
		background = new Background(game, new Vec2(0,0), "src/resources/panorama.jpg");
		layer2 = new Background(game, new Vec2(0,0), "src/resources/panorama.jpg");
		layer3 = new Background(game, new Vec2(0,0), "src/resources/panorama.jpg");
		game.getPlayer().setGravityStrength(1);

	}
	
	public void playMusic() {
        /**
         * music to the world
         */
        try {

            sunset = new SoundClip("src/resources/sunset.au");
            sunset.loop();
        }
        catch (Exception ex) {
        	System.out.println("Unable to play sound");
        }
	}
	
	public void stopMusic()
	{
		sunset.close();
	}
	
	public void populate() {        
        /**
         * make new score bubbles
         */
        Body bubble1 = new Bubble(game);
        bubble1.setPosition(new Vec2(200, 70));
        Body bubble2 = new Bubble(game);
        bubble2.setPosition(new Vec2(-200, 70));
        Body bubble3 = new Bubble(game);
        bubble3.setPosition(new Vec2(200, 120));
        Body bubble4 = new Bubble(game);
        bubble4.setPosition(new Vec2(-200, 120));
        Body bubble5 = new Bubble(game);
        bubble5.setPosition(new Vec2(700, 200));
        Body bubble6 = new Bubble(game);
        bubble6.setPosition(new Vec2(700, 200));
        Body bubble7 = new Bubble(game);
        bubble7.setPosition(new Vec2(700, 200));
        Body bubble8 = new Bubble(game);
        bubble8.setPosition(new Vec2(700, 200));
        Body bubble9 = new Bubble(game);
        bubble9.setPosition(new Vec2(700, 200));
        Body bubble10 = new Bubble(game);
        bubble10.setPosition(new Vec2(700, 200));
		
        /**
         * make some red bubbles
         */
        redBubble1 = new RedBubble(game);
        redBubble1.setPosition(new Vec2(200, 390));
        
        /**
         * make a new vortex
         */
        vortex = new Vortex(game);
        vortex.setPosition(new Vec2(1400, 150));

        /**
         * make the grounds
         */
        Body ground0 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground0.setPosition(new Vec2(-1600, -200));
        ground0.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground0.setAlwaysOutline(true);
        
        Body n0 = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        n0.setPosition(new Vec2(-1600, -300));
        n0.setImage(new BodyImage("src/resources/nebula4.png"));
        
        Body ground = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground.setPosition(new Vec2(-800, -200));
        ground.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground.setAlwaysOutline(true);
        
        Body n = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        n.setPosition(new Vec2(-800, -300));
        n.setImage(new BodyImage("src/resources/nebula5.png"));
        
        Body ground1 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground1.setPosition(new Vec2(0, -200));
        ground1.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground1.setAlwaysOutline(true);
        
        Body n1 = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        n1.setPosition(new Vec2(0, -300));
        n1.setImage(new BodyImage("src/resources/nebula4.png"));
        
        Body ground2 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground2.setPosition(new Vec2(800, -200));
        ground2.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground2.setAlwaysOutline(true);
        
        Body n2 = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        n2.setPosition(new Vec2(800, -300));
        n2.setImage(new BodyImage("src/resources/nebula5.png"));
        
        Body ground3 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground3.setPosition(new Vec2(1600, -200));
        ground3.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground3.setAlwaysOutline(true);
        
        Body n3 = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        n3.setPosition(new Vec2(1600, -300));
        n3.setImage(new BodyImage("src/resources/nebula4.png"));
        
        /**
         * make the ceilings 
         */
        
        Body staticPlatformT0 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT0.setPosition(new Vec2(-1600, 400));
        staticPlatformT0.setAlwaysOutline(true);
        staticPlatformT0.setImage(new BodyImage("src/resources/Hexagon2.png"));

        Body staticPlatformT = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT.setPosition(new Vec2(-800, 400));
        staticPlatformT.setAlwaysOutline(true);
        staticPlatformT.setImage(new BodyImage("src/resources/Hexagon2.png"));

        Body staticPlatformT1 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT1.setPosition(new Vec2(0, 400));
        staticPlatformT1.setAlwaysOutline(true);
        staticPlatformT1.setImage(new BodyImage("src/resources/Hexagon2.png"));
        
        Body staticPlatformT2 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT2.setPosition(new Vec2(800, 400));
        staticPlatformT2.setAlwaysOutline(true);
        staticPlatformT2.setImage(new BodyImage("src/resources/Hexagon2.png"));
        
        Body staticPlatformT3 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT3.setPosition(new Vec2(1600, 400));
        staticPlatformT3.setAlwaysOutline(true);
        staticPlatformT3.setImage(new BodyImage("src/resources/Hexagon2.png"));
        
        /**
         * make sticks
         */
        Body stickL = new Body(game.getWorld(), PolygonShape.makeBox(15, 285), Body.Type.STATIC);
        stickL.setPosition(new Vec2(-1500, 100));
        stickL.setFillColor(Color.black);
        Body stick2 = new Body(game.getWorld(), PolygonShape.makeBox(15, 100), Body.Type.STATIC);
        stick2.setPosition(new Vec2(-1300, -90));
        stick2.setFillColor(Color.black);
        Body stick3 = new Body(game.getWorld(), PolygonShape.makeBox(15, 100), Body.Type.STATIC);
        stick3.setPosition(new Vec2(-1200, 260));
        stick3.setFillColor(Color.black);
        Body stick4 = new Body(game.getWorld(), PolygonShape.makeBox(15, 150), Body.Type.STATIC);
        stick4.setPosition(new Vec2(-1000, -40));
        stick4.setFillColor(Color.black);
        Body stick5 = new Body(game.getWorld(), PolygonShape.makeBox(15, 90), Body.Type.STATIC);
        stick5.setPosition(new Vec2(-900, 260));
        stick5.setFillColor(Color.black);
        Body stick6 = new Body(game.getWorld(), PolygonShape.makeBox(15, 120), Body.Type.STATIC);
        stick6.setPosition(new Vec2(-700, -70));
        stick6.setFillColor(Color.black);
        Body stick7 = new Body(game.getWorld(), PolygonShape.makeBox(15, 100), Body.Type.STATIC);
        stick7.setPosition(new Vec2(-400, 210));
        stick7.setFillColor(Color.black);
        Body stick8 = new Body(game.getWorld(), PolygonShape.makeBox(15, 60), Body.Type.STATIC);
        stick8.setPosition(new Vec2(-300, 0));
        stick8.setFillColor(Color.black);
        Body stick9 = new Body(game.getWorld(), PolygonShape.makeBox(15, 200), Body.Type.STATIC);
        stick9.setPosition(new Vec2(0, 150));
        stick9.setFillColor(Color.black);
        Body stick10 = new Body(game.getWorld(), PolygonShape.makeBox(15, 170), Body.Type.STATIC);
        stick10.setPosition(new Vec2(150, -20));
        stick10.setFillColor(Color.black);
        Body stick11 = new Body(game.getWorld(), PolygonShape.makeBox(15, 100), Body.Type.STATIC);
        stick11.setPosition(new Vec2(200, 180));
        stick11.setFillColor(Color.black);
        Body stick12 = new Body(game.getWorld(), PolygonShape.makeBox(15, 190), Body.Type.STATIC);
        stick12.setPosition(new Vec2(400, -90));
        stick12.setFillColor(Color.black);
        Body stick13 = new Body(game.getWorld(), PolygonShape.makeBox(15, 80), Body.Type.STATIC);
        stick13.setPosition(new Vec2(700, -100));
        stick13.setFillColor(Color.black);
        Body stick14 = new Body(game.getWorld(), PolygonShape.makeBox(15, 120));
        stick14.setPosition(new Vec2(703, 0));
        stick14.setFillColor(Color.black);
        Body stick15 = new Body(game.getWorld(), PolygonShape.makeBox(15, 80), Body.Type.STATIC);
        stick15.setPosition(new Vec2(900, 100));
        stick15.setFillColor(Color.black);
        Body stick16 = new Body(game.getWorld(), PolygonShape.makeBox(15, 150), Body.Type.STATIC);
        stick16.setPosition(new Vec2(1200, 240));
        stick16.setFillColor(Color.black);
        Body stickR = new Body(game.getWorld(), PolygonShape.makeBox(15, 285), Body.Type.STATIC);
        stickR.setPosition(new Vec2(1500, 150));
        stickR.setFillColor(Color.black);
        
        
        //bricks
        Body brickL11 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL11.setPosition(new Vec2(-1200, 285));
        brickL11.setFillColor(Color.black);
        Body brickL12 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL12.setPosition(new Vec2(-985, 135));
        brickL12.setFillColor(Color.black);
        Body brickL13 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL13.setPosition(new Vec2(-910, 285));
        brickL13.setFillColor(Color.black);
        Body brickL14 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL14.setPosition(new Vec2(-712, 235));
        brickL14.setFillColor(Color.black);
        Body brickL15 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL15.setPosition(new Vec2(900, 25));
        brickL15.setFillColor(Color.black);
        Body brickL16 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL16.setPosition(new Vec2(900, 75));
        brickL16.setFillColor(Color.black);
        Body brickL17 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL17.setPosition(new Vec2(950, 125));
        brickL17.setFillColor(Color.black);
        Body brickL18 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL18.setPosition(new Vec2(950, 175));
        brickL18.setFillColor(Color.black);
        Body brickL19 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL19.setPosition(new Vec2(1000, 25));
        brickL19.setFillColor(Color.black);
        Body brickL20 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL20.setPosition(new Vec2(1000, 275));
        brickL20.setFillColor(Color.black);
        Body brickL21 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL21.setPosition(new Vec2(1050, 75));
        brickL21.setFillColor(Color.black);
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
        game.getPlayer().setPosition(new Vec2(-1350, 100));
	}
	public void putPlayerAtStart2() {
	}
}
