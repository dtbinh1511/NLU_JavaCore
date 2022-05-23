package Bai1;
import java.util.Scanner;

public class Ex3VeTamGiacDoiXung {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter h");
        int h = sc.nextInt();

        for (int i = 1; i <= h; i++) {
            for (int j = i-1; j <h ; j++) {
                System.out.print("   ");
            }
//            System.out.println();
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print(j+"  ");
                if(j>=i){
                    break;
                }
            }
            for (int j2 = i-1; j2 >0 ; j2--) {
                System.out.print(j2+"  ");
            }
            System.out.println();

        }
        sc.close();
    }

}