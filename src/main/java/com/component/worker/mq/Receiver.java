package com.component.worker.mq;

import com.component.worker.WorkerHandler;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.component.worker.models.WorkRequest;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {
    private final CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        if (isValid(message)) {
            WorkRequest workRequest = new Gson().fromJson(message, WorkRequest.class);
            WorkerHandler.workerHandler.createWorker(workRequest.getWords(), workRequest.getExcludedWords(), workRequest.getCode());
        }
        System.out.println("Received list of <" + message.length() + "> text");
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
