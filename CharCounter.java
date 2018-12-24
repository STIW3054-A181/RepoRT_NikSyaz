import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class CharCounter implements Callable<Integer> {

    private final File file;

    public CharCounter(File file) {
        this.file = file;
    }

    public Integer call() throws IOException {

        //get and read file line by line
        FileReader fr = new FileReader (file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int totalchar = 0;

            while (line != null) {
                String[] words = line.split(" "); //space aren't counted
                for (String word : words) {

                    totalchar += word.length();

                }

                line = br.readLine();

            }

            br.close();

            return totalchar;

    }
}
