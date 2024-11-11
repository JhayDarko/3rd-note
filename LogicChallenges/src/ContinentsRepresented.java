import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Developer {
    String firstName;
    String lastName;
    String country;
    String continent;
    int age;
    String language;

    public Developer(String firstName, String lastName, String country, String continent, int age, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.continent = continent;
        this.age = age;
        this.language = language;
    }
}

class DeveloperWithGreeting extends Developer {
    String greeting;

    public DeveloperWithGreeting(Developer developer) {
        super(developer.firstName, developer.lastName, developer.country, developer.continent, developer.age,
                developer.language);
        this.greeting = "Hi " + developer.firstName + ", what do you like the most about " + developer.language + "?";
    }
}

public class ContinentsRepresented {

    public static boolean allContinentsRepresented(List<Developer> developers) {
        Set<String> allContinents = new HashSet<>(Arrays.asList("Africa", "Americas", "Asia", "Europe", "Oceania"));
        for (Developer developer : developers) {
            allContinents.remove(developer.continent);
            if (allContinents.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static int jsEuropeDevs(List<Developer> developers) {
        int count = 0;
        for (Developer developer : developers) {
            if ("Europe".equals(developer.continent) && "JavaScript".equals(developer.language)) {
                count++;
            }
        }
        return count;
    }

    public static Set<String> languagesList(List<Developer> developers) {
        Set<String> lenguajes = new HashSet<>();
        for (Developer developer : developers) {
            lenguajes.add(developer.language);
        }
        return lenguajes;
    }

    public static List<DeveloperWithGreeting> addGreetings(List<Developer> developers) {
        return developers.stream().map(DeveloperWithGreeting::new).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Developer> developers = Arrays.asList(
            new Developer("Fatima", "A.", "Algeria", "Africa", 25, "JavaScript"),
            new Developer("Agustín", "M.", "Chile", "Americas", 37, "C"),
            new Developer("Jing", "X.", "China", "Asia", 39, "Ruby"),
            new Developer("Laia", "P.", "Andorra", "Europe", 55, "JavaScript"),
            new Developer("Oliver", "Q.", "Australia", "Oceania", 65, "PHP")
        );
        System.out.println("Continentes representados: " + allContinentsRepresented(developers));
        System.out.println("JavaScript devs de Europa: " + jsEuropeDevs(developers));
        System.out.println("Lenguajes representados: " + languagesList(developers));
        addGreetings(developers).forEach(developer -> System.out.println(developer.greeting));
    }
}