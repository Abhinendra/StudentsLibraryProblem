package com.company;

import java.util.Random;

public class Student implements Runnable {
    private int id;
    private Book[] book;
    private boolean isRun = true;
    private int count = 0;

    public void setRun(boolean run) {
        isRun = run;
    }

    @Override
    public String toString() {
        return "Student" + this.id;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public Student(int id, Book[] book) {
        this.id = id;
        this.book = book;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (isRun) {
            int id = random.nextInt(Constants.NUMBER_OF_BOOKS);
            try {
                book[id].read(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
