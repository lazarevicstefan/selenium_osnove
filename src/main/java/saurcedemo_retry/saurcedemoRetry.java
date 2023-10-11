package saurcedemo_retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class saurcedemoRetry implements IRetryAnalyzer {
    private int count = 0;
    private int max = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        for (int i = 0; i < max; i++) {
            if (count < max){
                count++;
                return true;
            }
        }


        return false;
    }
}
