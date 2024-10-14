package com.citi.mbd.TestCases;

import org.testng.TestNG;

import com.city.mbd.Utility.Reporting;

public class TestRunner {
	

	static TestNG testNG;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside main method");
		Reporting report = new Reporting();
		testNG = new TestNG();
		
		testNG.setTestClasses(new Class[] {TC_LoginTest_001.class});
		//testNG.setTestClasses(new Class[] {TC_LoginTest_001.class, TC_FLDA_012.class, TC_RDMUpload_010.class, TC_CreatePlan_003.class});
		//testNG.setTestClasses(new Class[] {TC_LoginTest_001.class, TC_Macro_006.class, TC_GCUpload_004.class});
		//testNG.setTestSuites(suites);
		//testNG.setGroups("sanity");
		testNG.addListener(report);
		testNG.run();

	}


}
