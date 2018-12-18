package Controller;

import Model.Model;
import View.Fishtank;
import View.addFishPanel;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

/**
	This simply handles the action once the addFishButton is clicked. The frame holds the relevant subsecuent actions to perform, and sends the string to the model.addFishByString(FishName)
*/

///should be in Controller.
public class addFishAction extends AbstractAction
{
	private Model model;
	private Fishtank fishtank;
	public addFishAction(Model m, Fishtank fishtank){
		this.model = m;
		this.fishtank = fishtank;
	}

//	@Override
	public void actionPerformed(ActionEvent e){
		JPanel addFishPanel = new addFishPanel(model, fishtank);
	}


}
