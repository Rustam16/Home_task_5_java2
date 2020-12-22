package Variant.A;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {
    private CountDownLatch cdl;


    public Uploader(String name, CountDownLatch cdl) {
        super(name);

        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            System.out.println(" Начелось загрузка из сервера");

            for (int i = 0; i < 20; i++) {
                sleep(111);
                System.out.print("\uD83D\uDFE5");
            }
                sleep(1000);
            System.out.println("\n загрузка завершена \n");
            cdl.countDown();
        } catch (Exception e) {
        }
    }
}
