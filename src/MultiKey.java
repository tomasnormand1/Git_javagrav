import java.util.ArrayList;
import java.awt.event.*;

import org.jbox2d.common.Vec2;

import city.soi.platform.*;

public class MultiKey { //implements KeyListener{

	// arraylist for storing all the keys pressed
	private ArrayList<Integer> keys;
	
	// the game in which the key presses apply
	private Game game;
	
	// the int code of the button press
	private int code;
	
	// different possible keys
	private boolean spaceKey;
	private boolean spaceKey2;
	
	// arena level
	private Arena arena;
	
	/**
	 * this class allows for multiple keys to be pressed at the same time and both be doing
	 * something rather than one key being pressed then when another is pressed, the action
	 * of the first key is cancelled.	
	 * @param game
	 */
	public MultiKey(Game game) {
		keys = new ArrayList<Integer>();
		this.game = game;
		spaceKey = false;
		spaceKey2 = false;
	}
	

	/**
	 * add the keycode from the game class when pressd, into the arraylist
	 * @param code
	 */
	public void addKey(int code) {
		keys.add(code);
		this.code = code;
	}
	
	/**
	 * iterate over the arraylist to check whether the element at any index is eqal to the key code 
	 * then remove that element. the keycode is taken from the game class when key relseased method is called
	 * @param code
	 */
	public void removeKey(int code) {
		for(int i = 0; i<getKeyList().size(); i++) {
			if(getKeyList().get(i).intValue() == code) {
				keys.remove(i);
			}
		}
	}
	
	/**
	 * this method returns the arraylist
	 * @return keys
	 */
	public ArrayList<Integer> getKeyList() {
		return keys;
	}
	
	/**
	 * this method returns the key code of the keys that are pressed
	 * @return code and code2
	 */
	public int getKeyInt() {
		return code;
	}
	
	/**
	 * pulls the trigger of the ship (for both players 1 and 2
	 * @param angleDeg
	 * @param playerPos
	 * @param shellSig
	 */
	public void pullTrigger(float angleDeg, Vec2 playerPos, int shellSig) {
		if(shellSig == 1) {
			game.makeBullets(angleDeg, playerPos);
		} else if(shellSig == 2) {
			game.makeHDBullets(angleDeg, playerPos);
		}
	}
	public boolean getSKey() {
		return spaceKey;
	}
	public void setSKey(boolean set) {
		spaceKey = set;
	}
	public boolean getSKey2() {
		return spaceKey2;
	}
	public void setSKey2(boolean set) {
		spaceKey2 = set;
	}

	
	/**
	 * key event firing -
	 * fire a specific key event depending on which key code is currently in the arraylist
	 */
	public void keyFire() {
		for(int i = 0; i<getKeyList().size(); i++) {
			if(getKeyList().get(i).intValue() == KeyEvent.VK_UP) {
					game.getPlayer().setLinearVelocity(game.getNewImpulseVec(game.getImpulsePower(), game.getPlayer().getAngleDegrees()));
					game.getPlayer().setImage(new BodyImage("src/resources/8bitshipfinalST.png"));								
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_LEFT) {
					game.incAngularVelocity();
					game.getPlayer().setAngularVelocity(game.getAngularVelocity());
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_RIGHT) {
					game.decAngularVelocity();
					game.getPlayer().setAngularVelocity(game.getAngularVelocity());				
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_M) {
				if(game.getShellSig() == 1) {
					game.setShellSig(2);
				} else if (game.getShellSig() == 2) {
					game.setShellSig(1);
				}
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_SPACE) {
				spaceKey = true;
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_T) {
				game.getPlayer2().setLinearVelocity(game.getNewImpulseVec(game.getImpulsePower(), game.getPlayer2().getAngleDegrees()));
				game.getPlayer2().setImage(new BodyImage("src/resources/8bitshipfinalST2.png"));
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_F) {
				game.incAngularVelocity2();
				game.getPlayer2().setAngularVelocity(game.getAngularVelocity2());
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_H) {
				game.decAngularVelocity2();
				game.getPlayer2().setAngularVelocity(game.getAngularVelocity2());				
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_W) {
				spaceKey2 = true;
			} else if (getKeyList().get(i).intValue() == KeyEvent.VK_Q) {
				if(game.getShellSig2() == 1) {
					game.setShellSig2(2);
				} else if (game.getShellSig2() == 2) {
					game.setShellSig2(1);
				}
			}
		}
	}
}
