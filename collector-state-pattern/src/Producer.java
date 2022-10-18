import java.util.Random;

public class Producer {
    private final MsgQueue queue;
    private final String name;
    private int msgId = 0;

    public Producer(String name, MsgQueue queue){
        this.name = name;
        this.queue = queue;
    }

    public void produce() throws InterruptedException{
        DigitMsg msg = new DigitMsg();
        queue.put(msg);
        Random rand = new Random();
        Thread.sleep(rand.nextInt(2000));
    }

}
