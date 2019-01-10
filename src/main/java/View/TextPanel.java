package View;

import javax.swing.*;
import java.awt.*;

import Model.Output;


/*
 * If you need more space to write the text in this class you can 
 * change the size of Add Fish in CenterPanel 
 * */
public class TextPanel extends JPanel
{
	private JTextArea tempWarnings = new JTextArea();
	private JTextArea pHWarnings = new JTextArea();
	private JTextArea groupSizeWarnings = new JTextArea();
	private JTextArea predatorsWarnings = new JTextArea();
	private Output out;

	public TextPanel(Output out){
		this.out = out;
		this.setLayout(new GridBagLayout());

		// WIDTH = 750 to span aquarium width
		this.tempWarnings.setText(out.getTempWarnings());
		this.tempWarnings.setPreferredSize(new Dimension(180, 200));
		this.tempWarnings.setLineWrap(true);
		this.add(tempWarnings);

		this.pHWarnings.setText(out.getpHWarnings());
		this.pHWarnings.setPreferredSize(new Dimension(160, 200));
		this.pHWarnings.setLineWrap(true);
		this.add(pHWarnings);

		this.groupSizeWarnings.setText(out.getGroupSizeWarnings());
		this.groupSizeWarnings.setPreferredSize(new Dimension(187, 200));
		this.groupSizeWarnings.setLineWrap(true);
		this.add(groupSizeWarnings);

		this.predatorsWarnings.setText(out.getPredatorsWarnings());
		this.predatorsWarnings.setPreferredSize(new Dimension(221, 200));
		this.predatorsWarnings.setLineWrap(true);
		this.add(predatorsWarnings);

		Dimension size = new Dimension(700,200);
		setPreferredSize(size);
	}
	
	public void updateWarnings()
	{
		this.tempWarnings.setText(out.getTempWarnings());
		this.pHWarnings.setText(out.getpHWarnings());
		this.groupSizeWarnings.setText(out.getGroupSizeWarnings());
		this.predatorsWarnings.setText(out.getPredatorsWarnings());
	}
}
