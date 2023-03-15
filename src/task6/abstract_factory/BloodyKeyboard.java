package task6.abstract_factory;

public class BloodyKeyboard implements Keyboard{
    @Override
    public void clickButton(int key) {
        System.out.printf("click %d on Bloody keyboard", key);
    }
}
