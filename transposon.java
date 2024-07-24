
import java.util.Scanner;

public class transposon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dizinin boyutu N x M  ");
        System.out.print("N : ");
        int n = scanner.nextInt();
        System.out.print("M : ");
        int m = scanner.nextInt();

        int[][] array = new int[n][m];
        int[][] newArr = new int[m][n];
        System.out.println("Dizinin elemanlarını giriniz : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((i + 1) + ". satır " + (j + 1) + ". sütun elemanı: ");
                int arr = scanner.nextInt();
                array[i][j] = arr;
                newArr[j][i] = arr;
            }
        }
        System.out.println("Matris : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Transpoze : ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }

    }
}
