package Statements;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class NextDays extends Year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time d/m/y");
        int d = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();

       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
       Calendar c1 = Calendar.getInstance();
       Date date = Date(d, m, y);
        c1.setTime(date);
        c1.roll(Calendar.DATE, true);
        System.out.println(simpleDateFormat.format(c1.getTime()));
    }

   

	private static Date Date(int d, int m, int y) {
		// TODO Auto-generated method stub
		return null;
	}



//	public static boolean isLeapYear(int y) {
//        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
//            return true;
//        }
//        return false;
//    }
}