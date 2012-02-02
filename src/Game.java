import city.soi.platform.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jbox2d.common.Vec2;
import javax.swing.*;

/**
 * ****************************************
 * **************KEPLER'S LAW**************
 * ****************************************
 * 
 * so far - a ship game, controls:
 * UP = thrust
 * Left = rotate left
 * RIGHT = rotate right
 * SPACE = fire gun
 * Q = switch weapon (not finished)
 * G = new game
 * H = print stats
 * 
 * Author: Tomas Normand
 * version 1.6 - for milestone 2 
 * 
 * 
 * to do list - 
 * --- done --- adding a background image
 * --- done --- adding music to game class
 * --- done --- making player loose 1 life when falls off level
 * --- done --- fixing the impulse/velocity vector
 * --- done --- applying textures and images to the shapes
 * --- done --- making the blue bubbles spawn in the right place
 * --- done --- creating a gun
 * --- done --- making the red bubbles spawn in the right place
 * --- done --- powerups of some kind
 * --- done --- make dynamic background layers
 * paint trails from wings when flying
 * more complex level design, including puzzle aspect using a pulley and a bucket that you shoot blocks into
 * fix xp levelling up --- done but doesnt do anything yet
 * make 10 levels
 * for every 5 bubbles - new life --- almost, something wrong with life increment
 * --- done --- make bullets spawn outside body
 * make an ammo count and destroy bullets that are not in the arraylist
 * make multiple button presses
 * make bullets sync to a certain fps
 * make text display to the screen
 * make another bullet type (piercing rounds)
 * make gravity pulse weapon
 * make grapple hook (?)
 * make joints and doors for pulley puzzle
 * make a set of turrets guarding portal that follow the player
 * make portal to next level
 * make next level
 * 
 * or something...
 * 
 * Author: Tomas Normand
 * Version: 1.6
 */
public class Game extends Thread implements StepListener
{	
    /** background */
    private Background background;
    /** redbubble1 */
    private RedBubble redBubble1;
    /** use to track how long the player has had the power-up */
    private float timeSincePower;
    /** power flag */
    private boolean powerON;
    
    /** The player (a specialised Actor). */
    private Player player;
    private Player player2;
    
    /** the current game level */
    private Levels currentLevel;
    /** other game levels */
    private int levelCount;
    /** target kill count */
    private int targetCount;
    /** the target class */
    private Target target;
    /** arena */
    private Arena arena;

    /** speed of rotation */
    private float angularVelocity;
    private float angularVelocity2;

    /** paused flag */
    private boolean isPaused;

    /** Game over flag. */
    private boolean isOver;

    /** array of bullets */
    private Ammo magazine1;

    /** new standard shell, HD shells and shell signitures */
    private StandardShell standard;
    private HighDShell hd;
    private int shellSig;
    private int shellSig2;

    /** The World in which the game bodies move and interact.*/
    private World world;
    private int viewX;
    private int viewY;

    /** A graphical display of the world (a specialised JPanel). */
    private WorldView view;

    /** A debug display. */
    private DebugViewer debugViewer;

    /** impulse power */
    private float impulsePower;

    /** heads up display with buttons and stats */
	private HUD hud;
	
	/** class that handles multiple key events */
	private MultiKey multiKey;

