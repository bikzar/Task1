package by.epam.training.javaweb.voitenkiv.task1.util.serializator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkiv.task1.model.entity.credit.Credit;

/**
 * @author Sergey Voitenkov Mar 25, 2019
 */

public class CreditSerializator {
	private static final Logger LOGGER;
	
	static {
		LOGGER = LogManager.getRootLogger();
	}
	
	public static void write(Credit credit, String filePath) {
		
		LOGGER.debug("Method write start");
		
		if (credit != null && filePath != null) {
			
			LOGGER.debug("Start try block");
		
			try (ObjectOutputStream dataOutPutStrim = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(filePath)))) {
				
				LOGGER.debug("Write credit object");
				
				dataOutPutStrim.writeObject(credit);
				
				LOGGER.debug("End try block");
				
			} catch (IOException e) {
				LOGGER.warn("IOExcetion from CreditSerializator calss in method write()", e);
			}
		}
		
		LOGGER.debug("Method write end");
	}
	
	public static Credit read(String filePath) {
		
		Credit credit = null;
		
		LOGGER.debug("Method read start");
		
		if (filePath != null) {
			
			LOGGER.debug("Start try block");
		
			try (ObjectInputStream dataInPutStream = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(filePath)))) {
				
				LOGGER.debug("Write credit object");
				
				credit = (Credit)dataInPutStream.readObject();
				
				LOGGER.debug("End try block");
				
			} catch (IOException e) {
				LOGGER.warn("IOExcetion from CreditSerializator calss in method read()", e);
				
			} catch (ClassNotFoundException e) {
				LOGGER.warn("ClassNotFoundException from CreditSerializator calss in method read()", e);
			}
		}
		
		LOGGER.debug("Method read end");
		
		return credit;
	}
}
