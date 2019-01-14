package Model;

import java.util.ArrayList;

public class Fish {
	private String fishName;
	private double tempMin, tempMax;
	private double pHMin, pHMax;
	public double volumePoints;
	private int minGroupSize, maxGroupSize;
	private ArrayList<String> predators = new ArrayList<String>();

	public Fish(String fishName) {
		this.fishName = fishName;
		System.out.println("A wild " + fishName + " appears!");

		setPreferredTemp(fishName);
		setPreferredpH(fishName);
		setGroupSizeRequirements(fishName);
		setPredators(fishName);
		setVolumePoints(fishName);
	}

	public String getFishName() {
		return fishName;
	}

	private void setPreferredTemp(String fishName) {
		switch(fishName){
			case "Red Crystal Shrimp":
				this.tempMin = 22;
				this.tempMax = 26;
				break;
			case "Red Cherry Shrimp":
				this.tempMin = 18.3;
				this.tempMax = 29.4;
				break;
			case "Pleco":
				this.tempMin =21;
				this.tempMax =28;
				break;
			case "Platy":
				this.tempMin = 22.2;
				this.tempMax = 27.8;
				break;
			case "Goldfish":
				this.tempMin = 18.9;
				this.tempMax = 22.2;
				break;

			case "Corydora":
				this.tempMin = 23.3;
				this.tempMax = 26.7;
				break;
			case "Betta (M)":
				this.tempMin = 23.9;
				this.tempMax = 26.7;
				break;
			case "Betta (F)":
				this.tempMin = 23.9;
				this.tempMax = 26.7;
				break;
			case "Guppy (M)":
				this.tempMin = 22.0;
				this.tempMax = 26.0;
				break;
			case "Guppy (F)":
				this.tempMin = 22.0;
				this.tempMax = 26.0;
				break;
			case "Cardinal":
				this.tempMin = 22.8;
				this.tempMax = 27.2;
				break;
			case "Endler":
				this.tempMin = 22.0;
				this.tempMax = 26.0;
				break;
			/*
			case "Endler (F)":
				this.tempMin = 22;
				this.tempMax = 26;
				break;
				**/
			case "Fire neon":
				this.tempMin = 22.0;
				this.tempMax = 28.0;
				break;
			case "Moon fish":
				this.tempMin = 23.9;
				this.tempMax = 27.8;
				break;
			case "Molly":
				this.tempMin = 23.9;
				this.tempMax = 26.7;
			default:
				this.tempMin = 0.0;
				this.tempMax = 100.0;
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
			case "Red Crystal Shrimp":
				this.pHMin = 6.0;
				this.pHMax = 7.4;
				break;
			case "Red Cherry Shrimp":
				this.pHMin = 6.5;
				this.pHMax = 8.0;
				break;
			case "Pleco":
				this.pHMin =6.0;
				this.pHMax =7.0;
				break;
			case "Platy":
				this.pHMin =6.5;
				this.pHMax =7.5;
				break;
				
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
				this.pHMin = 5.0;
				this.pHMax = 6.0;
				break;
			case "Endler":
				this.pHMin = 6.7;
				this.pHMax = 8.5;
				break;
			/*case "Endler (F)":
				this.pHMin = 6.7;
				this.pHMax = 8.5;
				break;
				*/
			case "Fire neon":
				this.pHMin = 6.0;
				this.pHMax = 7.5;
				break;
			case "Moon fish":
				this.pHMin = 7.2;
				this.pHMax = 8.5;
				break;
			case "Molly":
				this.pHMin = 7.0;
				this.pHMax = 8.0;
				break;
			default:
				this.pHMin = 0.0;
				this.pHMax = 14.0;
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
			case "Red Crystal Shrimp":
				this.minGroupSize = 5;
				this.maxGroupSize = 1000;
				break;
			case "Red Cherry Shrimp":
				this.minGroupSize = 5;
				this.maxGroupSize = 1000;
				break;
			case "Pleco":
				this.minGroupSize = 1;
				this.maxGroupSize = 1;
				break;
			case "Platy":
				this.minGroupSize =4;
				this.maxGroupSize =99;
				break;
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
			case "Endler":
				this.minGroupSize = 4;
				this.maxGroupSize = 99;
				break;
			/*
			case "Endler (F)":
				this.minGroupSize = 3;
				this.maxGroupSize = 99;
				break;
				*/
			case "Molly":
				this.minGroupSize = 4;
				this.maxGroupSize = 99;
				break;
		
			default:
				this.minGroupSize = 1;
				this.maxGroupSize = 99;
				break;
		}
	}

	public void setVolumePoints(String fishName){
		switch(fishName){
			case "Red Crystal Shrimp":
				this.volumePoints = 0.1;
				break;
			case "Red Cherry Shrimp":
				this.volumePoints = 0.1;
				break;
			case "Pleco":
				this.volumePoints = 5.0;
				break;
			case "Platy":
				this.volumePoints = 1.5;
				break;
			case "Goldfish":
				this.volumePoints = 25.0;
				break;
			case "Corydora":
				this.volumePoints = 1.5;
				break;
			case "Betta (M)":
				this.volumePoints = 5.0;
				break;
			case "Betta (F)":
				this.volumePoints = 3.0;
				break;
			case "Guppy (M)":
				this.volumePoints = 2.0;
				break;
			case "Guppy (F)":
				this.volumePoints = 2.0;
				break;
			case "Cardinal":
				this.volumePoints = 2.0;
				break;
			case "Endler":
				this.volumePoints = 1.0;
				break;
		
			case "Endler (F)":
				this.volumePoints = 1.0;
				break;
			
			case "Fire neon":
				this.volumePoints = 2.0;
				break;
			case "Moon fish":
				this.volumePoints = 7.0;
				break;
			case "Molly":
				this.volumePoints = 3.0;
			default:
				this.volumePoints = 0.0;
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
				this.predators.add("Pleco");
				this.predators.add("Moon fish");
				this.predators.add("Guppy");
				this.predators.add("Fire neon");
				//this.predators.add("Endler");
				//Endlers are the only fish too small to eat shrimp
				this.predators.add("Cardinal");
				this.predators.add("GoldFish");
				this.predators.add("Betta (M)");
				this.predators.add("Corydora");
				this.predators.add("Molly");
				break;
			case "Red Cherry Shrimp":
				this.predators.add("Pleco");	
				this.predators.add("Moon fish");
				this.predators.add("Guppy");
				this.predators.add("Fire neon");
				//this.predators.add("Endler"); 
				//Endlers are the only fish too small to eat shrimp	
				this.predators.add("Cardinal");
				this.predators.add("Goldfish");
				this.predators.add("Betta (M)");
				this.predators.add("Betta (F)");
				this.predators.add("Corydora");
				this.predators.add("Molly");
				break;
			case "Guppy":
				this.predators.add("Moon fish");
				this.predators.add("Betta (M)");
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
