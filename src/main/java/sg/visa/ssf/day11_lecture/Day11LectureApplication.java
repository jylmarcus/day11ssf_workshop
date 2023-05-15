package sg.visa.ssf.day11_lecture;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11LectureApplication {
	private static final Logger logger = LoggerFactory.getLogger(Day11LectureApplication.class);

	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		logger.info("main method started ..... ");
		SpringApplication app = new SpringApplication(Day11LectureApplication.class);

		String port = null;
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		if (appArgs.containsOption("port")) {
			port = appArgs.getOptionValues("port").get(0);
		}

		if (appArgs.getOptionValues("port") == null ||appArgs.getOptionValues("port").get(0) == null) {
			port = System.getenv("PORT");

			if(port == null) {
				port = DEFAULT_PORT;
			}
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));

		System.out.printf("Application started on port %s\n", port);
		app.run(args);
	}

}
