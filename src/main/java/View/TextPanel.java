package View;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;

import Model.Output;


/*
 * If you need more space to write the text in this class you can 
 * change the size of Add Fish in CenterPanel 
 * */
public class TextPanel extends JPanel
{
	private JLabel warnings = new JLabel();
	private Output out;

	public TextPanel(Output out){
		this.out = out;
		this.setLayout(new GridBagLayout());
		this.warnings.setText(out.getWarnings());
		this.add(warnings);

		Dimension size = new Dimension(500,200);
		setPreferredSize(size);
	}
	
	public void updateWarnings()
	{
		this.warnings.setText(out.getWarnings());
	}
}
