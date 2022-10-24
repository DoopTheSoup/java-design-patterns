package main.java.com.iluwatar.collectorstate;
/**
 * Class that changes states
 *
 * StateMachine keeps track of the state of a message
 */
public class StateMachine {
    // Current state of the machine
    State currentState;

    // Capacity and digit list containing collected digits
    int capacity = 1000;
    String[] digits = new String[capacity];

    // Change state of the machine
    public void changeState(State state){
        currentState = state;
    }
}
