package task3;

public class Main {
    public static void testMap(int n) {
        MapSemaphor<Integer, Integer> map = new MapSemaphor<>();

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

    public static void testSet(int n) {
        SetLok<String> sets = new SetLok<>();
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                sets.add(String.valueOf(i));
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                sets.add("world");
            }
        });

        Thread threadThree = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                System.out.println(sets.toString());
            }
        });
        threadOne.start();
        threadThree.start();
        threadTwo.start();


    }

    public static void main(String[] args) {
        testSet(10);
        testMap(10);
    }
}
