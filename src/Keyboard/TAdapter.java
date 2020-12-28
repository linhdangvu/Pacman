package Keyboard;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



import Main.Content;

public class TAdapter extends KeyAdapter {
	
	
	private Content content;
	
	public TAdapter (Content content) {
		this.content = content;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	System.out.println("left");
	content.moveleft();
	    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	System.out.println("right");
	    	content.moveright();
	    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	System.out.println("up");
		       content.moveup();
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	System.out.println("down");
	    	content.movedown();
	    } else {
	    	System.out.println("stay");
	    	
	    }
	   // content.repaint();
	}
	
	
			    

}