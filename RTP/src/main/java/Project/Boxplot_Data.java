package Project;

import static Project.Zscore.callZscore;

public class Boxplot_Data
{
    public void boxplotCalNDisplay()
    {
        try
        {
            int count = 0;
            for (Zscore.ZscoreValue size : callZscore())
            {
                count++; // Get size for double type array
            }
            double[]box = new double[count];
            int i = 0;
            for (Zscore.ZscoreValue value : callZscore())
            {
                double zScore = value.getzScore(); // Retrieve z score value from Zscore.java
                box[i] = zScore; // Assign current z score value into specific index of array
                i++;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
