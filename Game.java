
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mayın Tarlasına Hoşgeldiniz !");
        int row, column;
        do {
            System.out.print("Satır sayısını giriniz (min 2): ");
            row = scanner.nextInt();
            System.out.print("Sütun sayısını giriniz (min 2): ");
            column = scanner.nextInt();

            if (row < 2 || column < 2) {
                System.out.println("Satır ve sütun sayısı en az 2 x 2 olmalıdır. Lütfen tekrar giriniz.");
            }
        } while (row < 2 || column < 2);

        MineSweeper ms = new MineSweeper(row, column);
        ms.displayGame(ms.arrayCreator());
    }
}

class MineSweeper {

    private int row;
    private int column;

    Scanner scanner = new Scanner(System.in);

    public MineSweeper(int row, int column) { // satır sütun
        this.row = row;
        this.column = column;
    }

    public String[][] arrayCreator() {

        String[][] str = new String[row][column];

        int numberOfBomb = (row * column) / 4;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                str[i][j] = "- ";
            }
        }

        int randRow;
        int randCol;

        for (int i = 0; i < numberOfBomb; i++) {
            do {
                randRow = (int) (Math.random() * row);
                randCol = (int) (Math.random() * column);
            } while (str[randRow][randCol].equals("* "));
            str[randRow][randCol] = "* ";
        }

        /*  for (String[] strings : str) {
            System.out.println(Arrays.toString(strings));
        } */
        return str;
    }

    public void displayGame(String[][] str) {

        String[][] newStr = new String[str.length][str[0].length];
        boolean[][] revealed = new boolean[str.length][str[0].length]; // açılanlar
        int numberOfBomb = (row * column) / 4;
        int cellRevealed = 0;

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                newStr[i][j] = "- ";
                revealed[i][j] = false;
            }
        }

        int chooseRow;
        int chooseCol;
        int counter;
        boolean isOver = false;

        do {

            print(newStr);

            System.out.print("Satır giriniz: ");
            chooseRow = scanner.nextInt();
            System.out.print("Sütun giriniz: ");
            chooseCol = scanner.nextInt();

            if (chooseRow < 0 || chooseRow >= row || chooseCol < 0 || chooseCol >= column) {
                System.out.println("Lütfen geçerli bir koordinat giriniz :");
                continue;
            }
            if (revealed[chooseRow][chooseCol]) {
                System.out.println("Bu koordinat daha önce seçildi, başka bir kordinat giriniz.");
                continue;
            }
            if (str[chooseRow][chooseCol].equals("* ")) {
                print(str);
                System.out.println("Game Over !");
                isOver = true;
                continue;
            }
            revealed[chooseRow][chooseCol] = true;
            counter = 0;
            for (int i = chooseRow - 1; i <= chooseRow + 1; i++) {
                for (int j = chooseCol - 1; j <= chooseCol + 1; j++) {
                    if (i >= 0 && j >= 0 && j < column && i < row) {
                        if (str[i][j].equals("* ")) {
                            counter++;
                        }
                    }
                }
            }
            newStr[chooseRow][chooseCol] = counter + " ";
            cellRevealed++;

            if (cellRevealed == (row * column) - numberOfBomb) {
                print(str);
                System.out.println("Tebrikler, oyunu kazandınız!");
                isOver = true;
            }

            System.out.println("===========================");

        } while (!isOver);

    }

    private void print(String[][] board) {
        for (String[] strings : board) {
            System.out.println(Arrays.toString(strings));
        }
        System.out.println();
    }

}
