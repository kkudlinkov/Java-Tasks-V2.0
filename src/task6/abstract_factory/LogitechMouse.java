package task6.abstract_factory;

public class LogitechMouse implements Mouse {
    @Override
    public void clickLkm() {
        System.out.println("click LKM on Logitech mouse");
    }

    @Override
    public void clickPkm() {
        System.out.println("click PKM on Logitech mouse");
    }
}
