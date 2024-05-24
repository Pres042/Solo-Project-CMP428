import java.awt.Graphics;

public class Room1 extends Room
{
	
	//Lord lord = new Lord(100,100);
	
	public Room1(boolean[] pressing)
	{
		super(pressing, "S2.png");
			
	}
	
	Rect2 floor = new Rect2(0,900,1900,15);
	
	//gotta change the jump logic
	Pig pig = new Pig(600, 800);
	
	public void inGameLoop()
	{
		if (lord.getHealth()> 0) {
			if(pressing[UP] && lCanJump) {
				lord.goUP(15); lCanJump = false;
			}
			else if(pressing[DN]) lord.goDN(5);
	
			else if(pressing[LT]) lord.goLT(5);
			else if(pressing[RT]) lord.goRT(5);
			
			else lord.still();
			
			if (pressing[SPACE] && !lord.moving) {
	            lord.attack(); // Trigger attack animation
	            
	        }
		}
		else {
			lord.dead();
		}
		
		// This is to restart
		if(pressing[_R]) {
			lord.x =0; lord.y = 0;
			lord.heal(100);
			Room.room[0] = Room.room[1];
		}
		
		
		//lord.physicsOff();								
				
		lord.move();
		pig.move();
		
		if (lord.moving|| pig.moving) {
			pig.moving = true;
			pig.chase(lord, 2);
		}
		
		if (lord.overlaps(pig)) {
	        lord.takeDamage(1);
	    }
	
		
		if(lord.x > 1350)
		{
			Room.room[0] = Room.room[2];
			
			lord.x = 10;
		}
		
		if (lord.overlaps(floor))	{
			lord.pushedOutOf(floor);
			lCanJump = true;
		}
		
		if(pig.overlaps(floor)) {
			pig.pushedOutOf(floor);
		}
				
		
		
		
	}
	
	
	
	public void paint(Graphics pen)
	{
		
		/*
		 * background.draw(backBufferGraphics); lord.draw(backBufferGraphics);
		 * pig.draw(backBufferGraphics); floor.draw(backBufferGraphics);
		 */
	    // Copy the back buffer to the screen
	    pen.drawImage(backBuffer, 0, 0, null);
		
		
		background.draw(pen); lord.draw(pen); pig.draw(pen); floor.draw(pen);
		 
		
		
		//pen.setClip(_X, _Y, screenWidth, screenHeight);
	}

}