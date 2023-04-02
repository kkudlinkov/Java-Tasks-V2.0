package task8.State;

public class Context { // содержит ссылку на текущее состояние объекта и методы, позволяющие изменять состояние.
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void doAction() {
        state.doAction(this);
    }
}
