package p2;

public class StartStop extends Thread
{
    public static boolean flag=false;

    @Override
    public void run()
    {
        if (Thread.currentThread().getName().equalsIgnoreCase("Thread-0"))
        {
            new StartStop().num();
        }
        else {
            new StartStop().alpha();
        }
    }
    public void num()
    {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"---->"+i);
            if(flag==true)
            {
                Thread.currentThread().stop();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if(i==10)
            {
                flag=true;
            }

        }
    }
    public void alpha()
    {
        for (int i = 97; i <= 122; i++) {
            System.out.println(Thread.currentThread().getName()+"---->"+(char)i);
            if(flag==true)
            {
                Thread.currentThread().stop();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if(i==122)
            {
                flag=true;
            }
        }
    }
    public static void main(String[] args) {
        StartStop t1=new StartStop();
        StartStop t2=new StartStop();
        t1.start();
        t2.start();
    }
}
