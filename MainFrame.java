import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class MainFrame extends JFrame{
	public MainFrame(Model m){
		MainPanel p = new MainPanel(m);
		this.add(p, BorderLayout.CENTER);
		WaterPanel w = new WaterPanel(m);
		this.add(w, BorderLayout.LINE_START);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1050, 680));
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
