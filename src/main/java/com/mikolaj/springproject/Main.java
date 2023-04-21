package com.mikolaj.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class Main {

    RestControl restControl;

    public Main(RestControl restControl) {
        this.restControl = restControl;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

}
