package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Zscore{

    public static List<ZscoreValue> callZscore()
    {
        double zScore = 0.0;
        List<ZscoreValue> list = new ArrayList<>();
        try
        {
            int sum = 0;
            for (int m = 0; m < NoWordChar.characters.size(); m++)
            {
                sum += NoWordChar.characters.get(m).getNumber();
            }
            double mean = sum/NoWordChar.characters.size();

            ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            Future<Double> standardDeviation = service.submit(new StdDev());
            for (int i = 0; i < NoWordChar.characters.size(); i++)
            {
                zScore = (NoWordChar.characters.get(i).getNumber()-mean)/standardDeviation.get();
                list.add(new ZscoreValue(zScore));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public static void ZscoreResult()
    {
        try
        {
            int count = 1;
            System.out.println("\n\nThe result of Z-score value: \n");
            for (ZscoreValue value : callZscore()) {
                double zScore = value.getzScore();
                if(count==1){
                    System.out.printf(count+") Total A: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==2){
                    System.out.printf(count+") Total B: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==3){
                    System.out.printf(count+") Total C: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==4){
                    System.out.printf(count+") Total D: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==5){
                    System.out.printf(count+") Total E: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==6){
                    System.out.printf(count+") Total F: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==7){
                    System.out.printf(count+") Total G: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==8){
                    System.out.printf(count+") Total H: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==9){
                    System.out.printf(count+") Total I: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==10){
                    System.out.printf(count+") Total J: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==11){
                    System.out.printf(count+") Total K: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==12){
                    System.out.printf(count+") Total L: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==13){
                    System.out.printf(count+") Total M: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==14){
                    System.out.printf(count+") Total N: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==15){
                    System.out.printf(count+") Total O: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==16){
                    System.out.printf(count+") Total P: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==17){
                    System.out.printf(count+") Total Q: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==18){
                    System.out.printf(count+") Total R: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==19){
                    System.out.printf(count+") Total S: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==20){
                    System.out.printf(count+") Total T: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==21){
                    System.out.printf(count+") Total U: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==22){
                    System.out.printf(count+") Total V: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==23){
                    System.out.printf(count+") Total W: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==24){
                    System.out.printf(count+") Total X: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==25){
                    System.out.printf(count+") Total Y: %4.3f",+ zScore);
                    System.out.println();
                }
                else if(count==26){
                    System.out.printf(count+") Total Z: %4.3f",+ zScore);
                    System.out.println();
                }
                count++;
            }
            System.out.println(" ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static class ZscoreValue
    {
        private double zScore;

        public ZscoreValue(double zScore)
        {
            super();
            this.zScore = zScore;
        }

        public double getzScore()
        {
            return zScore;
        }

    }
}