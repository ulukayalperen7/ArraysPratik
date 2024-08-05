
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        System.out.println("Mayın Tarlasına Hoşgeldiniz !");
        MineSweeper ms = new MineSweeper(10, 10);
        ms.arrayCreator();
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

    public void arrayCreator() {

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

        for (String[] strings : str) {
            System.out.println(Arrays.toString(strings));
        }

    }

}
