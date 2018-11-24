
public class Model
{
	// Frame (GUI) dimensions
	int totalWidth = 1050;
	int totalHeight = 680;
	// Parameters (GUI) dimensions
	int paramsWidth = 150;

	// Parameters
	private int aquarium_width;
	private int aquarium_length;
	
    Model()
    {
		aquarium_length = 0;
		aquarium_width  = 0;
	}
	
	public void set_aquarium_width(int width){
		this.aquarium_width = width;
	}

	public void set_aquarium_length(int length){
		this.aquarium_length = length;
	}
	
	public int get_aquarium_width(){
		return aquarium_width;
	}
	public int get_aquarium_length(){
		return aquarium_length;
	}
}
