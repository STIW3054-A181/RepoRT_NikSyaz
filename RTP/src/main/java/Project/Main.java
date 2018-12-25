package Project;

import java.util.List;
import java.util.concurrent.*;

public class Main
{
    public static void main(String args[])
    {
        try
        {
            RetrieveFile.read();
            List<RetrieveFile.Data> list = RetrieveFile.theData;
            NoWordChar task = new NoWordChar(list, 0, list.size());
            ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            pool.invoke(task);
            pool.shutdown();

            NoWordChar.result();
            Thread.sleep(1000);

            StdDev.result();
            Thread.sleep(1000);

            Zscore.ZscoreResult();
            Thread.sleep(1000);

            System.out.println("--- Normalization graph ---\n");
            Normalization.test();;
            Normalization.getChart();
            Thread.sleep(1000);

            System.out.println("--- Boxplot ---\n");
            new Boxplot().showInFrame();
            Boxplot_Data display = new Boxplot_Data();
            display.boxplotCalNDisplay();
            Thread.sleep(1000);

            System.out.println("End of the program");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}