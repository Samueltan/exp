package exp.thread;

public class NotifyTest {
	private final  String[] flag = {"true"};

	class NotifyThread extends Thread{
		public NotifyThread(final String name) {
			super(name);
		}
		@Override
        public void run() {
			try {
				sleep(1000);//推迟通知
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}

			synchronized(flag) {
				flag[0] = "false";
		        System.out.println( "flag after change @" + flag );
				flag.notifyAll();
			}
		}
	}

	class WaitThread extends Thread {
		public WaitThread(final String name) {
			super(name);
		}

		@Override
        public void run() {
			synchronized(flag){
				while (flag[0] != "false") {
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
	}

	class Flag {
	    private boolean _flag;

        public Flag ( final boolean flag )
        {
            super( );
            _flag = flag;
        }

        boolean getFlag(){
	        return _flag;
	    }

	    void setFlag(final boolean flag){
	        _flag = flag;
	    }
	}

	public static void main(final String[] args) throws InterruptedException {
		System.out.println("Main Thread Run!");
		final NotifyTest test = new NotifyTest();
		System.out.println( "test.flag @" + test.flag );
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