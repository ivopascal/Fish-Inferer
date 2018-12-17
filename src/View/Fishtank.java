import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

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
	private ArrayList<Fish_image> fishImages = new ArrayList();
	private ArrayList<Fish_area> fishAreas = new ArrayList();
	private fishRemover fishRemover;
	private JButton addFishButton;
	private JPanel addFishPanel;
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
		this.addFishButton = new JButton(buttonText);
		addFishButton.setPreferredSize(new Dimension(this.imageWidth, m.totalHeight/2 - this.imageHeight/2));
		addFishButton.addActionListener(new addFishAction(m, this));
		this.add(addFishButton);
		this.fishRemover = new fishRemover(fishAreas, this);
		setPreferredSize(size);
		
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
			fishImages.add(new Fish_image(fishNames.get(i),fishImage));
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

		fishAreas.clear();
		for(int i=0; i < fishImages.size(); i++){
			System.out.println("Drawing fish no " + i);
			double x = xStart + Math.random() * (tankImg.getWidth(this) - 70);//min + Math.random()  * (max-min)
			double y = yStart + Math.random() * (tankImg.getHeight(this) - 70);
			g.drawImage(fishImages.get(i).image, (int)x, (int)y, 70,70,  null);
			fishAreas.add(new Fish_area(fishImages.get(i).name, x, y, 70, 70));
		}
		fishRemover.update_fish(fishAreas);
	}

	public void removeFish(String name){
		m.removeFishByString(name);
	}

	public void setAddFishPanel(JPanel addFishPanel){
		addFishPanel.setPreferredSize(new Dimension(this.imageWidth, m.totalHeight/2 - this.imageHeight/2));
		this.remove(addFishButton);
		this.add(addFishPanel);
		this.addFishPanel = addFishPanel;
		validate();
		//fishRemover = new fishRemover(fishAreas, this);
	}
	public void setAddFishButton(){
		this.remove(addFishPanel);
		this.add(addFishButton);
		validate();
	}
}

class Fish_area{

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

class Fish_image{
	public String name;
	public Image image;

	public Fish_image(String name, Image image){
		this.name = name;
		this.image = image;
	} 
}

class fishRemover extends MouseInputAdapter implements MouseListener{

	private ArrayList<Fish_area> fishAreas;
	private Fishtank fishtank;
	public fishRemover(ArrayList<Fish_area> fishAreas, Fishtank fishtank){
		this.fishAreas = fishAreas;
		this.fishtank = fishtank;
		fishtank.addMouseMotionListener(this);
		fishtank.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e){
		System.out.println("Registering a click");
		if(e.getClickCount() == 2){
			System.out.println("Double click");
			for(Fish_area f : fishAreas){
				if(e.getX() >= f.x && e.getX() <= f.x + f.width
					&& e.getY() >= f.y && e.getY() <= f.y + f.height){
					System.out.println("Removing fish " + f.name);
					fishtank.removeFish(f.name);
				} 
			}


		}
	}
	
	public void update_fish(ArrayList<Fish_area> fishAreas){
		this.fishAreas = fishAreas;
	}

	public void mousePressed(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
    	}
    	public void mouseEntered(MouseEvent e){
    	}
	public void mouseReleased(MouseEvent e){
	}
	public void mouseDragged(MouseEvent e){
	}
}
