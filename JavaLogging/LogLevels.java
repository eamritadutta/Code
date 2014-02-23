import java.util.logging.Logger;
import java.util.logging.Level;

public class LogLevels {
    
    private static final Logger logger = Logger.getLogger(LogLevels.class.getName());

    public static void main(String[] args) {
	logger.info("Logging an INFO-level message");
	logger.severe("Logging an SEVERE-level message");
	logger.warning("Logging an WARNING level message");

	// how to log an exception
	try {
	    throw new Exception("My Exception");
	} catch (Exception ex) {
	    logger.log(Level.SEVERE, "Logging in Catch Block", ex);
	}
    }
}
