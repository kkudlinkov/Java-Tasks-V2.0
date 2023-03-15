package task6.factory_method;

public class Factory {
    public Processor create(String company) {
        return switch (company) {
            case "Intel" -> new Intel();
            case "Amd" -> new Amd();
            case "Baikal" -> new Baikal();
            default -> null;
        };
    }
}
