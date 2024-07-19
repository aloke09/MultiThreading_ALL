package p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class phil_Main
{
    private static final int NBR_OF_PHILOSOPHERS = 5;
    public static void main(String[] args)
    {
        DiningPhilosopher[] philosophers = new DiningPhilosopher [NBR_OF_PHILOSOPHERS];
        Object[] chopsticks = IntStream.range(0, NBR_OF_PHILOSOPHERS).mapToObj(i -> new Object()).toArray();

        ExecutorService executor = Executors.newFixedThreadPool(NBR_OF_PHILOSOPHERS);

        IntStream.range(0, NBR_OF_PHILOSOPHERS).forEach(i -> executor.submit(()->
        {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[(i + 1) % NBR_OF_PHILOSOPHERS];
            philosophers[i] = new DiningPhilosopher(leftChopstick,rightChopstick,i+1);
            philosophers[i].start();
        }));
    }
}