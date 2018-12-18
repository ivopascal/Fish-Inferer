package View;

import Controller.addButtonAction;
import Model.Model;

import javax.swing.*;
import java.awt.*;

public class InfoButtons extends JPanel
{
	public InfoButtons(Model m)
	{
		// parameters can also go in the model
		String[] buttons = m.getInfoButtonStrings();
		GridLayout layout = new GridLayout(buttons.length, 1);
		this.setLayout(layout);

		for (String buttonText : buttons)
		{
			JButton l = new JButton(buttonText);
			this.add(l);

			if(buttonText.equals("Why are my fish dying?"))
			{
				l.addActionListener(new addButtonAction(m));
			}
		}

		Dimension size = new Dimension(m.paramsWidth, m.totalHeight);
		this.setPreferredSize(size);
	}
}



