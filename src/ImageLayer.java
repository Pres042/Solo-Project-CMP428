import java.awt.*;

public class ImageLayer
{
	public Image image;

	int x;
	int y;
	
	int z;
	public static int screenWidth;
    public static int screenHeight;

    static {
        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Get the screen size
        Dimension screenSize = toolkit.getScreenSize();

        // Set the screen width and height
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
    }

	
	
	public ImageLayer(String filename, int x, int y, int z)
	{
		image = Toolkit.getDefaultToolkit().getImage(filename);
	
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	public void draw(Graphics pen)
	{
		for(int i = 0; i < 10; i++)
		
			pen.drawImage(image, x + i * screenWidth - Camera.x / z, y - Camera.y / z, screenWidth, screenHeight-75, null);
	}
	

}
