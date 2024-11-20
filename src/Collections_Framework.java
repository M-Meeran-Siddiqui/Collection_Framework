import java.util.ArrayList;//class so it is in Pascal.
import java.util.Iterator; //class so it is in Pascal.
public class Collections_Framework {
    public static void main(String[] args) {

              ArrayList<Integer> list = new ArrayList<Integer>();//object or reference of a class so it is also in pascalcase.

              //add()-->
              list.add(1);
              list.add(2);
              list.add(3);
              list.add(4);
              list.add(5);
              list.add(6);

              ArrayList<Integer> list2  = new ArrayList<Integer>();
              list2.add(6);
              list2.add(7);
              list2.add(8);
              list2.add(9);

              //addAll();
              list.addAll(list2);

             //list.clear();

              //iterator();
              Iterator<Integer> iterate = list.iterator();

              //hasNext()/next();-->
              while(iterate.hasNext()){ //check each time is elem. available.
                     int elem = iterate.next();//help in +1increment.
                     System.out.print(elem + "   ");
              }
              //contains();-->
              System.out.println();
              if(list.contains(6)){
                   System.out.print("Oh! Yes I'm available . ");
              }else{
                   System.out.print("Oh! No I'm not available . ");
              }

              //clear();--->
             // list.clear();
            //  System.out.print(list);

            System.out.println();
              ArrayList<Integer> check_List = new ArrayList<Integer>();
              check_List.add(1);
              check_List.add(2);
              check_List.add(3);

            //containsAll();--->
              if(list.containsAll(check_List)){
                   System.out.print("Oh! Yes We are all Present . ");
              }
              else{
                   System.out.print("Oh! No Someone is missing or All. ");
              }

            System.out.println();

            //equals()-->it return true when both thing are true like size of both list as well as (order and nature) of all elem. are same.
            ArrayList<Character> l_1 = new ArrayList<Character>();
            l_1.add('a');
            l_1.add('b');
            l_1.add('c');
            ArrayList<Character> l_2 = new ArrayList<Character>();
            l_2.add('a');
            l_2.add('c');
            l_2.add('b');

             if(l_1.equals(l_2)){
                  System.out.print("Both are Equal .");
             }
             else{
                  System.out.print("Both are not equal . ");
             }

             System.out.println();
             //isEmpty()-->
            //   list.clear();
              if(list.isEmpty()){
                   System.out.print("Yes List Is Empty . ");
              }else{
                   System.out.print("No List Is Not Empty . ");
              }

              System.out.println();

              //remove/removeAll();-->
             // list.remove(2);
            //  list.removeAll(check_List);
            //  System.out.print("After remove : " + list + "   ");


        //retainAll();---> it store only the common elem. from d/f list and return it.
              list.retainAll(check_List);
              System.out.print(list);

              System.out.println();
              //size();--->
              System.out.print(list.size());

              System.out.println();

              //toArray()---> remember in below, 'Object' is a 'keyword' so it is necessary to use this 'name' nothing else.
             Object [] list_To_Arr = list.toArray();
             //Alternative
            //  Integer[] list_To_Arr = list.toArray(new Integer[0]);
              for(int i = 0 ; i<list_To_Arr.length ; i++){
                   System.out.print(list_To_Arr[i] + "  ");
              }

    }
}
