public class Word implements Comparable<Word> {
    String text;
    int count;

    public Word(String text){
        this.text = text;
        this.count = 1;
    }

    public int compareTo(Word t){
        return t.count - this.count;
    }
}