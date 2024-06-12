package ss10.bai_tap.trien_khai_cac_phuong_thuc_cua_arraylist;

public class MyListTest {

    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<>();
        integerMyList.add(1);
        integerMyList.add(1, 3);
        integerMyList.add(2, 5);

        System.out.println("\nDisplay array list: ");
        for (int i = 0; i < integerMyList.size; i++) {
            System.out.println(integerMyList.get(i));
        }

        integerMyList.remove(2);
        System.out.println("\nArray list after remove: ");
        for (int i = 0; i < integerMyList.size; i++) {
            System.out.println(integerMyList.get(i));
        }

        if (integerMyList.contains(3)) {
            System.out.println("\nArray list is contains 3");
        } else {
            System.out.println("\nArray list is not contains 3");
        }

        int checkIndexOf = integerMyList.indexOf(5);
        if (checkIndexOf >= 0) {
            System.out.println("Index of 5 is " + checkIndexOf);
        } else {
            System.out.println("Array list is not contains 5");
        }

        integerMyList.clear();
        System.out.println("\nArray list after clear: ");
        for (int i = 0; i < integerMyList.size; i++) {
            System.out.println(integerMyList.get(i));
        }

        MyList<Integer> myListClone = new MyList<>();
        myListClone = integerMyList.clone();
        System.out.println("\nDisplay array list clone: ");
        for (int i = 0; i < myListClone.size; i++) {
            System.out.println(myListClone.get(i));
        }
    }
}

