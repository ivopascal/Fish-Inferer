import javax.swing.AbstractAction;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;

/**
	This simply handles the action once the addFishButton is clicked. The frame holds the relevant subsecuent actions to perform, and sends the string to the model.addFishByString(FishName)
*/
public class addFishAction extends AbstractAction
{
	private Model model;
	public addFishAction(Model m){
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		JFrame addFishFrame = new addFishFrame(model);
	}


}
