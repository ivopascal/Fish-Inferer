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

	public void removeFishByString(String FishName){
		System.out.println("Removing fish from model");

		//Remove fish from fishNames
		fishNames.remove(FishName);
		//Remove fish from mrBubbles
		for(Fish f : mrBubbles){
			if(f.fishName == FishName){
				
				mrBubbles.remove(f);
			}
		}
		System.out.println("Removed fish");
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

	public boolean canAddFish(String FishName){
		Fish compfish = new Fish(FishName);
		System.out.println("Number of fish: " + mrBubbles.size());
		
		for(Fish f: mrBubbles){
			if(     compfish.getMinTemp() >= f.getMaxTemp()){
				System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers colder water.");
				return false;
			}
			if(	compfish.getMaxTemp() <= f.getMinTemp()){
				System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers warmer water.");
                                return false;

			}
			if(	compfish.getMinpH() >= f.getMaxpH()){
				System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers lower pH.");
                                return false;

			}
			if(	compfish.getMaxpH() <= f.getMinpH()){
				System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers higher pH.");
				return false;
			}
		}
		return true;
	}

	public String canAddFishProblems(String FishName){
                Fish compfish = new Fish(FishName);
                System.out.println("Number of fish: " + mrBubbles.size());

		String output = "";
                for(Fish f: mrBubbles){
                        if(     compfish.getMinTemp() >= f.getMaxTemp()){
                                System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers colder water.");
                                output = output + "Can't add " + FishName + " because " + f.fishName + " prefers colder water." + "\n";
                        }
                        if(     compfish.getMaxTemp() <= f.getMinTemp()){
                                System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers warmer water.");
				output = output + "Can't add " + FishName + " because " + f.fishName + " prefers warmer water." + "\n";
                        }
                        if(     compfish.getMinpH() >= f.getMaxpH()){
                                System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers lower pH.");
				output = output + "Can't add " + FishName + " because " + f.fishName + " prefers lower pH." + "\n";
                        }
                        if(     compfish.getMaxpH() <= f.getMinpH()){
                                System.out.println("Can't add " + FishName + " because " + f.fishName + " prefers higher pH.");
				output = output + "Can't add " + FishName + " because " + f.fishName + " prefers lower pH." + "\n";
                        }
                }
                return output;
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
