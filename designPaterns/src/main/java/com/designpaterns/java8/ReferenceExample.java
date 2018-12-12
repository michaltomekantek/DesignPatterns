package com.designpaterns.java8;

import java.net.InterfaceAddress;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ReferenceExample {

    public void test(){
        Consumer<String> consumerTest = ReferenceExample::consumerTest;
        consumerTest.accept("Consumer");

        BiConsumer<String, Integer> bigConsumerTest = ReferenceExample::bigPredicateTest;
        bigConsumerTest.accept("BiConsumer", 3);

        TriFunction2<String, Integer, String> triFunctionTest = ReferenceExample::triFunctionTest;
        triFunctionTest.apply("BiConsumer", 3, "tri");

        Supplier<TestClass> consumerNonStaticMethod = TestClass::new;

        TriFunction<TestClass, String, String, String> lambda =
                (TestClass s, String p, String arg2) -> s.testTwoArgument(p, arg2);

        TriFunction<TestClass, String, String, String> ref = TestClass::testTwoArgument;

        ConsumerNonStatic<TestClass, String, String> ref2 = TestClass::testOneArgument;

        ConsumerNonStaticNoArgument<TestClass> ref3 = TestClass::testNoArgument;
    }

    public static void consumerTest(String message){
        System.out.println(message);
    }

    public static void bigPredicateTest(String message, int value ){
        System.out.println(message + " " + value) ;
    }

    public static void triFunctionTest(String message, int value, String test){
        System.out.println(message + " " + value + "tri") ;
    }


    public interface TriFunction2<T,U,V>{
        void apply(T t, U u, V v);
    }

    public interface ConsumerNonStatic<T, U, R>{
        R apply(T t, U u);
    }

    public interface ConsumerNonStaticNoArgument<T>{
        void apply(T t);
    }

    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }


    class Sum {
        Integer doSum(String s1, String s2) {
            return Integer.parseInt(s1) + Integer.parseInt(s1);
        }
    }

}
