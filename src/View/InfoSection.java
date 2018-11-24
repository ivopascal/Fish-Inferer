import javax.swing.*;
import java.awt.*;

class InfoSection extends JPanel
{
	private String infoText;

	InfoSection(Model m)
	{
		this.infoText = "Here are some instructions and general info";
	}

	public void paintComponent(Graphics g)
	{
		g.drawString(this.infoText, 200, 10);
	}
}
