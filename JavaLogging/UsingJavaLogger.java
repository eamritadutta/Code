import java.util.logging.Logger;

public class UsingJavaLogger {
    // the reference cannot be changed
    private static final Logger logger = Logger.getLogger(UsingJavaLogger.class.getName());

    public static void main(String[] args) {
	logger.info("Logging an INFO-level message");
    }
}
