package by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader.readerinterface;

import by.epam.training.javaweb.voitenkiv.task1.util.creator.filedatagenerator.reader.exception.IncorrectFilePathTechnicalCreditProjectException;

public interface Readable {
	public String read() throws IncorrectFilePathTechnicalCreditProjectException;
}
