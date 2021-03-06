package View;


import Model.Model;
import Model.Fish;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

/*
	FishTank panel holds the picture of the aquarium, as well as the explanation text and the add fish button
*/

public class Fishtank extends JPanel
{
	private Model m;
	private Image tankImg;

	private int imageWidth;
	private int imageHeight;

	private ArrayList<Fish> fish;
	private ArrayList<Fish_image> fishImages = new ArrayList<Fish_image>();
	private ArrayList<Fish_area> fishAreas = new ArrayList<Fish_area>();

	private fishRemover fishRemover;

	

	Fishtank(Model m)
	{

		this.setLayout(new FlowLayout());
		this.m = m;
		this.m.addTankPanel(this);
		this.tankImg = getTankImage();
		this.imageWidth = this.tankImg.getWidth(null);
		this.imageHeight = this.tankImg.getHeight(null);
		
		Dimension size = new Dimension(this.imageWidth, this.imageHeight);

		loadFish();

		
		this.fishRemover = new fishRemover(fishAreas, this);
		setPreferredSize(size);
		
	}

	public void loadFish()
	{
		fish = m.getFish();
		loadFishImages();
	}

	private Image getTankImage()
	{
        URL url = getClass().getResource("/img/fishtank.png");
		return new ImageIcon(url).getImage();
	}

	private void loadFishImages()
	{
		fishImages = new ArrayList<Fish_image>();
		for (Fish f : fish)
		{
			URL fishAddress = getClass().getResource("/img/" + f.getFishName() + ".png");
			Image fishImage = new ImageIcon(fishAddress).getImage();
			fishImages.add(new Fish_image(f.getFishName(), fishImage));
		}
		this.repaint();
	}

	public void paintComponent(Graphics g)
	{
		int xStart = 0;
		int yStart = 0;
		g.drawImage(tankImg, xStart, yStart, null);
		fishAreas.clear();
		for (int i = 0; i < fishImages.size(); i++)
		{
			// Random num between min and max: min + Math.random()  * (max-min)
			double x = xStart + Math.random() * (tankImg.getWidth(this) - 70);
			double y = yStart + Math.random() * (tankImg.getHeight(this) - 70);
			g.drawImage(fishImages.get(i).image, (int)x, (int)y, 70,70,  null);
			fishAreas.add(new Fish_area(fishImages.get(i).name, x, y, 70, 70));
		}
		fishRemover.update_fish(fishAreas);
	}

	void removeFish(String name)
	{
		m.removeFishByString(name);
	}
}

class Fish_area
{
	public String name;
	public double x,y,width,height;

	public Fish_area(String name, double x, double y, double width, double height){
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class Fish_image
{
	public String name;
	public Image image;

	public Fish_image(String name, Image image)
	{
		this.name = name;
		this.image = image;
	} 
}

class fishRemover extends MouseInputAdapter implements MouseListener
{
	public ArrayList<Fish_area> fishAreas;
	public Fishtank fishtank;

	public fishRemover(ArrayList<Fish_area> fishAreas, Fishtank fishtank)
	{
		this.fishAreas = fishAreas;
		this.fishtank = fishtank;
		fishtank.addMouseMotionListener(this);
		fishtank.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getClickCount() == 2)
		{
			// double click registered
			for (Fish_area f : fishAreas)
			{
				if (e.getX() >= f.x && e.getX() <= f.x + f.width
						&& e.getY() >= f.y && e.getY() <= f.y + f.height)
				{
					// remove fish
					fishtank.removeFish(f.name);
				}
			}
		}
	}
	
	public void update_fish(ArrayList<Fish_area> fishAreas){
		this.fishAreas = fishAreas;
	}

	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
}
