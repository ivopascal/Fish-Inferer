package View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Dimension;


import Model.Model;


/*
 * If you need more space to write the text in this class you can 
 * change the size of Add Fish in CenterPanel 
 * */
public class TextPanel extends JPanel
{
	private Model m;
	private String InfoText;
	
	public TextPanel(Model m){
		this.m = m;
		this.add(new JLabel("Yabadabadoo"));
		this.InfoText = "Here are some instructions and general info";
	}
	
	
}
