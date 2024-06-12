package ss11.bai_tap.dem_so_lan_xuat_hien;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DemSoLanXuatHien {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String text = scanner.nextLine();

        text = text.toLowerCase();

        Map<String, Integer> wordCountMap = new TreeMap<>();

        String[] words = text.split("\\s+");

        for (String word : words) {

            word = word.replaceAll("[^a-zA-Z]", "");

            if (!word.isEmpty()) { // Ignore empty words

                if (wordCountMap.containsKey(word)) {

                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {

                    wordCountMap.put(word, 1);
                }
            }
        }


        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}


