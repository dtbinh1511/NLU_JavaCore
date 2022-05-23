package Method;

public class Bai37 {
    public static int freheit(int c) {
        int f = 9 * c / 5 + 32;
        return f;
    }

    public static void main(String[] args) {
        int f;
        for (int i = -50; i <= 50; i++) {
            f = freheit(i);
            System.out.printf("%3d độ C = %3d độ f \n", i, f);

        }
    }
}