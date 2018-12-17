package Project;

public class Char implements Comparable<Char> {
    private String character;
    private int number;

    public Char(String character, int number) {
        this.character = character;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Char o) {
        int compare = Integer.compare(number,o.number);
        if(compare==0) {
            compare=character.compareTo(o.character);
        }
        return compare;
    }

    public String toString() {
        return "Character "+character+", number is "+number;
    }
}
