import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class KnightGame extends GameBase
{
	
	private AudioPlayer bgMusic;
	Room1 room1 = new Room1(pressing);
	Room2 room2 = new Room2(pressing);

	
	public void init()
	{
		//Sound from Zapsplat.com		
		super.init();
		
		
		Room.room[0] = Room.room[1];
		bgMusic = new AudioPlayer();
	    bgMusic.load("8-bit.wav");
	    bgMusic.loop(); 
		
	}
	
	public void inGameLoop()
	{
		//lord.physicsOff();
		
		
		
		Room.inGameLoopStatic();	
	}
	
	
	
	public void paint(Graphics pen)
	{
		Room.paintStatic(pen);		
	}


	

	

	
}