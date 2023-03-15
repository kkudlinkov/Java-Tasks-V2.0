package task6.abstract_factory;

public class LogitechOneButtonInputDevice implements OneButtonInputDevice {
    @Override
    public void click() {
        System.out.println("click on Logitech OneButtonInputDevice");
    }
}