    /** Initialise a new Game. */
    public Game() {
        
    	isOver = false;

        /**
         * set the initial impulse power
         */
        impulsePower = 300;
        powerON = false;
        
        /**
         * Initialise the ammo class
         */
        magazine1 = new Ammo();
        
        shellSig = 1;
        shellSig2 = 1;
        /**
         * make the world
         */ 
        world = new World();
        viewX = 600;
        viewY = 600;

        /**
         * step listener
         */
        getWorld().addStepListener(this);

        /**
         * make a player
         */
        player = new Player(this, "src/resources/8bitshipfinalS.png");
        
        /**
         * new multikey class
         */
        multiKey = new MultiKey(this);
        
        /**
         * list of the levels
         */
        levelCount = 1;
    	currentLevel = new Tundra(this);
    	currentLevel.playMusic();
    	currentLevel.populate();
    	currentLevel.putPlayerAtStart();
    	
    	/**
    	 * player 2 initialisation TODO
    	 */  
        // make a view
        view = new WorldView(world, viewX, viewY);
        //view.setDrawStats(true); // uncomment this line to show simulation stats in game display

        // new gui test
        //final HUD hud = new HUD();
        // display the view in a frame
        final JFrame frame = new JFrame("Game");

        // add some keyboard handling
        frame.addKeyListener(new KeyAdapter(){
                /** Handle key press events for flying and shooting */
        	
        	
                public void keyPressed(KeyEvent e)
                {

                    if (isOver) return;
                    int code = e.getKeyCode();
                    	if (code == KeyEvent.VK_UP) {
                    		if (levelCount != 1) {
                    			//UP = apply an impulse / move forwards
                    			multiKey.addKey(code);
                    			multiKey.keyFire();
                    		}
                    	} else if (code == KeyEvent.VK_LEFT) {   
                			//LEFT ARROW = spin anti clockwise
                    		multiKey.addKey(code);
                    		multiKey.keyFire();                    		
                    	} else if (code == KeyEvent.VK_RIGHT) {
                			//rotate right
                    		multiKey.addKey(code);
                			multiKey.keyFire();
                    	} else if (code == KeyEvent.VK_M) {
                        	// toggle switch weapon
                        	multiKey.addKey(code);
                        	multiKey.keyFire();
                        } else if(code == KeyEvent.VK_SPACE) {  
                    		if (levelCount != 2) {
                            	// SPACE bar fires a shot
                    			multiKey.addKey(code);
                    			multiKey.keyFire();
                    		}
                    	} else if (code == KeyEvent.VK_T) {
                    		multiKey.addKey(code);
                    		multiKey.keyFire();
                    	} else if (code == KeyEvent.VK_F) {
                    		multiKey.addKey(code);
                    		multiKey.keyFire();
                    	} else if (code == KeyEvent.VK_H) {
                    		multiKey.addKey(code);
                    		multiKey.keyFire();
                    	} else if (code == KeyEvent.VK_W) {
                    		multiKey.addKey(code);
                    		multiKey.keyFire();
                    	} else if (code == KeyEvent.VK_Q) {
                        	// toggle switch weapon
                        	multiKey.addKey(code);
                        	multiKey.keyFire();
                        }
                        else if (code == KeyEvent.VK_F1) {
                            if (debugViewer == null) debugViewer = new DebugViewer(new DebugSettings(world));
                           	if (debugViewer.isRunning()) {
                               	debugViewer.stopViewer();
                           	} else {
                               	debugViewer.startViewer();
                           	} // make a new game (G)
                        } else if (code == KeyEvent.VK_O) {
                        	goToNext();   // prints stats for testing (H)
                        } else if (code == KeyEvent.VK_P) {
                            world.pause();
                        } else if (code == KeyEvent.VK_I) {
                        	printStats();
                        }
                }

                /** Handle key release events (stop rotating). */
        	
                public void keyReleased(KeyEvent e)
                {
                    if (isOver) return;
                    int code = e.getKeyCode();
                   	if (code == KeyEvent.VK_UP) {
               			multiKey.removeKey(code);
                        player.setImage(new BodyImage("src/resources/8bitshipfinalS.png"));
                    } else if (code == KeyEvent.VK_T) {
                    	multiKey.removeKey(code);
                        player2.setImage(new BodyImage("src/resources/8bitshipfinalS2.png"));
                    } else if (code == KeyEvent.VK_LEFT) {
                    	multiKey.removeKey(code);
                        angularVelocity -= angularVelocity;
                        player.setAngularVelocity(0);
                    } else if (code == KeyEvent.VK_F) {
                    	multiKey.removeKey(code);
                    	angularVelocity2 -= angularVelocity2;
                    	player2.setAngularVelocity(0);
                    } else if (code == KeyEvent.VK_RIGHT) {
                    	multiKey.removeKey(code);
                        angularVelocity -= angularVelocity;
                        player.setAngularVelocity(0);
                    } else if (code == KeyEvent.VK_H) {
                    	multiKey.removeKey(code);
                    	angularVelocity2 -= angularVelocity2;
                    	player2.setAngularVelocity(0);
                    } else if (code == KeyEvent.VK_SPACE) {                    	
                    	multiKey.setSKey(false);
                    	multiKey.removeKey(code);
                    } else if (code == KeyEvent.VK_W) {
                    	multiKey.setSKey2(false);
                    	multiKey.removeKey(code);
                    } else if (code == KeyEvent.VK_M) {
                    	multiKey.removeKey(code);
                    } else if (code == KeyEvent.VK_Q) {
                    	multiKey.removeKey(code);
                    }
                }
                
            });

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hud = new HUD(this);
        frame.add(hud, BorderLayout.SOUTH);
        // display the world in the window
        frame.add(view);        
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);

