package task6.abstract_factory;

public interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    OneButtonInputDevice getOneButtonInputDevice();
}