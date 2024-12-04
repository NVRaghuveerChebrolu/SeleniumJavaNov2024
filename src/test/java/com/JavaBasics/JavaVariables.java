package com.JavaBasics;

public class JavaVariables {
	int a=8;//instance variable : Declare inside a class and out side a method
	char c ='A';
	static String str ="Java"; //static variable
	public int sum(int a,int b) {
		return a+b;
	}
	public static void main(String[] args) {
		
		// 3 types of variables
		int c=2;//local varaible : declared inside a method
		System.out.println("hello my first java program");
//		System.out.print("it is executed");
//		System.out.print(" in single line");
		JavaVariables obj = new JavaVariables();
		System.out.println(obj.a);
		System.out.println(obj.c);
		System.out.println(str);
		System.out.println(obj.sum(5, 7));
	}

}
