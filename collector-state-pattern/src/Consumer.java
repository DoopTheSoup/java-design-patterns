import lombok.Getter;

public class Consumer {
    private final MsgQueue queue;
    private final String name;
    @Getter private DigitMsg msg;

    public Consumer(String name, MsgQueue queue){
        this.name = name;
        this.queue = queue;
    }

    public void consume() throws InterruptedException{
        msg = queue.take();
        System.out.println(String.format("Consuder [%s] consume item [%s] produced by [%s]", name, msg.getId(), msg.getProducer()));
        // Do digit collection?
    }
}
