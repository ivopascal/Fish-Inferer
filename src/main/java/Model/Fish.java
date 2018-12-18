package Model;

public class Fish
{
	public String fishName;
	private double tempMin, tempMax;
	private double pHMin, pHMax;

	public Fish(String fishName)
	{
		this.fishName = fishName;
		System.out.println("A wild " + fishName + " appears!");
		
		setPreferredTemp(fishName);
		setPreferredpH(fishName);
	}
	
	public String getFishName() {
		return fishName;
	}
	
	private void setPreferredTemp(String fishName)
	{
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
	
	private void setPreferredpH(String fishName)
	{
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
}
