package Project;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) throws IOException, InterruptedException, ExecutionException {
        //long start = System.currentTimeMillis();
        ReadPdf.read();

        List<Read> list = ReadPdf.read;
        Count task=new Count(list,0,list.size());
        ForkJoinPool pool= new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        pool.invoke(task);

       /* do {
            System.out.printf(Thread.currentThread().getName()+"- Parallelism: %d\n",pool.getParallelism());
            System.out.printf(Thread.currentThread().getName()+"- Active Thread: %d\n",pool.getActiveThreadCount());
            System.out.printf(Thread.currentThread().getName()+"- Task Count: %d\n",pool.getQueuedTaskCount());
            System.out.printf(Thread.currentThread().getName()+"- Pool size: %d\n", pool.getPoolSize());
            //TimeUnit.MILLISECONDS.sleep(5);
        }while (!task.isDone()); */

        pool.shutdown();

        //if (task.isCompletedNormally()){
        //  System.out.println("\nThe process has completed normally.");
        //}

        //Thread.sleep(500);
        try{
            TimeUnit.MILLISECONDS.sleep(5);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        Count.result();
        StdDeviation.result();
        System.out.println("\nEnd of the program");
        //long end=System.currentTimeMillis();
        //long duration=end-start;
    }

    //System.out.println("\nRunning is: "+duration+"ms.");

}