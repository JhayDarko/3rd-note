import java.util.List;

class Data {
    List<String> names;
    List<Integer> ages;

    public Data(List<String> names, List<Integer> ages) {
        this.names = names;
        this.ages = ages;
    }
}

public class Transformer {

    public static void generateOutput(Data data) {
        for (int i = 0; i < data.names.size(); i++) {
            System.out.printf("id: %s, nombre: %s, edad: %s%n", i + 1, data.names.get(i), data.ages.get(i));
        }
    }

    public static void main(String[] args) {
        Data data = new Data(List.of("Bruno", "Andrea"), List.of(20, 19));
        generateOutput(data);
    }
}