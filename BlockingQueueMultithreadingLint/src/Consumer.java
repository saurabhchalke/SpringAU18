import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{
	
static Logger logger = Logger.getLogger(Producer.class.getName());

private BlockingQueue<Message> queue;
    
    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Message msg;
            while((msg = queue.take()).getMsg() !="exit"){
            Thread.sleep(10);
            logger.info("Consumed "+msg.getMsg());
            }
        }catch (InterruptedException e) {
            logger.log(Level.WARNING, "Interrupted!", e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
          }
    }
}