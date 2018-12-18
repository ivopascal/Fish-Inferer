package View;

import Model.Model;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class GUI extends JFrame
{
	public GUI(Model m)
	{
		Dimension size = new Dimension(m.totalWidth, m.totalHeight);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(size);

		Fishtank fishtank = new Fishtank(m);
		this.add(fishtank, BorderLayout.CENTER);
		Parameters params = new Parameters(m);
		this.add(params, BorderLayout.WEST);
		InfoButtons buttons = new InfoButtons(m);
		this.add(buttons, BorderLayout.EAST);

		this.setResizable(false);
		this.setTitle("The Aquarium Diagnoser");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
