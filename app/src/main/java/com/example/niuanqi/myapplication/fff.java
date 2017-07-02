
/**
 * Created by niuanqi on 2017/6/28.
 */

class fff {
    public static void main(String[] args){

        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();
        t1.interrupt();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class T1 extends Thread{

        @Override
        public synchronized void start() {
            super.start();
            System.out.println("T1优先级是 "+getPriority());
            System.out.println("T1 - start");
        }

        @Override
        public void run() {
            System.out.println("T1 -run");
            for(int i=10;i>0;i--){
                System.out.println("T1"+" "+i);
                    try{
                        sleep(100);
                        interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class T2 extends Thread{

        @Override
        public synchronized void start() {
            super.start();
            System.out.println("T2优先级是 "+getPriority());
            System.out.println("T2 - start");
        }

        @Override
        public void run() {
            System.out.println("T2 - run");
            for(int j=0;j<10;j++){

                System.out.println("T2"+" "+j);
//                try {
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

}
