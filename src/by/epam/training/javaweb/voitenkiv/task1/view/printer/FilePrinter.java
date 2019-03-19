package by.epam.training.javaweb.voitenkiv.task1.view.printer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import by.epam.training.javaweb.voitenkiv.task1.view.printer.exception.WronOutputPathTechnicalException;
import by.epam.training.javaweb.voitenkiv.task1.view.printer.printerinterface.Printable;

/**
 * @author Sergey Voitenkov March 16 2019
 */

public class FilePrinter implements Printable {

	private String filePath = null;

	public FilePrinter() {
	}

	public FilePrinter(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void print(Object obj)
			throws WronOutputPathTechnicalException {

		Writer writer = null;

		try {

			writer = new FileWriter(filePath, true);
			writer.write(obj.toString());

		} catch (FileNotFoundException e) {

			throw new WronOutputPathTechnicalException(
					"File not found", e);

		} catch (IOException e) {
			// write to loger
		} finally {

			if (writer != null) {

				try {
					writer.close();
				} catch (IOException e) {
					// write to loger
				}
			}
		}
	}

	public void setFilePath(String filePath) {
		if (filePath != null) {
			this.filePath = filePath;
		}
	}

}
