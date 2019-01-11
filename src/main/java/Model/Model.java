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
	private String[] infoButtonStrings = {"> Analyze <", "Algae Info", "Stress", "Lighting", "Cleaning"};
	private String[] parameterStrings = {"Temp  ", "pH  ", "GH  ", "Nitrite  ", "Nitrate  ", "Chlorine  ", "Volume "};
	private String[] fishStrings = {"Red Crystal Shrimp", "Red Cherry Shrimp", "Pleco",
			"Moon fish", "Platy", "Guppy (M)", "Guppy (F)" , "Fire neon", "Endler",
			"Cardinal", "Betta (M)", "Betta (F)" , "Corydora", "Goldfish", "Molly"};

	private ArrayList<Fish> fish = new ArrayList<Fish>();
	private ArrayList<Param> parameters = new ArrayList<Param>();
	private Fishtank tankPanel;

	public Output printer = new Output();

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
		fish.add(new Fish(FishName));
		tankPanel.loadFish();
	}

	public void removeFishByString(String FishName) {
		Iterator<Fish> it = fish.iterator();
		while (it.hasNext()) {
			Fish f = it.next();
			if (f.getFishName().equals(FishName)) {
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
		printer.printWarnings();
	}

	private void checkWaterWarnings() {
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

	private void checkSocialWarnings() {
		// a set does not allow duplicates. if it is possible to add X to it, then X is new to it
		Set checkDuplicates1 = new HashSet<Fish>();
		Set checkDuplicates2 = new HashSet<Fish>();

		checkAquariumSize();

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
	}

	private void checkAquariumSize()
	{
		if (this.aquarium_volume > 0)
		{
			int totalPoints = 0;
			for (Fish f : fish)
			{
				totalPoints += 10; // f.volumePoints
			}
			int almostFull = 20;
			if (totalPoints + almostFull > this.aquarium_volume)
			{
				printer.addAquariumSizeWarning(totalPoints, this.aquarium_volume);
			}
		}
	}
}