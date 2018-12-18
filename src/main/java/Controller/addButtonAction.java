package Controller;

import Model.Model;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


///should be in controller.
public class addButtonAction extends AbstractAction
{
	private Model model;
	public addButtonAction(Model m){
		this.model = m;
	}

//	@Override
	public void actionPerformed(ActionEvent e){
		//JFrame addButtonMessageFrame = new addButtonMessageFrame(model);
		model.warn();
	}


}