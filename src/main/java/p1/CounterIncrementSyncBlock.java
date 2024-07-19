package p1;

public class CounterIncrementSyncBlock extends Thread {
    private static int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this)
            {
                count++;
                if(count<=100)
                {
                    System.out.println(Thread.currentThread().getName() + " ---> " + count);
                }
                else {
                    System.out.println("reached 100");
                    System.exit(0);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        CounterIncrementSyncBlock t1 = new CounterIncrementSyncBlock();
        CounterIncrementSyncBlock t2 = new CounterIncrementSyncBlock();
        t1.start();
        t2.start();
        System.out.println("Final counter value: " + count);
    }
}
