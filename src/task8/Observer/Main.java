package task8.Observer;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver("Observer 1", subject);
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2", subject);
        ConcreteObserver observer3 = new ConcreteObserver("Observer 3", subject);

        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        subject.setState("new state");

        subject.detach(observer2);

        subject.setState("another new state");
    }
}
