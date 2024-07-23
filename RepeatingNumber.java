
public class RepeatingNumber {

    public static void main(String[] args) {

        int[] list = {2, 3, 66, 25, 74, 242, 6, 889, 11, 23, 24, 41, 51, 2, 5, 8, 354, 73, 55, 60, 31, 42, 66, 56, 5722, 91};

        int len = list.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (list[i] == list[j] && i != j) {
                    if (list[i] % 2 == 0) {
                        System.out.print(list[i] +" ");
                    }
                }
            }
        }
    }
}
