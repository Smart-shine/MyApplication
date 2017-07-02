import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by niuanqi on 2017/6/30.
 */

class see {
    private static ReentrantLock lock = new ReentrantLock();
    private static int flag = 0;

    public static void main(String[] args) {

        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        t1.setPriority(5);
        t1.setPriority(7);
        t1.setPriority(9);

        t1.start();
        t2.start();
        t3.start();


    }

    static class T1 extends Thread {
        @Override
        public void run() {
            while (flag < 10) {
                lock.lock();
                if (flag < 10) {
                    System.out.println("T1" + "flag=====" + flag);
                    flag++;
                }
                lock.unlock();
            }
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {
            while (flag < 15) {
                lock.lock();
                if (flag < 10) {
                    System.out.println("T2" + "flag=====" + flag);
                    flag++;
                }
                lock.unlock();
            }
        }
    }

    static class T3 extends Thread {
        @Override
        public void run() {
//            System.out.println("T3 -------");
            while (flag < 20) {
                lock.lock();
                if (flag < 10) {
                    System.out.println("T3" + "flag=====" + flag);
                    flag++;
                }
                lock.unlock();
            }
        }
    }


}
