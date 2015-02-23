package org.nammabank.utility;

public class UtilityClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long number = 5;//Math.random();
		String prefix = "ACCNB";
		for(int i=5; i<200;){
		String code = prefix + String.format("%06d", i);
		i=i*5;
		System.out.println(code);
		}
		
	}

}
