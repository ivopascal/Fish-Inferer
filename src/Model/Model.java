import java.util.ArrayList;

import javax.swing.JPanel;

public class Model
{
	// Frame (GUI) dimensions
	int totalWidth = 1050;
	int totalHeight = 680;
	// Parameters (GUI) dimensions
	int paramsWidth = 150;

	// Parameters
	private int aquarium_width;
	private int aquarium_length;

	private ArrayList<String> fishNames = new ArrayList();
	private Fishtank tankPanel;

    Model()
    {
	}
	
	public void set_aquarium_width(int width){
		this.aquarium_width = width;
	}

	public void set_aquarium_length(int length){
		this.aquarium_length = length;
	}
	
	public int get_aquarium_width(){
		return aquarium_width;
	}
	public int get_aquarium_length(){
		return aquarium_length;
	}

	public void addFishByString(String FishName){
		System.out.println(FishName);
		fishNames.add(FishName);
		tankPanel.loadFish();
	}

	public ArrayList<String> getAllFishByString(){
		return fishNames;
	}

	public void addTankPanel(Fishtank tankPanel){
		this.tankPanel = tankPanel;
	}
}
