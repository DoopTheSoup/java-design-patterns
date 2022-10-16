import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        var expectedDigit = 8;
        var minimumDigit = 1;
        var collectorState = new DigitCollectorState(expectedDigit, minimumDigit);
        var m = new StateMachine();
        var msg = new DigitMsg();

        // Create a Logger
        Logger logger = Logger.getLogger("com.api.jar");

        // CHANGE TO TAKE IN THREADED MESSAGES
        // More than the minimum digit count
        for (int i = 0; i < expectedDigit - 1; i++){
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
}
