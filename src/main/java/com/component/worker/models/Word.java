package com.component.worker.models;

public class Word {
    private String text = "";
    private int value = 1;

    public Word(String word) {
        this.text = word;
    }

    public String getWord(){
        return this.text;
    }

    public void increment() {
        this.value++;
    }

    @Override
    public String toString(){
        String test = String.valueOf(this.value);
        return String.format("{ \"word\":\"%s\", \"amount\":\"%b\" }", this.value, test);
    }
}
