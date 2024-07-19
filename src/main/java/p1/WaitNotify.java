package p1;

public class WaitNotify
{
    public static void main(String[] args) {
        Object lock = new Object();
        Thread w=new Thread(new Waiter(lock),"waiter");
        Thread n=new Thread(new Notifier(lock),"notifier");
        w.start();
        n.start();

    }
}
class Waiter implements Runnable {
    private final Object lock;

    public Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for the notification...");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " has been notified!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Notifier implements Runnable {
    private final Object lock;

    public Notifier(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " is going to notify after 2 seconds...");
                Thread.sleep(2000);
                lock.notify();
                System.out.println(Thread.currentThread().getName() + " has notified!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}