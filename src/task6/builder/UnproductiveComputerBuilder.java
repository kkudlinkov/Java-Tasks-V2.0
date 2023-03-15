package task6.builder;

public class UnproductiveComputerBuilder implements ComputerBuilder {
    private final Computer computer;

    public UnproductiveComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public ComputerBuilder installMotherboard() {
        computer.setMotherboard("H52");
        System.out.println("Установка материнской платы H52");
        return this;
    }

    @Override
    public ComputerBuilder installProcessor() {
        computer.setProcessor("Intel Core i3-1215u");
        System.out.println("Установка процессора Intel Core i3-1215u");
        return this;
    }

    @Override
    public ComputerBuilder installGpu() {
        computer.setGpu("Nvidia GT 730");
        System.out.println("Установка видеокарты Nvidia GT 730");
        return this;
    }

    @Override
    public Computer build() {
        System.out.println("Закрываю крышку");
        return computer;
    }
}
