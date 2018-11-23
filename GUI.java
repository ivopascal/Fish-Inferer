import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

class GUI extends JFrame
{
	GUI(Model m)
	{
		Dimension size = new Dimension(m.totalWidth, m.totalHeight);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(size);

		Fishtank fishtank = new Fishtank(m);
		this.add(fishtank, BorderLayout.CENTER);
		Parameters params = new Parameters(m);
		this.add(params, BorderLayout.WEST);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}
}
