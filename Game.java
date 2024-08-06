
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        System.out.println("Mayın Tarlasına Hoşgeldiniz !");
        MineSweeper ms = new MineSweeper(10, 10);
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

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[0].length; j++) {
                newStr[i][j] = "- ";
            }
        }

        int chooseRow;
        int chooseCol;
        int counter = 0;
        do {

            for (String[] strings : newStr) {
                System.out.println(Arrays.toString(strings));
            }
            System.out.print("Satır giriniz: ");
            chooseRow = scanner.nextInt();
            System.out.print("Sütun giriniz: ");
            chooseCol = scanner.nextInt();
            System.out.println("===========================");
            if (str[chooseRow][chooseCol].equals("* ")) {
                System.out.println("Game Over!");
                return;
            }

            for (int i = chooseRow - 1; i < chooseRow + 2; i++) {
                for (int j = chooseCol - 1; j < chooseCol + 2; j++) {
                    if (str[i][j].equals("* ") && i >= 0 && j >= 0 && j <= column - 1 && i <= row - 1) {
                        counter++;
                    }
                }
            }
            newStr[chooseRow][chooseCol] = counter + "";

        } while (!str[chooseRow][chooseCol].equals("* "));

    }

}
