package task6.builder;


/*
 * https://habr.com/ru/company/otus/blog/552412/
 *
 * https://vertex-academy.com/tutorials/ru/pattern-builder-java/
 *
 * Можно делать не отдельный билдеры, а билдер с параметрами
 */

public class App {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder1 = new UnproductiveComputerBuilder();
        ComputerBuilder computerBuilder2 = new ProductiveComputerBuilder();

        Computer computer1 = computerBuilder1
                .installMotherboard()
                .installProcessor()
                .installGpu()
                .build();

        Computer computer2 = computerBuilder2
                .installMotherboard()
                .installProcessor()
                .installGpu()
                .build();

        System.out.println("--------");
        System.out.println(computer1);
        System.out.println(computer2);

        UniversalComputerBuilder universalComputerBuilder = new UniversalComputerBuilder();
        Computer computer3 = universalComputerBuilder
                .installMotherboard("M225")
                .installProcessor("AMD A6-9500E")
                .installGpu("And Radeon rx590")
                .build();

        System.out.println(computer3);
    }
}
