package task5;

public class SingletonFirst {
    private SingletonFirst instance;

    public synchronized SingletonFirst getInstance() {
        if(instance == null) {
            instance = new SingletonFirst();
            return instance;
        }
        return instance;
    }
}
