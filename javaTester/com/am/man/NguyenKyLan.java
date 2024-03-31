package com.am.man;

import com.am.woman.NguyenKyDuyen;

public class NguyenKyLan extends NguyenKyDuyen {
	
	// Constructor (hàm khởi tạo)
	public NguyenKyLan() {
		System.out.println(womanID);
		System.out.println(getWomanID());
		
		System.out.println(sex);
		System.out.println(getSex());
		
		System.out.println(womanCarName);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NguyenKyLan kylan = new NguyenKyLan();
		
	}
	
}
