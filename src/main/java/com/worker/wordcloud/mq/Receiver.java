package com.worker.wordcloud.mq;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.worker.wordcloud.WordCloudWorker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {
    private final CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        if (isValid(message)) {
            List<String> list = new Gson().fromJson(message, List.class);
            if (list.get(0).equals("calculate")){
                list.remove(0);
                WordCloudWorker.createWorker(list);
            }
        }

        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public boolean isValid(String json) {
        try {
            JsonParser.parseString(json);
        } catch (JsonSyntaxException e) {
            return false;
        }
        return true;
    }
}
