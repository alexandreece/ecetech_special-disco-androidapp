package com.example.lama.lamapp.SQLite;

/**
 * Created by alex on 06/12/2016.
 */

public class Word {

    private int idWord;
    private String category;
    private String word;

    public Word(int idWord, String category, String word) {
        this.idWord = idWord;
        this.category = category;
        this.word = word;
    }

    public Word(String category, String word) {
        this.category = category;
        this.word = word;
    }

    public Word() {
    }

    public int getIdWord() {
        return idWord;
    }

    public void setIdWord(int idWord) {
        this.idWord = idWord;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "idWord=" + idWord +
                ", category='" + category + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
