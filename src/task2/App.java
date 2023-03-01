package task2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        Human h1 = new Human("Nikolay", "Kudlinkov", LocalDate.now().minusYears(19).minusDays(7), 65);
        Human h2 = new Human("Oleg", "Ivanovich", LocalDate.now().minusYears(20).minusDays(18), 75);
        Human h3 = new Human("Vasiliy", "Terkin", LocalDate.now().minusYears(18).minusDays(12), 67);
        Human h4 = new Human("Nikita", "Romanovich", LocalDate.now().minusYears(22).minusDays(1), 72);
        Human h5 = new Human("Ekaterina", "Petrovna", LocalDate.now().minusYears(21).minusDays(22), 60);

        Stream<Human> stream = Stream.of(h1, h2, h3, h4, h5);


    }
}
