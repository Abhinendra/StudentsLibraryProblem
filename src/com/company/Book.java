package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    private int id;
    private Lock reentrantLock;

    public Book(int id){
        this.id=id;
        reentrantLock=new ReentrantLock();
    }

    @Override
    public String toString() {
        return "Book " +this.id;
    }

    public void read(Student student) throws InterruptedException {
        if(reentrantLock.tryLock(10, TimeUnit.MILLISECONDS)){
            System.out.println(student+ "starts reading "+this);
            student.increaseCount();
            Thread.sleep(250);
            reentrantLock.unlock();
            System.out.println(student+" finished reading "+this);
        }
    }
}
