package Model;

import java.util.ArrayList;

public class Fish {
	private String fishName;
	private double tempMin, tempMax;
	private double pHMin, pHMax;
	private int minGroupSize, maxGroupSize;
	private ArrayList<String> predators = new ArrayList<String>();

	public Fish(String fishName) {
		this.fishName = fishName;
		System.out.println("A wild " + fishName + " appears!");

		setPreferredTemp(fishName);
		setPreferredpH(fishName);
		setGroupSizeRequirements(fishName);
		setPredators(fishName);
	}

	public String getFishName() {
		return fishName;
	}

	private void setPreferredTemp(String fishName) {
		if ("GoldFish".equals(fishName)) {
			this.tempMin = 68;
			this.tempMax = 74;
		} else if ("Corydora".equals(fishName)) {
			this.tempMin = 74;
			this.tempMax = 80;
		} else if ("Beta".equals(fishName)) {
			this.tempMin = 70;
			this.tempMax = 80;
		} else {
			this.tempMin = 0;
			this.tempMax = 100;
		}
	}

	public double getMinTemp() {
		return tempMin;
	}

	public double getMaxTemp() {
		return tempMax;
	}

	private void setPreferredpH(String fishName) {
		if ("GoldFish".equals(fishName)) {
			this.pHMin = 7;
			this.pHMax = 8.4;
		} else if ("Corydora".equals(fishName)) {
			this.pHMin = 7;
			this.pHMax = 8;
		} else if ("Beta".equals(fishName)) {
			this.pHMin = 7;
			this.pHMax = 9;
		} else {
			this.pHMin = 0;
			this.pHMax = 100;
		}
	}

	public double getMinpH() {
		return pHMin;
	}

	public double getMaxpH() {
		return pHMax;
	}

	public void setGroupSizeRequirements(String fishName) {
		if ("MoonFish".equals(fishName)) {
			this.maxGroupSize = 15;
			this.minGroupSize = 6;
		} else {
			this.maxGroupSize = 5;
			this.minGroupSize = 1;
		}
	}

	public int getMinGroupSize() {
		return minGroupSize;
	}

	public int getMaxGroupSize() {
		return maxGroupSize;
	}

	public void setPredators(String fishName) {
		if ("Red Crystal Shrimp".equals(fishName) || "Red Cherry Shrimp".equals(fishName)) {
			this.predators.add("Pleco");
			this.predators.add("MoonFish");
			this.predators.add("Guppy");
			this.predators.add("FireNeon");
			this.predators.add("Endler");
			this.predators.add("Cardinal");
			this.predators.add("GoldFish");
			this.predators.add("Beta");
			this.predators.add("Corydora");
		}
	}

	public ArrayList<String> getPredators() {
		return predators;
	}

	// I need this and equals to remove duplicates via a hashset
    // just ignore this stuff
	@Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getFishName().hashCode();
        return result;
    }

    // again, just pretend this isnt here :)
    @Override
    public boolean equals(Object o) {
	    if (o == this) return true;
	    if (!(o instanceof Fish)) {
	        return false;
        }
	    Fish f = (Fish) o;
        return f.getFishName().equals(this.getFishName());
    }
}









/*
	public void fishWarning(String fishName, Model m)
	{
		if(aquariumTemp<tempMin || aquariumTemp>tempMax) {
			System.out.println("Warning: incorrect temperature");
			System.out.println("Range for " + fishName + " should be between " + tempMin + " and " + tempMax + ", but is " + aquariumTemp);
		}
		if(aquariumpH<pHMin || aquariumpH>pHMax) {
			System.out.println("Warning: incorrect pH value");
			System.out.println("Range for " + fishName + " should be between " + pHMin + " and " + pHMax + ", but is " + aquariumpH);
			
		}
	}
*/
