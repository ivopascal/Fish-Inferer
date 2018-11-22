import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Parameters extends JPanel
{
	public Parameters(Model m)
	{
        this.add(new JTextField("Temperature", 15));
        this.add(new JTextField("pH", 15));
        this.add(new JTextField("GH", 15));
        this.add(new JTextField("other param", 15));

		SpringLayout layout = new SpringLayout();
		Dimension size = new Dimension(m.paramsWidth, m.totalHeight);
		setLayout(layout);
		setPreferredSize(size);
	}
}
