package ss10.bai_tap.trien_khai_cac_phuong_thuc_cua_linkedlist;
import java.util.LinkedList;
public class MyLinkedListTest {

        public static void main(String[] args) {
            MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();

            LinkedList test = new LinkedList();
            integerMyLinkedList.addFirst(1);
            integerMyLinkedList.add(1, 2);
            integerMyLinkedList.add(2, 3);
            integerMyLinkedList.add(3, 4);
            integerMyLinkedList.addLast(5);

//        integerMyLinkedList.remove(3);
//        boolean checkValue = integerMyLinkedList.remove((Integer) 2);

            System.out.println("Display linked list: ");
            for (int i = 0; i < integerMyLinkedList.numNodes; i++) {
                System.out.println("Node " + (i + 1) + ": " + integerMyLinkedList.get(i));
            }

//        MyLinkedList<Integer> myLinkedListClone = new MyLinkedList<>();
//        myLinkedListClone = integerMyLinkedList.clone();
//        System.out.println("Display linked list clone: ");
//        for (int i = 0; i < myLinkedListClone.numNodes; i++) {
//            System.out.println("Node " + (i + 1) + ": " + myLinkedListClone.get(i));
//        }

//        final int FIVE = 5;
//        if (integerMyLinkedList.contains(FIVE)) {
//            System.out.println("Linked list contains " + FIVE);
//        } else {
//            System.out.println("Linked list do not contains " + FIVE);
//        }

//        final int FIVE = 5;
//        int indexOfFive = integerMyLinkedList.indexOf(FIVE);
//        if (indexOfFive >= 0) {
//            System.out.println("Index of " + FIVE + " is " + indexOfFive);
//        } else {
//            System.out.println("Linked list has not " + FIVE);
//        }

//        System.out.println("Data of first node " + integerMyLinkedList.getFirst());
//        System.out.println("Data of last node " + integerMyLinkedList.getLast());

//        integerMyLinkedList.clear();
//        System.out.println("Display linked list: ");
//        for (int i = 0; i < integerMyLinkedList.numNodes; i++) {
//            System.out.println("Node " + (i + 1) + ": " + integerMyLinkedList.get(i));
//        }
        }
    }

