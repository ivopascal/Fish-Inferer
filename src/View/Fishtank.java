import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/*
	FishTank panel holds the picture of the aquarium, as well as the explanatoin text and the add fish button
*/

public class Fishtank extends JPanel
{
	private Model m;
	private Image tankImg;
	private String InfoText;
	private int imageWidth;
	private int imageHeight;
	private String buttonText;

	private ArrayList<String> fishNames;
	private ArrayList<Image> fishImages = new ArrayList();

	Fishtank(Model m)
	{

		this.setLayout(new FlowLayout());
                this.m = m;
		m.addTankPanel(this);
		this.tankImg = getTankImage();
		this.imageWidth = this.tankImg.getWidth(null);
		this.imageHeight = this.tankImg.getHeight(null);
		this.InfoText = "Here are some instructions and general info";
		Dimension size = new Dimension(this.imageWidth, this.imageHeight);

		loadFish();

		buttonText = "Add Fish";
		JButton addFishButton = new JButton(buttonText);
		addFishButton.setPreferredSize(new Dimension(this.imageWidth, m.totalHeight/2 - this.imageHeight/2));
		addFishButton.addActionListener(new addFishAction(m));
		this.add(addFishButton);

		setPreferredSize(size);
		//setLayout(null);
	}

	public void loadFish(){
		System.out.println("Panel requesting fishNames");
		fishNames = m.getAllFishByString();
		loadFishImages();
	}

	private Image getTankImage()
	{
		return new ImageIcon("img/fishtank.png").getImage();
	}

	private void loadFishImages(){
		fishImages = new ArrayList();
		for(int i=0; i < fishNames.size(); i++){
			System.out.println("Requesting: " + "img/"+fishNames.get(i)+".png");
			String fishAdres = "img/"+fishNames.get(i)+".png";
			Image fishImage = new ImageIcon(fishAdres).getImage();
			fishImages.add(fishImage);
		}
		System.out.println("Panel requesting fishImages");
		this.repaint();
	}

	public void paintComponent(Graphics g)
	{
		int xStart = m.totalWidth/2 - this.imageWidth/2 - m.paramsWidth;
		int yStart = m.totalHeight/2 - this.imageHeight/2;
		g.drawImage(tankImg, xStart, yStart, null);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		g.drawString(InfoText, xStart , tankImg.getHeight(this) + yStart+g.getFontMetrics().getHeight());

		for(int i=0; i < fishImages.size(); i++){
			System.out.println("Drawing fish no " + i);
			double x = xStart + Math.random() * (tankImg.getWidth(this) - 70);//min + Math.random()  * (max-min)
			double y = yStart + Math.random() * (tankImg.getHeight(this) - 70);
			g.drawImage(fishImages.get(i), (int)x, (int)y, 70,70,  null);
		}
	}
}
