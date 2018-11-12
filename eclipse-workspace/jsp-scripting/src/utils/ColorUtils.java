package utils;
import java.util.Random;

public class ColorUtils {
	public static String random() {
        String bgColor = "#";
    	Random random = new Random();
    	int val = random.nextInt();
    	String Hex = new String();
    	Hex = Integer.toHexString(val);
    	System.out.println("val: " + val + "  Hex: "+ Hex);
    	bgColor += Hex;
        return bgColor;
	}
}
