import java.awt.Graphics;

public class Room2 extends Room
{
	ImageLayer h = new ImageLayer("S3.png", 0, 0, 1);
	
	
	
	public Room2(boolean[] pressing)
	{
		super(pressing, "grassfield1.png");
	}
	
	Rect2 floor = new Rect2(0,900,1900,15);
	Rect2[] wall = {
			new Rect2(1900, 60, 20, 1200)
	};
	Rect2[] platform = {
			new Rect2(275, 780, 200, 25),
			new Rect2(875, 780, 200, 25),
			new Rect2(1700, 450, 200, 25),
			new Rect2(1700, 590, 200, 25),
			new Rect2(1700, 740, 200, 25),
			new Rect2(875, 250, 775, 25),
			new Rect2(0, 250, 725, 25),
	};
	
	Pig[] pig = {
			new Pig(875,250),
			new Pig(300, 200),
	};
	
	Boolean move = true;
	
	
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
		
		lord.move();
		pig[0].move();
		pig[1].move();
		
		if((lord.moving && lord.x >1000) || pig[0].moving) {
			pig[0].moving = true;
			pig[0].chase(lord, 3);
		}
		
		
		if(pig[1].x == platform[6].x +platform[6].h && !pig[1].facingLeft) {
			pig[1].goLT(5);

		}
		else if(pig[1].x == platform[6].x && pig[1].facingLeft) {
			pig[1].goRT(5);
		}
		
		if (lord.overlaps(pig[0])) {
	        lord.takeDamage(1); 
	    }
		
		if (lord.overlaps(pig[1])){
			lord.takeDamage(1);
		}
	
		
		
		

		//handles moving to other rooms
		if(lord.x < -10)
		{
			Room.room[0] = Room.room[1];	
			lord.x = 1350;
		}
		
		if (lord.overlaps(floor))	{
			lord.pushedOutOf(floor);
			lCanJump = true;
		}
		
		if (pig[0].overlaps(floor))	{
			pig[0].pushedOutOf(floor);
		}
		
		if (pig[1].overlaps(floor))	{
			pig[1].pushedOutOf(floor);
		}
		
		//Right Most wall
		for(int i =0; i < wall.length; i++) {
			if (lord.overlaps(wall[i])) {
				lord.pushedOutOf(wall[i]);
			}
			
			if (pig[0].overlaps(wall[i])) {
				pig[0].pushedOutOf(wall[i]);
			}
			
			if (pig[1].overlaps(wall[i])) {
				pig[1].pushedOutOf(wall[i]);
			}
		}
		
		
		//platforms
		for (int i=0; i<platform.length; i++) {
			if (lord.overlaps(platform[i])){
				if (lord.cameFromAbove(platform[i])) {
					lord.pushbackUpFrom(platform[i]);
					lord.vx = 0;
					lCanJump = true;
				}
			
			}
			if (pig[0].overlaps(platform[i])){
				if (pig[0].cameFromAbove(platform[i])) {
					pig[0].pushbackUpFrom(platform[i]);
					pig[0].vx = 0;
				}
			}
			if (pig[1].overlaps(platform[i])){
				if (pig[1].cameFromAbove(platform[i])) {
					pig[1].pushbackUpFrom(platform[i]);
					pig[1].vx = 0;
					}
				}
			}
		
		
		
		
				
	}
	
	public void paint(Graphics pen)
	{
		h.draw(pen);
		
		lord.draw(pen);
		pig[0].draw(pen);
		pig[1].draw(pen);
		floor.draw(pen);
		for(int i = 0; i< wall.length; i++) {
			wall[i].draw(pen);
		}
		for(int i = 0; i< platform.length; i++) {
			platform[i].draw(pen);
		}
		
	}

}