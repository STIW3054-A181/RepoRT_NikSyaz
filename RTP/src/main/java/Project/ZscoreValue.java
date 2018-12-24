package Project;

public class ZscoreValue {
    private double zScore;

    public ZscoreValue(){
        super();
    }

    public ZscoreValue(double zScore){
        super();
        this.zScore = zScore;
    }

    public double getzScore(){
        return zScore;
    }

    public void setzScore(){
        this.zScore = zScore;
    }
}