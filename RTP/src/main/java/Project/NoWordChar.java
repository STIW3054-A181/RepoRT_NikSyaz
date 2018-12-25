package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class NoWordChar extends RecursiveAction
{
    private static int count = 0;
    public  static int countChar = 0;
    private static int cA,cB,cC,cD,cE,cF,cG,cH,cI,cJ,cK,cL,cM,cN,cO,cP,cQ,cR,cS,cT,cU,cV,cW,cX,cY,cZ;

    public final static List<Character> characters = new ArrayList<>();
    private List<RetrieveFile.Data> list;
    private int first,last;

    public NoWordChar(List<RetrieveFile.Data> list, int first, int size) {
        this.list = list;
        this.first = first;
        this.last = size;
    }

    protected void compute() {
        if(last-first>10) {
            int middle=(first+last)/2;
            NoWordChar t1 = new NoWordChar(list,first,middle+1);
            NoWordChar t2 = new NoWordChar(list,middle+1,last);
            t1.fork();
            t2.fork();
        }else
            {
                calculateCount();
            }
    }

    private void calculateCount()
    {
        for (int i=first;i<last;i++)
        {
            RetrieveFile.Data line= RetrieveFile.theData.get(i);
            char column=' ';

            for (int j=0;j<line.getData().length();j++)
            {
                if (line.getData().charAt(j)==column)
                {
                    count++;
                }
                char character=line.getData().charAt(j);

                switch (character)
                {
                    case 'A':
                        cA++;
                        countChar++;
                        break;

                    case 'B':
                        cB++;
                        countChar++;
                        break;

                    case 'C':
                        cC++;
                        countChar++;
                        break;
                    case 'D':
                        cD++;
                        countChar++;
                        break;

                    case 'E':
                        cE++;
                        countChar++;
                        break;

                    case 'F':
                        cF++;
                        countChar++;
                        break;

                    case 'G':
                        cG++;
                        countChar++;
                        break;

                    case 'H':
                        cH++;
                        countChar++;
                        break;

                    case 'I':
                        cI++;
                        countChar++;
                        break;

                    case 'J':
                        cJ++;
                        countChar++;
                        break;

                    case 'K':
                        cK++;
                        countChar++;
                        break;

                    case 'L':
                        cL++;
                        countChar++;
                        break;

                    case 'M':
                        cM++;
                        countChar++;
                        break;

                    case 'N':
                        cN++;
                        countChar++;
                        break;

                    case 'O':
                        cO++;
                        countChar++;
                        break;

                    case 'P':
                        cP++;
                        countChar++;
                        break;

                    case 'Q':
                        cQ++;
                        countChar++;
                        break;

                    case 'R':
                        cR++;
                        countChar++;
                        break;

                    case 'S':
                        cS++;
                        countChar++;
                        break;

                    case 'T':
                        cT++;
                        countChar++;
                        break;

                    case 'U':
                        cU++;
                        countChar++;
                        break;

                    case 'V':
                        cV++;
                        countChar++;
                        break;

                    case 'W':
                        cW++;
                        countChar++;
                        break;

                    case 'X':
                        cX++;
                        countChar++;
                        break;

                    case 'Y':
                        cY++;
                        countChar++;
                        break;

                    case 'Z':
                        cZ++;
                        countChar++;
                        break;

                    default:
                        break;
                }
            }
        }
    }

    public static void result()
    {
        System.out.println("\nThe result of words from PDF files: "+count);
        System.out.println("The result of characters from PDF files: "+countChar);

        characters.add(new Character("A",cA));
        characters.add(new Character("B",cB));
        characters.add(new Character("C",cC));
        characters.add(new Character("D",cD));
        characters.add(new Character("E",cE));
        characters.add(new Character("F",cF));
        characters.add(new Character("G",cG));
        characters.add(new Character("H",cH));
        characters.add(new Character("I",cI));
        characters.add(new Character("J",cJ));
        characters.add(new Character("K",cK));
        characters.add(new Character("L",cL));
        characters.add(new Character("M",cM));
        characters.add(new Character("N",cN));
        characters.add(new Character("O",cO));
        characters.add(new Character("P",cP));
        characters.add(new Character("Q",cQ));
        characters.add(new Character("R",cR));
        characters.add(new Character("S",cS));
        characters.add(new Character("T",cT));
        characters.add(new Character("U",cU));
        characters.add(new Character("V",cV));
        characters.add(new Character("W",cW));
        characters.add(new Character("X",cX));
        characters.add(new Character("Y",cY));
        characters.add(new Character("Z",cZ));
    }
}