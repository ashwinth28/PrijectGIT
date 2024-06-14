package gp.Hooks;

import java.util.ArrayList;
import java.util.List;

public class CustomLogger {

	private static List<String> logs = new ArrayList<>();

	public static void log(String message) {
		logs.add(message);
	}

	public static List<String> getLogs() {
		return logs;
	}
}
