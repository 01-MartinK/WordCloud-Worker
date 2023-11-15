package com.worker.wordcloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkRequest {
    private List<String> wordList;

    public void setWordList(List<String> list) {
        wordList = list;
    }

    public void calculateWordCloud() {
        List<String> wordsList = new ArrayList<>();
        List<Integer> sizeList = new ArrayList<>();
        wordList.forEach(e -> {
            String[] words = e.split("\\s+");
            for (int i = 0; i < words.length; i++){
                String word = words[i];
                if (wordsList.contains(word)){
                    sizeList.set(wordsList.indexOf(word), sizeList.get( wordsList.indexOf(word) ) +1 );
                }else {
                    wordsList.add(word);
                    sizeList.add(wordsList.indexOf(word), 1);
                }
            }
        });
    }
}
