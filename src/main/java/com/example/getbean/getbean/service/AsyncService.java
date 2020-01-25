package com.example.getbean.getbean.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Async
    public void doAsync() {
        SecondService secondService = applicationContext.getBean(SecondService.class);
        System.out.println(secondService);
        ThirdService thirdService = applicationContext.getBean(ThirdService.class);
        System.out.println(thirdService);
        FirstService firstService = applicationContext.getBean(FirstService.class, secondService, thirdService);
        System.out.println("firstService__" + firstService + "__Second__" + firstService.getSecondService() + "__Third__" + firstService.getThirdService());
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
