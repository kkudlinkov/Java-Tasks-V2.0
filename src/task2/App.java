package task2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        Human h1 = new Human("Nikolay", "Kudlinkov", LocalDate.now().minusYears(20).minusDays(7), 65);
        Human h2 = new Human("Oleg", "Ivanovich", LocalDate.now().minusYears(25).minusDays(18), 75);
        Human h3 = new Human("Vasiliy", "Terkin", LocalDate.now().minusYears(18).minusDays(12), 67);
        Human h4 = new Human("Nikita", "Romanovich", LocalDate.now().minusYears(30).minusDays(1), 72);
        Human h5 = new Human("Ekaterina", "Petrovna", LocalDate.now().minusYears(21).minusDays(22), 60);

        LocalDate date = LocalDate.of(1999,2,3);


        Stream<Human> stream = Stream.of(h1, h2, h3, h4, h5);
        List<Human> data = stream
                .peek(a1 -> a1.setWeight(a1.getWeight() + 3))
                .collect(Collectors.toList());
        System.out.println(data + "\n ---");
        data = data
                .stream()
                .filter(a1 -> a1.getBirthDate().isBefore(date))
                .collect(Collectors.toList());
        System.out.println(data + "\n ---");
        String str = data
                .stream()
                .map(p -> p.getLastName())
                .collect(Collectors.joining(" "));
        System.out.println(str + "\n ---");
    }
}
