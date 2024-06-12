package ss17.bai_tap.quan_ly_san_pham.controller;

import ss17.bai_tap.quan_ly_san_pham.service.ProductService;
import java.util.Scanner;

public class Main {
    static final int ADD =1;
    private static ProductService productService = new ProductService();
    public static void main(String[] args) {
        boolean flag =true;
        do {
            System.out.println("Menu Product:" +
                    "\n1.add" +
                    "\n2.display" +
                    "\n3.edit" +
                    "\n4.delete"+
                    "\n5.search"+
                    "\n6.Exit");
            Scanner scanner = new Scanner(System.in);
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu){
                case 1:
                    productService.add();
                    //code
                    break;
                case 2:
                    //code
                    productService.display();
                    break;
                case 3:
                    System.out.println("Function update Product:");
                    productService.edit();
                    break;
                case 4:
                    System.out.println("Function delete Product:");
                    productService.delete();
                    break;
                case 5:
                    System.out.println("Function search by Product code:");
                    productService.searchByProductCode();
                    break;
                default:
                    flag=false;
            }
        }while (flag);
    }
}