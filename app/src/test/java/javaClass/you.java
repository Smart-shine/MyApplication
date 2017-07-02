

/**
 * Created by niuanqi on 2017/6/29.
 */

 class you {

    public static void main(String[] args){
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();

        t1.start();
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


   static class T1 extends Thread{

        @Override
        public void run() {
            for(int i=10;i<20;i++){

                System.out.println("T1 " +i);
            }
        }
    }
   static class T2 implements Runnable{

        @Override
        public void run() {
            for(int i=20;i<30;i++){

                System.out.println("T2 " +i);
            }
        }
    }

   static class T3 extends Thread{
        @Override
        public void run() {
            for(int i= 30;i<40;i++){

                System.out.println("T3 " +i);
            }
        }
    }
}
