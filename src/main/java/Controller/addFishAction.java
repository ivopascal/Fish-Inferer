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
	private addFishPanel afp;
	public addFishAction(Model m, addFishPanel afp){
		this.model = m;
		this.afp = afp;
	}

//	@Override
	public void actionPerformed(ActionEvent e){
		afp.setAddFishPanel();
	}


}
