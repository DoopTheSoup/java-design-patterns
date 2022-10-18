import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        var expectedDigit = 8;
        var minimumDigit = 1;
        var collectorState = new DigitCollectorState(expectedDigit, minimumDigit);
        var m = new StateMachine();
//        var msg = new DigitMsg();

        // Create a Logger
        Logger logger = Logger.getLogger("com.api.jar");

        MsgQueue queue = new MsgQueue();
        ExecutorService exService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++){
            final Producer producer = new Producer("Producer_" + i, queue);
            exService.submit(() -> {
                while (true){
                    producer.produce();
                }
            });
        }

        for (int i = 0; i < 3; i++){
            final Consumer consumer = new Consumer("Consumer_" + i, queue);
            exService.submit(() -> {
                while (true){
                    consumer.consume();
                    DigitMsg msg = consumer.getMsg();

                    // More than the minimum digit count
                    for (int j = 0; j < expectedDigit - 1; j++){
                    collectorState.onDigit(m, msg);
                    }

                    collectorState.onDigitTimeout(m);
                    // Restart Timer
                    collectorState.restartDigitTimer();

                    // Less than the minimum digit count
                    collectorState.onDigit(m, msg);
                    collectorState.onDigitTimeout(m);

                    // Log DigitCollectorState Description
                    logger.info(collectorState.getDescription());
                }
            });
        }

        exService.shutdown();
        try {
            exService.awaitTermination(10, TimeUnit.SECONDS);
            exService.shutdownNow();
        }
        catch (InterruptedException e){
            System.out.println("ExecutorService shutdown error");
        }
    }
}

//// More than the minimum digit count
//        for (int i = 0; i < expectedDigit - 1; i++){
//        collectorState.onDigit(m, msg);
//        }
//
//        collectorState.onDigitTimeout(m);
//        // Restart Timer
//        collectorState.restartDigitTimer();
//
//        // Less than the minimum digit count
//        collectorState.onDigit(m, msg);
//        collectorState.onDigitTimeout(m);
//
//        // Log DigitCollectorState Description
//        logger.info(collectorState.getDescription());