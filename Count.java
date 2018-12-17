package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

public class Count extends RecursiveAction {
    private static final AtomicInteger count = new AtomicInteger();
    public  static int countChar = 0;
    private static int cA,cB,cC,cD,cE,cF,cG,cH,cI,cJ,cK,cL,cM,cN,cO,cP,cQ,cR,cS,cT,cU,cV,cW,cX,cY,cZ;

    public final static List<Char> characters = new ArrayList<>();
    private List<Read> list;
    private int first,last;

    public Count(List<Read> list, int first, int last) {
        this.list = list;
        this.first = first;
        this.last = last;
    }

    protected void compute() {
        if(last-first>6) {
            int middle=(first+last)/2;
            Count t1 = new Count(list,first,middle+1);
            Count t2 = new Count(list,middle+1,last);
            t1.fork();
            t2.fork();
        }
        else {
            System.out.println(Thread.currentThread().getName()+": "+first+" "+last);
            calculateCount();
        }
    }

    private void calculateCount() {
        for (int i=first;i<last;i++)
        {
            Read line = ReadPdf.read.get(i);
            line.getRead().indexOf(" ");
            count.getAndIncrement();

            for (int j=0;j<line.getRead().length();j++){
                char charecter=line.getRead().charAt(j);

                switch (charecter) {
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

    public static void result(){
        System.out.println("\nTotal number of words are: "+count);
        System.out.println("Total number of character are: "+countChar);

        System.out.println("\nTotal number of A or a: "+cA);
        characters.add(new Char("A",cA));

        System.out.println("Total number of B or b: "+cB);
        characters.add(new Char("B",cB));

        System.out.println("Total number of  C or c: "+cC);
        characters.add(new Char("C",cC));

        System.out.println("Total number of D or d: "+cD);
        characters.add(new Char("D",cD));

        System.out.println("Total number of  E or e: "+cE);
        characters.add(new Char("E",cE));

        System.out.println("Total number of F or f: "+cF);
        characters.add(new Char("F",cF));

        System.out.println("Total number of G or g: "+cG);
        characters.add(new Char("G",cG));

        System.out.println("Total number of  H or h: "+cH);
        characters.add(new Char("H",cH));

        System.out.println("Total number of I or i: "+cI);
        characters.add(new Char("I",cI));

        System.out.println("Total number of J or j: "+cJ);
        characters.add(new Char("J",cJ));

        System.out.println("Total number of K or k: "+cK);
        characters.add(new Char("K",cK));

        System.out.println("Total number of L or l: "+cL);
        characters.add(new Char("L",cL));

        System.out.println("Total number of M or m: "+cM);
        characters.add(new Char("M",cM));

        System.out.println("Total number of N or n: "+cN);
        characters.add(new Char("N",cN));

        System.out.println("Total number of O or o: "+cO);
        characters.add(new Char("O",cO));

        System.out.println("Total number of P or p: "+cP);
        characters.add(new Char("P",cP));

        System.out.println("Total number of Q or q: "+cQ);
        characters.add(new Char("Q",cQ));

        System.out.println("Total number of R or r: "+cR);
        characters.add(new Char("R",cR));

        System.out.println("Total number of S or s: "+cS);
        characters.add(new Char("S",cS));

        System.out.println("Total number of T or t: "+cT);
        characters.add(new Char("T",cT));

        System.out.println("Total number of U or u: "+cU);
        characters.add(new Char("U",cU));

        System.out.println("Total number of V or v: "+cV);
        characters.add(new Char("V",cV));

        System.out.println("Total number of W or w: "+cW);
        characters.add(new Char("W",cW));

        System.out.println("Total number of X or x: "+cX);
        characters.add(new Char("X",cX));

        System.out.println("Total number of Y or y: "+cY);
        characters.add(new Char("Y",cY));

        System.out.println("Total number of Z or z: "+cZ);
        characters.add(new Char("Z",cZ));
    }
}