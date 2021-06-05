package com.company;

public class WordContainer {
    private String word;
    private int count;

    WordContainer(String arg) {
        word = arg;
        count = 0;
    }

    public void setCount() {
        this.count += 1;
    }

    public String getWord() {
        return word;
    }

    public String toString() {
        return "Word: " + this.word + "\n" +
                "Count: " + this.count + "\n";
    }
}
