package com.designpaterns;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<Integer> c = String::valueOf;

        c.accept(1111);

    }

    public static void test(String a){

    }
}
