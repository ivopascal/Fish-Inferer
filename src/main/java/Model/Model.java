package Model;

import View.Fishtank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Model {
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

	private ArrayList<Fish> fish = new ArrayList<Fish>();
	private ArrayList<Param> parameters = new ArrayList<Param>();
	private Fishtank tankPanel;

	public Model() {
		makeParameters();
	}

	private void makeParameters() {
		for (String parameterString : this.parameterStrings) {
			Param p = new Param(parameterString, null);
			this.parameters.add(p);
		}
	}

	public void updateParameter(String paramName, Float newValue) {
		for (Param p : this.parameters) {
			if (p.name.equals(paramName)) {
				p.value = newValue;
				System.out.println("Name: " + p.name + " - New Value: " + p.value);
			}
		}
	}

	public String[] getParameterStrings() {
		return parameterStrings;
	}

	public String[] getFishStrings() {
		return fishStrings;
	}

	public String[] getInfoButtonStrings() {
		return infoButtonStrings;
	}

	public void addFishByString(String FishName) {
		System.out.println(FishName);
		fish.add(new Fish(FishName));
		tankPanel.loadFish();
	}

	public void removeFishByString(String FishName) {
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

	public ArrayList<Fish> getFish() {
		return fish;
	}

	public void addTankPanel(Fishtank tankPanel) {
		this.tankPanel = tankPanel;
	}

	public void warn() {
		checkWaterWarnings();
		checkSocialWarnings();
	}

	private void checkWaterWarnings() {
		Set checkDuplicates = new HashSet();
		// for each fish
		for (Fish f : fish) {
			if (checkDuplicates.add(f) == true) {
				// for each parameter
				for (Param p : this.parameters) {
					// check if the parameter value is within the limits of the requirements for the fish
					if (p.name.equals("Temp  ") && p.value != null) {
						if (p.value > f.getMaxTemp() || p.value < f.getMinTemp())
							System.out.println("WARNING for " + f.getFishName() + ": Temp is " + p.value +
									", but should be between " + f.getMinTemp() + " and " + f.getMaxTemp());
					}
					if (p.name.equals("pH  ") && p.value != null) {
						if (p.value > f.getMaxpH() || p.value < f.getMinpH())
							System.out.println("WARNING for " + f.getFishName() + ": pH is " + p.value +
									", but should be between " + f.getMinpH() + " and " + f.getMaxpH());
					}
				}
			}
		}
	}

	private void checkSocialWarnings() {
		// a set does not allow duplicates. if it is possible to add X to it, then X is new to it
		Set checkDuplicates1 = new HashSet();
		Set checkDuplicates2 = new HashSet();
		int fishCount = 0;

		// for each (unique) fish
		for (Fish f : fish) {
			if (checkDuplicates1.add(f) == true) {
				fishCount++;
				for (Fish f2 : fish) {
					if (checkDuplicates2.add(f2) == true) {
						// if there is another fish that could eat this fish, print a warning
						if (f.getPredators().contains(f2.getFishName())) {
							System.out.println("The " + f2.getFishName() + " will eat the " + f.getFishName() + "!");
						}
					} else {
						fishCount++;
					}
				}
				// if there are too many, or not enough of this fish, print a warning
				if (fishCount > f.getMaxGroupSize() || fishCount < f.getMinGroupSize()) {
					System.out.println("There are currently " + fishCount + " " + f.getFishName() + "'s, but they need " +
							"to be in a group of at least " + f.getMinGroupSize() + " and at most " + f.getMaxGroupSize());
				}
				fishCount = 0;
			}
		}
	}
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