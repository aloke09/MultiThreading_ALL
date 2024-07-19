package p1;

public class Join extends Thread
{

    @Override
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Join t1=new Join();
        Join t2=new Join();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
    }
}
