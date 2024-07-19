package p2;

public class ThreadExample {
//    private static volatile boolean stopRequested = false;
    private static boolean stopRequested = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->
        {
            try {
                for (int i = 1; i <= 10 && !stopRequested; i++) {
                    System.out.println(i);
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();// Handle exception
            }
            finally {
                stopRequested = true; // stoped thread
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (char c = 'a'; c <= 'z' && !stopRequested; c++) {
                    System.out.println(c);
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally {
                stopRequested = true;
            }
        });

        t1.start();
        t2.start();
    }
}
