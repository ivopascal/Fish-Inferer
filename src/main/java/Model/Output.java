package Model;

import View.TextPanel;

public class Output
{
    private String conclusion;

    private String water;
    private String generalWater;
    private String temp;
    private String pH;

    private String social;
    private String groupSize;
    private String gender;
    private String size;
    private String predators;
    private String incompatibleFish;

    private int generalWaterErrors;
    private int tempErrors;
    private int pHErrors;

    private int groupSizeErrors;
    private int genderErrors;
    private int sizeErrors;
    private int predatorErrors;
    private int incompatibleFishErrors;

    public TextPanel textPanel;
    public Model m;

    public Output(Model m)
    {
		this.m=m;
        resetWarnings();
        this.textPanel = new TextPanel(this);
    }

    public void resetWarnings()
    {
        conclusion = "<h1><center>Hit &#62Analyze&#60;<br> to evaluate!</center><h1>";


        water = "<h2>All Water Issues:</h2>";
        generalWater = "<h4>General Water Issues: </h4>None so far<br>";
        temp = "<h4>Temperature Issues: </h4>None so far<br>";
        pH = "<h4>pH Issues: </h4>None so far<br>";

        social = "<h2>All Social Issues:</h2>";
        groupSize = "<h4>Group size Issues: </h4>None so far<br>";
        gender = "<h4>Gender Issues: </h4>None so far<br>";
        size = "<h4>Aquarium size Issues: </h4>None so far<br>";
        predators = "<h4>Predator Issues: </h4>None so far<br>";
        incompatibleFish = "<h4>Incompatible Fish: </h4>None so far<br>";

        generalWaterErrors = 0;
        tempErrors = 0;
        pHErrors = 0;

        groupSizeErrors = 0;
        genderErrors = 0;
        sizeErrors = 0;
        predatorErrors = 0;
        incompatibleFishErrors = 0;
    }

    public void printWarnings()
    {
        textPanel.updateWarnings();
        textPanel.scrollToTop();
    }

    public String getSocialWarnings()
    {
        return social + "<br>"
                + groupSize + "<br>"
                + gender + "<br>"
                + size + "<br>"
                + predators + "<br>"
                + incompatibleFish + "<br>";
    }

    public String getWaterWarnings()
    {
        return  water + "<br>"
                + generalWater + "<br>"
                + temp + "<br>"
                + pH + "<br>";
    }

    public String getConclusions()
    {
        return this.conclusion;
    }

    public void setConclusion(String conclusion)
    {
        this.conclusion = conclusion;
    }

    public int getGeneralWaterErrors()
    {
        return generalWaterErrors;
    }

    public int getTempErrors()
    {
        return tempErrors;
    }

    public int getpHErrors()
    {
        return pHErrors;
    }

    public int getGroupSizeErrors()
    {
        return groupSizeErrors;
    }

    public int getGenderErrors()
    {
        return genderErrors;
    }

    public int getSizeErrors()
    {
        return sizeErrors;
    }

    public int getPredatorErrors()
    {
        return predatorErrors;
    }

    public int getIncompatibleFishErrors()
    {
        return incompatibleFishErrors;
    }

    private String removeNoneSoFar(String s)
    {
        return s.substring(0, s.length() - 15);
    }

    public void addGeneralWaterWarning(String paramName, float paramValue, float idealValue)
    {
        if (paramName.equals("NITRITE"))
        {
            if (generalWaterErrors == 0) generalWater = removeNoneSoFar(generalWater);
            generalWaterErrors += 1;
            generalWater += "Nitrite too high: Max: " + idealValue + "<br>";
        }
        if (paramName.equals("NITRATE"))
        {
            if (generalWaterErrors == 0) generalWater = removeNoneSoFar(generalWater);
            generalWaterErrors += 1;
            generalWater += "Nitrate too high: Max: " + idealValue + "<br>";
        }
        if (paramName.equals("CHLORINE"))
        {
            if (generalWaterErrors == 0) generalWater = removeNoneSoFar(generalWater);
            generalWaterErrors += 1;
            generalWater += "Chlorine too high: Max: " + idealValue + "<br>";
        }
    }

    public void addWaterWarning(String paramName, Fish f, float paramValue)
    {
        if (paramName.equals("TEMP"))
        {
            if (tempErrors == 0) temp = removeNoneSoFar(temp);
            tempErrors += 1;
            double min = f.getMinTemp();
            double max = f.getMaxTemp();
            if(m.temp_unit.equals("F"))
            {
				min = min * 9 / 5 + 32;
				max = max * 9 / 5 + 32;
			}
            temp += min + " &#60 " + shorten(f.getFishName()) + " &#60 " + max + "\n";
        }
        if (paramName.equals("PH"))
        {
            if (pHErrors == 0) pH = removeNoneSoFar(pH);
            pHErrors += 1;
            pH += f.getMinpH() + " &#60 " + shorten(f.getFishName()) + " &#60 " + f.getMaxpH() + "<br>";
        }
    }

    // group size (social)
    public void addGroupSizeWarning(Fish f, int fishCount)
    {
        if (groupSizeErrors == 0) groupSize = removeNoneSoFar(groupSize);
        groupSizeErrors += 1;
        if (fishCount < f.getMinGroupSize())
        {
            groupSize += "Min: " + f.getMinGroupSize() + " " + shorten(f.getFishName()) + "'s. (" + fishCount + ")<br>";
        }
        else
        {
			groupSize += "Max: " + f.getMaxGroupSize() + " " + shorten(f.getFishName()) + "'s. (" + fishCount + ")<br>";
        }
    }

    // gender (social)
    public void addGenderWarning(int maleCount, int femaleCount)
    {
        if (genderErrors == 0) gender = removeNoneSoFar(gender);
        genderErrors += 1;
        if (maleCount > 1 && femaleCount % maleCount == 0)
        {
            maleCount /= maleCount;
            femaleCount /= maleCount;
        }
        gender += "Guppy M:F ratio must be at <br>    least 1:3. Currently " + maleCount + ":" + femaleCount + "<br>";
    }

    // aquarium size (social)
    public void addAquariumSizeWarning(int totalPoints, int tankVolume)
    {
        if (sizeErrors == 0) size = removeNoneSoFar(size);
        sizeErrors += 1;
        if (totalPoints > tankVolume)
        {
            size += "The aquarium is too full!<br>";
        }
        else
        {
            size += "The aquarium is nearly full.<br>";
        }
    }

    // predators (social)
    // combine these warnings? if two fish types eat one, say that in one warning not two
    public void addPredatorWarning(Fish smallerFish, Fish biggerFish)
    {
        if (predatorErrors == 0) predators = removeNoneSoFar(predators);
        predatorErrors += 1;
        predators += shorten(biggerFish.getFishName()) + " eats " + shorten(smallerFish.getFishName()) + "<br>";
    }

    public void addIncompatibleFishWarning(Fish f1, Fish f2, String conflictingParamName)
    {
        if (incompatibleFishErrors == 0) incompatibleFish = removeNoneSoFar(incompatibleFish);
        incompatibleFishErrors += 1;
        incompatibleFish += shorten(f1.getFishName()) + " can never be kept with " + shorten(f2.getFishName())
                + " because of incompatible " + conflictingParamName + " requirements. <br><br>";
    }

    private String shorten(String fishname)
    {
        if (fishname.equals("Red Crystal Shrimp"))
        {
            return "Crystal Shrimp";
        }
        if (fishname.equals("Red Cherry Shrimp"))
        {
            return "Cherry Shrimp";
        }
        return fishname;
    }
}
