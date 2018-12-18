package View;

import Model.Model;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;


import java.awt.event.ActionEvent;
import java.awt.GridLayout;

/*
	addFishFrame opens a selector GUI where a button can be clicked to pick a fish
	The name of this fish is passed to the model as a string, from where the fish data should be computed
*/
public class addFishPanel extends JPanel
{
	private Model m;
	private ArrayList<String> fishNames;
	private Fishtank fishtank;

	public addFishPanel(Model m, Fishtank fishtank)
	{
		this.m = m;
		this.fishtank = fishtank;
		//this.setPreferredSize(size);
                this.setLayout(new GridLayout());

		fishNames = m.getAllFishByString();

		addFish("GoldFish");
		addFish("Corydora");
		addFish("Beta");
		addFish("Cardinal");
		addFish("Endler");
		addFish("FireNeon");
		addFish("Guppy");
		addFish("MoonFish");
		addFish("Pleco");
		addFish("Red Cherry Shrimp");
		addFish("Red Crystal Shrimp");

		fishtank.setAddFishPanel(this);

		//this.setResizable(false);
		//this.setTitle("Select a fish to add");

		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.pack();
		//this.setLocationRelativeTo(null);
		//this.setVisible(true);
	}

	public void addFish(String fishName){
		JButton fishButton = new JButton(fishName);
		if(!m.canAddFish(fishName) || fishNames.contains(fishName)){
			fishButton.setEnabled(false);
			if(fishNames.contains(fishName)){
				fishButton.setToolTipText("Can't add " + fishName + " because the fish is already added.\n");
			}else{
				fishButton.setToolTipText(m.canAddFishProblems(fishName));
			}
		}
		fishButton.addActionListener(new fishButtonAction(m, fishName, fishtank));
		this.add(fishButton);
	}
}

class fishButtonAction extends AbstractAction{
	Model m;
	String fishName;
	Fishtank fishtank;
	fishButtonAction(Model m, String fishName, Fishtank fishtank){
		this.m = m;
		this.fishName = fishName;
		this.fishtank = fishtank;
	}

//	@Override
	public void actionPerformed(ActionEvent e){
		m.addFishByString(fishName);
		fishtank.setAddFishButton();
	}

}
