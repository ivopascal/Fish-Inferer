
import javax.swing.JPanel;

public class MainPanel extends JPanel
{
    public MainPanel(Model m)
    {
		JPanel fishtank = getFishtank();
		fishtank.setVisible(true);
	}

	private JPanel getFishtank()
	{
		JPanel fishtank = new JPanel();
		JLabel image  = new JLabel();
		image.setIcon(getImage());
		return fishtank;
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
