
public class Model
{
	private int aquarium_width;
	private int aquarium_length;
	
    public Model()
    {
		aquarium_length = 0;
		aquarium_width  = 0;
	}
	
	public void set_aquarium_width(int width){
		this.aquarium_width = width;
	}
	
	//public void set_aquarium_length(int length){
	//	this.aquarium_length = lenght;
	//}
	
	public int get_aquarium_width(){
		return aquarium_width;
	}
	public int get_aquarium_length(){
		return aquarium_length;
	}
}
