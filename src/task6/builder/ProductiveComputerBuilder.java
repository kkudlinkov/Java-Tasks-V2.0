package task6.builder;

public class ProductiveComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public ProductiveComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public ComputerBuilder installMotherboard() {
        computer.setMotherboard("X99");
        System.out.println("Установка материнской платы X99");
        return this;
    }

    @Override
    public ComputerBuilder installProcessor() {
        computer.setProcessor("Intel Core i9-10700");
        System.out.println("Установка процессора Intel Core i9-10700");
        return this;
    }

    @Override
    public ComputerBuilder installGpu() {
        computer.setGpu("Nvidia geforce GTX 2080");
        System.out.println("Установка видеокарты Nvidia geforce GTX 2080");
        return this;
    }

    @Override
    public Computer build() {
        System.out.println("Закрываю крышку");
        return computer;
    }
}
