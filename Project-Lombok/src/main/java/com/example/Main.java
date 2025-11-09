package com.example;

import lombok.*;

public class Main {
    public static void main(String [] args) {
        System.out.println("Hello");

        val a = "Hello";
        var dummy = 1002;
    }

    public void dummyMethod(@NonNull String id) {
        System.out.println("Id is: "+ id);
    }
}
