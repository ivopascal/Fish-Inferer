import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class GUI extends JFrame
{
	public GUI(Model m)
	{
		Dimension size = new Dimension(m.totalWidth, m.totalHeight);

		Fishtank fishtank = new Fishtank(m);
		this.add(fishtank, BorderLayout.CENTER);
		Parameters params = new Parameters(m);
		this.add(params, BorderLayout.WEST);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(size);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
