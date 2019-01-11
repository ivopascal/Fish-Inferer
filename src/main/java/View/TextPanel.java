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
	private JEditorPane socialWarnings = new JEditorPane();
	private JEditorPane waterWarnings = new JEditorPane();
	private JEditorPane conclusions = new JEditorPane();

	private Output out;

	public TextPanel(Output out){
		this.out = out;
		this.setLayout(new GridBagLayout());

		// Total WIDTH ~ 750 to span aquarium pic

		this.conclusions.setPreferredSize(new Dimension(250, 200));
		this.conclusions.setContentType("text/html");
		JScrollPane c = new JScrollPane(conclusions, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		c.setPreferredSize(new Dimension(250, 200));
		this.add(c);
		this.conclusions.setText(out.getConclusions());

		this.socialWarnings.setPreferredSize(new Dimension(250, 200));
		this.socialWarnings.setContentType("text/html");
		JScrollPane s = new JScrollPane(socialWarnings, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		s.setPreferredSize(new Dimension(250, 200));
		this.add(s);
		this.socialWarnings.setText(out.getSocialWarnings());

		this.waterWarnings.setPreferredSize(new Dimension(250, 200));
		this.waterWarnings.setContentType("text/html");
		JScrollPane w = new JScrollPane(waterWarnings, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		w.setPreferredSize(new Dimension(250, 200));
		this.add(w);
		this.waterWarnings.setText(out.getWaterWarnings());

		Dimension size = new Dimension(700,200);
		setPreferredSize(size);
	}
	
	public void updateWarnings()
	{
		this.conclusions.setText(out.getConclusions());
		this.socialWarnings.setText(out.getSocialWarnings());
		this.waterWarnings.setText(out.getWaterWarnings());
	}
}
