package Variant.A;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        CountDownLatch uplouder = new CountDownLatch(1);
        CountDownLatch dowlounder = new CountDownLatch(10);
        Semaphore semaphore = new Semaphore(3, true);

        Uploader uploader = new Uploader("", uplouder);
        uploader.start();
        for (int i = 1; i <11 ; i++) {
            new Downlounder("Person "+ i,uplouder,dowlounder,semaphore ).start();
        }

        try {
            dowlounder.await();
            System.out.println("файл удалился из сервера ~ \uD83D\uDDD1️");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

