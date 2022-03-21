package lab3ListyJednokierunkowe;

public class Main {
    public static void main(String[] args) {
        OneWayLinkedListWithSentinel<Integer> l = new OneWayLinkedListWithSentinel<>();
        System.out.println("Modyfikacja: ");
        System.out.println(l);
        System.out.println("obrot");
        l.reverse();
        System.out.println(l);
        System.out.println();
        l.add(1);
        System.out.println(l);
        System.out.println("Obrot");
        l.reverse();
        System.out.println(l);
        System.out.println();
        l.add(2);
        System.out.println(l);
        System.out.println("Obrot");
        l.reverse();
        System.out.println(l);
        System.out.println();
        l.add(3);
        System.out.println(l);
        System.out.println("Obrot");
        l.reverse();
        System.out.println(l);



        System.out.println("Koniec modyfikacji: ");
        System.out.println();
        l.clear();
        System.out.println(l);
        System.out.println("Size: " + l.size());
        System.out.println("Remove element from empty list " + l.remove(new Element(3)));
        System.out.println("Is empty: " + l.isEmpty());
        System.out.println("Index of 3: " + l.indexOf(3));

        try{
            System.out.print("getting element 1: ");
            System.out.println("getting element: " + l.get(1));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index OOB exception");
        }

        System.out.println("Contains 3: " + l.contains(3));
        System.out.println("Clearing: " + l);
        l.clear();
        System.out.println("After clearing: " + l);
        System.out.println("Adding 3: ");
        l.add(3);
        System.out.println("After adding: " + l);

        System.out.println("Size: " + l.size());
        //System.out.println("Remove element from empty list " + l.remove(new Element(3)));
        System.out.println("Is empty: " + l.isEmpty());
        System.out.println("Index of 3: " + l.indexOf(3));

        try{
            System.out.print("getting element at index 1: ");
            System.out.println("getting element at index 1: " + l.get(1));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index OOB exception");
        }
        try{
            System.out.print("getting element at index 0: ");
            System.out.println(l.get(0));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index OOB exception");
        }

        System.out.println("Contains 3: " + l.contains(3));
        System.out.println("Clearing: " + l);
        l.clear();
        System.out.println("After clearing: " + l);
        System.out.println("Adding 3: ");
        l.add(3);
        System.out.println("After adding: " + l);

        System.out.println("Adding 4: ");
        l.add(4);
        System.out.println("After adding: " + l);
        System.out.println("Adding 5 at index 0: ");
        l.add(0, 5);
        System.out.println("After adding: " + l);
        System.out.println("Removing element(5):");
        l.remove(new Element(5));
        System.out.println("After removing: " + l);
        System.out.println("Contains 3: " + l.contains(3));
        System.out.println("Is empty: " + l.isEmpty());
        System.out.println(l);
        System.out.println("Setting index 2 as 9");
        System.out.println(l.set(2, 9));
        System.out.println(l);
        System.out.println("Setting index 1 as 6");
        System.out.println(l.set(1, 6));
        System.out.println(l);
        l.clear();
        System.out.println("After clearing");
        System.out.println(l);
    }
}
