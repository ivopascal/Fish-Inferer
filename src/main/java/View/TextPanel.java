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
	private JEditorPane conclusions = new JEditorPane();
	private JEditorPane socialWarnings = new JEditorPane();
	private JEditorPane waterWarnings = new JEditorPane();

	private Output out;

	public TextPanel(Output out){
		this.out = out;
		this.setLayout(new GridBagLayout());

		// Total WIDTH 750 to span aquarium pic

		conclusions.setPreferredSize(new Dimension(250, 200));
		conclusions.setContentType("text/html");
		JScrollPane conclusionScroller = new JScrollPane(conclusions, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		conclusionScroller.setPreferredSize(new Dimension(250, 200));
		this.add(conclusionScroller);
		conclusions.setText(out.getConclusions());

		socialWarnings.setPreferredSize(new Dimension(250, 200));
		socialWarnings.setContentType("text/html");
		JScrollPane socialScroller = new JScrollPane(socialWarnings, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		socialScroller.setPreferredSize(new Dimension(250, 200));
		this.add(socialScroller);
		socialWarnings.setText(out.getSocialWarnings());

		waterWarnings.setPreferredSize(new Dimension(250, 200));
		waterWarnings.setContentType("text/html");
		JScrollPane waterScroller = new JScrollPane(waterWarnings, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		waterScroller.setPreferredSize(new Dimension(250, 200));
		this.add(waterScroller);
		waterWarnings.setText(out.getWaterWarnings());

		Dimension size = new Dimension(700,200);
		setPreferredSize(size);
	}
	
	public void updateWarnings()
	{
		conclusions.setText(out.getConclusions());
		socialWarnings.setText(out.getSocialWarnings());
		waterWarnings.setText(out.getWaterWarnings());
	}

	public void scrollToTop()
	{
		conclusions.setCaretPosition(0);
		waterWarnings.setCaretPosition(0);
		socialWarnings.setCaretPosition(0);
	}
}
