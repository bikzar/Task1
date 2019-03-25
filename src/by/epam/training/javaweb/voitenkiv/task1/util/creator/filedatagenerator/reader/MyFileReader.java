package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader.exception.IncorrectFilePathTechnicalCreditProjectException;
import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader.readerinterface.Readable;

/**
 * @author Sergey Voitenkov Mar 24, 2019
 */
public class MyFileReader implements Readable {

	private String filePath = "Emty_Path";

	private static final Logger LOGER;

	static {
		LOGER = LogManager.getRootLogger();
	}

	public MyFileReader(String filePath) {

		LOGER.debug("MyFileRider class constructor filePath: "
				+ filePath);

		if (filePath != null) {
			this.filePath = filePath;
		}
	}

	@Override
	public String read()
			throws IncorrectFilePathTechnicalCreditProjectException {

		StringBuilder text = new StringBuilder();

		try (BufferedReader fileReader = new BufferedReader(
				new FileReader(filePath))) {

			String tempString;

			while ((tempString = fileReader.readLine()) != null) {
				text.append(tempString).append("\n");
			}

		} catch (FileNotFoundException e) {

			LOGER.warn("Incorrect file path: " + filePath);

			throw new IncorrectFilePathTechnicalCreditProjectException(
					"Incorrect file path", e);

		} catch (IOException e1) {

			LOGER.warn(
					"IOException in read() methood MyFileReader class: "
							+ filePath);
		}

		return text.toString();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {

		LOGER.debug("MyFileRider class setter filePath: " + filePath);

		if (filePath != null) {
			this.filePath = filePath;
		}
	}

}
