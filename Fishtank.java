import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fishtank extends JPanel
{
	private Model m;
	private Image img;
	private int imageWidth;
	private int imageHeight;

	Fishtank(Model m)
	{
		this.m = m;
		this.img = getImage();
		this.imageWidth = this.img.getWidth(null);
		this.imageHeight = this.img.getHeight(null);

		Dimension size = new Dimension(this.imageWidth, this.imageHeight);
		setPreferredSize(size);
		setLayout(null);
	}

	private Image getImage()
	{
		return new ImageIcon("img/fishtank.png").getImage();
	}

	public void paintComponent(Graphics g)
	{
		int xStart = m.totalWidth/2 - this.imageWidth/2 - m.paramsWidth;
		int yStart = m.totalHeight/2 - this.imageHeight/2;
		g.drawImage(img, xStart, yStart, null);
	}
}