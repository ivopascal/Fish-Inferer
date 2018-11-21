import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class GUI extends JFrame
{
	public GUI(Model m)
	{
		Fishtank fishtank = new Fishtank();
		this.add(fishtank, BorderLayout.CENTER);
		Parameters params = new Parameters(m);
		this.add(params, BorderLayout.LINE_START);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1050, 680));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
