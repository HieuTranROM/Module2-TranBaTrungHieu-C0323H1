package ss12.bai_tap.luyen_tap_su_dung_linkedList_arrayList;

import java.util.Comparator;

public class SortProductByPricesAsc implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        if (p2.getPrice() == p1.getPrice()) {
            return p2.getName().compareTo(p1.getName());
        }
        return (int) (p2.getPrice() - p1.getPrice());
    }
}

