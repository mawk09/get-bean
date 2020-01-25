package com.example.getbean.getbean.component;

import com.example.getbean.getbean.service.AsyncService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AsyncComponent {
    private final AsyncService asyncService;

    public AsyncComponent(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @PostConstruct
    public void postConstruct() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Calling doAsync");
                asyncService.doAsync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
