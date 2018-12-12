package com.designpaterns.java8;

public class TestClass {

    public TestClass() {
    }


    public String testOneArgument(String t){
        System.out.println("testOneArgument " + TestClass.class);

        return "test";
    }

    public void testNoArgument(){
        System.out.println("testNoArgument " + TestClass.class);
    }

    public String testTwoArgument(String t, String t2){
        System.out.println("testTwoArgument " + TestClass.class);

        return "test";
    }
}
