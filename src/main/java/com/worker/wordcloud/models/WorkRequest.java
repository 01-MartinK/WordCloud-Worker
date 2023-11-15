package com.worker.wordcloud.models;

import java.util.ArrayList;
import java.util.List;

public class WorkRequest {
    private Long code;
    private List<String> words;
    private List<String> excludedWords;

    WorkRequest(){
        excludedWords = new ArrayList<>();
    }

    public Long getCode() {
        return code;
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getExcludedWords() {
        return excludedWords;
    }

    public WorkRequest(Long code) {
        this.code = code;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void setExcludedWords(List<String> excludedWords) {
        this.excludedWords = excludedWords;
    }
}
