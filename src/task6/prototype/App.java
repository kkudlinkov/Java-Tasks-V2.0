package task6.prototype;

/*
 * https://youtu.be/7X3eQZX5b9Y
 */

public class App {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Helli", 5);
        Dog dog2 = dog1.copy();

        System.out.println(dog1);
        System.out.println(dog2);

    }
}
