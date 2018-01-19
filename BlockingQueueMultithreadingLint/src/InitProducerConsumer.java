import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

public class InitProducerConsumer {
	
	static Logger logger = Logger.getLogger(Producer.class.getName());

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        logger.info("Producer and Consumer has been started");
    }

}