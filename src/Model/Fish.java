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
		default:
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
		default:
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
