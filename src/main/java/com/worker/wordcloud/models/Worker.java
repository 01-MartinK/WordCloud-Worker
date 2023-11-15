package com.worker.wordcloud.models;

import com.google.gson.Gson;
import com.worker.wordcloud.WorkerHandler;

import java.util.ArrayList;
import java.util.List;

public class Worker {

    private Long id;
    private List<String> wordList;
    private List<String> excludedWords;
    private List<Word> calculatedList;

    public Worker(Long id){
        this.id = id;
    }

    public void setWordList(List<String> list, List<String> exludedList) {
        wordList = list;
        excludedWords = exludedList;
        addBasicExclusion();
    }

    public void addBasicExclusion() {
        excludedWords.add("and");
        excludedWords.add("or");
        excludedWords.add("the");
        excludedWords.add("a");
        excludedWords.add(" ");
        excludedWords.add("");
    }

    public void calculateWordCloud() {
        WorkerHandler.workerHandler.ChangeStatus(id, 1);

        calculatedList = new ArrayList<>();
        wordList.forEach(e -> {
            String[] words = e.replaceAll("([?!.,:;])",  " ").split("\\s+");
            for (int i = 0; i < words.length; i++){
                String word = words[i].toLowerCase();
                if (!excludedWords.contains(word) && word.length() > 1)
                    if (hasWord(word)){
                        calculatedList.get(getIndex(word)).increment();
                    }else{
                        calculatedList.add(new Word(word));
                    }
            }
        });
        WorkerHandler.workerHandler.ChangeWordlist(id, new Gson().toJson(calculatedList));
        WorkerHandler.workerHandler.ChangeStatus(id, 2);
    }

    public boolean hasWord(String word) {
        return calculatedList.stream().anyMatch(o -> o.getWord().equals(word));
    }

    public int getIndex(String word) {
        for(int i = 0; i < calculatedList.size(); i++){
            if (calculatedList.get(i).getWord().equals(word)){
                return i;
            }
        }
        return -1;
    }
}
