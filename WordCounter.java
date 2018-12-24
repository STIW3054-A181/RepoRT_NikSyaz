import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class WordCounter implements Callable<Integer> {

    final File file;

    public WordCounter(File file){
        this.file = file;
    }

    public Integer call() throws IOException {

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int totalWord = 0;

            while (line != null) {

                String[] words = line.split(" ");
                totalWord += words.length;

                line = br.readLine();

            }

            br.close();

        return totalWord;
    }
}
