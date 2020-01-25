package com.example.getbean.getbean.component;

import com.example.getbean.getbean.service.AsyncService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Component
public class AsyncComponent {
    private final AsyncService asyncService;

    public AsyncComponent(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @PostConstruct
    public void postConstruct() {
        new Thread(() -> {
            IntStream.rangeClosed(1, 3).forEach(value -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Calling doAsync " + value + " -------");
                    asyncService.doAsync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }).start();
    }
}
