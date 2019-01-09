package View;

import Model.Model;
import Controller.addFishAction;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


/*
	addFishFrame opens a selector GUI where a button can be clicked to pick a fish
	The name of this fish is passed to the model as a string, from where the fish data should be computed
*/
public class addFishPanel extends JPanel
{
	private Model m;
	private JButton addFishButton;

	public addFishPanel(Model m)
	{
		Dimension size = new Dimension(300,100);
		setPreferredSize(size);
		this.m = m;
		this.setLayout(new GridLayout());

		

		
		String buttonText = "Add Fish";
		this.addFishButton = new JButton(buttonText);
		this.addFishButton.addActionListener(new addFishAction(m, this));
		this.add(addFishButton);
	}

	public void addFish()
	{
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		this.setLayout(gbl);
		for (String fishName : m.getFishStrings())
		{
			if(c.gridx >= 5){
				c.gridx = 0;
				c.gridy++;
			}
			JButton fishButton = new JButton(fishName);

			fishButton.addActionListener(new fishButtonAction(m, fishName, this));
			this.add(fishButton,c);
			c.gridx++;
		}
	}
	
	public void setAddFishButton(){
		this.removeAll();
		this.setLayout(new GridLayout());
		this.add(addFishButton);
		revalidate();
		this.repaint();
		
		
	}
	
	public void setAddFishPanel(){
		this.remove(addFishButton);
		addFish();
		revalidate();
		this.repaint();
		
	}
}

class fishButtonAction extends AbstractAction
{
	Model m;
	String fishName;
	addFishPanel panel;

	fishButtonAction(Model m, String fishName, addFishPanel panel)
	{
		this.m = m;
		this.fishName = fishName;
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		m.addFishByString(fishName);
		panel.setAddFishButton();
	}
}
