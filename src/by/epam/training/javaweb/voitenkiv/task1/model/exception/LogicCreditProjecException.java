package by.epam.training.javaweb.voitenkiv.task1.model.exception;

public class LogicCreditProjecException
	extends CreditProjectException {

    private static final long serialVersionUID = -5785885249046034347L;

    public LogicCreditProjecException() {
    }

    public LogicCreditProjecException(String message,
	    Throwable cause) {
	super(message, cause);
    }

    public LogicCreditProjecException(Throwable cause) {
	super(cause);
    }

}
