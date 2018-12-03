import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
	FishTank panel holds the picture of the aquarium, as well as the explanatoin text and the add fish button
*/

public class Fishtank extends JPanel
{
	private Model m;
	private Image img;
	private String InfoText;
	private int imageWidth;
	private int imageHeight;
	private String buttonText;

	Fishtank(Model m)
	{
		
		this.setLayout(new FlowLayout());
                this.m = m;
		this.img = getImage();
		this.imageWidth = this.img.getWidth(null);
		this.imageHeight = this.img.getHeight(null);
		this.InfoText = "Here are some instructions and general info";
		Dimension size = new Dimension(this.imageWidth, this.imageHeight);

		buttonText = "Add Fish";
		JButton addFishButton = new JButton(buttonText);
		addFishButton.setPreferredSize(new Dimension(this.imageWidth, m.totalHeight/2 - this.imageHeight/2));
		addFishButton.addActionListener(new addFishAction(m));
		this.add(addFishButton);

		setPreferredSize(size);
		//setLayout(null);
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
		g.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		g.drawString(InfoText, xStart , img.getHeight(this) + yStart+g.getFontMetrics().getHeight());
	}
}
