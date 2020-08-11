package Lesson_7.Homework_7;

public class MainSpiral {

    public static void main(String[] args) {

        final int Y = 4;
        final int X = 4;

        int[][] arr = new int[Y][X];

        int indMax = Y / 2;
        if (Y % 2 != 0) {
            indMax += 1;
        }

        int count = 1;
        for (int ind = 0; ind < indMax; ind++) {
            for (int j = ind; j < X - ind; j++) {
                arr[ind][j] = count++;
            }
            for (int i = ind + 1; i < Y - ind; i++) {
                arr[i][X - 1 - ind] = count++;
            }
            for (int m = X - 2 - ind; m >= ind; m--) {
                arr[Y - 1 - ind][m] = count++;
            }
            for (int k = Y - 2 - ind; k > ind; k--) {
                arr[k][ind] = count++;
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("\n");
        }

    }

}
