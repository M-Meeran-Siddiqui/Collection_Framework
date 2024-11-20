//List Interface---> as we know that List Interface extends--> Collection Interface extends--> Iterator Interface so List must be used all method or Collections and have ability to create it's also-->

/*Theory--->
(*)The List interface in Java SE 8 represents an ordered collection that allows precise control over the insertion of elements and enables access to these elements via integer indices. Unlike sets, lists may contain duplicate elements and null values, and they come with constraints on operations and methods extending from the Collection interface. The List interface also offers unique functionalities such as the ListIterator for bidirectional traversal and element manipulation and restricts certain operations to protect against the insertion of invalid elements.

  Key Points:-
(1)The List interface is an ordered collection that allows users to control the position of each inserted element.
(2)Lists may contain duplicate elements and generally allow null values, unlike sets.
(3)The iterator, add, remove, equals, and hashCode methods in the List interface have additional contractual obligations compared to the Collection interface.
(4)Lists provide four methods for indexed access to elements, typically starting from zero, and performance may vary by implementation.
(5)The ListIterator allows for bidirectional access and supports element insertion and replacement beyond standard iterator operations.
(6)Some methods for searching elements in a list may involve costly linear searches and should be used judiciously.
(7)Certain implementations may impose restrictions on allowable elements, such as prohibiting nulls, with associated exceptions for invalid operations.
*/
//List Specific Methods-->

