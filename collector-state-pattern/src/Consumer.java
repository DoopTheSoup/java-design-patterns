import lombok.Getter;

/**
 * Consumer class consumes the message created by its producer
 */

public class Consumer {
    private final MsgQueue queue;
    private final String name;
    @Getter
    private DigitMsg msg;

    // Initialise
    public Consumer(String name, MsgQueue queue){
        this.name = name;
        this.queue = queue;
    }

    // Consumer consuming from the queue
    public void consume() throws InterruptedException{
        msg = queue.take();
        System.out.println(String.format("Consumer [%s] consume item [%s] produced by [%s]", name, msg.getId(), msg.getProducer()));
        // Do digit collection?
    }
}
