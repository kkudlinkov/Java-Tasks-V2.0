package task6.abstract_factory;

public class LogitechFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new LogitechMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new LogitechKeyboard();
    }

    @Override
    public OneButtonInputDevice getOneButtonInputDevice() {
        return new LogitechOneButtonInputDevice();
    }
}
