package com.javarush.khmelov.lesson19;

import java.util.concurrent.atomic.AtomicInteger;

public class ExploreAtomic {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
    }
}
