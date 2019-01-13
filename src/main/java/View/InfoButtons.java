package View;

import Controller.addButtonAction;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InfoButtons extends JPanel
{
	public InfoButtons(Model m)
	{
		// parameters can also go in the model
		String[] buttons = m.getInfoButtonStrings();
		GridLayout layout = new GridLayout(buttons.length, 1);
		this.setLayout(layout);

		for (String buttonText : buttons)
		{
			JButton l = new JButton(buttonText);
			this.add(l);

			if(buttonText.equals("> Analyze <"))
			{
				l.addActionListener(new addButtonAction(m));
			}
			else
			{
				l.addActionListener(new popUpAction(buttonText));
			}
		}

		Dimension size = new Dimension(m.paramsWidth, m.totalHeight);
		this.setPreferredSize(size);
	}
}

class popUpAction extends AbstractAction
{
	private String buttonText;
	public popUpAction(String buttonText)
	{
		this.buttonText = buttonText;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFrame infoBox = new JFrame();
		JEditorPane textBox = new JEditorPane("text/html", "");
		//textBox.setLineWrap(true);
        	//textBox.setWrapStyleWord(true);
		JScrollPane areaScrollPane = new JScrollPane(textBox);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(600, 600));
		infoBox.add(areaScrollPane);
		
		
		String text;
		switch(buttonText){
			case "Algae Info":
				text =
" <p>Algae in the aquarium might be the greatest nuisance for every tank keeper, " +
		"be it in a classic social tank, an aquascape, a biotope aquarium or in breeding " +
		"tanks for fish or shrimp. When confronted with an algal infestation, many aquarium " +
		"keepers simply give up their beautiful hobby. However, there are good ways to get a " +
		"grip on these pests, to fight them off or to prevent them from spreading." +
		"</p><h3>What are algae?</h3><p>The term 'algae' is basically a comprehensive term for a " +
		"vast number of different organisms. All   plants not belonging to the mosses (liverworts, " +
		"true mosses and hornworts) or the higher plants (ferns, Lycopodiopsida and seed-bearing plants), " +
		"are classified as algae. Amongst them we have microscopic unicellular organisms and thread-like " +
		"forms as well as the so-called macroscopic algae, like seaweeds, some of which can reach a length " +
		"of up to 60 meters. For life on Earth, algae are crucial.<br>Just like germs, i.e. viruses, " +
		"bacteria and other microorganisms, the smallest algae forms are omnipresent in our environment. " +
		"There are some algae that float in the air passively, the so-called aeroplankton, in order to reach " +
		"new places to inhabit. For our aquaria, this means that their omnipresence makes an aquarium that " +
		"is absolutely free from algae practically impossible.</p><h3>The myth of the algae-free tank</h3><p>" +
		"The reasons stated above make it pretty clear that algae form a part of every aquarium. There are no " +
		"aquaria without any algae, despite the most dedicated care. Of course there are tanks that do not have " +
		"any obvious algal growth, however, we cannot see the tiniest microscopic algae (most of them are unicellular) " +
		"that are mostly present in the biofilms. Biofilms form on all the surfaces in the aquarium, and besides " +
		"algae, they contain different microorganisms. They are nothing that needs to be removed, on the contrary - " +
		"biofilms are all-important for the biological balance of a tank. Moreover, many aquarium inhabitants " +
		"feed on biofilm, which is great food for them.<br>During the cycling phase of a tank, when the biological " +
		"system is still finding its stability, a certain algae population is perfectly normal. Diatoms will " +
		"form during the first few days to weeks, and after that, in their place, green algae will form. In " +
		"the long run, however, it is possible to have an aquarium without visible algae, and this is even " +
		"realistic for beginning aquarium keepers. Just keep some basic things in mind and inform yourself about " +
		"the reasons for the formation of algae.</p><h3>Reasons</h3><p>As we have already mentioned, especially " +
		"during the first few weeks in the life of an aquarium, the formation of algae is very probable. Frequently, " +
		"the ecological balance has not yet been established in such a tank. In this case, you'll need to be patient " +
		"until the system is balanced. The relation of algae to aquatic plants is not yet balanced in the beginning " +
		"either. Stronger plant growth will shift it towards the plants, at the detriment of the algae. For this " +
		"reason it is rather important to start the tank with a good plant population and to use fast-growing stem " +
		"plants.<br>Until the tank has found its biological balance we recommend controlling the algae with specific " +
		"measures for each kind. First and foremost, the use of a sufficiently large number of algae eaters is " +
		"recommendable.</p> <p>Source:https://www.aquasabi.com/aquascaping-wiki_algae_algae-in-the-aquarium</p>";
				break;
			case "Stress":
				text = 
"<h2>How Stress Can Affect Your Fishes’ Health</h2><p>Stress is a critical factor in fish health. It " +
		"is so important, in fact, that scientists have studied it in detail, both in the wild and in captive fish. " +
		"Stress is a very complicated subject that permeates every aspect of fish-keeping.</p><p>" +
		"<strong>'Stressors'</strong></p><p>The primary rule to remember with stress is that, as the " +
		"saying goes, prevention is better than cure. The things that cause stress in a fish’s life (“stressors”) " +
		"include overcrowding, handling, a poor or unfavorable environment, inappropriate or aggressive fish " +
		"sharing the same tank and, in the wild, predators. All of these (and others) cause fish to react in " +
		"different ways depending on the type and amount of stress.</p><p>Fish have evolved and " +
		"live in a relatively stable environment. Their stress responses are consequently better at handling " +
		"short-term trouble and are not as well-suited to long-term environmental stressors. Unfortunately, both " +
		"types of stress can cause problems.</p><p><strong>Short-term Stress</strong></p><p>For short" +
		"-term stress, the most common reaction is one everybody recognizes -- to flee from danger. In the wild, " +
		"the cause is frequently a predator. In captivity, it can be a net that causes the reaction, as the keeper " +
		"tries to capture a fish for closer examination or transfer to another tank.</p><p>When a " +
		"fish senses this kind of danger, it triggers a short-term alarm reaction by releasing hormones, including " +
		"adrenalin for its locomotory muscles. This will give it a shot of energy to escape quickly. The fish also " +
		"releases cortisol. Problems occur because the fish’s body exchanges long-term health for a short-term " +
		"boost to relieve the cause of stress -- the adrenalin disturbs the fish’s natural osmoregulation (the " +
		"balance of salt and water in its body) and the cortisol affects white blood cells and reduces the " +
		"effectiveness of the immune system.</p><p>Once the panic has passed, the fish must also " +
		"regain its natural balance. This can take hours or days, even after only a short period of stress.</p><p>" +
		"<strong>Long-term Stress</strong></p><p>Long-term changes, such " +
		"as a poor or unsuitable environment, are handled with the same initial response – an alarm message to " +
		"escape. However, if escape is impossible, the fish does not stop being stressed: it begins to adapt to " +
		"the new environment as best it can.</p><p>At first, the fish’s body tends to overreact but, " +
		"with time, it will adapt to reach the best possible balance – physiologically and behaviorally. Throughout " +
		"the period of adaptation, the fish still prioritizes reacting to the new environment and remains stressed, " +
		"so its immune system suffers and it is prone to disease. Adaptation normally lasts from four to six weeks." +
		"</p><p>However, if the fish continues to be in stressful conditions, such as a constantly " +
		"deteriorating environment or endless bullying from aggressive tankmates, it continues to try to adapt and " +
		"extends all the bodily responses as long as necessary. This reduces its chance of survival. In the worst " +
		"possible situation, where adaptation to the new environment is impossible (such as putting marine fish in " +
		"fresh water), the fish will exhaust itself fatally.</p><p>As a fishkeeper, it is extremely " +
		"important to consider the effects of stress. Planning ahead, careful control of the environment and " +
		"management of the fish population are fundamental basics in fishkeeping. Less stress means less disease." +
		"</p><p>Source: https://www.petmd.com/fish/care/evr_fi_stress_in_fish?page=show</p>";
				break;
			case "Lighting":
				text =
"<h1> What You Should Know About Aquarium Lighting </h1> <p> Aquarium lighting is both a design feature and a " +
		"practical necessity. The soft inner illumination of a lighted aquarium makes it an important element of " +
		"room decor. And both the fish and the live plants in your aquarium require light in order to thrive. But " +
		"determining how much light the fish and plants need, and controlling that amount, can be tricky. In general, " +
		"most aquariums require 8 to 12 hours of light each day (10 hours is a good starting point), at least some " +
		"of which needs to be provided by supplemental aquarium lights. </p> <h3> Light Needs for Live Aquatic Plants " +
		"</h3> <p> A primary reason for using supplemental aquarium lighting is to provide the light necessary for " +
		"living aquatic plants to perform their necessary photosynthesis. Just like land-based plants, aquatic plants " +
		"use light to synthesize food from carbon dioxide and water, and they obtain this light both from ambient " +
		"room light and from supplemental aquarium lighting. <br>If there are live plants in the aquarium, the " +
		"supplemental lighting period will probably need to be maximized. Plants require as much as 12 hours of " +
		"light per day, but the precise length of time will depend on the aquarium setup and species of plants. " +
		"If, on the other hand, your tank has no living aquatic plants, your lighting needs will be less—only " +
		"what's necessary for the fish.<br>It is usually recommended that the aquatic plants in your aquarium be " +
		"matched to the type of fish you are keeping: tropical plants for tanks with tropical fish; temperate " +
		"cold-water plants for tanks with cold-water species. So light levels should also be chosen to match the " +
		"natural inclination of the plants.<br>Tropical plants that will thrive on roughly 12 hours of light each " +
		"day, all year long, include the banana, Amazon, Java, and fern plants. Cold water plants that do best " +
		"with seasonal variation in light levels include the Anubias species and tiger lotus.<br>When you introduce " +
		"new live plants to your aquarium, it is best to leave the light on for longer periods of time; this gives " +
		"the plants a better chance to take root and grow vigorously as they're getting established. </p> <h3>Light " +
		"Needs for Different Fish Species</h3> <p>When it comes to the fish themselves, aquarium lighting is mostly " +
		"about you, not them. Lighting in an aquarium tank makes it easier for you to see and enjoy your fish, but " +
		"it usually doesn't affect the fish all that much. The nature of an aquarium, with its four glass sides " +
		"and relatively small size, means that most fish are getting more light than they do in natural settings, " +
		"whether or not you are using supplemental lights. Most fish don't mind getting more light. A few species, " +
		"such as cichlids and tetras, thrive on less light, and for these, too much supplemental aquarium lighting " +
		"may affect them negatively.<br>Consider the conditions that a species experiences in the wild when " +
		"determining how much extra lighting, if any, is required. Tropical fish have evolved under conditions that " +
		"provided roughly 12 hours of light each day, so logic suggests that an aquarium with tropical fish will " +
		"likely need a combination of ambient and aquarium lighting for roughly half the day. On the other hand, " +
		"cold-water species such as goldfish, minnows, ricefish, and danios (zebrafish) are from temperate climate " +
		"zones where the daylight hours vary according to the season. Here, you might want to vary the amount of " +
		"light over the course of the year. To create a more natural environment, match the length of aquarium " +
		"lighting to what the species experiences in its native environment. </p> <h3Light and Algae Levels</h3> " +
		"<p>If excess algae is a problem in the tank, a contributing factor is usually too much light. Algae are " +
		"tiny plants, and too much light causes too much algae growth. Reducing the time the aquarium lights are on " +
		"to eight hours, or a bit less if necessary, will help reduce the algae growth.<br>Monitoring algae levels " +
		"can, therefore, help you determine if your lighting levels are appropriate. If you begin to see excessive " +
		"algae, shorten the periods of light to retard the algae growth. But remember that it's also possible to " +
		"have too little algae in an aquarium. Algae are a food source for some fish species, so you don't want to " +
		"eliminate algae altogether—just control it. <br>Direct sunlight tends to create more algae than does " +
		"artificial light. An aquarium near a sunny window may require less supplemental lighting than one on an " +
		"interior wall. </p> <h3>Controlling Lighting in Your Aquarium</h3> <p>The biggest obstacle to maintaining " +
		"a uniform period of aquarium lighting is that owners find it difficult to turn the lights on and off at " +
		"the same time each day. Fortunately, there is an inexpensive and easy way to remedy that problem.<br>" +
		"Purchase an inexpensive on-off timer and plug the lighting unit into it. Set the on and off times to obtain " +
		"the desired period of light. On-off timers are highly recommended for all aquarium owners.</p> <p>" +
		"Source:https://www.thesprucepets.com/how-long-should-aquarium-lights-be-left-on-1380774</p>";
				break;
			case "Cleaning":
				text =
"<h1>Routine Aquarium Maintenance</h1> <p>A large part of keeping your fish healthy is ensuring that their habitat " +
		"remains healthy. Regular maintenance is key to keeping the aquarium environment safe. One roadblock for " +
		"aquarium owners is knowing what maintenance they should perform. Experts may disagree on the specific points " +
		"of aquarium maintenance, but everyone agrees that following a regular routine of any kind is better than no " +
		"maintenance at all. This is my recommended routine aquarium maintenance plan.</p> <h3>Why Do Maintenance?" +
		"</h3> <p>Often aquarium owners don't give much thought to maintenance. After all, they have a filter, and " +
		"some bottom feeding fish to pick up stuff that falls there. So what else is needed? Some will cite the fact " +
		"that nobody is cleaning the rivers, lakes, and oceans, and they do fine. So why clean the aquarium? That's " +
		"actually a good question. Mother Nature is not idle, she does a pretty good job of cleaning things up in the " +
		"great outdoors. Lakes, rivers, and oceans are large bodies of water that have currents and waves circulating " +
		"the water. Rain falling adds fresh water, and live plants produce oxygen while absorbing carbon dioxide. " +
		"The sheer volume of water also serves to dilute any harmful toxins.<br>Unlike bodies of water in nature, an " +
		"aquarium is a relatively small amount of water. Add to that the fact that it is a closed system, and it " +
		"becomes quite different than a habitat in nature. Nothing goes into or out of the tank unless you have a hand " +
		"in making it happen. Filters certainly help, but if not maintained filters become clogged and can cause more " +
		"harm than good. Meanwhile fish continue to produce waste, uneaten food decays, and potentially harmful " +
		"byproducts slowly build up. The only way an aquarium will remain clean is if you take the time to perform " +
		"maintenance on a regular basis. Otherwise, over time the habitat will become less and less healthy for the " +
		"fish.<p> <h3>Frequency of Maintenance</h3> <p>It is neither practical nor healthy to clean every surface in " +
		"the aquarium on daily or even weekly basis. For that matter, it's never wise to clean everything at the same " +
		"time. To minimize the impact cleaning has on beneficial bacteria, cleaning of colony rich areas, such as the " +
		"filter and the substrate, should be staggered. If the bacterial colonies are disturbed too much, it can " +
		"disrupt the nitrogen cycle enough to cause a spike in ammonia and/or nitrites. For that reason, it's also " +
		"wise to test the water a few days after a significant cleaning, to ensure nothing is amiss.</p> <h3>Daily</h3> " +
		"<p> Do a quick visual check of the aquarium to ensure the filter is running at full strength, the lights are " +
		"functioning properly, and any other equipment you have is running normally. Check the temperature to ensure " +
		"it's in the proper range. Count the fish and check if they appear healthy. A good time to do this is when you " +
		"feed them, as they will be out and easy to observe. Once they have finished eating, examine the tank to see " +
		"if there is uneaten food remaining on the bottom. If you notice that there is often uneaten food left after " +
		"ten minutes, cut back on the volume of food you give your fish at each feeding. Should you notice that " +
		"uneaten food starts building up on the bottom of the tank, use a siphon to remove it. If the water level has " +
		"dropped, top it off with treated or aged water as needed.<br>This is a good time to start an aquarium journal " +
		"or log if you haven't done so already. While there is no need to record everything, it is helpful to note " +
		"anything out of the ordinary on your daily checks. That way you can catch trends that may be occurring. For " +
		"instance, the temperature dropping by a degree isn't a huge deal, but if it drops a degree four days in a " +
		"row, that's a tip-off that something may be wrong with your heater. All of this can be done in literally a " +
		"matter of minutes, so it's not a huge time investment.</p> <h3> Weekly/Bi-Weekly </h3> <p> I am a proponent " +
		"of weekly partial water changes, while others prefer to do them every other week. As long as you are " +
		"regularly performing partial water changes every couple of weeks, the exact frequency is not so critical. " +
		"Use water that is treated, and if possible, aged. Replacement water should be close to the temperature of the " +
		"aquarium. However, prior to performing the water change, perform the other weekly and every other week tasks " +
		"first, leaving the partial water change as the last task.<br> The other task that should be performed every " +
		"week or two is general cleaning of the tank. By performing light cleaning every couple of weeks, your tank " +
		"will never get overly dirty. Wipe down the outside tank surfaces with a non-ammonia aquarium safe cleanser, " +
		"or simply use a damp cloth. Gently shake plants, whether they are live or artificial, to dislodge debris. " +
		"Scrape the inside glass to remove any algae, then take a break for ten or fifteen minutes and let everything " +
		"settle a bit. When you come back, gently siphon the substrate to remove debris.<br>Lastly, perform a partial " +
		"water change. </p> <h3>Monthly</h3> <p> Water testing should be performed monthly to ensure nothing unseen " +
		"is brewing. I recommend testing the following parameters: pH, ammonia, nitrite, and nitrate. If you have " +
		"algae problems, you may also test for phosphates to see if that may be part of the root cause. Perform water " +
		"tests first before water changes and any other maintenance. If you have live plants, inspect them and remove " +
		"any dead leaves, and trim excess growth.<br>Next perform the weekly/biweekly cleaning tasks, followed by the " +
		"partial water change. Save a bucket of the water removed from the tank to use for performing filter maintenance. " +
		"If you use exhaustible media, such as activated carbon or zeolite, replace it. Using the water saved from " +
		"the water change, rinse the mechanical media. If the mechanical media is very clogged, replace it. However, " +
		"avoid replacing all the filter media at the same time. Instead, retain part of the media to avoid losing too " +
		"large a portion of the beneficial biological colonies. The next month you can replace the remaining filter " +
		"media. Mechanical filter media (such as foam) generally only has to be replaced once or twice a year. </p> " +
		"<h3> Cleaning Equipment</h3> <p>Aquarium maintenance does not require a lot of equipment. However, it does " +
		"help to have a few specialized tools on hand. The most important piece of equipment to have is a dedicated " +
		"aquarium bucket, and make sure you do not use it for anything else. Having two buckets is helpful, but not " +
		"absolutely necessary. In addition to the bucket, a siphon, water conditioner, algae scrubber, filter brush, " +
		"aquarium-safe glass cleaner, soft cloth and some towels round out your cleaning materials. All of these items " +
		"can be stored inside the aquarium bucket to make cleaning day quick and easy. Additionally, you'll need fresh " +
		"filter media and if you have live plants, fertilizer, and small scissors to trim the plants.</p> <p> " +
		"Source: https://www.thesprucepets.com/routine-aquarium-maintenance-1381084 </p>";
				break;
			case "Info":
				text =
		"<h1> How to use </h1> "+
		"<p> The Aquarium diagnoser is a tool to help you identify problems with your aquarium, " +
		"or to help you select a community of fish that would live together harmoniously in a tank. <br>" +
		"If you want to diagnose any issues with your aquarium you can enter the data in the text boxes on the left. " +
		"The units for temperature and volume can be set with the buttons below, the units for nitrite, nitrate and chlorine " +
		"are set to parts per million (ppm), and pH to mol per liter. To measure these values in the appropriate units you can "+
		"buy a set of test strips or use any other water measuring techniques. They will generally output in the right units. <br>"+
		"You can add the fish that you currently have in your aquarium with the Add Fish button at the top, and then select the fish "+
		"that you want to add. Also be aware of the gender that you select. If you have more than one of the same fish you should add "+
		"it the correct number of times. <br>" +
		"When all the parameters are set and all the fish are added you can click the analyze butten on the lower left and any errors "+
		"will show up in the white areas below the aquarium. <br>" +
		"If you want to remove a fish you can double click the image of the fish in the aquarium. If you want to remove all fish and "+
		"the parameters you should click the clear button in the lower left corner. You can remove and change individual parameters "+
		"at any time, just make sure that you click analyze when you are done. <br>" +
		"If you are interested in more aquarium related info you can click the buttons on the right side, which will show some more "+
		"information on how to set up and maintain your tank.</p>"+
		"<h3> Development </h3> "+
		"This project was developed by Travis Hammond, Helma Koops and Ivo de Jong, in an attempt to center the information " +
		"about fish keeping and fish parameters, and to perform the logical operations to determine whether the tank is "+
		"in a good set up. It was developed as a project for University Groningen." +
		"<h3> Sources </h3> " +
		"This project has used several online sources and an expert source. Article sources at the info popups are shown at the bottom " +
		"of these popups. Below we will compile all the sources used for the images of our fish and the aquarium.";
				break;
			default:
				text = "No text dialog found.";
				break;

		}

		textBox.setText(text);
		textBox.setEditable(false);
		textBox.setCaretPosition(0);

		infoBox.setLocationRelativeTo(null);
		infoBox.setResizable(false);
		infoBox.setTitle(buttonText);
		infoBox.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		infoBox.pack();
		infoBox.setVisible(true);
	}
}



