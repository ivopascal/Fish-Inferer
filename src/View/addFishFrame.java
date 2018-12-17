import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;


/*
	addFishFrame opens a selector GUI where a button can be clicked to pick a fish
	The name of this fish is passed to the model as a string, from where the fish data should be computed
*/
class addFishFrame extends JFrame
{
	private Model m;
	private ArrayList<String> fishNames;
	// this is some ugly shit but it works (barely)
	addFishFrame(Model m)
	{
		this.m = m;
		this.setLayout(new FlowLayout());
		Dimension size = new Dimension(m.totalWidth, m.totalHeight);
		//this.setPreferredSize(size);
		fishNames = m.getAllFishByString();

		addFish("GoldFish");
		addFish("Corydora");
		addFish("Beta");

		this.setResizable(false);
		this.setTitle("Select a fish to add");

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addFish(String fishName){
		JButton fishButton = new JButton(fishName);
		if(!m.canAddFish(fishName) || fishNames.contains(fishName)){
			fishButton.setEnabled(false);
		}
		fishButton.addActionListener(new fishButtonAction(m, fishName, this));
		this.add(fishButton);
	}
}

class fishButtonAction extends AbstractAction{
	Model m;
	String fishName;
	JFrame fishFrame;
	fishButtonAction(Model m, String fishName, JFrame fishFrame){
		this.m = m;
		this.fishName = fishName;
		this.fishFrame  = fishFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		m.addFishByString(fishName);
		fishFrame.dispose();	//Closes the frame after a fish is selected

	}

}
