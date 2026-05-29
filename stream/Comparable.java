package stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Comparable implements java.lang.Comparable<Comparable>{
    private int age;
    private String name;

    @Override
    public int compareTo(Comparable o) {
        return Integer.compare(this.age, o.age);
    }

    public static void main(String[] args) {
        Comparable c1 = new Comparable(25, "Alice");
        Comparable c2 = new Comparable(30, "Bob");
        List<Comparable> ls = List.of(c1, c2);
        ls.sort(Comparator.naturalOrder());  //sorts the list based on age as defined in the compareTo method
        Collections.sort(ls);  //does not work as class does not implement the Comparable interface
        //need to implement the Comparable interface and override the compareTo method to sort the list of Comparable objects based on age or name
        List<String> ls2 = new ArrayList<>();
        ls2.add("Charlie");
        ls2.add("Alice");
        Collections.sort(ls2);  //works as String class already has compareTo implemented
        ls.sort(null); //works as List.sort() can accept a null Comparator which means it will use the natural ordering of the elements, in this case it will use the compareTo method defined in the Comparable class to sort based on age
//        ls2.sort();   //doent work as List.sort() requires a Comparator to be provided or null, in this case String does implement Comparable but we need to provide a Comparator to sort based on name or age

        ls.sort(Comparator.comparingInt(Comparable::getAge)); //this works without implementing the Comparable interface as we are providing a Comparator that compares the age of the Comparable objects
        Collections.sort(ls,Comparator.comparingInt(Comparable::getAge)); //same as above but using Collections.sort instead of List.sort
    }

}
