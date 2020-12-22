package Variant.B;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends  Thread{

    Semaphore semaphore;
    CountDownLatch cdl;
    private int ticketPrice= 50;

    public PassengerThread(String name,Semaphore semaphore, CountDownLatch cdl) {
        super(name);
        this.semaphore = semaphore;
        this.cdl = cdl;

    }

    public void run() {
        try {

            System.out.println(getName() + " прибыл на автовагзал ");
            semaphore.acquire();
            System.out.println(getName() + " подощел к кассе и купил билет за "+ticketPrice +" рублей");
            sleep(1000);
            //semaphore.release();
            System.out.println(getName()+" купил билет и занимает место в автобусе ");



        }catch (Exception e){}finally {
            cdl.countDown();
            semaphore.release();
        }
    }
}
