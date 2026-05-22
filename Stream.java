//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class Stream {
//
//    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.addAll(List.of("Alice", "Bob", "Charlie","Bob", "David", "Eve"));
//        names.stream().collect(Collectors.groupingBy(a->a, Collectors.counting()))
//                .forEach((k,v)-> System.out.println(k + " : " + v));
//    }
//
////    Find the word with the highest occurrence.
//
//    Optional<Map.Entry<String, Long>> mostFrequent =
//            names.stream()
//                    .collect(Collectors.groupingBy(
//                            s -> s,
//                            Collectors.counting()
//                    ))
//                    .entrySet()
//                    .stream()
//                    .max(Map.Entry.comparingByValue());
//}
//
//
//
////Find the longest word
//Optional<String> longest =
//        names.stream()
//                .max(Comparator.comparingInt(String::length));
//
//
////join all the words with a comma
//String joined =
//        names.stream()
//                .collect(Collectors.joining(", "));
//
////first non-repeated word
//Optional<String> firstUnique =
//        names.stream()
//                .collect(Collectors.groupingBy(
//                        s -> s,
//                        LinkedHashMap::new,
//                        Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue() == 1)
//                .map(Map.Entry::getKey)
//                .findFirst();
//
////find missing number from a list of integers
//List<Integer> numbers = List.of(0, 1, 3, 6);
//int n = 6;
//
//Set<Integer> set = new HashSet<>(numbers);
//
//List<Integer> missing =
//        IntStream.rangeClosed(0, n)
//                .filter(i -> !set.contains(i))
//                .boxed()
//                .toList();
//
//System.out.println(missing);
//
//
//1️⃣ Intermediate Operations (Return a Stream)
//
//They transform a stream and can be chained.
//
//Common Intermediate Operations
//🔹 map()
//
//Transforms elements
//
//numbers.stream()
//       .map(n -> n * 2)
//        .forEach(System.out::println);
//🔹 filter()
//
//Keeps elements matching condition
//
//numbers.stream()
//       .filter(n -> n % 2 == 0)
//        .forEach(System.out::println);
//🔹 sorted()
//
//Sorts stream
//
//numbers.stream()
//       .sorted()
//       .forEach(System.out::println);
//numbers.stream()
//       .sorted(Comparator.reverseOrder())
//        .forEach(System.out::println);
//🔹 distinct()
//
//Removes duplicates
//
//numbers.stream()
//       .distinct()
//       .forEach(System.out::println);
//🔹 limit() / skip()
//numbers.stream().limit(3).forEach(System.out::println);
//numbers.stream().skip(2).forEach(System.out::println);
//🔹 peek() (for debugging only)
//        numbers.stream()
//       .peek(System.out::println)
//       .filter(n -> n > 5)
//        .forEach(System.out::println);
//2️⃣ Terminal Operations (Produce Result)
//
//They end the stream and return a value or side-effect.
//
//🔥 Most Important Terminal Operations (INTERVIEW MUST-KNOW)
//🔹 forEach()
//
//Consumes stream
//
//numbers.stream().forEach(System.out::println);
//🔹 collect()
//
//Collects stream into a structure
//
//List<Integer> list =
//        numbers.stream().collect(Collectors.toList());
//🔹 reduce()
//
//Reduces stream to single value
//
//int sum =
//        numbers.stream().reduce(0, Integer::sum);
//🔹 count()
//
//Counts elements
//
//long count =
//        numbers.stream().count();
//🔹 max() / min()
//Optional<Integer> max =
//        numbers.stream().max(Integer::compareTo);
//🔹 anyMatch() / allMatch() / noneMatch()
//boolean anyEven =
//        numbers.stream().anyMatch(n -> n % 2 == 0);
//🔹 findFirst() / findAny()
//Optional<Integer> first =
//        numbers.stream().findFirst();
//3️⃣ Primitive Stream Terminal Operations
//🔹 sum()
//int sum =
//        numbers.stream().mapToInt(Integer::intValue).sum();
//🔹 average()
//double avg =
//        numbers.stream().mapToInt(Integer::intValue)
//                .average()
//                .orElse(0);
//🔹 summaryStatistics()
//IntSummaryStatistics stats =
//        numbers.stream()
//                .mapToInt(Integer::intValue)
//                .summaryStatistics();
//4️⃣ Short-Circuiting Terminal Operations
//
//These may stop early.
//
//Operation	Stops early?
//findFirst()	✅
//findAny()	✅
//anyMatch()	✅
//allMatch()	✅
//noneMatch()	✅