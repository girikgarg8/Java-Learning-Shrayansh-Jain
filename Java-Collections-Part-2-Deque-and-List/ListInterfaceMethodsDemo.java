import java.util.*;

public class ListInterfaceMethodsDemo {
    public static void main(String [] args) {
        List <Integer> nums = new ArrayList<>();

        // add(index,element)
        nums.add(0,100);
        nums.add(1,200);
        nums.add(2,300);

        // addAll(index,collection)
        List <Integer> nums2 = new ArrayList<>();
        nums2.add(0,400);
        nums2.add(1,500);
        nums2.add(2,600);

        nums.addAll(1,nums2);
        nums.forEach(val -> System.out.println("Value is " + val));

        // replaceAll(unaryOperator)
        nums.replaceAll((Integer val) -> -1*val);
        nums.forEach(val -> System.out.println("Element is " + val));

        // sort(Comparator)
        nums.sort((Integer val1, Integer val2) -> val1-val2);
        nums.forEach(val -> System.out.println("Item is " + val));

        // get(index)
        System.out.println("Value present at index 2 is : " + nums.get(2));

        // set(index,element)
        nums.set(3,-350);
        nums.forEach(val -> System.out.println("The value is " + val));

        // remove(index)
        nums.remove(3);
        nums.forEach(val -> System.out.println("Element is " + val));

        // indexOf(object)
        Integer index = nums.indexOf(-400);
        System.out.println("Index is: " + index);

        // need to provide the index in listIterator, from where the iteration should start
        ListIterator <Integer> listIterator = nums.listIterator(nums.size());

        // traversing backward direction
        while (listIterator.hasPrevious()) {
            int previousVal = listIterator.previous();
            // think of the cursor pointing to the spaces between elements, rather than on to the elements themselves
            System.out.println("traversing backward: " + previousVal + " nextIndex: " + listIterator.nextIndex() + " previous index: " + listIterator.previousIndex());
        }

        ListIterator <Integer> listIterator2 = nums.listIterator();

        // traversing forward direction
        while (listIterator2.hasNext()) {
            int nextVal = listIterator2.next();
            // -600, 1, 0
            System.out.println("traversing forward: " + nextVal + " nextIndex: " + listIterator2.nextIndex() + " previous index: " + listIterator2.previousIndex());
            if (nextVal == -200) {
                listIterator2.add(-150);
            }
        }

        nums.forEach(val -> System.out.println("After add, Element is " + val));

        List <Integer> subList = nums.subList(1,3);
        subList.forEach(val -> System.out.println("Sublist Element is " + val));
        subList.add(1800);

        nums.forEach(val -> System.out.println("The Element is " + val));

    }
};