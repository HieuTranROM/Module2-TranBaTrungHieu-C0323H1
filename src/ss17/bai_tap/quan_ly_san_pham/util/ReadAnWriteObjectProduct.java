package ss17.bai_tap.quan_ly_san_pham.util;



import ss17.bai_tap.quan_ly_san_pham.model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAnWriteObjectProduct {
    final static String PRODUCT_PATH = "src/ss17/bai_tap/quan_ly_san_pham/data/product.dat";

    public static void writeObjectProduct(ArrayList<Product> listProduct) {
        File file = new File(PRODUCT_PATH);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ArrayList<Product> list = new ArrayList<>();
        if (file.length() > 0) {
            list = readObjectProduct();
        }
        for (Product product : listProduct) {
            list.add(product);
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> readObjectProduct() {
        File file = new File(PRODUCT_PATH);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        ArrayList<Product> list = new ArrayList<>();
        try {
            if (file.length()>0){
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                list = (ArrayList<Product>) objectInputStream.readObject();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lỗi xuất nhạp dữ liệu");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void updateObjectProduct(ArrayList<Product> listProduct) {
        File file = new File(PRODUCT_PATH);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ArrayList<Product> list = new ArrayList<>();
        for (Product product : listProduct) {
            list.add(product);
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}