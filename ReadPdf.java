package Project;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class ReadPdf extends RecursiveAction {
    public final static List<Read> read = new ArrayList<>();

    public static void read() throws IOException {

        //Load the pdf file
        PDDocument document = PDDocument.load(new File(Common.PDF));
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition(true);

        //Instantiate PDFTextStripper and retrieving text form PDF document
        PDFTextStripper tStripper = new PDFTextStripper();
        String pdfFileInText = tStripper.getText(document);

        //System.out.println(pdfFileInText);

        Scanner scan = new Scanner(pdfFileInText);

        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String upperCase = line.toUpperCase();
            read.add(new Read(upperCase));
        }
        document.close();
    }

    @Override
    protected void compute() {

    }
}
