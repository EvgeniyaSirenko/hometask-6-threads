import ua.mainacademy.model.ConnectionInfo;
import ua.mainacademy.service.FileManager;
import ua.mainacademy.service.ThreadService;

import java.util.Date;
import java.util.logging.Logger;

public class AppRunner {
	private static final Logger LOG = Logger.getLogger(AppRunner.class.getName());
	
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			ConnectionInfo connectionInfo = new ConnectionInfo(i, new Date().getTime(), "123.123.123.123");
			FileManager.writeConnectionInfoToFile(connectionInfo, "connections.txt", true);
			Thread thread = new ThreadService();
			thread.start();
			LOG.info(String.format("Thread name is: %s", thread.getName()));
		}
		LOG.info(String
				.format("The list of connections: %s", FileManager.readConnectionInfoFromFile("connections.txt")));
	}
}
