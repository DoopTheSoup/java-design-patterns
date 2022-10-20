import lombok.Getter;

/**
 * Class that changes the state of the message
 */

public class DigitCollectorState {
    int receivedDigits;
    final int expectedDigits;
    final int minimumDigits;
    @Getter
    String description;

    //Initialisation
    public DigitCollectorState(int expectedDigits, int minimumDigits){
        this.expectedDigits = expectedDigits;
        this.minimumDigits = minimumDigits;
        this.description = String.format("Expected Digits: %d, Minimum Digits: %d", expectedDigits, minimumDigits);
    }

    // Change State depending on collection progress
    public void onDigit(StateMachine m, DigitMsg message){
        m.digits[receivedDigits++] = message.getDigit();

        if (message.isLastDigit() || (receivedDigits == expectedDigits)){
            m.changeState(State.CallRoutingState);
        }
        else{
            restartDigitTimer();
        }

    }
    // Restart timer
    void restartDigitTimer(){
        receivedDigits = 0;
    }

    // Change state on timeout
    void onDigitTimeout(StateMachine m){
        if (receivedDigits < minimumDigits){
            m.changeState(State.PartialDialingState);
        }
        else{
            m.changeState(State.CallRoutingState);
        }
    }
}
