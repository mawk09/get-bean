package com.example.getbean.getbean.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Scope("prototype")
public class FirstService {
    private final SecondService secondService;
    private ThirdService thirdService;

    public FirstService(SecondService secondService, ThirdService thirdService) {
        this.secondService = secondService;
        this.thirdService = thirdService;
    }

    @PostConstruct
    public void postConstuct() {
        System.out.println("this__" + this + "__Second__" + secondService + "__Third__" + thirdService);
    }

    public SecondService getSecondService() {
        return secondService;
    }

    public ThirdService getThirdService() {
        return thirdService;
    }

    public void setThirdService(ThirdService thirdService) {
        this.thirdService = thirdService;
    }
}

