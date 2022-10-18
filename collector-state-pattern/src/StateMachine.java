public class StateMachine {
    State currentState;
    int capacity = 1000;
    String[] digits = new String[capacity];

    // Change state of the machine
    public void changeState(State state){
        currentState = state;
    }
}
