package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValuesFunctions {
	public static boolean checkIfEmail(String checkIfEmail){
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(checkIfEmail);
		return m.matches();
	}
}
