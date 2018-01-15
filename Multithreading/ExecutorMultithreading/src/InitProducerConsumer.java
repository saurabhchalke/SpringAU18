import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InitProducerConsumer {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
    	ExecutorService producerExecutor = Executors.newFixedThreadPool(3);
    	ExecutorService consumerExecutor = Executors.newFixedThreadPool(10);
    	
    	Producer p1 = new Producer(queue);
    	Producer p2 = new Producer(queue);
    	Producer p3 = new Producer(queue);
    	
    	Consumer c1 = new Consumer(queue);
    	Consumer c2 = new Consumer(queue);
    	Consumer c3 = new Consumer(queue);
    	Consumer c4 = new Consumer(queue);
    	Consumer c5 = new Consumer(queue);

    	producerExecutor.execute(p1);
    	consumerExecutor.execute(c1);
    	producerExecutor.execute(p2);
    	consumerExecutor.execute(c2);
    	consumerExecutor.execute(c3);
    	consumerExecutor.execute(c4);
    	producerExecutor.execute(p3);
    	consumerExecutor.execute(c5);

    }

}