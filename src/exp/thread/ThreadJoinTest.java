package exp.thread;

public class ThreadJoinTest {
    private static String  str=null;
    public static void main(String[] args) {
        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("进入"+Thread.currentThread().getName()+"线程");
                    Thread.sleep(1000);
                    str="hello Word";
                    System.out.println(Thread.currentThread().getName()+"线程业务处理完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        try {
            thread.join();//设置main线程等待子线程先处理业务
            System.out.println(Thread.currentThread().getName()+"线程处理业务开始");
            System.out.println("获取str值："+str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

