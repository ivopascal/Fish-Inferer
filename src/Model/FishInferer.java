public class FishInferer
{
    public static void main( String[] args )
    {
		Model m = new Model();
	    GUI gui = new GUI(m);
	    
	    String mrBubbles = "GoldFish";
	    
	    Fish dory = new Fish(mrBubbles);
	    
	    dory.fishWarning(mrBubbles, 10, 10);
	    
	    
    }
}
