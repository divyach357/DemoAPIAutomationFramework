package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	private static final Logger logger = LogManager.getLogger(TestListener.class);
	
	public void onStart(ITestContext context) {
	    
		logger.info("Test Suite Started!!!");
	    
	}
	public void onTestSuccess(ITestResult result) {
		 
		logger.info(result.getMethod().getMethodName() + "Test is Success!!");
		
		logger.info("Description "+ result.getMethod().getDescription());
		 
	}

	 
	  public void onTestFailure(ITestResult result) {

			logger.error(result.getMethod().getMethodName() + "Test Failed!!");
			
			logger.info("Description "+ result.getMethod().getDescription());

	  }

	  public void onTestSkipped(ITestResult result) {
		  
		  logger.info(result.getMethod().getMethodName() + "Test Suite Skipped!!");
		 
	  }
	  
	  public void onFinish(ITestContext context) {

		  logger.info("Test Suite Finished!!");

	  }


}
