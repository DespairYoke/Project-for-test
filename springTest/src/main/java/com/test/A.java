package com.test;

public class A {

	static String a;
	static int b;
	static int c;
	public A(int b,int c){
		this.b=b;
		this.c=c;
	}
	private static void say() {
		// TODO Auto-generated method stub
		System.out.println(a+b+c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new A(1,2);
		A.say();
	}
	

}
