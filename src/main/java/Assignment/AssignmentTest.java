package Assignment;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AssignmentTest {

public  static  void main(String[] args) throws Exception{

    Path path = Paths.get("C:\\Users\\hp\\Documents\\Firstname.txt");
    List<String> list=Files.readAllLines(path);

    //Print the counts of names which start with B

    Map<Character, List<String>> collect = list.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0)));

    System.out.println(collect);
    List<String> list1=collect.get('B');
    System.out.println(list1.size());

    long b = list.stream()
            .filter(name -> name.startsWith("B"))
            .count();
    System.out.println(b);



    //Create a list which start with C and contains 's' in it.

    Map<Character, List<String>> map = list.stream()
            .filter(l -> l.contains("s"))
            .collect(Collectors.groupingBy(s -> s.charAt(0)));

    List<String> list2=map.get('C');
      System.out.println(list2);


    List<String> collect1 = list.stream()
            .filter(name -> name.startsWith("C"))
            .filter(name -> name.contains("s"))
            .collect(Collectors.toList());
    System.out.println(collect1);



    //print the total num of character for all the names starting from M
//
//            list.stream()
//            .collect(Collectors.groupingBy(s -> s.charAt(0)))
//            .get('M')
//            .stream()
//            .forEach(s-> System.out.println(s +" "+ s.length()));

//    List<String> list3=map1.get('M');
//    System.out.println(list3);

//    int m = list.stream()
//            .filter(name -> name.startsWith("M"))
//            .map(String::trim)
//            .map(String::length)
//            .mapToInt(i -> i)
//            .sum();
//
//    System.out.println(m);

    List<String> collect2 = list.stream()
            .filter(name -> name.contains("-"))
            .map(name -> name.replace("-", " "))
            .collect(Collectors.toList());
    System.out.println(collect2);

    Optional<String> max = collect2.stream()
            .max(Comparator.comparing(s -> s.length()));
    System.out.println(max);


}







}
