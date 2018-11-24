import java.awt.*;
import javax.swing.*;

class Parameters extends JPanel
{
	Parameters(Model m)
	{
		// parameters can also go in the model
		String[] parameters = {"Temp", "pH", "GH", "X", "Y", "Z"};
		// find a way to resize the height of each row?
		GridLayout layout = new GridLayout(parameters.length, 1);
		this.setLayout(layout);

		for (String parameter : parameters)
		{
			JLabel l = new JLabel(parameter);
			this.add(l);
			JTextField t = new JTextField(10);
			l.setLabelFor(t);
			this.add(t);
		}

		Dimension size = new Dimension(m.paramsWidth, m.totalHeight);
		this.setPreferredSize(size);
	}
}
