package task6.builder;

interface ComputerBuilder {
    // Stage 1
    ComputerBuilder installMotherboard();

    // Stage 2
    ComputerBuilder installProcessor();

    // Stage 3
    ComputerBuilder installGpu();

    // Final stage
    Computer build();
}
