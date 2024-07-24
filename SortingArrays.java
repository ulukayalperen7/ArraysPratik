
import java.util.Arrays;
import java.util.Scanner;

public class SortingArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Dizinin boyutu n : ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Dizinin elemanlarını giriniz : ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". eleman : ");
            int arr = scanner.nextInt();
            array[i] = arr;
        }
       /*  Arrays.sort(array);
        System.out.println(Arrays.toString(array)); */

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 0;
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
