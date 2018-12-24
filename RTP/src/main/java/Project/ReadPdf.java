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

public class ReadPdf {
    public final static List<Row> rows = new ArrayList<>();

    public static void read() throws IOException {
        Path path= Paths.get("C:\\Users\\User\\IdeaProjects\\RTP\\TestPDFfiles"); // Change file name here!
        try(Stream<Path> subPaths= Files.walk(path)){
            List<String> subPathList=subPaths.filter(Files::isRegularFile).map(Objects::toString).collect(Collectors.toList());

            for (int i=0;i<subPathList.size();i++){
        //Load the pdf file
        PDDocument document = PDDocument.load(new File(subPathList.get(i).trim()));
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);

        //Instantiate PDFTextStripper and retrieving text form PDF document
        PDFTextStripper tStripper = new PDFTextStripper();
                String text = stripper.getText(document);
                Scanner scan = new Scanner(text);
                //Save data to Row class
                while (scan.hasNextLine())
                {
                    String line = scan.nextLine();
                    String upperCase=line.toUpperCase();
                    rows.add(new Row(upperCase));
                }
                document.close(); // Close all pdf running
            }
        }
    }
}