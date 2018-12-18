package Model;

import View.Fishtank;

import java.util.ArrayList;
import java.util.Iterator;

public class Model
{
	// Frame (GUI) dimensions
	public int totalWidth = 1050;
	public int totalHeight = 680;
	// Parameters (GUI) dimensions
	public int paramsWidth = 150;

	// Parameters
	private int aquarium_width;
	private int aquarium_length;
	private int aquarium_depth;
	private String[] infoButtonStrings = {"Why are my fish dying?", "Algae Info", "Stress", "Lighting"};
	private String[] parameterStrings = {"Temp  ", "pH  ", "GH  ", "X  ", "Y  ", "Z  "};
	private String[] fishStrings = {"Red Crystal Shrimp", "Red Cherry Shrimp", "Pleco",
			"MoonFish", "Guppy", "FireNeon", "Endler", "Cardinal", "Beta", "Corydora", "GoldFish"};

	private ArrayList<String> fishNames = new ArrayList<String>();
	private ArrayList<Fish> fish = new ArrayList<Fish>();
	private ArrayList<Param> parameters = new ArrayList<Param>();
	private Fishtank tankPanel;

    public Model()
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

	public String[] getParameterStrings() { return parameterStrings; }
	public String[] getFishStrings() { return fishStrings; }
	public String[] getInfoButtonStrings() { return infoButtonStrings; }

	public void addFishByString(String FishName)
	{
		System.out.println(FishName);
		fish.add(new Fish(FishName));
		tankPanel.loadFish();
	}

	public void removeFishByString(String FishName)
	{
		System.out.println("Removing fish from model");

		Iterator<Fish> it = fish.iterator();
		while (it.hasNext()) {
			Fish f = it.next();
			if (f.getFishName().equals(FishName)) {
				it.remove();
			}
		}

		System.out.println("Removed fish");
		tankPanel.loadFish();
	}

	public ArrayList<Fish> getFish()
	{
    	return fish;
	}
	public void addTankPanel(Fishtank tankPanel) { this.tankPanel = tankPanel; }
	
	public void warn()
	{
		for (Fish f: this.fish)
		{
			checkWaterWarningsPerFish(f);
		}
		checkSocialWarnings();
	}
	
	private void checkWaterWarningsPerFish(Fish f)
	{
		for (Param p: this.parameters)
		{
			if (p.name.equals("Temp  ") && p.value != null )
			{
				if (p.value > f.getMaxTemp() || p.value < f.getMinTemp())
					System.out.println("WARNING for " + f.getFishName() + ": Temp is " + p.value +
							", but should be between " + f.getMinTemp() + " and " + f.getMaxTemp());
			}
			if (p.name.equals("pH  ") && p.value != null )
			{
				if (p.value > f.getMaxpH() || p.value < f.getMinpH())
					System.out.println("WARNING for " + f.getFishName() + ": pH is " + p.value +
							", but should be between " + f.getMinpH() + " and " + f.getMaxpH());
			}
		}
	}

	private void checkSocialWarnings()
	{
		System.out.println("To be Implemented");
		// for each fish, do
			// check compatibility with each other type of fish
			// check correct min/max group size of same type fish
	}
/*
	public boolean canAddFish(String FishName)
	{
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
*/
}