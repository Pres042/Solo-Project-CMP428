import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Rect2 extends Rect {

	Rect resizer;
	private static final int ORIGINAL_SCREEN_WIDTH = 1920;
    private static final int ORIGINAL_SCREEN_HEIGHT = 1080;
    
    static int screenWidth;
	static int screenHeight; 
	
	static {
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = toolkit.getScreenSize();
	    screenWidth = screenSize.width;
	    screenHeight = screenSize.height;
	}
	double scaleX = (double) screenWidth / ORIGINAL_SCREEN_WIDTH;
	double scaleY = (double) screenHeight / ORIGINAL_SCREEN_HEIGHT;

	
	
	
	public Rect2 (int x, int y, int w, int h) {
		
		super(x,y,w,h);
		//This scales any rectangles made to fit the screen
		//If you don't want automatic scaling take this out and put the above variables
		//into the class you want scaling and call the scale method
		scale(scaleX, scaleY);
		
		resizer = new Rect(x+w-10, y+h-10, 10, 10);
		
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		resizer.draw(g);
	}
	
	public void moveBy(int dx, int dy) {
		super.moveBy(dx, dy);
		
		resizer.moveBy(dx, dy);
	}
	
	public void resizeBy(int dx, int dy) {
		super.resizeBy(dx, dy);
		
		resizer.moveBy(dx, dy);
	}
	
	public void scale(double scaleX, double scaleY) {
        x *= scaleX;
        y *= scaleY;
        w *= scaleX;
        h *= scaleY;
    }
	
}