package utility;

import org.apache.log4j.Logger;

public class Log {
	
	
    static public Logger logger=Logger.getLogger(Log.class.getName());
    
    public static void startTestcase(String sTestcaseName)
    {
    	logger.info(sTestcaseName);
    }
    public static void endTestcase(String sTestcaseName)
    {
    	logger.info(sTestcaseName);
    }
    public static void info(String message)
    {
    	logger.info(message);
    }
}
