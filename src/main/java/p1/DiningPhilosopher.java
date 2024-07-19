package p1;

public class DiningPhilosopher extends Thread
{
    private final Object LEFT;
    private final Object RIGHT;

    public DiningPhilosopher(Object left, Object right,int n) {
        LEFT = left;
        RIGHT = right;
        this.setName("phil-->"+n);
    }
    @Override
    public void run()
    {
        while(true)
        {
            System.out.println(Thread.currentThread().getName()+" is thinking");
            synchronized (LEFT)
            {
                System.out.println(Thread.currentThread().getName()+" picked left chopstick");
                synchronized (RIGHT)
                {
                    System.out.println(Thread.currentThread().getName()+" picked right chopstick");
                }
                System.out.println(Thread.currentThread().getName()+" put down both chopstick and started thinking again!!");
            }
        }
    }

}

