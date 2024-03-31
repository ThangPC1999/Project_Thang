package com.java.basic;

public class Basic_04_Dynamic_Locator {
	
	
	

	public static void main(String[] args) {
		String locator = "//p[@class='%s' and @id='%s' and contains(text(),'%s']";
		
		Basic_04_Dynamic_Locator test = new Basic_04_Dynamic_Locator();
		test.castToObject(locator, "thang", "phan", "chi");

	}
	
	public void castToObject(String Locator, String...valueName ) {
		Locator =  String.format(Locator,(Object[]) valueName);
		System.out.println(Locator);
		
	}

}
