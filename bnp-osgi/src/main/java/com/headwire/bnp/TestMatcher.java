package com.headwire.bnp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TestMatcher {
	
	//www.invitrogen.com/site/us/en/home/support*
	//www.lifetechnologies.com/us/en/home/support*
	
	public static void main(String[] args) {
		
		
		matcherExample();
		
		matcherInvitrogen1();
		matcherInvitrogen2();
	}
	
	private static void matcherInvitrogen2() {
		// TODO Auto-generated method stub
		String test1 = "This is a test of http://www.invitrogen.com/site/us/en/home/support/PAGE1_lol.html some link.html";
		//String test2 = "This is a test of http://www.invitrogen.com/site/us/en/home/support/PAGE1_lol.html some link.html";
		
		String test2 = "This is a test of http://www.invitrogen.com/site/ca/en/home/support/page1 some link";
		String test3 = "This is a test of http://www.invitrogen.com/site/ca/fr/home/support/page1 some link";
		String test4 = "This is a test of http://www.invitrogen.com/site/fr/fr/home/support/page1 some link";
		
		String regx1 = "(?:https?\\://)?www.invitrogen.com/site/(../..)(/home/support)(/.*?\\.html)";
		// Using a Matcher now, so no replacement string
		//String repl1 = "www.lifetechnologies.com/$1/$2/home/support$3";
		
		String test1R = "";
		
		Pattern pattern = Pattern.compile(regx1);
		Matcher matcher = pattern.matcher(test1);
		
		StringBuffer s = new StringBuffer();
		
		// find the match
		matcher.find();
		
		// build the replacement
		StringBuffer replacement = new StringBuffer();
		replacement.append("/content/lifetech/");
		replacement.append(matcher.group(1));
		replacement.append(matcher.group(2));
		//replacement.append("/home/support");
		replacement.append(matcher.group(3).toLowerCase().replaceAll("_", "-"));
		
		// append the replacement
		matcher.appendReplacement(s, replacement.toString());
		
		matcher.appendTail(s);
		
		test1R = s.toString();
		
		out(test1);
		out(test1R);
		out();
		
//		out(test2);
//		out(test2.replaceAll(regx1, repl1));
//		out();
		
//		out(test3);
//		out(test3.replaceAll(regx1, repl1));
//		out();
		
//		out(test4);
//		out(test4.replaceAll(regx1, repl1));
//		out();
	}
	
	private static void matcherInvitrogen1() {
		// TODO Auto-generated method stub
		String test1 = "This is a test of http://www.invitrogen.com/site/us/en/home/support/PAGE1_lol.html some link.html";
		String test2 = "This is a test of http://www.invitrogen.com/site/us/en/home/support/PAGE1_lol.html some link.html";
		
		String regx1 = "(?:https?\\://)?www.invitrogen.com/site/(../..)(/home/support)(/.*?\\.html)";
		// Using a Matcher now, so no replacement string
		//String repl1 = "www.lifetechnologies.com/$1/$2/home/support$3";
		
		String test1R = "";
		
		Pattern pattern = Pattern.compile(regx1);
		Matcher matcher = pattern.matcher(test1);
		
		StringBuffer s = new StringBuffer();
		
		// find the match
		matcher.find();
		
		// build the replacement
		StringBuffer replacement = new StringBuffer();
		replacement.append("/content/lifetech/");
		replacement.append(matcher.group(1));
		replacement.append(matcher.group(2));
		
		replacement.append(matcher.group(3).toLowerCase().replaceAll("_", "-"));
		
		// append the replacement
		matcher.appendReplacement(s, replacement.toString());
		
		matcher.appendTail(s);
		
		test1R = s.toString();
		out(test1);
		out(test1R);
		out();
	}
	
	private static void matcherExample() {
		Pattern p = Pattern.compile("(\\d{1,2})");
	    Matcher m = p.matcher("12 54 1 65");
	    StringBuffer s = new StringBuffer();
	    while (m.find())
	        m.appendReplacement(s, String.valueOf(3 * Integer.parseInt(m.group(1))));
	    System.out.println(s.toString());
	}
	
	private static void out(String s) {
		System.out.println(s);
	}
	
	private static void out() {
		System.out.println();
	}
	
}