
public class Pig extends Sprite {
	
	public static String[] pose = {
			"Idle_lt", "Idle_rt", 
			"Run_lt", "Run_rt",
			"Jump_lt", "Jump_rt",
			"Attack_lt","Attack_rt",
			"Dead_lt", "Dead_rt"
			};
	
	public static int[] count = {
			11, 11, 6, 6, 2, 2, 5, 5, 4, 4 
		
	};

	public Pig(int x, int y) {
		super("P", pose, x, y, 50, 50, count, 8);
		
		
	}

	@Override
	public void attack() {
		if (facingLeft) {
			action = 6; // Index of "Attack_lt" in the pose array
			} 
		else {
			 action = 7; // Index of "Attack_rt" in the pose array
		}
	}
		

	@Override
	public void dead() {
		if(facingLeft) {
			action = 8;
		}
		else {
			action = 9;
		}
		
	}
	
	@Override
	public void chase(Rect r,int dx) {
	
		if (isLeftOf(r)) goRT(dx);
		if (isRightOf(r)) goLT(dx);
	    if (isBelow(r)) {
	    	goUP(dx*2);
	        jump();
	    }
		
	}
	public void jump() {
        if (vy == 0) { 
            vy = -20; 
        }
    }

}
