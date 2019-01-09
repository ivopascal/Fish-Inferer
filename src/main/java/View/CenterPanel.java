package View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;


import Model.Model;
import View.TextPanel;
import View.Fishtank;


public class CenterPanel extends JPanel
{
	private Model m;
	private Fishtank fishTank;
	private addFishPanel addPanel;
	private TextPanel textPanel;
	
	public CenterPanel(Model m){
		this.m = m;
		//this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		this.setLayout(gbl);
		addPanel = new addFishPanel(m);
		fishTank = new Fishtank(m);
		textPanel = new TextPanel(m);
		
		
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		c.gridx = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		//c.ipady = 150; //Determines the height of the AddFish
		this.add(addPanel, c);
		c.ipady = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 1;
		this.add(fishTank, c);
		c.weightx = 0;
		c.weighty = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_START;
		this.add(textPanel, c);
		
	}
	
	
}
