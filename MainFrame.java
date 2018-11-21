import javax.swing.JFrame;
import java.awt.Dimension;

public class MainFrame extends JFrame{
	public MainFrame(Model m){
		MainPanel p = new MainPanel(m);
		this.add(p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1050, 680));
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
