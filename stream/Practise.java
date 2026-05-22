package stream;

public class Practise {

    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.addAll(List.of("Alice", "Bob", "Charlie","Bob", "David", "Eve"));
//
//        String namre = names.stream()
//                .collect(Collectors.groupingBy(s->s, TreeMap::new,Collectors.counting()))
//                .entrySet().stream()
//                .filter(e->e.getValue()==1)
//                .map(Map.Entry::getKey).findFirst().orElse(null);
//        System.out.println(namre);

//        String name = "aahdudbdww";
//        String result = name.char()
//                .mapToObj(c -> (char) c)
//

        String name = "Shubham";
        String name2 = "Shubham";
        String name3 = new String("Shubham");

        System.out.println(name == name2); // true
        System.out.println(name.equals(name2)); // true
        System.out.println(name == name3); // false


    }



}
