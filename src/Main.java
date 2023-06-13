import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("___________CAC BAI TOAN GIAI THUAT____________");
            System.out.println("1. Star square 1 loop");
            System.out.println("2. Star square 2 loop");
            System.out.println("3. Spiral square 2 loop");
            System.out.println("4. Diagonal and square");
            System.out.println("5. Star triangle");
            System.out.println("6. Spiral triangle");
            System.out.println("Nhap vao lua chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Nhap vao canh hinh vuong");
                    int length = sc.nextInt();
                    squareOneLoop(length);
                }
                case 2 ->{
                    System.out.println("Nhap vao canh hinh vuong");
                    int length = sc.nextInt();
                    squareTwoLoop(length);
                }
                case 3 ->{
                    System.out.println("Nhap vao canh hinh vuong");
                    int length = sc.nextInt();
                    spiralSquare(length);
                }
                case 4 -> {
                    System.out.println("Nhap vao canh hinh vuong");
                    int length = sc.nextInt();
                    diagonalLineOfSquare(length);
                }
                case 5 -> {
                    System.out.println("Nhap vao chieu cao hinh tam giac");
                    int height = sc.nextInt();
                    triangleTwoLoop(height);
                }
                case 6 -> {
                    System.out.println("Nhap vao chieu cao hinh tam giac");
                    int height = sc.nextInt();
                    spiralTriangle(height);
                }
            }
        }
        while (choice == 0);
    }
    public static void squareOneLoop(int length){
        for (int i = 1; i <= length * length; i++) {
            if(i % length != 0){
                System.out.print("*");
            } else {
                System.out.print("*");
                System.out.println();
            }
        }
    }
    public static void squareTwoLoop(int length){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void diagonalLineOfSquare(int length){
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++){
                if (i == 1 || i == length) {
                    System.out.print("*");
                } else {
                    if (j == 1 || j == length){
                        System.out.print("*");
                    } else {
                        if (j == i || j == length - i +1){
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
        /*
        side = 7
        * * * * * * *       * * * * * *
        * *       * *       * *     * *
        *   *   *   *       *   * *   *
        *     *     *       *   * *   *
        *   *   *   *       * *     * *
        * *       * *       * * * * * *
        * * * * * * *
         */
    }
    public static void spiralSquare(int length){
        int[][] matrix = new int[length][length];
        int start = 0, end = length - 1, i = 1;
        int x = 0, y = 0, count = 0;
        while (matrix[length / 2][length / 2 - 1] == 0 || matrix[length / 2][length / 2] == 0){
            if (count % 4 == 0){
                x = start;
                y = start;
                while(y <= end) {
                    if (i==10) i=1;
                    matrix[x][y] = i;
                    i++;
                    y++;
                }
                count++;
                start++;
            } else if (count % 4 == 1){
                y = end;
                x = start;
                while(x <= end) {
                    if (i==10) i=1;
                    matrix[x][y] = i;
                    i++;
                    x++;
                }
                count++;
                start--;
            } else if (count % 4 == 2){
                x = end;
                y = end - 1;
                while(y >= start) {
                    if (i==10) i=1;
                    matrix[x][y] = i;
                    i++;
                    y--;
                }
                count++;
                start++;
                end--;
            } else if (count % 4 == 3){
                x = end;
                y = start - 1;
                while(x >= start) {
                    if (i==10) i = 1;
                    matrix[x][y] = i;
                    i++;
                    x--;
                }
                count++;
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    public static void triangleTwoLoop(int height){
        int count = 1;
        int side = height * 2 - 1;
        for (int i = 0; i < height; i++) {
            for (int j = 1; j <= side ; j++) {
                if ((j > side / 2 - i) && (j < (side + 1) / 2 + 1 + i)){
                    System.out.print(count);
                    if((j > side / 2 - i) && j < (side + 1) / 2){
                        count++;
                    } else {
                        count--;
                    }
                }
                else {
                    System.out.print("*");
                }
            }
            count = 1;
            System.out.println();
        }
    }
    public static void spiralTriangle(int height){
        int side = height * 2 - 1;
        int[][] matrix = new int[height][side];
        int start = 0, end = height - 1, m = 0, i = 1;
        int x, y, count = 0, z = 0;
        if (height % 2 == 0) {
            while (matrix[height / 2][height - 2] == 0) {
                if (count % 3 == 0) {
                    x = start;
                    y = side / 2;
                    while (y <= end * 2) {
                        if (i==10) i=1;
                        matrix[x][y] = i;
                        x++;
                        y++;
                        i++;
                    }
                    count++;
                } else if (count % 3 == 1) {
                    x = end;
                    y = end * 2 - 1;
                    while (y >= m + 1) {
                        if (i==10) i=1;
                        matrix[x][y] = i;
                        y--;
                        i++;
                    }
                    count++;
                } else if (count % 3 == 2) {
                    x = end;
                    y = m;
                    while (x > start) {
                        if (i==10) i=1;
                        matrix[x][y] = i;
                        y++;
                        x--;
                        i++;
                    }
                    m = m + 2;
                    start++;
                    end--;
                    count++;
                }
            }
        } else {
            while (matrix[height / 2][(height / 2) * 2] == 0) {
                if (count % 3 == 0) {
                    x = start;
                    y = side / 2;
                    while (y <= end * 2) {
                        if (i==10) i=1;
                        matrix[x][y] = i;
                        x++;
                        y++;
                        i++;
                    }
                    count++;
                } else if (count % 3 == 1) {
                    x = end;
                    y = end * 2 - 1;
                    while (y >= m + 1) {
                        if (i==10) i=1;
                        matrix[x][y] = i;
                        y--;
                        i++;
                    }
                    count++;
                } else if (count % 3 == 2) {
                    x = end;
                    y = m;
                    while (x > start) {
                        if (i==10) i=1;
                        matrix[x][y] = i;
                        y++;
                        x--;
                        i++;
                    }
                    m = m + 2;
                    start++;
                    end--;
                    count++;
                }
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

        /*[[0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 20, 21, 2, 0, 0, 0, 0],
         [0, 0, 0, 19, 32, 0, 22, 3, 0, 0, 0],
         [0, 0, 18, 31, 0, 0, 0, 23, 4, 0, 0], 3 4
      [0, 17, 30, 29, 28, 27, 26, 25, 24, 5, 0],
        [16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6]]

                 height = 4 side = 7 1+ 7 * 4 /2
           *     *     *   [0 3]   *     *     *
           *     *   [1 2] [1 3] [1 4]   *     *
           *   [2 1] [2+2] [2 3] [2 4] [2 5]   *    2 2
         [3 0] [3 1] [3 2] [3 3] [3 4] [3 5] [3 6]

                h = 5 side = 9
           *     *     *     *   [0 4]   *     *     *     *
           *     *     *   [1 3] [1 4] [1 5]   *     *     *
           *     *   [2 2] [2 3] [2+4] [2 5] [2 6]   *     *    2 4
           *   [3 1] [3 2] [3 3] [3 4] [3 5] [3 6] [3 7]   *
         [4 0] [4 1] [4 2] [4 3] [4 4] [4 5] [4 6] [4 7] [4 8]
                    h = 6, side = 11
            * * * * *        1       * * * * *
            * * * * 1        2        1 * * * *
            * * * 1     2    3     2     1 * * *
            * * 1   2  [3]   4   3    2    1 * * [3;4]
            * 1  2   3    4  5  4   3    2   1 *
            1  2   3   4   5 6 5  4    3    2  1

                h =7 side =13 49
                         1
                    24   25   2
                23  40   41   26  3
            22  39  48  [49]  42  27  4     3 6
        21  38  47  46   47   44  43  28  5
    20  37  36  35  34   33   32  31  30  29  6
19  18  17  16  15  14   13   12  11  10  9  8   7

          */
