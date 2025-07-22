package com.javarush.khmelov.lesson19;

import java.util.concurrent.locks.ReentrantLock;

public class ExploreReenteredLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
    }
}
