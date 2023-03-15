package task6.abstract_factory;

public class LogitechKeyboard implements Keyboard{
    @Override
    public void clickButton(int key) {
        System.out.printf("click %d on Logitech keyboard", key);
    }
}
