package task6.abstract_factory;

public class BloodyFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new BloodyMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new BloodyKeyboard();
    }

    @Override
    public OneButtonInputDevice getOneButtonInputDevice() {
        return new BloodyOneButtonInputDevice();
    }
}
