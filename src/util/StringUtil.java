package util;

public class StringUtil {
	public static boolean ifEmpty(String str) {
		if("".equals(str)||str==null) {
			return true;
		}
		return false;

	}
}
