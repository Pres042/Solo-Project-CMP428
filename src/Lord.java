import java.awt.Color;
import java.awt.Graphics;

public class Lord extends Sprite {

	public static String[] pose = {
			"Idle_lt", "Idle_rt", 
			"Run_lt", "Run_rt",
			"Jump_lt", "Jump_rt",
			"Attack_lt","Attack_rt",
			"Dead_lt", "Dead_rt"
			};
	//Number of frames associated with each animation 
	public static int[] count = {
			11, 11, 8, 8, 1, 1, 3, 3, 4,4
	};
	
	
	private int health;
    private int maxHealth;
    
    
    
    
    AudioPlayer slash;
	
	public Lord(int x, int y, int w, int h) {
		super("L", pose, x, y, w, h, count,6);
		setDefaultAction(0);
		this.maxHealth = 100;
        this.health = this.maxHealth;
        slash = new AudioPlayer();
        slash.load("slash2.wav");
        
       
	}
	
	public void attack() {
		 if (!moving) { // Only allow attacking when not moving
			 if (facingLeft) {
				 action = 6; // Index of "Attack_lt" in the pose array
				 } 
			 else {
				 action = 7; // Index of "Attack_rt" in the pose array
				 }
			 }
		 slash.play();
		
	    }
	
	public void dead() {
		if(facingLeft) {
			action = 8;
		}
		else {
			action = 9;
		}
		
		
	}

	//Some code was used from the group project
	public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
  

    public void heal(int amount) {
        this.health += amount;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
    
    public int getHealth() {
        return this.health;
    }
    private void drawHealthBar(Graphics g) {
        int barWidth = 200;
        int barHeight = 15;
        int barX = 50;
        int barY = 50 - barHeight; // Position the bar above the character

        g.setColor(Color.RED);
        g.fillRect(barX, barY, barWidth, barHeight);
        g.setColor(Color.GREEN);
        g.fillRect(barX, barY, (int) ((barWidth * health) / (double) maxHealth), barHeight);
        g.setColor(Color.BLACK);
        g.drawRect(barX, barY, barWidth, barHeight);
    }
    public void draw(Graphics g) {
        super.draw(g);
        drawHealthBar(g);
    }
	
}
