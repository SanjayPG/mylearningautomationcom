package lambda;
import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {

        List<Integer> list =new ArrayList<>();

        Collections.addAll(list,1,2,3,4,5,6,7,8,9);

        IntStream.range(1,9)
                .forEach(i-> System.out.println("printing range : "+i));

        IntStream.rangeClosed(1,9)
                  .forEach(i-> System.out.println("Printing rangeClosed value "+i));

    }
}