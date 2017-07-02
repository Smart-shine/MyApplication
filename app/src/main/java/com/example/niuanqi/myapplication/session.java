/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次，请写出程序。
 *
 * @author lijinnan
 * @date:2013-11-5 下午3:07:10
 */
class session {

    private static final int ROUND_COUNT = 50;

    public static void main(String[] args) {

        //主线程和子线程“共享”一个Busines实例  
        final Business business = new Business();  
          
        /* 
        //主线程 
        for (int i = 0; i < ROUND_COUNT; i++) { 
            business.main(i); 
        } 
        */

        //子线程-注意要先启动子线程，否则子线程不会启动，主线程在roundIndex=0执行完毕后就陷入无限等待  
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < ROUND_COUNT; i++) {
                    business.sub(i);
                }
            }

        }).start();

        //主线程  
        for (int i = 0; i < ROUND_COUNT; i++) {
            business.main(i);
        }
    }

}


class Business {

    private static final int SUB_COUNT = 10;
    private static final int MAIN_COUNT = 100;

    private boolean doSub;

    public synchronized void sub(int roundIndex) {
        while (!doSub) {
            try {
                wait();
            } catch (InterruptedException e) {
                //ignore  
            }
        }
        for (int i = 0; i < SUB_COUNT; i++) {
            System.out.println("sub " + i + " of " + roundIndex);
        }
        doSub = false;
        notifyAll();
    }

    public synchronized void main(int roundIndex) {
        while (doSub) {
            try {
                wait();
            } catch (InterruptedException e) {
                //ignore  
            }
        }
        for (int i = 0; i < MAIN_COUNT; i++) {
            System.out.println("main " + i + " of " + roundIndex);
        }
        doSub = true;
        notifyAll();
    }

} 