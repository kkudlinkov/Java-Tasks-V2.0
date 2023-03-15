package task6.abstract_factory;

/*
 * https://youtu.be/FYX9l5OQtJE
 */

public class App {
    public static DeviceFactory getFactoryByCompanyName(String name) {
        return switch (name) {
            case "Logitech" -> new LogitechFactory();
            case "Bloody" -> new BloodyFactory();
            default -> throw new RuntimeException("Unsupported company name");
        };
    }

    public static void main(String[] args) {
        DeviceFactory deviceFactory = getFactoryByCompanyName("Logitech");

        Mouse mouse = deviceFactory.getMouse();
        Keyboard keyboard = deviceFactory.getKeyboard();

        mouse.clickLkm();
        keyboard.clickButton(34);
    }
}
