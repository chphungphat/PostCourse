package com.example.demo;

import com.example.demo.service.MyClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        MyClass myClass = context.getBean(MyClass.class);
        myClass.methodOne();
        myClass.methodTwo();
        try {
            myClass.methodThree();
        } catch (Exception exception) {
            System.out.println("Exception was caught");
        }
    }

}
