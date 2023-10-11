package swagLabs_retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class swagLabsRetry implements IRetryAnalyzer {
    private int count = 0;
    private int max = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < max){
            count++;
            return true;
        }
        return false;
    }
}
