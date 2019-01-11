package Model;

import View.TextPanel;

public class Output
{
    private String generalWater;
    private String temp;
    private String pH;
    private String social;
    private String predators;

    private int generalWaterErrors;
    private int tempErrors;
    private int pHErrors;
    private int socialErrors;
    private int predatorErrors;

    public TextPanel textPanel;

    public Output()
    {
        resetWarnings();
        this.textPanel = new TextPanel(this);
    }

    public void resetWarnings()
    {
        generalWater = "General Water Issues: \nNone so far\n";
        temp = "Temperature Issues: \nNone so far\n";
        pH = "pH Issues: \nNone so far\n";
        social = "Social Issues: \nNone so far\n";
        predators = "Predator Issues: \nNone so far\n";

        generalWaterErrors = 0;
        tempErrors = 0;
        pHErrors = 0;
        socialErrors = 0;
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

    public String getSocialWarnings()
    {
        return social;
    }

    public String getPredatorsWarnings()
    {
        return predators;
    }

    public String getGeneralWaterWarnings()
    {
        return generalWater;
    }

    private String removeNoneSoFar(String s)
    {
        return s.substring(0, s.length() - 12);
    }

    public void addGeneralWaterWarning(String paramName, float paramValue, float idealValue)
    {
        if (paramName.equals("NITRITE"))
        {
            if (generalWaterErrors == 0) generalWater = removeNoneSoFar(generalWater);
            generalWaterErrors += 1;
            generalWater += "Nitrite too high: Max: " + idealValue + "\n";
        }
        if (paramName.equals("NITRATE"))
        {
            if (generalWaterErrors == 0) generalWater = removeNoneSoFar(generalWater);
            generalWaterErrors += 1;
            generalWater += "Nitrate too high: Max: " + idealValue + "\n";
        }
        if (paramName.equals("CHLORINE"))
        {
            if (generalWaterErrors == 0) generalWater = removeNoneSoFar(generalWater);
            generalWaterErrors += 1;
            generalWater += "Chlorine too high: Max: " + idealValue + "\n";
        }
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

    // group size (social)
    public void addGroupSizeWarning(Fish f, int fishCount)
    {
        if (socialErrors == 0) social = removeNoneSoFar(social);
        socialErrors += 1;
        if (fishCount < f.getMinGroupSize())
        {
            social += "Min: " + f.getMinGroupSize() + " " + f.getFishName() + "'s. Current: " + fishCount + "\n";
        }
        else
        {
            social += "Max: " + f.getMaxGroupSize() + " " + f.getFishName() + "'s. Current: " + fishCount + "\n";
        }
    }

    // gender (social)
    public void addGenderWarning(int maleCount, int femaleCount)
    {
        if (socialErrors == 0) social = removeNoneSoFar(social);
        socialErrors += 1;
        if (maleCount > 1 && femaleCount % maleCount == 0)
        {
            maleCount /= maleCount;
            femaleCount /= maleCount;
        }
        social += "Guppy M:F ratio must be at \n    least 1:3. Currently " + maleCount + ":" + femaleCount + "\n";
    }

    // aquarium size (social)
    public void addAquariumSizeWarning(int totalPoints, int tankVolume)
    {
        if (socialErrors == 0) social = removeNoneSoFar(social);
        socialErrors += 1;
        if (totalPoints > tankVolume)
        {
            social += "The aquarium is too full!\n";
        }
        else
        {
            social += "The aquarium is nearly full.\n";
        }
    }

    // predators
    // combine these warnings? if two fish types eat one, say that in one warning not two
    public void addPredatorWarning(Fish smallerFish, Fish biggerFish)
    {
        if (predatorErrors == 0) predators = removeNoneSoFar(predators);
        predatorErrors += 1;
        predators += biggerFish.getFishName() + " eats " + smallerFish.getFishName() + "\n";
    }
}
