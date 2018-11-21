import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class MainPanel extends JPanel
{
    public MainPanel(Model m)
    {
		//JPanel fishtank = getFishtank();
		//fishtank.setVisible(true);
		
	}
	
	

	/*private JPanel getFishtank()
	{
		JPanel fishtank = new JPanel();
		JLabel image  = new JLabel();
		image.setIcon(getImage());
		return fishtank;
	}
	* */
	
	@Override
	protected void paintComponent(Graphics g){
		g.drawImage(getImage(), 200,500, 400,400,null);
	}

	private BufferedImage getImage()
	{
		String filename = "fishtank.png";
		BufferedImage fishtank = null;
		try
		{
			File imgFile = new File(filename);
			fishtank = ImageIO.read(imgFile);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		return fishtank;
	}
}
