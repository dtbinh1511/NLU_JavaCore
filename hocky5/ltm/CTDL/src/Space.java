import java.util.Iterator;

public class Space {
	
	public static String [] spaceString(String strings) {
		String newString = strings.toLowerCase();
		
		String[] stringArray = newString.split(" ");
		
		String result ="";
		for(int i =0 ; i < stringArray.length; i++){
			result += stringArray[i];
		}
		
		return stringArray;
	}
	
	public static void main(String[] args) {
		String s = "  Do  Thanh BINH  ";
		
		System.out.println(s.split(" "));
	}
}
