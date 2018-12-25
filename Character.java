package Project;

public class Character implements Comparable<Character>
{
    private String character;
    private int number;

    public Character(String character, int number)
    {
        this.character = character;
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

    @Override
    public int compareTo(Character o)
    {
        int compare = Integer.compare(number,o.number);
        if(compare==0) {
            compare=character.compareTo(o.character);
        }
        return compare;
    }

    public String toString()
    {
        return "Character "+character+", number is "+number;
    }
}