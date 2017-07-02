
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by niuanqi on 2017/6/29.
 */

class lock {

    static private ReentrantLock lock = new ReentrantLock();
    static private int state = 0;

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
        new T3().start();
    }

    static class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                print();
                try {
//                    if (state % 3 == 0 ) {
//                        System.out.println("T1");
                        state++;
                        System.out.println(state);
                        i++;
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static void print() {
        lock.lock();
        try {
            System.out.println("..........");
        } finally {
            lock.unlock();
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {

            for (int i = 0; i < 10; ) {
                lock.lock();
                try {
//                    if (state % 3 == 1) {
//                        System.out.println("T2");
                        state++;
                        System.out.println(state);
                        i++;
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class T3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();

                try {
//                    if (state % 3 == 2) {

//                        System.out.println("T3");
                        state++;
                    System.out.println(state);
                        i++;
//                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
