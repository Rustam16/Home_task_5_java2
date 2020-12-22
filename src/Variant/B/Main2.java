package Variant.B;

import com.sun.jdi.InternalException;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(4, true);
        CountDownLatch cdl = new CountDownLatch(20);
        for (int i = 1; i <= 20; i++) {
            new PassengerThread("Passenger " + i, semaphore, cdl).start();
        }
            try{
               // Thread.sleep(444);
                cdl.await();
            }catch (Exception e){}



        if (cdl.getCount() <= 0){
            System.out.println("Автобус заполнен ,теперь он едет в ош");
        }

    }


}
