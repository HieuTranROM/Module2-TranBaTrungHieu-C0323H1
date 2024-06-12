package ss17.bai_tap.quan_ly_san_pham.service;

import ss17.bai_tap.quan_ly_san_pham.model.Product;
import ss17.bai_tap.quan_ly_san_pham.util.ReadAnWriteObjectProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private Scanner scanner = new Scanner(System.in);

    public void add() {
        List<Product> productList = ReadAnWriteObjectProduct.readObjectProduct();

        System.out.println("Add new Product:");
        String productCode;
        if (productList.size() == 0) {
            System.out.println("Product code:");
            productCode = scanner.nextLine();
        } else {
            while (true) {
                boolean checkDuplicate = false;
                System.out.println("Product code:");
                productCode = scanner.nextLine();

                for (int i = 0; i < productList.size(); i++) {
                    if (productList.get(i).getProductCode().equals(productCode)) {
                        checkDuplicate = true;
                        break;
                    }
                }

                if (checkDuplicate) {
                    System.out.println("\nError: Duplicate Product code.\nTry agian.\n");
                    continue;
                } else {
                    break;
                }
            }
        }
        System.out.println("Product name:");
        String productName = scanner.nextLine();
        System.out.println("Manufacturer:");
        String manufacturer = scanner.nextLine();
        System.out.println("Price:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Other descriptions:");
        String descriptions = scanner.nextLine();
        Product product = new Product(productCode,productName,manufacturer,price,descriptions);
        List<Product> newProductList = new ArrayList<>();
        newProductList.add(product);
        ReadAnWriteObjectProduct.writeObjectProduct((ArrayList<Product>) newProductList);
    }

    public void display(){
        System.out.println("Display list Product:");
        List<Product> productList = ReadAnWriteObjectProduct.readObjectProduct();
        for (int i=0;i<productList.size();i++){
            System.out.println((i+1)+"."+productList.get(i));
        }
    }

    public void edit(){
        display();
        List<Product> productList = ReadAnWriteObjectProduct.readObjectProduct();
        if (productList.size() == 0) {
            System.out.println("\nNo products. Let's add new Product.\n");
            return;
        }
        int index;
        while (true) {
            System.out.println("Choose Product to update:");
            index = Integer.parseInt(scanner.nextLine());

            if (index < 1 || index > productList.size()) {
                System.out.println("\nError: Invalid index. Try agian.\n");
                continue;
            } else {
                break;
            }
        }

        String productCode = "";
        while (true) {
            boolean checkDuplicate = false;
            System.out.println("Product code:");
            productCode = scanner.nextLine();

            for (int i = 0; i < productList.size(); i++) {
                if (i == index - 1) {
                    continue;
                }
                if (productList.get(i).getProductCode().equals(productCode)) {
                    checkDuplicate = true;
                    break;
                }
            }

            if (checkDuplicate) {
                System.out.println("\nError: Duplicate Product code.\nTry agian.\n");
                continue;
            } else {
                break;
            }
        }
        System.out.println("Product name:");
        String productName= scanner.nextLine();
        System.out.println("Manufacturer:");
        String manufacturer= scanner.nextLine();
        Double price;
        while (true) {
            System.out.println("Price:");
            price = Double.parseDouble(scanner.nextLine());
            if (price <= 0) {
                System.out.println("\nError: The price can't be small than or equal to 0.\nTry agian.\n");
            } else {
                break;
            }
        }
        System.out.println("Descriptions:");
        String descriptions= scanner.nextLine();

        productList.get(index-1).setProductCode(productCode);
        productList.get(index-1).setProductName(productName);
        productList.get(index-1).setManufacturer(manufacturer);
        productList.get(index-1).setPrice(price);
        productList.get(index-1).setDescriptions(descriptions);

        ReadAnWriteObjectProduct.updateObjectProduct((ArrayList<Product>) productList);
    }

    public void delete(){
        display();
        List<Product> productList = ReadAnWriteObjectProduct.readObjectProduct();
        if (productList.size() == 0) {
            System.out.println("\nNo products. Let's add new Product.\n");
            return;
        }
        System.out.println("Chose Product to delete:");
        int index = Integer.parseInt(scanner.nextLine());
        productList.remove(index-1);
        ReadAnWriteObjectProduct.updateObjectProduct((ArrayList<Product>) productList);
    }

    public void searchByProductCode(){
        List<Product> productList = ReadAnWriteObjectProduct.readObjectProduct();
        if (productList.size() == 0) {
            System.out.println("\nNo products. Let's add new Product.\n");
            return;
        }
        System.out.println("Enter product code:");
        String searchProductCode = scanner.nextLine();

        boolean checkProductCode = false;
        for (Product product: productList){
            if (product.getProductCode().equals(searchProductCode)){
                checkProductCode = true;
                System.out.println(product.toString());
                break;
            }
        }

        if (checkProductCode == false) {
            System.out.println("No products found.");
        }
    }
}
