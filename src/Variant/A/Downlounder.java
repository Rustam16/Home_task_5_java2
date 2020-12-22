package Variant.A;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downlounder  extends Thread{

   private CountDownLatch uploader;
   private CountDownLatch downlounder;
   private Semaphore semaphore;

    public Downlounder(String name, CountDownLatch uploader, CountDownLatch downlounder, Semaphore semaphore) {
        super(name);
        this.uploader = uploader;
        this.downlounder = downlounder;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            uploader.await();
            System.out.println(getName() +" Начал загрузку");
            semaphore.acquire();
            sleep(1000);
            uploader.await();
            sleep(1000);
            System.out.println(getName() + " Завершил загрузку");
            downlounder.countDown();
            semaphore.release();

        }catch (Exception e){}

    }
}
