package View;

import Controller.addButtonAction;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class InfoButtons extends JPanel
{
	InfoButtons(Model m)
	{
		// parameters can also go in the model
		String[] buttons = {"Why are my fish dying?", "Algae Info", "Stress", "Lighting"};
		// find a way to resize the height of each row?
		GridLayout layout = new GridLayout(buttons.length, 1);
		this.setLayout(layout);

		for (String parameter : buttons)
		{
			JButton l = new JButton(parameter);
			this.add(l);
			
			///ADDED
			if(parameter=="Why are my fish dying?") {
				l.addActionListener(new addButtonAction(m));
			}
		}

		Dimension size = new Dimension(m.paramsWidth, m.totalHeight);
		this.setPreferredSize(size);

	}
}



