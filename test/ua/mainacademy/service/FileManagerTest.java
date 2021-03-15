package ua.mainacademy.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.mainacademy.model.ConnectionInfo;

import java.io.File;
import java.util.List;

class FileManagerTest {
	private static final String MAIN_DIR = System.getProperty("user.dir");
	private static final String SEPARATOR = System.getProperty("file.separator");
	private static final String FILES_DIR = MAIN_DIR + SEPARATOR + "files";
	
	@BeforeAll
	public static void addData() {
		ConnectionInfo connectionTest = new ConnectionInfo(123456, 2L, "123.123.123.123");
		FileManager.writeConnectionInfoToFile(connectionTest, "connectionsTest.txt", true);
	}
	
	@AfterAll
	public static void deleteData() {
		String filePath = FILES_DIR + SEPARATOR + "connectionsTest.txt";
		File file = new File(filePath);
		file.delete();
	}
	@Test
	void readConnectionInfoFromFile() {
		List<ConnectionInfo> result = FileManager.readConnectionInfoFromFile("connectionsTest.txt");
		Assertions.assertEquals("[123456 2 123.123.123.123]", result.toString());
	}
}