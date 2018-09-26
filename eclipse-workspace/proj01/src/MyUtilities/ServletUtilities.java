package MyUtilities;

public class ServletUtilities {
	public static String headWithTitle(String title) {
		return("<!DOCTYPE html>\n" + 
	"<html>\n" + "<head><title>" + title + "</title></head>\n");
	}
	
	public static String footerString() {
		return("<hr><p>CST 4713</p></body></html>");
	}
	
	
}
