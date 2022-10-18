import java.util.concurrent.LinkedBlockingQueue;

public class MsgQueue {

    private LinkedBlockingQueue<DigitMsg> queue;

    public MsgQueue(){
        queue = new LinkedBlockingQueue<>(5);
    }

    public void put(DigitMsg digitMsg) throws InterruptedException{
        queue.put(digitMsg);
    }

    public DigitMsg take() throws InterruptedException{
        return queue.take();
    }

//    public synchronized  void add(DigitMsg digitMsg){
//        queue.add(digitMsg);
//        System.out.println("Msg added to the queue.");
//        notify();
//    }

//    public synchronized DigitMsg remove(){
//    }
}
