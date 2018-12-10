public class Fish {

	public String fishName;
	private double length;
	private double tempMin, tempMax;
	private double pHMin, pHMax;
	
	
	public Fish(String fishName){
		this.fishName=fishName;
		
		System.out.println("A wild " + fishName + " appears!");
		
		setPrefferedTemp(fishName);
		setPrefferedpH(fishName);
		
	}
	
	public String getFishName() {
		return fishName;
	}
	
	public void setPrefferedTemp(String fishName) {
		
		switch(fishName) {
		case "GoldFish": 
			this.tempMin=68;
			this.tempMax=74;
			break;
		case "Corydora":
			this.tempMin=74;
			this.tempMax=80;
			break;
		case "Beta":
			this.tempMin=70;
			this.tempMax=80;
			break;
			
		}
	}
	
	public double getMinTemp(String fishName) {
		return tempMin;
	}
	
	public double getMaxTemp(String fishName) {
		return tempMax;
	}
	
	public void setPrefferedpH(String fishName) {
		
		switch(fishName) {
		case "GoldFish": 
			this.pHMin=7;
			this.pHMax=8.4;
			break;
		case "Corydora":
			this.pHMin=7;
			this.pHMax=8;
			break;
		case "Beta":
			this.pHMin=7;
			this.pHMax=9;
			break;
			
		}
	}
	
	public double getMinpH(String fishName) {
		return pHMin;
	}
	
	public double getMaxpH(String fishName) {
		return pHMax;
	}
	
	public void fishWarning(String fishName, double aquariumTemp, double aquariumpH) {
		if(aquariumTemp<tempMin || aquariumTemp>tempMax) {
			System.out.println("Warning: incorrect temperature");
			System.out.println("Range for " + fishName + " should be between " + tempMin + " and " + tempMax + ", but is " + aquariumTemp);
		}
		if(aquariumpH<pHMin || aquariumpH>pHMax) {
			System.out.println("Warning: incorrect pH value");
			System.out.println("Range for " + fishName + " should be between " + pHMin + " and " + pHMax + ", but is " + aquariumpH);
			
		}
	}
	
}
