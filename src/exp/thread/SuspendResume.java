package exp.thread;

//Suspending and resuming a thread for Java2
class NewThread implements Runnable {
    String name; // name of thread
    Thread t;
    boolean suspendFlag;
    NewThread(final String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start(); // Start the thread
    }

    // This is the entry point for thread.
    @Override
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized(this) {
                    while(suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (final InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    void suspend() {
        suspendFlag = true;
    }

    synchronized void resume() {
        suspendFlag = false;
        notify();
    }
}

class SuspendResume {
    public static void main(final String args[]) {
        final NewThread ob1 = new NewThread("One");
        final NewThread ob2 = new NewThread("Two");
        try {
            Thread.sleep(1000);
            ob1.suspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.resume();
            System.out.println("Resuming thread One");
            ob2.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ob2.resume();
            System.out.println("Resuming thread Two");
        } catch (final InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
        } catch (final InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}