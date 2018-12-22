package Model;

public class Output {
    private String general;
    private String temp;
    private String pH;
    private String groupSize;
    private String predators;

    private int tempErrors;
    private int pHErrors;
    private int groupSizeErrors;
    private int predatorErrors;

    public Output()
    {
        resetWarnings();
    }

    public void resetWarnings()
    {
        general = "Current Warnings:";
        temp = "Temperature Issues: None so far";
        pH = "pH Issues: None so far";
        groupSize = "GroupSize Issues: None so far";
        predators = "Predator Issues: None so far";

        tempErrors = 0;
        pHErrors = 0;
        groupSizeErrors = 0;
        predatorErrors = 0;
    }

    public void printWarnings()
    {
        System.out.println("\n" + general + "\n" + temp + "\n" + pH + "\n" + groupSize + "\n" + predators + "\n");
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
            temp += f.getFishName() + " --> (Temp: " + paramValue + " Min: " + f.getMinTemp() + " Max: " + f.getMaxTemp() + ") ";
        }
        if (paramName.equals("PH"))
        {
            if (pHErrors == 0) pH = removeNoneSoFar(pH);
            pHErrors += 1;
            pH += f.getFishName() + " --> (pH: " + paramValue + " Min: " + f.getMinpH() + " Max: " + f.getMaxpH() + ") ";
        }
    }

    // group size
    public void addSocialWarning(Fish f, int fishCount)
    {
        if (groupSizeErrors == 0) groupSize = removeNoneSoFar(groupSize);
        groupSizeErrors += 1;
        groupSize += f.getFishName() + " --> (Count: " + fishCount +
                " Min: " + f.getMinGroupSize() + " Max: " + f.getMaxGroupSize() + ") ";
    }

    // predators
    // combine these warnings? if two fish types eat one, say that in one warning not two
    public void addSocialWarning(Fish smallerFish, Fish biggerFish)
    {
        if (predatorErrors == 0) predators = removeNoneSoFar(predators);
        predatorErrors += 1;
        predators += "(" + biggerFish.getFishName() + " will eat " + smallerFish.getFishName() + ") ";
    }
}
