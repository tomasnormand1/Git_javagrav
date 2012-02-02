import org.jbox2d.common.Vec2;

import city.soi.platform.*;


/**
 * @author tomas
 * Quiet is the class for the first level of the game
 * a space level.
 * extends Levels class to inherit the abstract methods from the Levels class.
 * Uses dynamic backgrounds of a space theme.
 */
public class Quiet extends Levels {
    /** background */
    private Background background;
    /** asteroid belt 1 */
    private Background asteroid1;
    /** asteroid belt 2 */
    private Background asteroid2;
    /** redbubble1 */
    private RedBubble redBubble1;
    /** vortex */
    private Vortex vortex;
    /** use to track how long the player has had the power-up */
    private float timeSincePower;
    /** sound clip */
    private SoundClip paprika;
    /** completed? */
    private boolean isComplete;
    
    
	public Quiet(Game game)
	{
		super(game);
		

        /**
         * initial time since power-up
         */
        timeSincePower = 0f;
        isComplete = false;
        redBubble1 = new RedBubble(game);
        vortex = new Vortex(game);
		background = new Background(game, new Vec2(400, -120), "src/resources/backgroundspace2.png");
        asteroid1 = new Background(game, new Vec2(-120, -120), "src/resources/asteroid1.2.png");
        asteroid2 = new Background(game, new Vec2(-120, -120), "src/resources/asteroid2.2.png");
		game.getPlayer().setGravityStrength(1);

	}
	
	public void playMusic() {
        /**
         * music to the world
         */
        try {

            paprika = new SoundClip("src/resources/paprika2.au");
            paprika.loop();
        }
        catch (Exception ex) {
        	System.out.println("Unable to play sound");
        }
	}
	
