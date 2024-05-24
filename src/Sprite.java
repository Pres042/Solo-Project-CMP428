import java.awt.Graphics;

//Using sprites from Kings and pigs


public abstract class Sprite extends Rect2{

	Animation[] animation;
	boolean facingLeft = false;
	boolean moving = false;
	
	int action =0;
	int defaultAction =0;
	public Sprite(String name, String[] pose, int x, int y, int w, int h, int[] count, int duration) {
        
		//x and y is his position
		//Modify their size here
        super(x, y, w, h);
        animation = new Animation[pose.length];
        
        
        // Initialize animations
        for (int i = 0; i < animation.length; i++) {
            animation[i] = new Animation(name + "_" + pose[i], count[i], duration);
        }
        
        // Set default action to the first animation
        defaultAction = 0;
    }
    
	public void setDefaultAction(int defaultAction) {
        this.defaultAction = defaultAction;
    }
	
	public void goLT(int dx) {
		 super.goLT(dx);
		 action = 2;
		 facingLeft = true;
	
		 moving = true;
	}
	public void goRT(int dx) {
		super.goRT(dx);
		action = 3;
		facingLeft = false;
		moving = true;
	}
	
	public void goUP(int dy) {
		super.goUP(dy);
		if(facingLeft) {
			action =4;
		}
		else {
			action = 5;
		}
		moving = true;
	}
	
	 public void still() {
	        //action = defaultAction; // Set action to defaultAction
	        
	        if(facingLeft) {
	        	action = 0;
	        }
	        else {
	        	action =1;
	        }
	        moving = false;
	    }
	 
	 public abstract void attack();
	 
	 public abstract void dead();
	 
	
	/*public void moveDN(int dy) {
		old_y = y;
		y += dy;
	}*/
	
	public void draw(Graphics g) {
		/*
		 * if(!moving ) { g.drawImage(animation[action].stillImage(), x, y, w, h, null);
		 * }
		 * 
		 * else { g.drawImage(animation[action].nextImage(), x, y, w, h, null); }
		 */
		
		g.drawImage(animation[action].nextImage(), x, y, w, h, null);
		g.drawRect(x,y,w,h);
	}
	
}
