package ss12.bai_tap.luyen_tap_su_dung_linkedList_arrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        Product p1 = new Product(1, "Giay", 230000);
        Product p2 = new Product(2, "Ao", 220000);
        Product p3 = new Product(3, "Quan", 210000);
        Product p4 = new Product(4, "Giay", 200000);
        Product p5 = new Product(5, "Sach", 210000);
        Product p6 = new Product(6, "Vo", 190000);

        productManager.addProduct(p1);
        productManager.addProduct(p2);
        productManager.addProduct(p3);
        productManager.addProduct(p4);
        productManager.addProduct(p5);
        productManager.addProduct(p6);

        List<Product> products = productManager.getProductList();
        productManager.sortProductByPricesAsc(products);

        System.out.println("Sap xep theo gia giam dan, neu gia bang nhau thi sap xep giam dan theo ten:");
        products.stream().forEach(p -> System.out.println(p));

        Product updateProduct = new Product(1, "vang", 50000);
        if (productManager.editProduct(updateProduct)) {
            System.out.println("Cap nhat san pham thanh cong");
        } else {
            System.out.println("Cap nhat san pham that bai");
        }

        if (productManager.deleteProduct(6)) {
            System.out.println("Xoa san pham thanh cong");
        } else {
            System.out.println("Xoa san pham that bai");
        }

        products.stream().forEach(p -> System.out.println(p));
    }
}