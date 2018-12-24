package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Zscore{

    public static List<ZscoreValue> callZscore() throws Exception { //  to Calculation of z score
        double zScore = 0.0;
        List<ZscoreValue> list = new ArrayList<>();
        try {
            int sum = 0;
            for (int i = 0; i < Count.characters.size(); i++) {
                sum += Count.characters.get(i).getNumber(); // Add all value into sum
            }
            double mean = sum/Count.characters.size(); // Calculate mean

            ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            Future<Double> standardDeviation = service.submit(new StdDeviation());
            for (int i = 0; i < Count.characters.size(); i++) {
                zScore = (Count.characters.get(i).getNumber()-mean)/standardDeviation.get(); //  to Calculate every value's z score
                list.add(new ZscoreValue(zScore));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void ZscoreResult(){ // to  print all z score value
        try {
            int count = 1;
            System.out.println("  Z score value : ");
            for (ZscoreValue value : callZscore()) {
                double zScore = value.getzScore(); // Retrieve every z score value
                if(count==1){
                    System.out.println(count+". A and a: "+ zScore);
                }
                else if(count==2){
                    System.out.println(count+". B and b: "+ zScore);
                }
                else if(count==3){
                    System.out.println(count+". C and c: "+ zScore);
                }
                else if(count==4){
                    System.out.println(count+". D and d: "+ zScore);
                }
                else if(count==5){
                    System.out.println(count+". E and e: "+ zScore);
                }
                else if(count==6){
                    System.out.println(count+". F and f: "+ zScore);
                }
                else if(count==7){
                    System.out.println(count+". G and g: "+ zScore);
                }
                else if(count==8){
                    System.out.println(count+". H and h: "+ zScore);
                }
                else if(count==9){
                    System.out.println(count+". I and i: "+ zScore);
                }
                else if(count==10){
                    System.out.println(count+". J and j: "+ zScore);
                }
                else if(count==11){
                    System.out.println(count+". K and k: "+ zScore);
                }
                else if(count==12){
                    System.out.println(count+". L and l: "+ zScore);
                }
                else if(count==13){
                    System.out.println(count+". M and m: "+ zScore);
                }
                else if(count==14){
                    System.out.println(count+". N and n: "+ zScore);
                }
                else if(count==15){
                    System.out.println(count+". O and o: "+ zScore);
                }
                else if(count==16){
                    System.out.println(count+". P and p: "+ zScore);
                }
                else if(count==17){
                    System.out.println(count+". Q and q: "+ zScore);
                }
                else if(count==18){
                    System.out.println(count+". R and r: "+ zScore);
                }
                else if(count==19){
                    System.out.println(count+". S and s: "+ zScore);
                }
                else if(count==20){
                    System.out.println(count+". T and t: "+ zScore);
                }
                else if(count==21){
                    System.out.println(count+". U and u: "+ zScore);
                }
                else if(count==22){
                    System.out.println(count+". V and v: "+ zScore);
                }
                else if(count==23){
                    System.out.println(count+". W and w: "+ zScore);
                }
                else if(count==24){
                    System.out.println(count+". X and x: "+ zScore);
                }
                else if(count==25){
                    System.out.println(count+". Y and y: "+ zScore);
                }
                else if(count==26){
                    System.out.println(count+". Z and z: "+ zScore);
                }
                count++;
            }
            System.out.println(" ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}