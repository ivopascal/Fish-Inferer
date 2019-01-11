package View;

import Model.Model;

import java.awt.*;
import java.util.ConcurrentModificationException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Parameters extends JPanel
{
	Parameters(Model m)
	{
		this.setLayout(new FlowLayout());

		// for each changeable parameter in the model
		for (String parameter : m.getParameterStrings())
		{
			// make a new panel so that the labels and textfields appear next to each other
			JPanel paramPanel = new JPanel();
			paramPanel.setLayout(new GridBagLayout());

			// make the label
			JLabel l = new JLabel(parameter, JLabel.TRAILING);
			l.setPreferredSize(new Dimension(80, 50));
			paramPanel.add(l);

			// and the textfield
			JFormattedTextField t = new JFormattedTextField();
			t.setColumns(5);
			l.setLabelFor(t);
			t.getDocument().addDocumentListener(new parameterAction(m, t, parameter));

			// and add it to the parameter panel
			paramPanel.add(t);

			// add the parameter panel to the entire parameter panel
			this.add(paramPanel);
		}

		Dimension size = new Dimension(m.paramsWidth, m.totalHeight);
		this.setPreferredSize(size);
	}
}

class parameterAction implements DocumentListener
{
	private Model m;
	private JFormattedTextField input;
	private String param;

	public parameterAction(Model m, JFormattedTextField text, String param)
	{
		this.m = m;
		this.input = text;
		this.param = param;
	}

	public void insertUpdate(DocumentEvent e)
	{
		updateParameter();
	}

	public void removeUpdate(DocumentEvent e)
	{
		updateParameter();
	}

	public void changedUpdate(DocumentEvent e)
	{
		updateParameter();
	}

	private void updateParameter()
	{
		String inputString = this.input.getText();
		if (!inputString.equals(""))
		{
			if (param.equals("Volume "))
			{
				// aquarium volume must be a positive integer
				int intVal = 0;
				try
				{
					intVal = Integer.parseInt(inputString);
				} catch (NumberFormatException e)
				{
					System.out.println("Invalid Input!");
				}
				if (intVal > 0)
				{
					m.aquarium_volume = intVal;
				}
			}
			else
			{
				// all other parameter values must be valid floats
				Float value = null;
				try
				{
					value = Float.parseFloat(inputString);
				} catch (NumberFormatException e)
				{
					System.out.println("Invalid Input!");
				}
				m.updateParameter(param, value);
			}
		}
		else
		{
			try {
				m.removeParameter(param);
			} catch (ConcurrentModificationException e) { }
		}
	}
}