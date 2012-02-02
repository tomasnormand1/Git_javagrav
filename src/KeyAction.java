import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class KeyAction extends Thread {

	private Timer timer;
	private final MultiKey multiKey;
	
	public KeyAction(int interval, MultiKey multiKeys) {
		this.multiKey = multiKeys;
		
        this.timer = new Timer(interval, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if(multiKey.isPressed(KeyEvent.VK_UP)) {
	    		//	System.out.println("up pressed");
				//}
				
			}
        });
	}
}
