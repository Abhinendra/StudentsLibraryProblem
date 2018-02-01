package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);
        Student[] students = new Student[Constants.NUMBER_OF_STUDENTS];
        Book[] books = new Book[Constants.NUMBER_OF_BOOKS];
        for (int index = 0; index < Constants.NUMBER_OF_BOOKS; index++) {
            books[index] = new Book(index);
        }

        for (int index = 0; index < Constants.NUMBER_OF_STUDENTS; index++) {
            students[index] = new Student(index, books);
            executorService.execute(students[index]);
        }

        Thread.sleep(6000);
        for (Student student : students) {
            student.setRun(false);
        }
        executorService.shutdown();
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
        for(Student student:students){
            System.out.println(student +" read "+student.getCount() +" times");
        }
    }
}
