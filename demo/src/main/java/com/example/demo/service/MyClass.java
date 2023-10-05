package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class MyClass {
    public void methodOne() {
        System.out.println("Method One was called");
    }

    public void methodTwo() {
        System.out.println("It's not method one, it's method two");
    }

    public void methodThree() {
        System.out.println("Method three is here just to suffering");
        throw new RuntimeException("Exception is call");
    }
}
