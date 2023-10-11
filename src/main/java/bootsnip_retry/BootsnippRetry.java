package bootsnip_retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class BootsnippRetry implements IRetryAnalyzer {

    private int count = 0;
    private int maxRetry = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxRetry) {
            count++;
            return true;
        }
        return false;
    }
}