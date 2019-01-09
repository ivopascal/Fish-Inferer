package View;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
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
		this.setLayout(new GridLayout());
		this.add(new JButton("Yabadabadoo"));
		this.InfoText = "Here are some instructions and general info";
		
		Dimension size = new Dimension(500,200);
		setPreferredSize(size);

	}
	
	
}
