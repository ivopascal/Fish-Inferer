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
		switch(fishName){
			case "Goldfish":
				this.tempMin = 18.89;
				this.tempMax = 22.22;
				break;

			case "Corydora":
				this.tempMin = 23.33;
				this.tempMax = 26.66;
				break;
			case "Betta (M)":
				this.tempMin = 23.89;
				this.tempMax = 26.67;
				break;
			case "Betta (F)":
				this.tempMin = 23.89;
				this.tempMax = 26.67;
				break;
			case "Guppy (M)":
				this.tempMin = 22;
				this.tempMax = 26;
				break;
			case "Guppy (F)":
				this.tempMin = 22;
				this.tempMax = 26;
				break;
			case "Cardinal":
				this.tempMin = 22.78;
				this.tempMax = 27.22;
				break;
			case "Endler":
				this.tempMin = 22;
				this.tempMax = 26;
				break;
			case "Endler (F)":
				this.tempMin = 22;
				this.tempMax = 26;
				break;
			case "Fire neon":
				this.tempMin = 22;
				this.tempMax = 28;
				break;
			case "Moon fish":
				this.tempMin = 23.9;
				this.tempMax = 27.8;
				break;
			default:
				System.out.println("Using default value for " + fishName);
				this.tempMin = 0;
				this.tempMax = 100;
				break;
		}
	}

	public double getMinTemp() {
		return tempMin;
	}

	public double getMaxTemp() {
		return tempMax;
	}

	private void setPreferredpH(String fishName) {
		switch(fishName){
			case "Goldfish":
				this.pHMin = 7.2;
				this.pHMax = 7.8;
				break;
			case "Corydora":
				this.pHMin = 7.0;
				this.pHMax = 8.0;
				break;
			case "Betta (M)":
				this.pHMin = 6.0;
				this.pHMax = 7.5;
				break;
			case "Betta (F)":
				this.pHMin = 6.0;
				this.pHMax = 7.5;
				break;
			case "Guppy (M)":
				this.pHMin = 6.7;
				this.pHMax = 8.5;
				break;
			case "Guppy (F)":
				this.pHMin = 6.7;
				this.pHMax = 8.5;
				break;
			case "Cardinal":
				this.pHMin = 5;
				this.pHMax = 6;
				break;
			case "Endler (M)":
				this.pHMin = 6.7;
				this.pHMax = 8.5;
				break;
			case "Endler (F)":
				this.pHMin = 6.7;
				this.pHMax = 8.5;
				break;
			case "Fire neon":
				this.pHMin = 6.0;
				this.pHMax = 7.5;
				break;
			case "Moon fish":
				this.pHMin = 7.2;
				this.pHMax = 8.5;
				break;
			

			default:
				System.out.println("Using default value for " +fishName);
				this.pHMin = 0;
				this.pHMax = 14;
				break;

		}
	}

	public double getMinpH() {
		return pHMin;
	}

	public double getMaxpH() {
		return pHMax;
	}

	public void setGroupSizeRequirements(String fishName) {
		switch(fishName){
			case "Moon fish":
				this.minGroupSize = 5;
				this.maxGroupSize = 99;
				break;
			case "Goldfish":
				this.minGroupSize = 3;
				this.maxGroupSize = 99;
				break;
			case "Corydora":
				this.minGroupSize = 6;
				this.maxGroupSize = 99;
				break;
			case "Betta (M)":
				this.minGroupSize = 1;
				this.maxGroupSize = 1;
				break;
			case "Betta (F)":
				this.minGroupSize = 3;
				this.maxGroupSize = 99;
				break;
			case "Guppy (M)":
				this.minGroupSize = 1;
				this.maxGroupSize = 99;
				break;
			case "Guppy (F)":
				this.minGroupSize = 3;
				this.maxGroupSize = 99;
				break;
			case "Cardinal":
				this.minGroupSize = 6;
				this.maxGroupSize = 99;
				break;
			case "Endler (M)":
				this.minGroupSize = 1;
				this.maxGroupSize = 99;
				break;
			case "Endler (F)":
				this.minGroupSize = 3;
				this.maxGroupSize = 99;
				break;
		
			default:
				this.minGroupSize = 1;
				this.maxGroupSize = 99;
				break;
		}
	}

	public int getMinGroupSize() {
		return minGroupSize;
	}

	public int getMaxGroupSize() {
		return maxGroupSize;
	}

	public void setPredators(String fishName) {
		switch(fishName){
			case "Red Crystal Shrimp":
				//this.predators.add("Pleco");
				this.predators.add("Moon fish");
				this.predators.add("Guppy");
				this.predators.add("Fire neon");
				//this.predators.add("Endler"); 
				//Endlers are the only fish too small to eat shrimp	
				this.predators.add("Cardinal");
				this.predators.add("GoldFish");
				this.predators.add("Betta (M)");
				//this.predators.add("Corydora");
				break;
			case "Red Cherry Shrimp":
				//this.predators.add("Pleco");	
				this.predators.add("Moon fish");
				this.predators.add("Guppy");
				this.predators.add("Fire neon");
				//this.predators.add("Endler"); 
				//Endlers are the only fish too small to eat shrimp	
				this.predators.add("Cardinal");
				this.predators.add("Goldfish");
				this.predators.add("Betta (M)");
				this.predators.add("Betta (F)");
				//this.predators.add("Corydora");
				break;
			case "Guppy":
				this.predators.add("Moon fish");
				break;
			case "Endler":
				this.predators.add("Betta (M)");
				this.predators.add("Moon fish");
				break;
			default:
				break;
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
