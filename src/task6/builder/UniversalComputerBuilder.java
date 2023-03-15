package task6.builder;

public class UniversalComputerBuilder {
    private final Computer computer;

    public UniversalComputerBuilder() {
        this.computer = new Computer();
    }

    public UniversalComputerBuilder installMotherboard(String motherboard) {
        computer.setMotherboard(motherboard);
        System.out.printf("Установка материнской платы %s\n", motherboard);
        return this;
    }

    public UniversalComputerBuilder installProcessor(String processor) {
        computer.setProcessor(processor);
        System.out.printf("Установка процессора %s\n", processor);
        return this;
    }

    public UniversalComputerBuilder installGpu(String gpu) {
        computer.setGpu(gpu);
        System.out.printf("Установка видеокарты %s\n", gpu);
        return this;
    }

    public Computer build() {
        System.out.println("Закрываю крышку");
        return computer;
    }
}
