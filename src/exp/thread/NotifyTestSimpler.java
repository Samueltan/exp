package exp.thread;

public class NotifyTestSimpler {
    private  Boolean flag = Boolean.TRUE;

    class NotifyThread extends Thread{
        public NotifyThread(final String name) {
            super(name);
        }
        @Override
        public void run() {
            try {
                sleep(3000);//推迟3秒钟通知
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }

                flag = Boolean.FALSE;
                flag.notify();
        }
    };

    class WaitThread extends Thread {
        public WaitThread(final String name) {
            super(name);
        }

        @Override
        public void run() {

                while (flag!=false) {
                    System.out.println(getName() + " begin waiting!");
                    long waitTime = System.currentTimeMillis();
                    try {
                        flag.wait();
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitTime = System.currentTimeMillis() - waitTime;
                    System.out.println("wait time :"+waitTime);
                }
                System.out.println(getName() + " end waiting!");

        }
    }

    public static void main(final String[] args) throws InterruptedException {
        System.out.println("Main Thread Run!");
        final NotifyTestSimpler test = new NotifyTestSimpler();
        final NotifyThread notifyThread =test.new NotifyThread("notify01");
        final WaitThread waitThread01 = test.new WaitThread("waiter01");
        final WaitThread waitThread02 = test.new WaitThread("waiter02");
        final WaitThread waitThread03 = test.new WaitThread("waiter03");
        notifyThread.start();
        waitThread01.start();
        waitThread02.start();
        waitThread03.start();
    }

}