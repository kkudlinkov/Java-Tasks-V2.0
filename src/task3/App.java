package task3;

public class App {
    public static void main(String[] args) {
        int n = 10;
        MapSemaphore<Integer, Integer> map = new MapSemaphore<>();

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                map.put(i * 2, i * 3);
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                map.put(i * 3, i * 4);
            }
        });
        Thread threadThree = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                System.out.println(map.get(i * 2));
            }
        });
        Thread threadFour = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                System.out.println(map.get(i * 3));
            }
        });

        threadOne.start();
        threadThree.start();

        threadTwo.start();
        threadFour.start();
    }
}
