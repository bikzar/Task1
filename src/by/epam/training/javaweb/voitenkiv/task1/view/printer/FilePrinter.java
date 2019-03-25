package by.epam.training.javaweb.voitenkiv.task1.view.printer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkiv.task1.view.printer.printerinterface.Printable;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class FilePrinter implements Printable {

	private static final Logger LOGGER;
	
	static {
		LOGGER = LogManager.getRootLogger();
	}

	private String filePath = null;

	public FilePrinter() {
	}

	public FilePrinter(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void print(Object obj) {

		Writer writer = null;

		try {
			if (obj != null && filePath != null) {
				writer = new FileWriter(filePath, true);
				writer.write(obj.toString());
			}

		} catch (IOException e) {
			LOGGER.warn(
					"IOException in print() methood FilePrinter class");
		} finally {

			if (writer != null) {

				try {
					writer.close();
				} catch (IOException e) {
					LOGGER.warn(
							"IOException with writer.close() in FilePrinter class");
				}
			}
		}
		
		LOGGER.debug("End MyFileReader clss");
	}

	public void setFilePath(String filePath) {
		if (filePath != null) {
			this.filePath = filePath;
		}
	}

}
