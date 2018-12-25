package Project;

import java.util.concurrent.*;

public class StdDev implements Callable
{
    @Override
    public Double call()
    {
        int all = 0;
        for (int a=0;a<NoWordChar.characters.size();a++)
        {
            all+=NoWordChar.characters.get(a).getNumber();
        }
        double mean=all/NoWordChar.characters.size();
        double valueData = 0;
        for (int b=0;b<NoWordChar.characters.size();b++)
        {
            valueData+=Math.pow(NoWordChar.characters.get(b).getNumber()-mean,2);
        }
        double stdDeviation=Math.sqrt(valueData/NoWordChar.characters.size());
        return stdDeviation;
    }

    public static void result() throws ExecutionException, InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Double> stdDeviation = service.submit(new StdDev());
        System.out.printf("\nThe total of Standard Deviation: %4.3f",+stdDeviation.get());
        Thread.sleep(1000);
    }
}
