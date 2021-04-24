package pl.devfoundry.unit_testing_java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;

public class OrderBackUp {

	private Writer writer;

	public Writer getWriter() {
		return writer;
	}
	
	void createFile() throws FileNotFoundException {
		File file = new File("orderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
	}
	
	void backUpOrder(Order order) throws IOException {
		writer.append(order.toString());
		
	}
	
	void closeFile() throws IOException {
		writer.close();
	}
}
