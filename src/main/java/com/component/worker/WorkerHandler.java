package com.component.worker;

import com.component.worker.models.Worker;
import com.component.worker.models.wordcloud.Wordcloud;
import com.component.worker.models.wordcloud.WordcloudRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerHandler {

    public static WorkerHandler workerHandler;
    public static List<Worker> workers = new ArrayList<>();
    private final WordcloudRepository wordRepository;
    public WorkerHandler(WordcloudRepository wordRepository) {
        this.wordRepository = wordRepository;
        workerHandler = this;
    }

    public void createWorker(List<String> wordList, List<String> exclusionList, Long code) {
        Worker worker = new Worker(code);
        worker.setWordList(wordList, exclusionList);
        workers.add(worker);
        worker.calculateWordCloud();
    }

    public void ChangeStatus(Long id, int status) {
        Wordcloud wordcloud = wordRepository.findById(id).get();
        wordcloud.setStatus(status);
        wordRepository.save(wordcloud);
    }

    public void ChangeWordlist(Long id, String list) {
        Wordcloud wordcloud = wordRepository.findById(id).get();
        wordcloud.setWordList(list);
        wordRepository.save(wordcloud);
    }
}
