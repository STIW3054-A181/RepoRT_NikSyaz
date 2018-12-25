package Project;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RetrieveFile
{
    public final static List<Data> theData = new ArrayList<>();

    public static void read() throws IOException
    {
        Path path= Paths.get(Project.File.PDF);
        try(Stream<Path> subPaths= Files.walk(path)){
            List<String> subPathList=subPaths.filter(Files::isRegularFile).map(Objects::toString).collect(Collectors.toList());

            for (int i=0;i<subPathList.size();i++)
            {
                PDDocument document = PDDocument.load(new File(subPathList.get(i).trim()));
                PDFTextStripper stripper = new PDFTextStripper();
                stripper.setSortByPosition(true);

                String text = stripper.getText(document);
                Scanner scan = new Scanner(text);

                while (scan.hasNextLine())
                {
                    String line = scan.nextLine();
                    String upperCase = line.toUpperCase();
                    theData.add(new Data(upperCase));
                }
                document.close();
            }
        }
    }

    public static class Data
    {
        private final String data;

        public Data(String data)
        {
            this.data = data;
        }

        public String getData()
        {
            return data;
        }
    }
}