        frame.setFocusable(true);
        
        // start!
        world.start();
    }  

	/**
     * step listener
     */
    public void preStep(StepEvent e)
    {
        /**
         * 3 levels
         */
        if(player.getXP() >= 16.5 && player.getLevel() == 0) {
            player.levelIncrement();
        } else if(player.getXP() >= 38.5 && player.getLevel() == 1) {
            player.levelIncrement();
        } else if(player.getXP() >= 66 && player.getLevel() == 2) {
            player.levelIncrement();    
        } else if(player.getXP() >= 132 && player.getLevel() == 3) {
            player.levelIncrement();    
        } else if(player.getXP() >= 264 && player.getLevel() == 4) {
            player.levelIncrement();    
        } else if(player.getXP() >= 528 && player.getLevel() == 5) {
            player.levelIncrement();    
        }
       

    }

    /**
     * step events (post)
     * frist 3 events are to update the 3 background layers
     * next is to update camera position
     * next is to update whether the player is in bounds
     * next is to see whether player has enough lives left to carry on
     */
    public void postStep(StepEvent e)
    {
        
    	Vec2 pos = getPlayer().getPosition();
        double posXD = pos.x * 0.7;
        double posYD = pos.y * 0.4;
        float posX = (float) posXD;
        float posY = (float) posYD;
        getLayer1().setPosition(new Vec2(posX, posY));

        Vec2 pos2 = getPlayer().getPosition();
        double posXD2 = pos2.x * 0.6;
        double posYD2 = pos2.y * 0.3;
        float posX2 = (float) posXD2;
        float posY2 = (float) posYD2;
        getLayer2().setPosition(new Vec2(posX2, posY2));
        
        Vec2 pos3 = getPlayer().getPosition();
        double posXD3 = pos3.x * 0.5;
        double posYD3 = pos3.y * 0.2;
        float posX3 = (float) posXD3;
        float posY3 = (float) posYD3;
        getLayer3().setPosition(new Vec2(posX3, posY3));
        
    	/**
         * sets a timer on the red bubble power-up
         */
        if(getPowerON() == true) {
        	//System.out.println("" + powerON);
    		timeSincePower += e.getStep();
    		int powerUP = Math.round(timeSincePower % 6);
    		//System.out.println(Math.round(timeSincePower));    		
    		if (powerUP == 0) {
    			System.out.println("" + (5 - Math.round(timeSincePower)));
    		}    		
    		if (Math.round(timeSincePower) >= 6f) {
    			dampenPower();
    		}    		    	
        }
    	/**
    	 * bullet sync
    	 */
    	if (multiKey.getSKey() == true) {    		
    		float bulletSync;    
    		timeSincePower += e.getStep();
    		bulletSync = timeSincePower % 0.3f;
    		if(bulletSync > 0.15f && bulletSync < 0.2f) {
    			multiKey.pullTrigger(getPlayer().getAngleDegrees(), getPlayer().getPosition(), getShellSig());
    		}    		
    	} else if (multiKey.getSKey2() == true) {
    		float bulletSync;    
    		timeSincePower += e.getStep();
    		bulletSync = timeSincePower % 0.3f;
    		if(bulletSync > 0.15f && bulletSync < 0.2f) {
    			multiKey.pullTrigger(getPlayer2().getAngleDegrees(), getPlayer2().getPosition(), getShellSig2());
    		} 
    	}

    	/**
    	 * ammo cap TODO
    	 */
        if (magazine1.magazineCap() == 40) {
            magazine1.removeShell();   
        }

        /**
         * allows camera to track player
         */
        view.setCamera(player.getPosition(), 1.0f);  
        player.getPosition();
        if (levelCount == 4) {
        	view.setCamera(new Vec2(450, 300), 0.45f);
            getLayer1().setPosition(new Vec2(-400, 400));
            getLayer2().setPosition(new Vec2(0, 0));
            getLayer3().setPosition(new Vec2(0, 0));
        }
        /**
         * split screen for arena TODO    
         */
        
        
        /**
         * decreases a life if the player goes OOB
         * also set the player back to the start position
         */
        if (levelCount == 2) {
        	if(player.getPosition().x < -1900 || (player.getPosition().x > 1900)) {
        		player.decrementLife();
        		player.setPosition(new Vec2(-1700, -130));
        	} 
        } else if(levelCount == 3) {
        	if(player.getPosition().y < -250 || (player.getPosition().x < -1000)) {
        		player.decrementLife();
        		player.setPosition(new Vec2(0, -130));
        	} 
        } 
        
        /**
         * if the number of lives reaches 0, then sleep the thread for 2 seconds and then
         * end the game by closing the window
         */
        if(player.lifeCount() == 0) {
        	System.out.println("GAME OVER");
        	try {
        		Thread.sleep(2000);
        	} catch(Exception f) {
        		
        	}	
        	loadHub();
        	player.resetLives();
        	player.setLinearVelocity(new Vec2(0, 0));
        }
        
        /**
         * for the first level, if the player kills 5 targets, progress to next level
         */
        if (getKillCount() == 3) {
        	goToNext();
        	incKillCount();
        }
    }

    /**
     * dampen powerup
     */
    public void dampenPower() {
    	setPowerON(false);
		setImpulsePower(300);
		System.out.println("Power-up over");
		timeSincePower = 0f;
    }
    
    /**
     * set the power on 
     */
    public void setPowerON(boolean b) {
    	powerON = b;
    }
    public boolean getPowerON() {
    	return powerON;
    }

    /**
     * progress to next level
     * to add a new level, add the loadLevel() method and the current level
     */
    public void goToNext()
    {
    	int lCount = levelCount;
    	float exP = player.getXP();
    	if(levelCount == 1) {
    		loadLevel1();
        	currentLevel = new Jungle(this);
        	loadLevel2();
        	levelCount++;
        	player.incrementBubbleCount();
    	} else if (levelCount == 2) {
    		loadLevel1();
        	currentLevel = new Quiet(this);
        	loadLevel2();   			
        	levelCount++;
        	player.incrementBubbleCount();
    	} else if (levelCount == 3) {
    		loadHub();
    		player.incrementBubbleCount();
    	}
    	
        FileWriter2 writer = new FileWriter2();
        try {
			writer.save(Math.max(exP, player.getXP()), Math.max(lCount, levelCount));
		} catch (IOException e) {			
			e.printStackTrace();
		}
    }
    
    /**
     * load level stuff
     */
    public void loadLevel1() {
		currentLevel.stopMusic();
		currentLevel.cleanLevel();
    }
    
    public void loadLevel2() {
    	currentLevel.populate();
    	currentLevel.putPlayerAtStart();
    	currentLevel.playMusic();
    	player.setLinearVelocity(new Vec2(0, 0));
    	dampenPower();
    }
    
    /**
     * load the arena for 2 player mode
     */
    public void loadArena() {
    	loadLevel1();
    	currentLevel = new Arena(this);
    	loadLevel2();
    	addNewPlayer();
    	levelCount = 4;
    }
    
    /**
     * return back to the hub level
     */
    public void loadHub() {
    	loadLevel1();
    	currentLevel = new Tundra(this);
    	loadLevel2();
    	player.setLinearVelocity(new Vec2(0, 0));
    	levelCount = 1;
    }
    
    /**
     * add new player if button is pressed
     */
    public void addNewPlayer() {
    	if (hud.getFlag() == true) {
    		player2 = new Player(this, "src/resources/8bitshipfinalS2.png");            
    	}
    }
    
    /**
     * get level
     */
    public Levels getLevel()
    {
    	return currentLevel;
    }
    /**
     * get level count
     */
    public int getLevelCount()
    {
    	return levelCount;
    }
    
    /**
     * get and set the kill count for the tundra level
     */
    public void incKillCount()
    {
    	targetCount++;
    }
	public int getKillCount()
	{
		return targetCount;
	}
	
    
    /**
     * get layers
     */
    public Body getLayer1()
    {
    	return currentLevel.layer1();
    }
    
    public Body getLayer2()
    {
    	return currentLevel.layer2();
    }
    public Body getLayer3()
    {
    	return currentLevel.layer3();
    }
    
    /**
     * get powerups
     */
    public Body getRedBubble1()
    {
    	return currentLevel.redBubble1();
    }
    

    /**
     * print stats to terminal for testing
     */
    public void printStats()
    {
        if (player.lifeCount() == 0) {
        	hud.setString("GAME OVER");
        }
        if (player.getXP() >= 16.5 && player.getLevel() == 0) {
            hud.setString("LEVEL UP!");
        } else if(player.getXP() >= 38.5 && player.getLevel() == 1) {
        	hud.setString("LEVEL UP!");
        } else if(player.getXP() >= 66 && player.getLevel() == 2) {
        	hud.setString("LEVEL UP!");
        }
        System.out.println("" + player2.getAngleDegrees());
        System.out.println("" + getPlayer2());
        System.out.println("" + player2.getPosition());
    }
    
    /**
     * set shell type
     */
    public void setShellSig(int weaponSig)
    {
        shellSig = weaponSig;    
    }
    public void setShellSig2(int weaponSig) {
    	shellSig2 = weaponSig;
    }

    /**
     * get shell type
     */
    public int getShellSig()
    {
        return shellSig;    
    }
    public int getShellSig2() {
    	return shellSig2;
    }

    /**
     * create new bullets
     */
    public StandardShell makeBullets(float angleDegs, Vec2 playPos)
    {
    	float angleDeg = angleDegs;
        Vec2 pos = new Vec2(0, 0);
        pos.x = getNewImpulseVec(50, angleDeg).x - getNewImpulseVec(20, angleDeg).x;
        pos.y = getNewImpulseVec(50, angleDeg).y - getNewImpulseVec(20, angleDeg).y;

        standard = new StandardShell(this);
        standard.setPosition(playPos);
        standard.move(pos);
        standard.setLinearVelocity(getNewImpulseVec(700, angleDeg));
        standard.setAngleDegrees(angleDeg);        

        return standard;
    }

    /**
     * create new HD shells
     */
    public HighDShell makeHDBullets(float angleDegs, Vec2 playPos)
    {   
    	float angleDeg = angleDegs;
        Vec2 pos2 = new Vec2(0, 0);
        pos2.x = getNewImpulseVec(50, angleDeg).x - getNewImpulseVec(20, angleDeg).x;
        pos2.y = getNewImpulseVec(50, angleDeg).y - getNewImpulseVec(20, angleDeg).y;

        hd = new HighDShell(this);
        hd.setPosition(playPos);
        hd.move(pos2);
        hd.setLinearVelocity(getNewImpulseVec(700, angleDeg));
        hd.setAngleDegrees(angleDeg);

        return hd;   
    }

    /**
     * get shell to be deleted
     */
    public StandardShell getSS()
    {
        return standard;    
    }
    
    /** standard shell */
    public HighDShell getHD()
    {
    	return hd;
    }

    /**
     * get the x and y coords for the impulse vector
     */

    public Vec2 getNewImpulseVec(float impulse, float angleDeg)
    {
        float xFloat;
        double xDouble;
        float yFloat;
        double yDouble;

        /** 
         * 90 + for the correction of the direction, % 360 to get the angle when
         * the ship rotates more than once. player.getAngleDegrees() - 30 is to
         * compensate for the measure of the ships angle by the engine (because of
         * the irregular shape of the player body
         */
        double angle = 90 + (Math.toRadians((angleDeg - 30) % 360));
        Vec2 impulseVector = new Vec2(0, 0);

        /**
         * converting the double value to a float, as required by the Vec2
         */
        xDouble = Math.cos(angle);
        xFloat = (float) xDouble;
        impulseVector.x = xFloat;
        yDouble = Math.sin(angle);
        yFloat = (float) yDouble;
        impulseVector.y = yFloat;

        /**
         * getting the magnitute of the impulse vector (hypotenuse)
         */
        impulseVector.x = impulseVector.x * impulse;
        impulseVector.y = impulseVector.y * impulse;
        return impulseVector;
    }

    /**
     * set the impulse power
     */
    public void setImpulsePower(float impulsePower)
    {
        this.impulsePower = impulsePower;
    }
    
    /**
     * return the current impulse power 
     * @return impulsePower
     */
    public float getImpulsePower()
    {
    	return impulsePower;
    }
    
    /**
     * increase angular velocity
     */
    public void incAngularVelocity()
    {
    	this.angularVelocity = 5f; 
    }
    public void incAngularVelocity2() {
    	this.angularVelocity2 = 5f;
    }
    /**
     * decrease angular velocity
     */
    public void decAngularVelocity()
    {
    	this.angularVelocity = -5f;
    }
    public void decAngularVelocity2() {
    	this.angularVelocity2 = -5f;
    }
    /**
     * return the ships angular velocity 
     * (speed at which it rotates in radians per second)
     */
    public float getAngularVelocity()
    {
        return angularVelocity;    
    }  
    public float getAngularVelocity2() {
    	return angularVelocity2;
    }
    
    /**
     * @return isPaused
     */
    public boolean getPauseStatus()
    {
    	return isPaused;
    }
    
    /**
     * is the game paused?#
     * if no, pause game
     * else if yes, unpause game.
     */
    public void pauseGame()
    {
    	if (getPauseStatus() == false) {
        	world.pause();
        	isPaused = true;
        } else if (getPauseStatus() == true) {
        	world.unpause();
        	isPaused = false;
        }
    }
    
    /**
     * restart method
     */
    public void restartGame()
    {
    	getPlayer().setLinearVelocity(new Vec2(0,0));
    	if (levelCount == 1) {
    		loadLevel1();
    		currentLevel = new Tundra(this);
        	loadLevel2();
    		player.resetLives();
    	} else if (levelCount == 2) {
    		loadLevel1();
    		currentLevel = new Jungle(this);
        	loadLevel2();
    		player.resetLives();
    	} else if (levelCount == 3) {
    		loadLevel1();
    		currentLevel = new Quiet(this);
        	loadLevel2();
    		player.resetLives();
    	}
    }
    
    /**
     * is the game over?
     */
    public boolean isOver()
    {
        return isOver;
    }

    /**
     * end the game
     */
    public void gameOver()
    {
        world.pause();
        isOver = true;
        System.exit(0);
    }

    /** 
     * The world in which this game is played. 
     */
    public World getWorld()
    {
        return world;
    }

    /** The world view. */
    public WorldView getView()
    {
        return view;

    }
    
    /** The player. */
    public Player getPlayer()
    {
        return player;
    }
    
    /** get player 2 */
    public Player getPlayer2()
    {
    	return player2;
    }

    /** Play a game. */
    public static void main(String[] args) 
    {
        new Game();
    }
}

