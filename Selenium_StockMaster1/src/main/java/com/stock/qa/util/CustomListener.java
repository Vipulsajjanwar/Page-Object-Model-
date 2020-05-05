package com.stock.qa.util;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.stock.qa.base.TestBase;

 
public class CustomListener extends TestBase implements ITestListener{

	@Override
	 public void onTestFailure(ITestResult result) {
		System.out.println("test failed");
		try {
			FailedTestCase(result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
