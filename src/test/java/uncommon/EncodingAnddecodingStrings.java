package uncommon;

import org.apache.commons.codec.binary.Base64;

public class EncodingAnddecodingStrings {

	public static void main(String[] args) {
		
		String str="str123";
		
		byte[] encodedString=Base64.encodeBase64(str.getBytes());
		System.out.println("Encoded string:"+new String(encodedString));
		
		byte[] decodedString=Base64.decodeBase64(encodedString);
		System.out.println("Encoded string:"+new String(decodedString));

	}
}
