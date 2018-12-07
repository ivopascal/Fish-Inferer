import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

class GUI extends JFrame
{
	// this is some ugly shit but it works (barely)
	GUI(Model m)
	{
		Dimension size = new Dimension(m.totalWidth, m.totalHeight);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(size);

		Fishtank fishtank = new Fishtank(m); 	//This handles the picture, the bottomtext and the addFishButton
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
