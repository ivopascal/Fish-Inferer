package View;

import Model.Model;

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
	private Fishtank fishtank;

	public addFishPanel(Model m, Fishtank fishtank)
	{
		this.m = m;
		this.fishtank = fishtank;
		this.setLayout(new GridLayout());

		for (String fishName : m.getFishStrings())
		{
			addFish(fishName);
		}

		fishtank.setAddFishPanel(this);

		//this.setResizable(false);
		//this.setTitle("Select a fish to add");

		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.pack();
		//this.setLocationRelativeTo(null);
		//this.setVisible(true);
	}

	public void addFish(String fishName)
	{
		JButton fishButton = new JButton(fishName);

		// we should always allow adding because otherwise we run into problems when
		// adding one fish although there need to be at least X of them. I think we
		// should just show the warnings instead, and make them as informative as possible
/*
		if(!m.canAddFish(fishName) || fishNames.contains(fishName)){
			fishButton.setEnabled(false);
			if(fishNames.contains(fishName)){
				fishButton.setToolTipText("Can't add " + fishName + " because the fish is already added.\n");
			}else{
				fishButton.setToolTipText(m.canAddFishProblems(fishName));
			}
		}
*/
		fishButton.addActionListener(new fishButtonAction(m, fishName, fishtank));
		this.add(fishButton);
	}
}

class fishButtonAction extends AbstractAction
{
	Model m;
	String fishName;
	Fishtank fishtank;

	fishButtonAction(Model m, String fishName, Fishtank fishtank)
	{
		this.m = m;
		this.fishName = fishName;
		this.fishtank = fishtank;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		m.addFishByString(fishName);
		fishtank.setAddFishButton();
	}
}
