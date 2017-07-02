
/**
 * Created by niuanqi on 2017/6/29.
 */

 class miss {
    public static void main(String[] args){


        T1 t1 = new T1();
       Thread s1 = new Thread(t1);

       Thread s2 = new Thread(t1);
        System.out.println("s1的name: "+s1.getName());
        System.out.println("s2的name: "+s2.getName());

        s1.start();
        s2.start();
    }

    static class T1 implements Runnable{

        private volatile int  flag = 10;

        @Override
        public  void run() {

            for(int i=0;i<20;i++){

                if(flag>0) {

                    System.out.println(Thread.currentThread().getName() +" "+ flag--);
                }
            }
        }
    }
}
