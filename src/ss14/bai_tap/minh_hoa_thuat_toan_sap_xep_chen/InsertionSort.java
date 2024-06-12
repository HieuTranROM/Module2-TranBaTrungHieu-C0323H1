package ss14.bai_tap.minh_hoa_thuat_toan_sap_xep_chen;

public class InsertionSort {

    // Phương thức sắp xếp chèn
    public static void insertSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            System.out.println("Chen key " + arr[j + 1] + " vao vi tri " + (j + 1));
        }
    }

    // In các phần tử của mảng
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};
        System.out.println("Mang ban dau:");
        printArray(arr);
        insertSort(arr);
        System.out.println("Mang sau khi sap xep:");
        printArray(arr);
    }
}