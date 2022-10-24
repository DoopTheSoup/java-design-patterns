package main.java.com.iluwatar.collectorstate;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class that is responsible for the message queue
 */

public class MsgQueue {
    //Create queue for producer-consumer
    private LinkedBlockingQueue<DigitMsg> queue;

    //Initialise size of queue
    public MsgQueue(){
        queue = new LinkedBlockingQueue<>(5);
    }

    // Adding to the queue
    public void put(DigitMsg digitMsg) throws InterruptedException{
        queue.put(digitMsg);
    }

    // Taking from the queue
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