	public void stopMusic()
	{	
		paprika.close();
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
        bubble5.setPosition(new Vec2(670, 365));
        Body bubble6 = new Bubble(game);
        bubble6.setPosition(new Vec2(670, 405));
        Body bubble7 = new Bubble(game);
        bubble7.setPosition(new Vec2(670, 445));
        Body bubble8 = new Bubble(game);
        bubble8.setPosition(new Vec2(630, 365));
        Body bubble9 = new Bubble(game);
        bubble9.setPosition(new Vec2(630, 405));
        Body bubble10 = new Bubble(game);
        bubble10.setPosition(new Vec2(630, 445));
        Body bubble11 = new Bubble(game);
        bubble11.setPosition(new Vec2(700, 600));
        Body bubble12 = new Bubble(game);
        bubble12.setPosition(new Vec2(500, 600));
        Body bubble13 = new Bubble(game);
        bubble13.setPosition(new Vec2(300, 600));
        Body bubble14 = new Bubble(game);
        bubble14.setPosition(new Vec2(100, 600));
        
        /**
         * make some red bubbles
         */
        redBubble1.setPosition(new Vec2(200, 390));
        
        /**
         * make the vortex
         */
        vortex.setPosition(new Vec2(-200, 665));	

        /**
         * make the ground
         */
        Body ground = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground.setPosition(new Vec2(0, -200));
        ground.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground.setAlwaysOutline(true);

        /**
         * make backgrounds
         */

        Body backgroundL = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        backgroundL.setPosition(new Vec2(-1000, 0));        
        backgroundL.setImage(new BodyImage("src/resources/nebula2.png"));
        backgroundL.setRenderLayer(0);   
        backgroundL.setGhostly(true);

        Body backgroundM = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        backgroundM.setPosition(new Vec2(-1000, 1500));        
        backgroundM.setImage(new BodyImage("src/resources/nebula3.png"));
        backgroundM.setRenderLayer(0);   
        backgroundM.setGhostly(true);
        
        Body backgroundJ = new Body(game.getWorld(), PolygonShape.makeBox(10, 10), Body.Type.STATIC);
        backgroundJ.setPosition(new Vec2(0, 1700));
        backgroundJ.setImage(new BodyImage("src/resources/black.jpg"));
        backgroundJ.setRenderLayer(-7);
        backgroundJ.setGhostly(true);

        /**
         * make some platforms. L = left side, R = right side, 
         * T = top side, B  = bottom side, C = center, M = middle
         */ 

        Body staticPlatformR = new Body(game.getWorld(), PolygonShape.makeBox(15, 400), Body.Type.STATIC);
        staticPlatformR.setPosition(new Vec2(1295, 185));
        staticPlatformR.setImage(new BodyImage("src/resources/Hexagon2.5.png"));
        staticPlatformR.setAlwaysOutline(true);

        Body staticPlatformTR = new Body(game.getWorld(), PolygonShape.makeBox(15, 400), Body.Type.STATIC);
        staticPlatformTR.setPosition(new Vec2(1295, 985));
        staticPlatformTR.setImage(new BodyImage("src/resources/Hexagon2.5.png"));
        staticPlatformTR.setAlwaysOutline(true);

        Body staticPlatformRB = new Body(game.getWorld(), PolygonShape.makeBox(40, 15), Body.Type.STATIC);
        staticPlatformRB.setPosition(new Vec2(1240, -200));
        staticPlatformRB.setFillColor(java.awt.Color.BLACK);
        staticPlatformRB.setImage(new BodyImage("src/resources/Hexagon2.2.png"));
        staticPlatformRB.setAlwaysOutline(true);

        Body cornerL = new Body(game.getWorld(), new PolygonShape(-50,-50, -50,150, 0,150, 150,0, 150,-50), Body.Type.STATIC);
        cornerL.setPosition(new Vec2(-350, -135));
        cornerL.setImage(new BodyImage("src/resources/iron1.png", new Vec2 (50,50), 1f));
        Body cornerR = new Body(game.getWorld(), new PolygonShape(50,-50, 50,150, 0,150, -150,0, -150,-50), Body.Type.STATIC);
        cornerR.setPosition(new Vec2(1230, -135));
        cornerR.setImage(new BodyImage("src/resources/iron3.png", new Vec2(-50,50), 1f));
        Body cornerT = new Body(game.getWorld(), new PolygonShape(-50,50, 150,50, 150,0, 0,-150, -50,-150), Body.Type.STATIC);
        cornerT.setPosition(new Vec2(860, 505));
        cornerT.setImage(new BodyImage("src/resources/iron2.png", new Vec2(50,-50), 1f));

        Body staticPlatformCMM = new Body(game.getWorld(), PolygonShape.makeBox(10, 150), Body.Type.STATIC);
        staticPlatformCMM.setPosition(new Vec2(800, 405));
        staticPlatformCMM.setAlwaysOutline(true);
        staticPlatformCMM.setImage(new BodyImage("src/resources/Hexagon6.png"));

        Body staticContainerBase = new Body(game.getWorld(), PolygonShape.makeBox(50, 10), Body.Type.STATIC);
        staticContainerBase.setPosition(new Vec2(650, 355));
        staticContainerBase.setAlwaysOutline(true);
        staticContainerBase.setImage(new BodyImage("src/resources/Hexagon5.png"));

        Body staticLaunch = new Body(game.getWorld(), PolygonShape.makeBox(40, 15), Body.Type.STATIC);
        staticLaunch.setPosition(new Vec2(0, -170));
        staticLaunch.setFillColor(java.awt.Color.BLACK);
        staticLaunch.setImage(new BodyImage("src/resources/Hexagon2.2.png"));
        staticLaunch.setAlwaysOutline(true);

        Body ground2 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        ground2.setPosition(new Vec2(800, -200));
        ground2.setImage(new BodyImage("src/resources/Hexagon2.png"));
        ground2.setAlwaysOutline(true);

        Body staticPlatformT = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT.setPosition(new Vec2(0, 570));
        staticPlatformT.setAlwaysOutline(true);
        staticPlatformT.setImage(new BodyImage("src/resources/Hexagon2.png"));

        Body staticPlatformT2 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT2.setPosition(new Vec2(800, 570));
        staticPlatformT2.setAlwaysOutline(true);
        staticPlatformT2.setImage(new BodyImage("src/resources/Hexagon2.png"));

        Body staticPlatformT3 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT3.setPosition(new Vec2(0, 770));
        staticPlatformT3.setAlwaysOutline(true);
        staticPlatformT3.setImage(new BodyImage("src/resources/Hexagon2.png"));
        
        Body staticPlatformT4 = new Body(game.getWorld(), PolygonShape.makeBox(400, 15), Body.Type.STATIC);
        staticPlatformT4.setPosition(new Vec2(800, 770));
        staticPlatformT4.setAlwaysOutline(true);
        staticPlatformT4.setImage(new BodyImage("src/resources/Hexagon2.png"));
        
        // center platforms
        Body staticPlatformCBR = new Body(game.getWorld(), PolygonShape.makeBox(50, 10), Body.Type.STATIC);
        staticPlatformCBR.setPosition(new Vec2(200, 40));
        staticPlatformCBR.setAlwaysOutline(true);
        staticPlatformCBR.setImage(new BodyImage("src/resources/Hexagon5.png"));

        Body staticPlatformCBL = new Body(game.getWorld(), PolygonShape.makeBox(50, 10), Body.Type.STATIC);
        staticPlatformCBL.setPosition(new Vec2(-200, 40));
        staticPlatformCBL.setAlwaysOutline(true);
        staticPlatformCBL.setImage(new BodyImage("src/resources/Hexagon5.png"));

        Body staticPlatformCBM = new Body(game.getWorld(), PolygonShape.makeBox(10, 150), Body.Type.STATIC);
        staticPlatformCBM.setPosition(new Vec2(-410, -35));
        staticPlatformCBM.setAlwaysOutline(true);
        staticPlatformCBM.setImage(new BodyImage("src/resources/Hexagon6.png"));

        Body staticPlatformCTR = new Body(game.getWorld(), PolygonShape.makeBox(50, 10), Body.Type.STATIC);
        staticPlatformCTR.setPosition(new Vec2(200, 359));
        staticPlatformCTR.setAlwaysOutline(true);
        staticPlatformCTR.setImage(new BodyImage("src/resources/Hexagon5.png"));

        Body staticPlatformCTL = new Body(game.getWorld(), PolygonShape.makeBox(50, 10), Body.Type.STATIC);
        staticPlatformCTL.setPosition(new Vec2(-200, 359));
        staticPlatformCTL.setAlwaysOutline(true);
        staticPlatformCTL.setImage(new BodyImage("src/resources/Hexagon5.png"));

        /**
         * build bricks - dynamic
         * number = level, R/L = right or left platform, R/L = right/ left brick
         * eg, 1RL is the 1st level, right platform, left brick
         */  
        // level 1 bricks
        Body brick1RL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick1RL.setPosition(new Vec2(160, 75));
        brick1RL.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick1RR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick1RR.setPosition(new Vec2(240, 75));
        brick1RR.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick1LL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick1LL.setPosition(new Vec2(-240, 75));
        brick1LL.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick1LR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick1LR.setPosition(new Vec2(-160, 75));
        brick1LR.setImage(new BodyImage("src/resources/Hexagon3.png"));
        // level 2 bricks
        Body brick2RL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick2RL.setPosition(new Vec2(160, 125));
        brick2RL.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick2RR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick2RR.setPosition(new Vec2(240, 125));
        brick2RR.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick2LL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick2LL.setPosition(new Vec2(-240, 125));
        brick2LL.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick2LR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick2LR.setPosition(new Vec2(-160, 125));
        brick2LR.setImage(new BodyImage("src/resources/Hexagon4.png"));
        // level 3 bricks
        Body brick3RL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick3RL.setPosition(new Vec2(160, 175));
        brick3RL.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick3RR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick3RR.setPosition(new Vec2(240, 175));
        brick3RR.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick3LL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick3LL.setPosition(new Vec2(-240, 175));
        brick3LL.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick3LR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick3LR.setPosition(new Vec2(-160, 175));
        brick3LR.setImage(new BodyImage("src/resources/Hexagon3.png"));
        // level 4 bricks
        Body brick4RL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick4RL.setPosition(new Vec2(160, 225));
        brick4RL.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick4RR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick4RR.setPosition(new Vec2(240, 225));
        brick4RR.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick4LL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick4LL.setPosition(new Vec2(-240, 225));
        brick4LL.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick4LR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick4LR.setPosition(new Vec2(-160, 225));
        brick4LR.setImage(new BodyImage("src/resources/Hexagon4.png"));
        // level 5 bricks
        Body brick5RL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick5RL.setPosition(new Vec2(160, 275));
        brick5RL.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick5RR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick5RR.setPosition(new Vec2(240, 275));
        brick5RR.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick5LL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick5LL.setPosition(new Vec2(-240, 275));
        brick5LL.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brick5LR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick5LR.setPosition(new Vec2(-160, 275));
        brick5LR.setImage(new BodyImage("src/resources/Hexagon3.png"));
        // level 6 bricks
        Body brick6RL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick6RL.setPosition(new Vec2(160, 325));
        brick6RL.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick6RR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick6RR.setPosition(new Vec2(240, 325));
        brick6RR.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick6LL = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick6LL.setPosition(new Vec2(-240, 325));
        brick6LL.setImage(new BodyImage("src/resources/Hexagon4.png"));
        Body brick6LR = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brick6LR.setPosition(new Vec2(-160, 325));
        brick6LR.setImage(new BodyImage("src/resources/Hexagon4.png"));
		
        
        // top level bricks

        Body brickTR1 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR1.setPosition(new Vec2(800, 600));
        brickTR1.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickTR2 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR2.setPosition(new Vec2(800, 650));
        brickTR2.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickTR3 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR3.setPosition(new Vec2(800, 700));
        brickTR3.setImage(new BodyImage("src/resources/Hexagon3.png"));
        
        Body brickTR5 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR5.setPosition(new Vec2(400, 625));
        brickTR5.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickTR6 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR6.setPosition(new Vec2(400, 675));
        brickTR6.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickTR66 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR66.setPosition(new Vec2(400, 725));
        brickTR66.setImage(new BodyImage("src/resources/Hexagon3.png"));
        
        Body brickTR7 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR7.setPosition(new Vec2(0, 600));
        brickTR7.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickTR8 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR8.setPosition(new Vec2(0, 650));
        brickTR8.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickTR9 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickTR9.setPosition(new Vec2(0, 700));
        brickTR9.setImage(new BodyImage("src/resources/Hexagon3.png"));    
        
        // left wall bricks - middle

        Body brickL1 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL1.setPosition(new Vec2(-390, 25));
        brickL1.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL2 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL2.setPosition(new Vec2(-390, 75));
        brickL2.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL3 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL3.setPosition(new Vec2(-390, 125));
        brickL3.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL4 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL4.setPosition(new Vec2(-390, 175));
        brickL4.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL5 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL5.setPosition(new Vec2(-390, 225));
        brickL5.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL6 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL6.setPosition(new Vec2(-390, 275));
        brickL6.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL7 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL7.setPosition(new Vec2(-390, 325));
        brickL7.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL8 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL8.setPosition(new Vec2(-390, 375));
        brickL8.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL9 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL9.setPosition(new Vec2(-390, 425));
        brickL9.setImage(new BodyImage("src/resources/Hexagon3.png"));

        //left wall bricks - right
        
        Body brickL10 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL10.setPosition(new Vec2(-370, 25));
        brickL10.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL20 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL20.setPosition(new Vec2(-370, 75));
        brickL20.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL30 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL30.setPosition(new Vec2(-370, 125));
        brickL30.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL40 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL40.setPosition(new Vec2(-370, 175));
        brickL40.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL50 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL50.setPosition(new Vec2(-370, 225));
        brickL50.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL60 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL60.setPosition(new Vec2(-370, 275));
        brickL60.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL70 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL70.setPosition(new Vec2(-370, 325));
        brickL70.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL80 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL80.setPosition(new Vec2(-370, 375));
        brickL80.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL90 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL90.setPosition(new Vec2(-370, 425));
        brickL90.setImage(new BodyImage("src/resources/Hexagon3.png"));
        
        // left wall bricks - left
        
        Body brickL11 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL11.setPosition(new Vec2(-410, 125));
        brickL11.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL21 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL21.setPosition(new Vec2(-410, 175));
        brickL21.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL31 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL31.setPosition(new Vec2(-410, 225));
        brickL31.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL41 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL41.setPosition(new Vec2(-410, 275));
        brickL41.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL51 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL51.setPosition(new Vec2(-410, 325));
        brickL51.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL61 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL61.setPosition(new Vec2(-410, 375));
        brickL61.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL71 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL71.setPosition(new Vec2(-410, 425));
        brickL71.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL81 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL81.setPosition(new Vec2(-410, 475));
        brickL81.setImage(new BodyImage("src/resources/Hexagon3.png"));
        Body brickL91 = new Body(game.getWorld(), PolygonShape.makeBox(10, 25));
        brickL91.setPosition(new Vec2(-410, 525));
        brickL91.setImage(new BodyImage("src/resources/Hexagon3.png"));
        
	}
	
	/**
	 * layers 1-3 of the background layers. 1 being furthest back
	 */
	public Body layer1() 
	{
		return background;
	}
	public Body layer2() 
	{
        return asteroid1;
	}
	public Body layer3() 
	{
        return asteroid2;
	}
	
	/**
	 * getters for the powerups
	 */
	public Body redBubble1() 
	{
		return redBubble1;
	}
	
	
	public boolean isCompleted() 
	{
		return isComplete;
	}
	
    /**
     * put player on launch pad
     */
	public void putPlayerAtStart() 
	{
        game.getPlayer().setPosition(new Vec2(0, 0));
	}
	public void putPlayerAtStart2() {
	}
}
