package Arrays_List;

import java.util.ArrayList;

public class Test {
public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(5);
	list.add(10);
	list.add(7);
	list.remove(2);
	list.get(1);
	System.out.println(list);
}
}
