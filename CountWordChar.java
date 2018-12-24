import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CountWordChar {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        int noOfFile;
        Scanner input = new Scanner(System.in);

        for (noOfFile = 1; noOfFile <= 5; noOfFile++) {

            System.out.println("Enter the name of file: ");
            String fileName = input.nextLine();

            //Create the list that contain all the task
            File file = new File("C:\\Users\\Lenovo\\Desktop\\TestPDFfiles\\" + fileName + ".pdf");

            if (file.exists()) {
                List<FutureTask<Integer>> futureWord = new ArrayList<FutureTask<Integer>>();
                List<FutureTask<Integer>> futureChar = new ArrayList<FutureTask<Integer>>();

                //Create a task for the current String
                FutureTask<Integer> nextWord = new FutureTask<Integer>(new WordCounter(file) {
                });
                FutureTask<Integer> nextChar = new FutureTask<Integer>(new CharCounter(file) {
                });

                //Add the task to the list of tasks
                futureWord.add(nextWord);
                futureChar.add(nextChar);

                //Provide the task to a new Thread
                new Thread(nextWord).start();
                new Thread(nextChar).start();

                int calcWord = 0;
                int calcChar = 0;

                //Iterate over all the task
                for (FutureTask<Integer> task : futureWord) {
                    calcWord += task.get(); //occur two unhandled exception

                }

                System.out.println("Total words: " + calcWord);

                for (FutureTask<Integer> task : futureChar) {
                    calcChar += task.get(); //occur two unhandled exception
                }

                System.out.println("Total characters: " + calcChar);

            }
            else {
                System.out.println("file not found!");
            }
            System.out.println();
        }
    }
}
