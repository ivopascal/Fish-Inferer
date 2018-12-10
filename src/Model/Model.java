import java.awt.geom.FlatteningPathIterator;
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
	private String[] parameterStrings = {"Temp  ", "pH  ", "GH  ", "X  ", "Y  ", "Z  "};

	private ArrayList<String> fishNames = new ArrayList<>();
	private ArrayList<Param> parameters = new ArrayList<>();
	private Fishtank tankPanel;
	
	///ADDED
	private ArrayList<Fish> mrBubbles = new ArrayList<>();
	
    Model()
    {
    	makeParameters();
	}

	private void makeParameters()
	{
		for (String parameterString : this.parameterStrings)
		{
			Param p = new Param(parameterString,null);
			this.parameters.add(p);
		}
	}

	public void updateParameter(String paramName, Float newValue)
	{
		for (Param p : this.parameters)
		{
			if (p.name.equals(paramName))
			{
				p.value = newValue;
				System.out.println("Name: " + p.name + " - New Value: " + p.value);
			}
		}
		
	}

	public String[] getParameterStrings()
	{
		return parameterStrings;
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
		
		///ADDED
		Fish dory= new Fish(FishName);
		///ADDED
		this.mrBubbles.add(dory);
		
		tankPanel.loadFish();
		
	}

	public ArrayList<String> getAllFishByString(){
		return fishNames;
	}

	public void addTankPanel(Fishtank tankPanel){
		this.tankPanel = tankPanel;
	}
	
	///ADDED
	public void warn() {
		for (String s: this.fishNames) {
			checkWarnings(s);
		}
	}
	
	public void checkWarnings(String FishName) {
		
		///ADDED
		double aquariumTemp=1000, aquariumpH=1000;
		
		for (Param p: this.parameters) {
			
			if(p.name.equals("Temp  ") && p.value !=null)  {
				aquariumTemp=p.value;
				
			}
			if(p.name.equals("pH  ") && p.value !=null) {
				aquariumpH=p.value;
			}
		}
		if (aquariumTemp!=1000 && aquariumpH !=1000) {
			for (Fish dory : this.mrBubbles) {
				if(dory.getFishName()==FishName) {
					dory.fishWarning(FishName, aquariumTemp, aquariumpH);
				}
			}
		}
		
	}
}

class Param
{
	public String name;
	public Float value;

	public Param(String name, Float value)
	{
		this.name = name;
		this.value = value;
	}
}
