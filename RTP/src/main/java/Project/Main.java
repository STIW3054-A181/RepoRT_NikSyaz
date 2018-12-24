package Project;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class Main
{
    public static void main(String args[]) throws IOException, InterruptedException, ExecutionException
    {
        try
        {
            long start = System.currentTimeMillis();
            ReadPdf.read();
            List<Row> list = ReadPdf.rows;
            Count task = new Count(list, 0, list.size());
            ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            pool.invoke(task);

            /*do
                {
                System.out.printf(Thread.currentThread().getName() + "- Parallelism: %d\n", pool.getParallelism());
                System.out.printf(Thread.currentThread().getName() + "- Active Thread: %d\n", pool.getActiveThreadCount());
                System.out.printf(Thread.currentThread().getName() + "- Task Count: %d\n", pool.getQueuedTaskCount());
                System.out.printf(Thread.currentThread().getName() + "- Pool size: %d\n", pool.getPoolSize());
                //TimeUnit.MILLISECONDS.sleep(5);
            }while (!task.isDone());*/

            pool.shutdown();
            System.out.println(" ");
            if (task.isCompletedNormally()){
            //  System.out.println("\nThe process has completed normally.");
            }

            //Thread.sleep(500);
            /*try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            Count.result();
            Thread.sleep(1000);
            //ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            StdDeviation.result();
            Thread.sleep(1000);

            Zscore.ZscoreResult();
            Thread.sleep(1000);

            //long end=System.currentTimeMillis();
            //long duration=end-start;

            Normalization.test();;
            Normalization.getChart();
            Thread.sleep(1000);

            BoxPlot box_plot = new BoxPlot("Box Plot");
            box_plot.pack();
            box_plot.setVisible(true);
            Thread.sleep(1000);
            System.out.println("End of the program");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //System.out.println("\nRunning is: "+duration+"ms.");
}