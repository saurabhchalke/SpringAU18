import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;
    
    static Logger logger = Logger.getLogger(Producer.class.getName());
    
    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        for(int i=0; i<100; i++){
            Message msg = new Message(""+i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                logger.info("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                logger.log(Level.WARNING, "Interrupted!", e);
                // Restore interrupted state...
                Thread.currentThread().interrupt();
              }
        }
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Interrupted!", e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
          }

    }
}