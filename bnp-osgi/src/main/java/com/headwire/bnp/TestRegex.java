package com.headwire.bnp;

public class TestRegex {
	
	//www.invitrogen.com/site/us/en/home/support*
	//www.lifetechnologies.com/us/en/home/support*
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "This is a test of http://www.invitrogen.com/site/us/en/home/support/PAGE1_lol.html some link.html";
		
		String test2 = "This is a test of http://www.invitrogen.com/site/ca/en/home/support/page1 some link";
		String test3 = "This is a test of http://www.invitrogen.com/site/ca/fr/home/support/page1 some link";
		String test4 = "This is a test of http://www.invitrogen.com/site/fr/fr/home/support/page1 some link";
		
		String regx1 = "www.invitrogen.com/site/(..)/(..)/home/support(/.*?\\.html)";
		String repl1 = "www.lifetechnologies.com/$1/$2/home/support$3";

		out(test1);
		out(test1.replaceAll(regx1, repl1));
		out();
		
//		out(test2);
//		out(test2.replaceAll(regx1, repl1));
//		out();
//		
//		out(test3);
//		out(test3.replaceAll(regx1, repl1));
//		out();
//		
//		out(test4);
//		out(test4.replaceAll(regx1, repl1));
//		out();
		
	}
	
	private static void out(String s) {
		System.out.println(s);
	}
	
	private static void out() {
		System.out.println();
	}

}
