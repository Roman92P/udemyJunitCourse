package pl.devfoundry.testNG;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

	public int actualRetry=0;
	public static final int MAX_RETRY=3;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(actualRetry<MAX_RETRY) {
			actualRetry++;
			return true;
		}
		return false;
	}

}
