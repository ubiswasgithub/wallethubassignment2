package ub.wallethub.pages;

import org.apache.log4j.Logger;

/**
 * 
 * @author Uttam
 *
 */

public class Log {
	final static Logger logger = Logger.getLogger(Log.class);

	public Logger getLogger() {
		return logger;

	}

	public void showErrorLog(String parameter) {
		logger.error("This is error : " + parameter);
	}

	public void showInfoLog(String parameter) {
		logger.info("This is Info : " + parameter);
	}

}
