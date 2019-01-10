package Model;

import View.TextPanel;

public class Output
{
    private String temp;
    private String pH;
    private String groupSize;
    private String predators;

    private int tempErrors;
    private int pHErrors;
    private int groupSizeErrors;
    private int predatorErrors;

    public TextPanel textPanel;

    public Output()
    {
        resetWarnings();
        this.textPanel = new TextPanel(this);
    }

    public void resetWarnings()
    {
        temp = "Temperature Issues: \nNone so far";
        pH = "pH Issues: \nNone so far";
        groupSize = "GroupSize Issues: \nNone so far";
        predators = "Predator Issues: \nNone so far";

        tempErrors = 0;
        pHErrors = 0;
        groupSizeErrors = 0;
        predatorErrors = 0;
    }

    public void printWarnings()
    {
        textPanel.updateWarnings();
    }

    public String getTempWarnings()
    {
        return temp;
    }

    public String getpHWarnings()
    {
        return pH;
    }

    public String getGroupSizeWarnings()
    {
        return groupSize;
    }

    public String getPredatorsWarnings()
    {
        return predators;
    }

    private String removeNoneSoFar(String s)
    {
        return s.substring(0, s.length() - 11);
    }

    public void addWaterWarning(String paramName, Fish f, float paramValue)
    {
        if (paramName.equals("TEMP"))
        {
            if (tempErrors == 0) temp = removeNoneSoFar(temp);
            tempErrors += 1;
            temp += f.getMinTemp() + " < " + f.getFishName() + " < " + f.getMaxTemp() + "\n";
        }
        if (paramName.equals("PH"))
        {
            if (pHErrors == 0) pH = removeNoneSoFar(pH);
            pHErrors += 1;
            pH += f.getMinpH() + " < " + f.getFishName() + " < " + f.getMaxpH() + "\n";
        }
    }

    // group size
    public void addSocialWarning(Fish f, int fishCount)
    {
        if (groupSizeErrors == 0) groupSize = removeNoneSoFar(groupSize);
        groupSizeErrors += 1;
        groupSize += "Min: " + f.getMinGroupSize() + " " + f.getFishName() + "'s. Current: " + fishCount + "\n";
    }

    // predators
    // combine these warnings? if two fish types eat one, say that in one warning not two
    public void addSocialWarning(Fish smallerFish, Fish biggerFish)
    {
        if (predatorErrors == 0) predators = removeNoneSoFar(predators);
        predatorErrors += 1;
        predators += biggerFish.getFishName() + " eats " + smallerFish.getFishName() + "\n";
    }
}
