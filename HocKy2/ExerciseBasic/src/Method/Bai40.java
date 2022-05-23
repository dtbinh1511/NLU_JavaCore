package Method;

// import java.util.Scanner;

public class Bai40 {
    public static double toHop(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        if (k == 1)
            return n;
        return toHop(k - 1, n - 1) + toHop(k, n - 1);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                int c = (int) toHop(i, j);
                System.out.printf("%3d ", c);
            }
            System.out.println();
        }
        System.out.println("  ......");
    }
}