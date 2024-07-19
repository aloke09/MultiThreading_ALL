package p1;

public class Daemon extends Thread
{
    @Override
    public void run()
    {
        try {
            while (true) {
                // Simulate cleanup task by printing a message and sleeping
                System.out.println("Performing cleanup task...");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println("Cleanup task interrupted.");
        } finally {
            System.out.println("Cleanup task final cleanup before exit.");
            //sys.gc
        }
    }

    public static void main(String[] args) {

        Daemon daemonThread=new Daemon();
        daemonThread.setDaemon(true);
        System.out.println(daemonThread.isDaemon());
        daemonThread.start();
    }
}
