package task4;

public class App {
    public static void main(String[] args) {
        MyExecutorService myExecutorService = new MyExecutorService(1);
        myExecutorService.execute(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Second");
        });

        myExecutorService.execute(() -> System.out.println("First"));
        myExecutorService.shutdown();


    }
}