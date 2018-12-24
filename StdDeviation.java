package Project;

import java.util.concurrent.*;

public class StdDeviation implements Callable        // Calculate standard deviation
{
    @Override
    public Double call() throws Exception
    {
        int all = 0;
        for (int a=0;a<Count.characters.size();a++)
        {
            all+=Count.characters.get(a).getNumber(); // Sum all the value
        }
        double mean=all/Count.characters.size(); // Calculation of mean
        double valueData = 0;
        for (int b=0;b<Count.characters.size();b++)
        {
            valueData+=Math.pow(Count.characters.get(b).getNumber()-mean,2); // Result of x-mean
        }
        double stdDeviation=Math.sqrt(valueData/Count.characters.size()); // Calculation of standard deviation
        return stdDeviation;
    }
    public static void result() throws ExecutionException, InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Double> stdDeviation = service.submit(new StdDeviation());
        System.out.println("\nStandard deviation value: "+stdDeviation.get() +"\n");
        Thread.sleep(1000);
    }
}
