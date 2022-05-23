package String;

public class StringBufferHome {

	public static void main(String[] args) {
		/*
		 * stringbuffer() : 15 
		 * stringbuffer(string) : chuỗi 
		 * stringbuffer(int capacity) : độ dài chuỗi
		 */
		StringBuffer buffer = new StringBuffer(15);
		// append dùng để nối chuỗi
		buffer.append("This is ");
		buffer.append("String");
		buffer.insert(7, " a");
		buffer.append('.');
		System.out.println(buffer.length()); // 17
		// dung lượng hiện tại công thức: (dung lượng cũ *2) +2
		System.out.println(buffer.capacity()); // 32
		// dung lượng bằng mức tối thiểu
		buffer.ensureCapacity(100);
		String output = buffer.toString();
		System.out.println(output); // "This is a String."

		// chèn vào vị trí 1 ký tự, 1 mảng chuỗi ,....

		System.out.println(buffer.insert(15, 'm'));

		// replace thay thế

		System.out.println(buffer.replace(5, 10, " this is string replace "));

		// detele
		System.out.println(buffer.delete(5, buffer.length()));
		// đảo ngược chuỗi
		System.out.println(buffer.reverse());
		// ????
		buffer.trimToSize();

		// thay đổi ký tự
		buffer.setCharAt(4, '5');
		System.out.println(buffer.toString());
		// trả về ký tự ở vị trí
		System.out.println(buffer.charAt(2));
		// trả về chuỗi bắt đầu từ,.. kết thúc
		System.out.println(buffer.substring(2));

	}

}
