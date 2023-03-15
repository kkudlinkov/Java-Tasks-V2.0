package task6.factory_method;

public class App {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Processor processor1 = factory.create("Intel");
        Processor processor2 = factory.create("Amd");
        Processor processor3 = factory.create("Baikal");

        processor1.start();
        processor2.start();
        processor3.start();
    }
}
