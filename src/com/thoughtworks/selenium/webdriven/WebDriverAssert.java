package com.thoughtworks.selenium.webdriven;

import org.junit.Assert;

public class WebDriverAssert {

	static WebDriverLog logutil;
	
	public static boolean True(boolean bool,String msg){

		if(bool==true){
			WebDriverLog.logInfo("*.* Assert Passed! "+msg);
			Assert.assertTrue(msg, true);
		}else{
			WebDriverLog.logInfo("*.* Assert Failed! "+msg);
			Assert.assertTrue(msg, false);
		}
		return bool;
	}
	
	public static boolean Verify_True(boolean bool,String msg){

		if(bool==true){
			WebDriverLog.logInfo("*.* Vefify Passed! "+msg);

		}else{
			WebDriverLog.logInfo("*.* Vefify Failed! "+msg);
		}
		return bool;
	}
	
	public static boolean True(String ex,String ac,String msg){
		boolean result = ex.trim().equals(ac.trim());
		if(result){
			WebDriverLog.logInfo("*.* Assert Passed! [EX = "+ex.trim()+"] [AC = "+ac.trim()+"] |*|"+msg);
			Assert.assertTrue(msg, true);
		}else{
			WebDriverLog.logInfo("*.* Assert Failed! [EX = "+ex.trim()+"] [AC = "+ac.trim()+"] |*|"+msg);
			Assert.assertTrue(msg, true);
		}
		return result;
	}
	
	public static boolean Verify_True(String ex,String ac,String msg){
		boolean result = ex.trim().equals(ac.trim());
		if(result){
			WebDriverLog.logInfo("*.* Verify Passed! [EX = "+ex.trim()+"] [AC = "+ac.trim()+"] |*|"+msg);
		}else{
			WebDriverLog.logInfo("*.* Verify Failed! [EX = "+ex.trim()+"] [AC = "+ac.trim()+"] |*|"+msg);
		}
		return result;
	}
	
	public static boolean Verify_True_(String ex,String ac,String msg){
		boolean result = (ac.trim().contains(ex.trim()));
		if(result){
			WebDriverLog.logInfo("*.* Verify Passed! [EX = "+ex.trim()+"] [AC = "+ac.trim()+"] |*|"+msg);
		}else{
			WebDriverLog.logInfo("*.* Verify Failed! [EX = "+ex.trim()+"] [AC = "+ac.trim()+"] |*|"+msg);
		}
		return result;
	}
	
	@org.junit.Test
	public void testAA(){
		WebDriverAssert.True(false, "aa");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
