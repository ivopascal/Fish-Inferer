import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

class Parameters extends JPanel
{
	Parameters(Model m)
	{
		// these are stacking directly on top of each other...
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