/*NOTE--->
(*)When you import an interface (e.g., Collection, Set, List), you can only use the interface type.
(*)To create an object using a concrete class (e.g., ArrayList, HashSet, LinkedList), you need to import those specific classes separately, even though they implement or extend the interface.

Example:--->
import java.util.List;        // Import the List interface
import java.util.ArrayList;   // Import the ArrayList class

List<Integer> list = new ArrayList<>();  // Need to import ArrayList to use it.

*******************************************************************
In short,importing an interface does not give access toits concrete
implementations, and those implementations must be
imported separately. This applies across the entire Collection
Framework.
*******************************************************************

*/

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class List_Interface {
    public static void main (String args []){
        List<Integer> li = new ArrayList<Integer>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5);
        li.add(6);
        li.add(6);
        li.add(6);
        System.out.println(li);
        //Another way using of add();-->
        li.add(0 , 10);
        System.out.println(li);
        //addAll();-->
        li.addAll(0 , li); //duplication allowed but you can add another list also.
        System.out.println(li);

        //remove();-->
        //  li.remove(0);
        System.out.println(li);
        //Remember :-
                 /*
                 (a)remove(int index): Removes the element at the specified index in the list.
                 (b)remove(Object o): Removes the first occurrence of the specified object (if it exists) from the list.
                 */
        //  li.remove(Integer.valueOf(1));
        System.out.println(li);
        //  li.removeAll(li);-->
        System.out.println(li + " Null ");

        //get(), indexOf();-->
        for(int i = 0 ; i<li.size() ; i++){
            System.out.print("At index "+ li.indexOf(i) +"  "+li.get(i) +  "\n   ");
        }

        //indexOf() , lastIndexOf();-->
        System.out.println(li.indexOf(Integer.valueOf(6)));
        System.out.println(li.lastIndexOf(Integer.valueOf(6)));

        //listIterator();
/*
The listIterator() method in Java provides a way to traverse and manipulate
 elements in a List in both forward and backward directions. It is more powerful
  than a regular Iterator.

   1. Without starting index:
    ListIterator<E> listIterator();
    Starts from the beginning of the list.

   2. With starting index:
    ListIterator<E> listIterator(int index);
    Starts from the specified index.

    Key Features
    (1)Bi-Directional Traversal:
        Use hasNext() and next() to move forward.
        Use hasPrevious() and previous() to move backward.
    (2)Element Manipulation:
        Add or modify elements during iteration.
    (3)Index Access:
    Get the index of the next or previous element using nextIndex() and
    previousIndex().

-Method------------------Description-
hasNext()     	Checks if there's a next element.
next()	        Returns the next element and moves forward.
hasPrevious()	Checks if there's a previous element.
previous()   	Returns the previous element and moves backward.
nextIndex()	    Returns the index of the next element.
previousIndex()	Returns the index of the previous element.
add(E e)	    Inserts the specified element into the list at the current iterator position.
set(E e)	    Replaces the last element returned by next() or previous() with e.
remove()	    Removes the last element returned by next() or previous().

Use Cases
Bidirectional Traversal: Navigate lists in both directions.
Dynamic Updates: Modify, add, or remove elements during iteration.
Index Tracking: Access element indices dynamically.
Notes for Quick Reference
Powerful Alternative: Use listIterator() for advanced manipulation compared to Iterator.
Index Control: Use listIterator(index) to start at a specific position.
Avoid Concurrent Modification: Safe against modification during iteration. Use methods like add() and set().
Let me know if you need further clarification!

*/

     ListIterator<Integer> iterator = li.listIterator();
     //Forward Traversal-->
     while(iterator.hasNext()){
                  int elem = iterator.next();
                  System.out.print(elem + " ");
             }
     System.out.println();
     //Backward Traversal-->
             while(iterator.hasPrevious()){
                 int elem = iterator.previous();
                  System.out.print(elem + "  ");
             }
//   Adding and Modifying Elements-->
        while(iterator.hasNext()){
            int current = iterator.next();
            //Replace element
            if(current == 2){
                 iterator.set(20);
            }
//         add element after a specific element
            if(current == 3){
                 iterator.add(30);
            }
        }
        System.out.println("Modified list : "+ li);

        //replaceAll();-->
/*
    <--------**Notes on `replaceAll` Method in Java**--------->
1. **Definition**:
   - Modifies a list in-place by applying a **UnaryOperator** to each element.

2. **Syntax**:
   list.replaceAll(UnaryOperator<E> operator);
3. **Key Features**:
   - Works with **`List`** interface.
   - Introduced in **Java 8**.
   - Operates directly on the existing list (no new list is created).

4. **Use Cases**:
   - **Transform Elements**: Modify list elements, e.g., increment, square, or capitalize.
   - **Functional Programming**: Uses lambda expressions or method references for concise transformations.

5. **Examples**:
   - Increment: `list.replaceAll(e -> e + 1);`
   - Square: `list.replaceAll(e -> e * e);`
   - Uppercase: `list.replaceAll(String::toUpperCase);`

6. **Efficiency**:
   - Eliminates manual looping, making code shorter and easier to read.

**Quick Example**:
list.replaceAll(e -> e * e); // Squares each element
list.replaceAll(String::toUpperCase); // Converts strings to uppercase

**Important**: The `replaceAll` method directly updates the list; ensure this is intended.

*/

//Example-1:->
        li.replaceAll(elem -> elem +1);
        System.out.println(li);
//Example-2:->
        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("python");
        list1.add("c++");

        System.out.println("Original List: " + list1);

        // Convert each string to uppercase:-
        list1.replaceAll(String::toUpperCase);

        System.out.println("After replaceAll: " + list1);

//Example-3:->
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        System.out.println("Original List: " + list2);

        // Square each element
        list2.replaceAll(element -> element * element);

        System.out.println("After replaceAll: " + list2);

        //set();-->
        li.set(3  ,  10);
        System.out.println(li);
        //sort();-------->
        Collections.sort(list2);
        System.out.println(list2);
        //Custom Sorting-->means you can do sorting according to your own logic-->
        Collections.sort(list2 , Comparator.reverseOrder());
        System.out.println(list2);
        //You can also define your own comparator for sorting-->
        Collections.sort(list2 , (a , b)-> a -  b);
        System.out.println(list2);

        //Using List.sort();-->
        list2.sort(Comparator.naturalOrder());
        System.out.print(list2);
        list2.sort(Comparator.reverseOrder());
        System.out.print(list2);

        //subList(start , end);-->
        System.out.println(li.subList(5  , 7));
    }
}


/*Summary For Above--->
(1)Both List<Integer> li = new ArrayList<>(); and ArrayList<Integer> li2 = new ArrayList<>(); can perform the same tasks since ArrayList implements List.

(2)Use List<Integer> li = new ArrayList<>(); for flexibility if you may switch to a different List implementation later.

(3)Use ArrayList<Integer> li2 = new ArrayList<>(); only if you need ArrayList-specific features, though this is rare.
*/