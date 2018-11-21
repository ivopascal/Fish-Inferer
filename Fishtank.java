import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Fishtank extends JPanel
{
	private Image img;

	public Fishtank()
	{
		this.img = new ImageIcon("img/fishtank.png").getImage();
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(img, 50, 50, null);
	}
}