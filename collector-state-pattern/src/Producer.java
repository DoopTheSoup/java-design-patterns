import java.util.Random;

/**
 * Producer class that creates a unit of work (message) and submits it to the queue
 */

public class Producer {
    private final MsgQueue queue;
    private final String name;
    private int msgId = 0;

    // Initialise
    public Producer(String name, MsgQueue queue){
        this.name = name;
        this.queue = queue;
    }

    // Producer adding to the queue
    public void produce() throws InterruptedException{
        DigitMsg msg = new DigitMsg();
        queue.put(msg);
        Random rand = new Random();
        Thread.sleep(rand.nextInt(2000));
    }

}
