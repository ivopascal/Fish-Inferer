package Model;

import View.Fishtank;

import java.util.*;

public class Model {
	// Frame (GUI) dimensions
	public int totalWidth = 1050;
	public int totalHeight = 680;
	// Parameters (GUI) dimensions
	public int paramsWidth = 150;

	// Parameters
	public int aquarium_volume = 0;
	private String[] infoButtonStrings = {"Info", "Algae Info", "Stress", "Lighting", "Cleaning"};
	private String[] parameterStrings = {"Temp  ", "pH  ", "Nitrite  ", "Nitrate  ", "Chlorine  ", "Volume  "};
	private String[] fishStrings = {"Red Crystal Shrimp", "Red Cherry Shrimp", "Pleco",
			"Moon fish", "Platy", "Guppy (M)", "Guppy (F)" , "Fire neon", "Endler",
			"Cardinal", "Betta (M)", "Betta (F)" , "Corydora", "Goldfish", "Molly"};

	private ArrayList<Fish> fish = new ArrayList<Fish>();
	private ArrayList<Param> parameters = new ArrayList<Param>();
	private Fishtank tankPanel;
	
	public String temp_unit = "C";
	public String vol_unit = "L";

	public Output printer = new Output(this);

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
				if(paramName == "Temp  " && temp_unit == "F"){
					p.value = (newValue - 32) * 5 / 9; //adjust for fahrenheit
					System.out.println("Temp set to " + p.value);
				}else if(paramName == "Volume  " && vol_unit == "G"){
					p.value = newValue * (float) 3.78541178; //adjust for gallons
					System.out.println("Vol set to " + p.value);
				}else{
					p.value = newValue;
				}
			}
		}
	}

	public void removeParameter(String paramName)
	{
		for (Param p : this.parameters)
		{
			if (p.name.equals(paramName))
			{
				p.value = null;
			}
		}
	}

	public void clearParameters(){
		for(Param p : this.parameters){
			p.value = null;
		}
		aquarium_volume = 0;
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
		fish.add(new Fish(FishName));
		tankPanel.loadFish();
	}

	public void removeFishByString(String FishName) {
		Iterator<Fish> it = fish.iterator();
		while (it.hasNext()) {
			Fish f = it.next();
			if(FishName == "All"){
					it.remove();
					tankPanel.loadFish();
			}else if (f.getFishName().equals(FishName)) {
				it.remove();
				tankPanel.loadFish();
				return;
			}
		}
	}

	public ArrayList<Fish> getFish() {
		return fish;
	}

	public void addTankPanel(Fishtank tankPanel) {
		this.tankPanel = tankPanel;
	}

	public void warn() {
		printer.resetWarnings();
		checkWaterWarnings();
		checkSocialWarnings();
		deriveConclusion();
		printer.printWarnings();
	}

	private void checkWaterWarnings() {
		// first check general water warnings, regardless of fish, then fish specific water warnings
		checkGeneralWaterWarnings();

		// a set does not allow duplicates. if it is possible to add X to it, then X is new to it
		Set checkDuplicates = new HashSet<Fish>();
		// for each fishtype
		for (Fish f : fish) {
			if (checkDuplicates.add(f)) {
				// for each parameter
				for (Param p : this.parameters) {
					// check if the parameter value is within the limits of the requirements for the fish
					if (p.name.equals("Temp  ") && p.value != null) {
						if (p.value > f.getMaxTemp() || p.value < f.getMinTemp())
							printer.addWaterWarning("TEMP", f, p.value);
					}
					if (p.name.equals("pH  ") && p.value != null) {
						if (p.value > f.getMaxpH() || p.value < f.getMinpH())
							printer.addWaterWarning("PH", f, p.value);
					}
				}
			}
		}
	}

	private void checkGeneralWaterWarnings()
	{
		for (Param p : this.parameters)
		{
			// the following all general requirements across all fish
			if (p.name.equals("Nitrite  ") && p.value != null) {
				if(p.value > 10){
					printer.addGeneralWaterWarning("NITRITE", p.value, 10);
				}
			}
			if(p.name.equals("Nitrate  ") && p.value != null){
				if(p.value > 50){
					printer.addGeneralWaterWarning("NITRATE", p.value, 50);
				}
			}
			if(p.name.equals("Chlorine  ") && p.value != null){
				if(p.value > .2){
					printer.addGeneralWaterWarning("CHLORINE", p.value, 0.2f);
				}
			}
		}
	}

	private void checkSocialWarnings() {
		// first check the aquarium size issues, then predator, groupsize, gender issues, and finally incompatible fish
		checkAquariumSize();

		// a set does not allow duplicates. if it is possible to add X to it, then X is new to it
		Set checkDuplicates1 = new HashSet<Fish>();
		Set checkDuplicates2 = new HashSet<Fish>();

		// for each fishtype
		for (Fish f : fish) {
			if (checkDuplicates1.add(f)) {
				// for each other fishtype
				for (Fish f2 : fish) {
					if (checkDuplicates2.add(f2)) {
						// if there is another fish that could eat this fish, print a warning
						if (f.getPredators().contains(f2.getFishName()))
							printer.addPredatorWarning(f, f2);
					}
				}
				// clear the second duplicate check, else we will skip some fish on the next outer for loop iteration
				checkDuplicates2 = new HashSet();
				// if there are too many, or not enough of this fish, print a warning
				int fishCount = Collections.frequency(fish, f);
				if (fishCount > f.getMaxGroupSize() || fishCount < f.getMinGroupSize())
					printer.addGroupSizeWarning(f, fishCount);
				// if there is a male guppy in our aquarium
				if (f.getFishName().equals("Guppy (M)"))
				{
					int maleCount = 0;
					int femaleCount = 0;
					// check each individual fish and count the male and female occurrences of guppies
					for (Fish f3 : fish)
					{
						if (f3.getFishName().equals("Guppy (M)"))
						{
							maleCount++;
						}
						if (f3.getFishName().equals("Guppy (F)"))
						{
							femaleCount++;
						}
					}
					// if there are not at least 3 females for each male, add a gender warning
					if (maleCount*3 > femaleCount)
					{
						printer.addGenderWarning(maleCount, femaleCount);
					}
				}
			}
		}
		checkForIncompatibleFish();
	}

	private void checkAquariumSize()
	{
		if (this.aquarium_volume > 0)
		{
			int totalPoints = 0;
			for (Fish f : fish)
			{
				totalPoints += f.volumePoints;
			}
			int almostFull = 10;
			if (totalPoints + almostFull > this.aquarium_volume/1.48) 
			//divisor from converting gallon and inch
			{
				printer.addAquariumSizeWarning(totalPoints, this.aquarium_volume);
			}
		}
	}

	private void checkForIncompatibleFish()
	{
		HashSet checkDuplicates = new HashSet<Fish>();
		for (Fish f1 : fish)
		{
			if (checkDuplicates.add(f1))
			{
				for (Fish f2 : fish)
				{
					if (!checkDuplicates.contains(f2))
					{
						if (f1.getMinpH() > f2.getMaxpH() || f2.getMinpH() > f1.getMaxpH())
						{
							printer.addIncompatibleFishWarning(f1, f2, "pH");
						}
						if (f1.getMinTemp() > f2.getMaxTemp() || f2.getMinTemp() > f1.getMaxTemp())
						{
							printer.addIncompatibleFishWarning(f1, f2, "temperature");
						}
					}
				}
			}
		}
	}

	private void deriveConclusion()
	{
		int totalWaterErrors = printer.getGeneralWaterErrors()
				+ printer.getTempErrors()
				+ printer.getpHErrors();

		int totalSocialErrors = printer.getGroupSizeErrors()
				+ printer.getGenderErrors()
				+ printer.getSizeErrors()
				+ printer.getPredatorErrors()
				+ printer.getIncompatibleFishErrors();

		String conclusion;
		if (totalWaterErrors + totalSocialErrors == 0)
		{
			conclusion = "<h4>There are no issues with the current setup!</h4><br>" +
					"Your fish are healthy, ignoring any unset parameters.";
		}
		else
		{
			conclusion = "<h4>There are some issues with your current setup.</h4><br>" +
					"See the details on the right to figure out the problem.";
		}
		printer.setConclusion(conclusion);
	}
	
	public void setUnit(String u){
		String prev;
		if(u == "L" || u == "G"){
			prev = vol_unit;
			vol_unit = u;
		}else{
			prev = temp_unit;
			temp_unit = u;
		}	
		if(prev != u){
			for(Param p : parameters){
				if((p.name.equals("Temp  ") || p.name.equals("Volume  ")) && p.value != null){
					if(u == "F" && p.name.equals("Temp  ")){
						p.value = (p.value - 32) * 5 / 9;
					}
					if(u == "C" && p.name.equals("Temp  ")){
						p.value = p.value * 9 / 5 + 32;
					}
					if(u == "G" && p.name.equals("Volume  ")){
						p.value = p.value * (float) 3.78541178;
					}
					if(u == "L" && p.name.equals("Volume  ")){
						p.value = p.value / (float) 3.78541178;
					}
					System.out.println(p.name + " = " + p.value); 
				}
			}
		}
	}
}
