
/**
 * Created by niuanqi on 2017/6/30.
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

 class sea {
    private static Lock lock = new ReentrantLock();
    private static class T1 extends Thread {
        @Override
        public void run() {
            System.out.println("线程1启动");
            lock.lock();
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("线程2终止");
        }
    }
    private static class T2 extends Thread {
        @Override
        public void run() {
            System.out.println("线程2启动");
            lock.lock();
            lock.unlock();
            System.out.println("线程2终止");
        }
    }
    public static void main(String[] args) {
        new T1().start();
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new T2().start();
    }
}

