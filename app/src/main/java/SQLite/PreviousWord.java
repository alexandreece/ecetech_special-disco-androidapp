package SQLite;

/**
 * Created by alex on 06/12/2016.
 */

public class PreviousWord {

    private int idPreviousWord;
    private String previousWord;

    public PreviousWord(int idPreviousWord, String previousWord) {
        this.idPreviousWord = idPreviousWord;
        this.previousWord = previousWord;
    }

    public int getIdPreviousWord() {
        return idPreviousWord;
    }

    public void setIdPreviousWord(int idPreviousWord) {
        this.idPreviousWord = idPreviousWord;
    }

    public String getPreviousWord() {
        return previousWord;
    }

    public void setPreviousWord(String previousWord) {
        this.previousWord = previousWord;
    }

    @Override
    public String toString() {
        return "PreviousWord{" +
                "idPreviousWord=" + idPreviousWord +
                ", previousWord='" + previousWord + '\'' +
                '}';
    }
}
