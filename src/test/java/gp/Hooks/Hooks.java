package gp.Hooks;

import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setup() {
		// Any setup code
	}

	@After
	public void tearDown() {
		// Log relevant information after scenario execution
		List<String> logs = CustomLogger.getLogs();
		// Log the logs to console or file or any other storage
		for (String log : logs) {
			System.out.println(log);
		}
	}

}
