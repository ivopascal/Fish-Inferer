package View;

import Model.Model;
import Controller.addButtonAction;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ConcurrentModificationException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class Parameters extends JPanel implements ActionListener
{
	private Model m;
	Parameters(Model m)
	{
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(gbl);
		this.m=m;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;

		// for each changeable parameter in the model
		JPanel allPPanel = new JPanel();
		allPPanel.setLayout(new GridLayout((m.getParameterStrings().length),1));
		allPPanel.setBorder(BorderFactory.createTitledBorder("Water parameters"));
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
			allPPanel.add(paramPanel);	 
		}
		c.gridx = 0;
		c.gridy = 0;
		this.add(allPPanel,c);
		
		
		
		JRadioButton F_button = new JRadioButton("Fahrenheit");
		F_button.setActionCommand("F");
		F_button.addActionListener(this);
		JRadioButton C_button = new JRadioButton("Celsius");
		C_button.setActionCommand("C");
		C_button.setSelected(true);
		C_button.addActionListener(this);
		
		ButtonGroup temp_group = new ButtonGroup();
		temp_group.add(F_button);
		temp_group.add(C_button);
		
		JRadioButton L_button = new JRadioButton("Litres");
		L_button.setActionCommand("L");
		L_button.setSelected(true);
		L_button.addActionListener(this);
		JRadioButton G_button = new JRadioButton("Gallons");
		G_button.setActionCommand("G");
		G_button.addActionListener(this);
		
		ButtonGroup vol_group = new ButtonGroup();
		vol_group.add(L_button);
		vol_group.add(G_button);
		
		JPanel temp_panel = new JPanel();
		temp_panel.setLayout(new GridLayout(2,1));
		temp_panel.setBorder(BorderFactory.createTitledBorder("Temp unit"));
		temp_panel.add(C_button);
		temp_panel.add(F_button);
		
		JPanel vol_panel = new JPanel();
		vol_panel.setLayout(new GridLayout(2,1));
		vol_panel.setBorder(BorderFactory.createTitledBorder("Volume unit"));
		vol_panel.add(L_button);
		vol_panel.add(G_button);
		
		c.gridy = 1;
		this.add(temp_panel,c);
		c.gridy = 2;
		this.add(vol_panel,c);
		
		JButton analyze_button = new JButton("> Analyze <");
		analyze_button.addActionListener(new addButtonAction(m));
		c.gridy = 3;
		this.add(analyze_button, c);

		JButton clear_button = new JButton("Clear");
		clear_button.addActionListener(new clearAction(m));
		c.gridy = 5;
		this.add(clear_button, c);
		
		Dimension size = new Dimension(m.paramsWidth, m.totalHeight);
		this.setPreferredSize(size);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		m.setUnit(e.getActionCommand());
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

class clearAction extends AbstractAction{
	private Model m;
	
	public clearAction(Model m){
		this.m = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
			m.removeFishByString("All");
	}
	
}
