package task6.abstract_factory;

public class BloodyOneButtonInputDevice implements OneButtonInputDevice {
    @Override
    public void click() {
        System.out.println("click on Bloody OneButtonInputDevice");
    }
}
