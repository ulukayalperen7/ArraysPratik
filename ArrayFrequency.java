
import java.util.Scanner;

public class ArrayFrequency {

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
        System.out.println("Tekrar Sayilari : ");

        boolean[] counted = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!counted[i]) { // defaul false 
                int count = 1;
                for (int j = 0; j < n; j++) {
                    if (array[i] == array[j] && i != j) {
                        count++;
                        counted[j] = true;
                    }
                }
                System.out.println(array[i] + " sayısı " + count + " kere tekrar edildi.");
            }
        }
    }
}
