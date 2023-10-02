package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateForrmater {
	private static final String PATTERN = "yyyy-MM-dd";
	private static final DateTimeFormatter FORRMATER = DateTimeFormatter.ofPattern(PATTERN);
	public static LocalDate format(String date) {
		return LocalDate.parse(date, FORRMATER);
	}
	
	
	public static boolean isValidStringDate(String date) {
		try {
			format(date);
			return true;
		}catch(DateTimeParseException e) {
			return false;
		}
	}
}
